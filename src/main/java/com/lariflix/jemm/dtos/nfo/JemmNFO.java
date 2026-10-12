
package com.lariflix.jemm.dtos.nfo;

/**
 * Root DTO representing a Jellyfin NFO metadata document.
 * <p>
 * This class acts as the top-level container for a movie metadata structure,
 * exposing the main {@link Movie} object used during serialization and
 * deserialization of NFO content.
 * </p>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see Movie
 */
public class JemmNFO {
    /** The movie metadata represented by this NFO document. */
    Movie movie = new Movie();

    /**
     * Creates a new empty NFO document container.
     *
     * @since 1.0
     * @see Movie
     */
    public JemmNFO() {
    }

    /**
     * Returns the movie metadata associated with this NFO document.
     *
     * @return the movie metadata, or {@code null} if not configured
     * @since 1.0
     * @see #setMovie(Movie)
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets the movie metadata associated with this NFO document.
     *
     * @param movie the movie metadata to store
     * @since 1.0
     * @see #getMovie()
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
