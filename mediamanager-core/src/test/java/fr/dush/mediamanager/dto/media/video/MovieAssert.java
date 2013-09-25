package fr.dush.mediamanager.dto.media.video;

import static com.google.common.collect.Lists.*;
import static java.lang.String.*;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.fest.assertions.api.AbstractAssert;
import org.fest.assertions.api.Assertions;

import com.google.common.collect.Lists;

import fr.dush.mediamanager.dto.media.SourceId;

/**
 * {@link Movie} specific assertions - Generated by CustomAssertionGenerator.
 */
public class MovieAssert extends AbstractAssert<MovieAssert, Movie> {

	/**
	 * Creates a new </code>{@link MovieAssert}</code> to make assertions on actual Movie.
	 *
	 * @param actual the Movie we want to make assertions on.
	 */
	public MovieAssert(Movie actual) {
		super(actual, MovieAssert.class);
	}

	/**
	 * An entry point for MovieAssert to follow Fest standard <code>assertThat()</code> statements.<br>
	 * With a static import, one's can write directly : <code>assertThat(myMovie)</code> and get specific assertion with code completion.
	 *
	 * @param actual the Movie we want to make assertions on.
	 * @return a new </code>{@link MovieAssert}</code>
	 */
	public static MovieAssert assertThat(Movie actual) {
		return new MovieAssert(actual);
	}

	/**
	 * Verifies that the actual Movie's backdrops contains the given String elements.
	 *
	 * @param backdrops the given elements that should be contained in actual Movie's backdrops.
	 * @return this assertion object.
	 * @throws AssertionError if the actual Movie's backdrops does not contain all given String elements.
	 */
	public MovieAssert hasBackdrops(String... backdrops) {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// check that given String varargs is not null.
		if (backdrops == null) throw new AssertionError("Expecting backdrops parameter not to be null.");

		// check with standard error message (see commented below to set your own message).
		Assertions.assertThat(getActual().getBackdrops()).contains(backdrops);

		// uncomment the 4 lines below if you want to build your own error message :
		// WritableAssertionInfo assertionInfo = new WritableAssertionInfo();
		// String errorMessage = "my error message";
		// assertionInfo.overridingErrorMessage(errorMessage);
		// Iterables.instance().assertContains(assertionInfo, actual.getTeamMates(), teamMates);

		// return the current assertion for method chaining
		return this;
	}

	private Movie getActual() {
		return actual;
	}

	/**
	 * Verifies that the actual Movie has no backdrops.
	 *
	 * @return this assertion object.
	 * @throws AssertionError if the actual Movie's backdrops is not empty.
	 */
	public MovieAssert hasNoBackdrops() {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected actual <%s> not to have backdrops but had :\\n%s", getActual(), getActual().getBackdrops());

		// check
		if (!getActual().getBackdrops().isEmpty()) throw new AssertionError(errorMessage);

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie's collection is equal to the given one.
	 *
	 * @param collection the given collection to compare the actual Movie's collection to.
	 * @return this assertion object.
	 * @throws AssertionError - if the actual Movie's collection is not equal to the given one.
	 */
	public MovieAssert hasCollection(BelongToCollection collection) {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected Movie's collection to be <%s> but was <%s>", collection, getActual().getCollection());

		// check
		if (!getActual().getCollection().equals(collection)) {
			throw new AssertionError(errorMessage);
		}

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie's directors contains the given Person elements.
	 *
	 * @param directors the given elements that should be contained in actual Movie's directors.
	 * @return this assertion object.
	 * @throws AssertionError if the actual Movie's directors does not contain all given Person elements.
	 */
	public MovieAssert hasDirectors(Person... directors) {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// check that given Person varargs is not null.
		if (directors == null) throw new AssertionError("Expecting directors parameter not to be null.");

		// check with standard error message (see commented below to set your own message).
		Assertions.assertThat(getActual().getDirectors()).contains(directors);

		// uncomment the 4 lines below if you want to build your own error message :
		// WritableAssertionInfo assertionInfo = new WritableAssertionInfo();
		// String errorMessage = "my error message";
		// assertionInfo.overridingErrorMessage(errorMessage);
		// Iterables.instance().assertContains(assertionInfo, actual.getTeamMates(), teamMates);

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie has no directors.
	 *
	 * @return this assertion object.
	 * @throws AssertionError if the actual Movie's directors is not empty.
	 */
	public MovieAssert hasNoDirectors() {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected actual <%s> not to have directors but had :\\n%s", getActual(), getActual().getDirectors());

		// check
		if (!getActual().getDirectors().isEmpty()) throw new AssertionError(errorMessage);

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie's genres contains the given String elements.
	 *
	 * @param genres the given elements that should be contained in actual Movie's genres.
	 * @return this assertion object.
	 * @throws AssertionError if the actual Movie's genres does not contain all given String elements.
	 */
	public MovieAssert hasGenres(String... genres) {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// check that given String varargs is not null.
		if (genres == null) throw new AssertionError("Expecting genres parameter not to be null.");

		// check with standard error message (see commented below to set your own message).
		Assertions.assertThat(getActual().getGenres()).contains(genres);

		// uncomment the 4 lines below if you want to build your own error message :
		// WritableAssertionInfo assertionInfo = new WritableAssertionInfo();
		// String errorMessage = "my error message";
		// assertionInfo.overridingErrorMessage(errorMessage);
		// Iterables.instance().assertContains(assertionInfo, actual.getTeamMates(), teamMates);

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie has no genres.
	 *
	 * @return this assertion object.
	 * @throws AssertionError if the actual Movie's genres is not empty.
	 */
	public MovieAssert hasNoGenres() {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected actual <%s> not to have genres but had :\\n%s", getActual(), getActual().getGenres());

		// check
		if (!getActual().getGenres().isEmpty()) throw new AssertionError(errorMessage);

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie's mainActors contains the given Person elements.
	 *
	 * @param mainActors the given elements that should be contained in actual Movie's mainActors.
	 * @return this assertion object.
	 * @throws AssertionError if the actual Movie's mainActors does not contain all given Person elements.
	 */
	public MovieAssert hasMainActors(Person... mainActors) {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// check that given Person varargs is not null.
		if (mainActors == null) throw new AssertionError("Expecting mainActors parameter not to be null.");

		// check with standard error message (see commented below to set your own message).
		Assertions.assertThat(getActual().getMainActors()).contains(mainActors);

		// uncomment the 4 lines below if you want to build your own error message :
		// WritableAssertionInfo assertionInfo = new WritableAssertionInfo();
		// String errorMessage = "my error message";
		// assertionInfo.overridingErrorMessage(errorMessage);
		// Iterables.instance().assertContains(assertionInfo, actual.getTeamMates(), teamMates);

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie has no mainActors.
	 *
	 * @return this assertion object.
	 * @throws AssertionError if the actual Movie's mainActors is not empty.
	 */
	public MovieAssert hasNoMainActors() {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected actual <%s> not to have mainActors but had :\\n%s", getActual(), getActual().getMainActors());

		// check
		if (!getActual().getMainActors().isEmpty()) throw new AssertionError(errorMessage);

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie's overview is equal to the given one.
	 *
	 * @param overview the given overview to compare the actual Movie's overview to.
	 * @return this assertion object.
	 * @throws AssertionError - if the actual Movie's overview is not equal to the given one.
	 */
	public MovieAssert hasOverview(String overview) {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected Movie's overview to be <%s> but was <%s>", overview, getActual().getOverview());

		// check
		if (!getActual().getOverview().equals(overview)) {
			throw new AssertionError(errorMessage);
		}

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie's release is equal to the given one.
	 *
	 * @param release the given release to compare the actual Movie's release to.
	 * @return this assertion object.
	 * @throws AssertionError - if the actual Movie's release is not equal to the given one.
	 */
	public MovieAssert hasRelease(Date release) {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected Movie's release to be <%s> but was <%s>", release, getActual().getRelease());

		// check
		if (!getActual().getRelease().equals(release)) {
			throw new AssertionError(errorMessage);
		}

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie's trailers is equal to the given one.
	 *
	 * @param trailers the given trailers to compare the actual Movie's trailers to.
	 * @return this assertion object.
	 * @throws AssertionError - if the actual Movie's trailers is not equal to the given one.
	 */
	public MovieAssert hasTrailers(Trailers trailers) {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected Movie's trailers to be <%s> but was <%s>", trailers, getActual().getTrailers());

		// check
		if (!getActual().getTrailers().equals(trailers)) {
			throw new AssertionError(errorMessage);
		}

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Movie's videoFiles contains the given VideoFile elements.
	 *
	 * @param videoFiles the given elements that should be contained in actual Movie's videoFiles.
	 * @return this assertion object.
	 * @throws AssertionError if the actual Movie's videoFiles does not contain all given VideoFile elements.
	 */
	public MovieAssert hasVideoFiles(VideoFile... videoFiles) {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// check that given VideoFile varargs is not null.
		if (videoFiles == null) throw new AssertionError("Expecting videoFiles parameter not to be null.");

		// check with standard error message (see commented below to set your own message).
		Assertions.assertThat(getActual().getVideoFiles()).contains(videoFiles);

		// uncomment the 4 lines below if you want to build your own error message :
		// WritableAssertionInfo assertionInfo = new WritableAssertionInfo();
		// String errorMessage = "my error message";
		// assertionInfo.overridingErrorMessage(errorMessage);
		// Iterables.instance().assertContains(assertionInfo, actual.getTeamMates(), teamMates);

		// return the current assertion for method chaining
		return this;
	}

	public void hasVideoFiles(String... videoFiles) {
		isNotNull();

		if (videoFiles == null) throw new AssertionError("Expecting videoFiles parameter not to be null.");

		List<String> paths = Lists.newArrayList();
		for (VideoFile p : getActual().getVideoFiles()) {
			paths.add(p.getFile().toString());
		}

//		List<String> list = transform(newArrayList(videoFiles), new Function<String, String>() {
//			@Override
//			public String apply(String s) {
//				return Paths.get(s).toAbsolutePath().toString();
//			}
//		});
//		list.toArray(new String[list.size()])
		Assertions.assertThat(paths).containsOnly(videoFiles);
	}

	/**
	 * Verifies that the actual Movie has no videoFiles.
	 *
	 * @return this assertion object.
	 * @throws AssertionError if the actual Movie's videoFiles is not empty.
	 */
	public MovieAssert hasNoVideoFiles() {
		// check that actual Movie we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected actual <%s> not to have videoFiles but had :\\n%s", getActual(), getActual().getVideoFiles());

		// check
		if (!getActual().getVideoFiles().isEmpty()) throw new AssertionError(errorMessage);

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Media's creation is equal to the given one.
	 *
	 * @param creation the given creation to compare the actual Media's creation to.
	 * @return this assertion object.
	 * @throws AssertionError - if the actual Media's creation is not equal to the given one.
	 */
	public MovieAssert hasCreation(Date creation) {
		// check that actual Media we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected Media's creation to be <%s> but was <%s>", creation, actual.getCreation());

		// check
		if (!actual.getCreation().equals(creation)) {
			throw new AssertionError(errorMessage);
		}

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Media's id is equal to the given one.
	 *
	 * @param id the given id to compare the actual Media's id to.
	 * @return this assertion object.
	 * @throws AssertionError - if the actual Media's id is not equal to the given one.
	 */
	public MovieAssert hasId(ObjectId id) {
		// check that actual Media we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected Media's id to be <%s> but was <%s>", id, actual.getId());

		// check
		if (!actual.getId().equals(id)) {
			throw new AssertionError(errorMessage);
		}

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Media's mediaIds contains the given Object elements.
	 *
	 * @param mediaIds the given elements that should be contained in actual Media's mediaIds.
	 * @return this assertion object.
	 * @throws AssertionError if the actual Media's mediaIds does not contain all given Object elements.
	 */
	public MovieAssert hasMediaIds(SourceId... mediaIds) {
		// check that actual Media we want to make assertions on is not null.
		isNotNull();

		// check that given Object varargs is not null.
		if (mediaIds == null) throw new AssertionError("Expecting mediaIds parameter not to be null.");

		// check with standard error message (see commented below to set your own message).
		Assertions.assertThat(actual.getMediaIds()).contains(mediaIds);

		// uncomment the 4 lines below if you want to build your own error message :
		// WritableAssertionInfo assertionInfo = new WritableAssertionInfo();
		// String errorMessage = "my error message";
		// assertionInfo.overridingErrorMessage(errorMessage);
		// Iterables.instance().assertContains(assertionInfo, actual.getTeamMates(), teamMates);

		// return the current assertion for method chaining
		return this;
	}

	public MovieAssert hasMediaIds(String... ids) {
		if (0 != ids.length % 2) throw new IllegalArgumentException("Args must be by pair : type => value");

		List<SourceId> sources = newArrayList();
		for (int i = 0; i < ids.length; i += 2) {
			sources.add(new SourceId(ids[i], ids[i + 1]));
		}

		return hasMediaIds(sources.toArray(new SourceId[sources.size()]));
	}

	/**
	 * Verifies that the actual Media has no mediaIds.
	 *
	 * @return this assertion object.
	 * @throws AssertionError if the actual Media's mediaIds is not empty.
	 */

	public MovieAssert hasNoMediaIds() {
		// check that actual Media we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected actual <%s> not to have mediaIds but had :\\n%s", actual, actual.getMediaIds());

		// check
		if (!actual.getMediaIds().isEmpty()) throw new AssertionError(errorMessage);

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Media's otherMetaData is equal to the given one.
	 *
	 * @param otherMetaData the given otherMetaData to compare the actual Media's otherMetaData to.
	 * @return this assertion object.
	 * @throws AssertionError - if the actual Media's otherMetaData is not equal to the given one.
	 */

	public MovieAssert hasOtherMetaData(String otherMetaData) {
		// check that actual Media we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected Media's otherMetaData to be <%s> but was <%s>", otherMetaData, actual.getOtherMetaData());

		// check
		if (!actual.getOtherMetaData().equals(otherMetaData)) {
			throw new AssertionError(errorMessage);
		}

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Media's poster is equal to the given one.
	 *
	 * @param poster the given poster to compare the actual Media's poster to.
	 * @return this assertion object.
	 * @throws AssertionError - if the actual Media's poster is not equal to the given one.
	 */

	public MovieAssert hasPoster(String poster) {
		// check that actual Media we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected Media's poster to be <%s> but was <%s>", poster, actual.getPoster());

		// check
		if (!actual.getPoster().equals(poster)) {
			throw new AssertionError(errorMessage);
		}

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Media's seen is equal to the given one.
	 *
	 * @param seen the given seen to compare the actual Media's seen to.
	 * @return this assertion object.
	 * @throws AssertionError - if the actual Media's seen is not equal to the given one.
	 */

	public MovieAssert hasSeen(int seen) {
		// check that actual Media we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected Media's seen to be <%s> but was <%s>", seen, actual.getSeen());

		// check
		if (actual.getSeen() != seen) {
			throw new AssertionError(errorMessage);
		}

		// return the current assertion for method chaining
		return this;
	}

	/**
	 * Verifies that the actual Media's title is equal to the given one.
	 *
	 * @param title the given title to compare the actual Media's title to.
	 * @return this assertion object.
	 * @throws AssertionError - if the actual Media's title is not equal to the given one.
	 */

	public MovieAssert hasTitle(String title) {
		// check that actual Media we want to make assertions on is not null.
		isNotNull();

		// we overrides the default error message with a more explicit one
		String errorMessage = format("Expected Media's title to be <%s> but was <%s>", title, actual.getTitle());

		// check
		if (!actual.getTitle().equals(title)) {
			throw new AssertionError(errorMessage);
		}

		// return the current assertion for method chaining
		return this;
	}

}
