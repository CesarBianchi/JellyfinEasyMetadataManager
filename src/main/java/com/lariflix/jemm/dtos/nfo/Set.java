package com.lariflix.jemm.dtos.nfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Represents a collection/set entry inside an NFO metadata document.
 * <p>
 * This DTO stores the set name and overview information associated with a media
 * collection or related group in Jellyfin metadata files.
 * </p>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JemmNFO
 */
@JacksonXmlRootElement(localName = "set")
public class Set {
    /** Name of the collection or set. */
    public String name;

    /** Overview or description of the set. */
    public String overview;

    /**
     * Creates a new empty set definition.
     *
     * @since 1.0
     * @see JemmNFO
     */
    public Set() {
    }

    /**
     * Returns the set name.
     *
     * @return the set name, or {@code null} if not set
     * @since 1.0
     * @see #setName(String)
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the set name.
     *
     * @param name the set name to store
     * @since 1.0
     * @see #getName()
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the set overview or description.
     *
     * @return the overview, or {@code null} if not set
     * @since 1.0
     * @see #setOverview(String)
     */
    public String getOverview() {
        return overview;
    }

    /**
     * Sets the set overview or description.
     *
     * @param overview the overview text to store
     * @since 1.0
     * @see #getOverview()
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }
}
