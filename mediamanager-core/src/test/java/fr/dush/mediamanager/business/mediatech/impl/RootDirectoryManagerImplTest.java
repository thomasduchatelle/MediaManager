package fr.dush.mediamanager.business.mediatech.impl;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;
import static org.fest.assertions.api.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.nio.file.Paths;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import fr.dush.mediamanager.dao.mediatech.IRootDirectoryDAO;
import fr.dush.mediamanager.dto.tree.MediaType;
import fr.dush.mediamanager.dto.tree.RootDirectory;
import fr.dush.mediamanager.engine.SimpleJunitTest;
import fr.dush.mediamanager.exceptions.RootDirectoryAlreadyExistsException;

public class RootDirectoryManagerImplTest extends SimpleJunitTest {

	@InjectMocks
	private RootDirectoryManagerImpl rootDirectoryManager;

	@Mock
	private IRootDirectoryDAO rootDirectoryDAO;

	@Test
	public void testSave_KO() throws Exception {
		when(rootDirectoryDAO.findUsingPath(anyCollectionOf(String.class))).thenReturn(
				newArrayList(new RootDirectory(), new RootDirectory()));

		// Root path of existing RootDirectory
		try {
			final RootDirectory root = new RootDirectory("My Directory", MediaType.MOVIE, "/home/medias");
			root.setEnricher("my-scanner");
			rootDirectoryManager.createOrUpdateRootDirectory(root);

			failBecauseExceptionWasNotThrown(RootDirectoryAlreadyExistsException.class);

		} catch (Exception e) {
			assertThat(e).isInstanceOf(RootDirectoryAlreadyExistsException.class);
		}
	}

	@Test
	public void testNonUpdatable() throws Exception {

		final RootDirectory existing = new RootDirectory("Existing Directory", MediaType.MOVIE, "/home/medias/movies/vf",
				"/home/medias/collections");
		when(rootDirectoryDAO.findUsingPath(anyCollectionOf(String.class))).thenReturn(newArrayList(existing));
		when(rootDirectoryDAO.findById("My Directory")).thenReturn(existing);

		try {
			rootDirectoryManager.createOrUpdateRootDirectory(new RootDirectory("My Directory", MediaType.MOVIE, "/home/medias/movies",
					"/home/media/collections/Marvels", "/mnt/remote/movies"));
			failBecauseExceptionWasNotThrown(RootDirectoryAlreadyExistsException.class);
		} catch (RootDirectoryAlreadyExistsException e) {
			assertThat(e).isInstanceOf(RootDirectoryAlreadyExistsException.class);
		}
	}

	@Test
	public void testNewRootDirectory() throws Exception {
		final RootDirectory root = new RootDirectory("My Directory", MediaType.MOVIE, "/home/medias/movies", "../collections");
		when(rootDirectoryDAO.findById("My Directory")).thenReturn(root);

		final RootDirectory root2 = rootDirectoryManager.createOrUpdateRootDirectory(root);

		assertThat(root2).isEqualTo(root);

		verify(rootDirectoryDAO)
				.findUsingPath(newHashSet("/home/medias/movies", Paths.get("../collections").toAbsolutePath().normalize().toString()));
		verify(rootDirectoryDAO).saveOrUpdate(root);
	}

	@Test
	public void testUpdateWithSameId() throws Exception {
		final RootDirectory existing = new RootDirectory("My Directory", MediaType.MOVIE, "/home/medias/movies", "/home/medias/collections");
		when(rootDirectoryDAO.findUsingPath(anyCollectionOf(String.class))).thenReturn(newArrayList(existing));
		when(rootDirectoryDAO.findById(anyString())).thenReturn(existing);

		final RootDirectory returned = rootDirectoryManager.createOrUpdateRootDirectory(new RootDirectory("My Directory", MediaType.MOVIE,
				"/home/medias"));

		assertThat(returned).isEqualTo(existing);

		verify(rootDirectoryDAO).saveOrUpdate(returned);
		verify(rootDirectoryDAO).findById("My Directory");
	}

	@Test
	public void testMergeWIthoutChangeId() throws Exception {
		final RootDirectory existing = new RootDirectory("Existing Directory", MediaType.MOVIE, "/home/medias/movies/vf",
				"/home/medias/movies/collections", "/home/medias/shows");
		existing.setEnricher("oldEnricher");

		when(rootDirectoryDAO.findUsingPath(anyCollectionOf(String.class))).thenReturn(newArrayList(existing));

		final RootDirectory update = new RootDirectory("My Directory", MediaType.MOVIE, "/home/medias/movies", "/home/media",
				"/home/medias/shows/pilots", "/mnt/remote/movies");
		update.setEnricher("newEnricher");
		final RootDirectory returned = rootDirectoryManager.createOrUpdateRootDirectory(update);

		assertThat(returned).isEqualTo(existing);
		assertThat(returned.getPaths()).containsOnly("/home/medias/movies", "/home/media", "/home/medias/shows", "/mnt/remote/movies");
		assertThat(returned.getEnricher()).isEqualTo("newEnricher");

		verify(rootDirectoryDAO).saveOrUpdate(existing);
	}
}
