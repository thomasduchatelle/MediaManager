package fr.dush.mediamanager.business.mediatech.scanner;

import static com.google.common.collect.Sets.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;

import fr.dush.mediamanager.dto.configuration.ScannerConfiguration;
import fr.dush.mediamanager.dto.tree.RootDirectory;
import fr.dush.mediamanager.events.scan.InprogressScanning;
import fr.dush.mediamanager.events.scan.NewRootDirectoryEvent;
import fr.dush.mediamanager.exceptions.RootDirectoryAlreadyExists;
import fr.dush.mediamanager.exceptions.ScanningException;

/**
 * Listen {@link RootDirectory}'s events to scan directory's contents and find valuable media.
 *
 * <p>
 * Warning : this bean is accessible only with events, no interface.
 * </p>
 *
 * @author Thomas Duchatelle
 *
 */
public class FileScanner {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileScanner.class);

	public final static ScannerConfiguration SCANNER_CONFIGURATION = new ScannerConfiguration();

	@Inject
	private Event<InprogressScanning> bus;

	@Inject
	private Instance<MoviesScanner> moviesScanner;

	static {
		// TODO dynamic configuration
		SCANNER_CONFIGURATION.setVideoExtensions(newHashSet(Splitter.on(" ").split(
				".m4v .3gp .nsv .ts .ty .strm .rm .rmvb .m3u .ifo .mov .qt .divx .xvid .bivx .vob .nrg .img .iso .pva .wmv "
						+ ".asf .asx .ogm .m2v .avi .bin .dat .dvr-ms .mpg .mpeg .mp4 .mkv .avc .vp3 .svq3 .nuv .viv .dv .fli .flv .rar "
						+ ".001 .wpl .zip")));

		SCANNER_CONFIGURATION
				.getCleanStrings()
				.add("[ _\\,\\.\\(\\)\\[\\]\\-](ac3|dts|custom|dc|divx|divx5|dsr|dsrip|dutch|dvd|dvdrip|dvdscr|dvdscreener|screener|dvdivx|cam|fragment|fs|hdtv|hdrip|hdtvrip|internal|limited|multisubs|ntsc|ogg|ogm|pal|pdtv|proper|repack|rerip|retail|r3|r5|bd5|se|svcd|swedish|german|french|truefrench|read.nfo|nfofix|unrated|ws|telesync|ts|telecine|tc|brrip|bdrip|480p|480i|576p|576i|720p|720i|1080p|1080i|hrhd|hrhdtv|hddvd|bluray|x264|h264|xvid|xvidvd|xxx|www.www|subforced|19[0-9][0-9]|20[0-1][0-9]|\\[.*\\])([ _\\,\\.\\(\\)\\[\\]\\-]|$)");
		SCANNER_CONFIGURATION.getCleanStrings().add("(\\[.*\\])");

		SCANNER_CONFIGURATION
				.setDateRegex("(.+[^ _\\,\\.\\(\\)\\[\\]\\-])[ _\\.\\(\\)\\[\\]\\-]+(19[0-9][0-9]|20[0-1][0-9])([ _\\,\\.\\(\\)\\[\\]\\-]+([^0-9]|.).*|$)");

		SCANNER_CONFIGURATION.getMoviesStacking().add("(.*?)([ _.-]*(?:cd|dvd|p(?:ar)?t|dis[ck]|d)[ _.-]*[0-9]+)(.*?)(\\.[^.]+)$");
		SCANNER_CONFIGURATION.getMoviesStacking().add("(.*?)([ _.-]*(?:cd|dvd|p(?:ar)?t|dis[ck]|d)[ _.-]*[a-d])(.*?)(\\.[^.]+)$");
	}

	public void scanNewDirectory(@Observes NewRootDirectoryEvent event) throws RootDirectoryAlreadyExists, ScanningException,
			InterruptedException {
		LOGGER.debug("--> scanNewDirectory {}", event);

		// Get enricher
		final ScanningStatus status = moviesScanner.get().startScanning(event.getRootDirectory());

		// Fire event
		bus.fire(new InprogressScanning(this, event.getRootDirectory(), status));

	}

	@Produces
	@ApplicationScoped
	public ScannerConfiguration produceScannerConfiguration() {
		return SCANNER_CONFIGURATION;
	}

}
