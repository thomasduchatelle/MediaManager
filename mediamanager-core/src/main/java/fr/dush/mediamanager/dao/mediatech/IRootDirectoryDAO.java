package fr.dush.mediamanager.dao.mediatech;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import fr.dush.mediamanager.dto.tree.RootDirectory;

/**
 * Provide access to persisted data on mediatech location (root directory), there is no constrains containing on implementations.
 *
 *
 * @author Thomas Duchatelle
 *
 */
public interface IRootDirectoryDAO {

	/**
	 * Find RootDirectory by its name.
	 *
	 * @param name
	 * @return
	 */
	RootDirectory findById(String name);

	/**
	 * Save or update RootDirectory, no constrains...
	 *
	 * @param rootDirectory
	 * @return Return updated RootDirectory
	 */
	RootDirectory saveOrUpdate(RootDirectory rootDirectory);

	/**
	 * Find all root directory, sorted by name.
	 *
	 * @return
	 */
	List<RootDirectory> findAll();

	/**
	 * Find {@link RootDirectory} corresponding to path.
	 *
	 * @param path Path or subpath to directory...
	 * @return
	 */
	RootDirectory findBySubPath(Path path);

	/**
	 * Find {@link RootDirectory}s which have path containing or contained by this colleciton.
	 *
	 * @param paths
	 * @return
	 */
	List<RootDirectory> findUsingPath(Collection<String> paths);

	/**
	 * Update "last update" date
	 *
	 * @param rootDirectoryName
	 * @param updatedDate New lastUpdate's value
	 */
	void markAsUpdated(String rootDirectoryName, Date updatedDate);
}
