package fr.dush.mediamanager.dto.media.video;

import static com.google.common.collect.Lists.*;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import fr.dush.mediamanager.dto.media.Media;

/**
 * Collection of films.
 *
 * <p>
 * <code>FilmsCollection</code>s and {@link Film}s are {@link Media}s, thus there are persisted on same place. <code>FilmsCollection</code>s
 * are saved 2 times :
 * <ul>
 * <li>first directly in media/film column</li>
 * <li>second in each film of the collection</li>
 * </ul>
 * </p>
 *
 * <p>
 * But films are only saved once. {@link #films} is <b>lazy</b> attribute.
 * </p>
 *
 * @author Thomas Duchatelle
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true, of = {})
public class FilmsCollection extends Media {

	/** List of films in this collection. This list is LAZY and is not saved in database. */
	private List<Film> films = newArrayList();

}