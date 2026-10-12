package com.lariflix.jemm.dtos.nfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Represents a fanart entry inside an NFO metadata document.
 * <p>
 * This DTO is used to serialize and deserialize the fanart image reference
 * associated with a media item in Jellyfin's NFO structure.
 * </p>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JemmNFO
 */
@JacksonXmlRootElement(localName = "fanart")
public class Fanart {
    /** URL or path to the fanart image associated with the media item. */
    public String thumb;

    /**
     * Creates a new empty fanart definition.
     *
     * @since 1.0
     * @see JemmNFO
     */
    public Fanart() {
    }

    /**
     * Returns the fanart image URL or path.
     *
     * @return the fanart thumbnail path or URL, or {@code null} if it was not set
     * @since 1.0
     * @see #setThumb(String)
     */
    public String getThumb() {
        return thumb;
    }

    /**
     * Sets the fanart image URL or path.
     *
     * @param thumb the fanart thumbnail path or URL to store
     * @since 1.0
     * @see #getThumb()
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
