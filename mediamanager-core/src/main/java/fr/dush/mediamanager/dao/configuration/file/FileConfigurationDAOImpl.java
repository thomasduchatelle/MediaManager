package fr.dush.mediamanager.dao.configuration.file;

import static com.google.common.collect.Lists.*;
import static org.apache.commons.lang3.StringUtils.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import fr.dush.mediamanager.annotations.FileConfigurationDAO;
import fr.dush.mediamanager.dao.configuration.IConfigurationDAO;
import fr.dush.mediamanager.dto.configuration.Field;
import fr.dush.mediamanager.dto.configuration.FieldSet;
import fr.dush.mediamanager.exceptions.ConfigurationException;

/**
 * Use property file
 *
 * @author Thomas Duchatelle
 *
 */
@ApplicationScoped
@FileConfigurationDAO
public class FileConfigurationDAOImpl implements IConfigurationDAO {

	private Path configFile = null;

	private Properties properties = new Properties();

	@PostConstruct
	public void initialize() {
		final String propertyFile = System.getProperty("mediamanager.propertiesfile");

		if (!isEmpty(propertyFile)) {
			configFile = Paths.get(propertyFile);

			if (!configFile.toFile().exists()) {
				throw new ConfigurationException("Properties file %s does't exist.", configFile);
			}

			try {
				properties.load(new FileInputStream(configFile.toFile()));
			} catch (IOException e) {
				throw new ConfigurationException("Properties file %s can't be read : %s", configFile, e.getMessage());
			}
		}

	}

	@Override
	public List<Field> findByPackage(String packageName) {
		List<Field> set = newArrayList();

		for (Entry<Object, Object> entry : properties.entrySet()) {
			if (entry.getKey() instanceof String && ((String) entry.getKey()).startsWith(packageName + ".")) {
				final String key = (String) entry.getKey();
				set.add(new Field(key.substring(packageName.length() + 1), (String) entry.getValue()));
			}
		}

		return set;
	}

	@Override
	public void save(FieldSet configuration) {
		throw new RuntimeException("FileConfigurationDAOImpl.save isn't implemented : file value must be changed manually");
	}

}