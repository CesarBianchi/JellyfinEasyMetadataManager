package com.lariflix.jemm.dtos.nfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Represents an actor entry within an NFO metadata document.
 * <p>
 * This DTO is used to serialize and deserialize cast data in the Jellyfin
 * metadata format, including the actor name, role, display order, and thumbnail.
 * </p>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JemmNFO
 */
@JacksonXmlRootElement(localName = "actor")
public class Actor {
    /** Full name of the actor. */
    public String name;

    /** Character or role performed by the actor in the media item. */
    public String role;

    /** Ordinal position used to define the actor order in the cast list. */
    public int order;

    /** URL or path to the actor thumbnail image. */
    public String thumb;

    /**
     * Creates a new empty actor definition.
     *
     * @since 1.0
     * @see JemmNFO
     */
    public Actor() {
    }

    /**
     * Returns the actor's full name.
     *
     * @return the actor name, or {@code null} if it was not set
     * @since 1.0
     * @see #setName(String)
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the actor's full name.
     *
     * @param name the actor name to store
     * @since 1.0
     * @see #getName()
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the role or character played by the actor.
     *
     * @return the role name, or {@code null} if it was not set
     * @since 1.0
     * @see #setRole(String)
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role or character played by the actor.
     *
     * @param role the role description to store
     * @since 1.0
     * @see #getRole()
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns the display order of the actor in the cast list.
     *
     * @return the actor order index
     * @since 1.0
     * @see #setOrder(int)
     */
    public int getOrder() {
        return order;
    }

    /**
     * Sets the display order of the actor in the cast list.
     *
     * @param order the actor order index
     * @since 1.0
     * @see #getOrder()
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * Returns the actor thumbnail location.
     *
     * @return the thumbnail URL or path, or {@code null} if it was not set
     * @since 1.0
     * @see #setThumb(String)
     */
    public String getThumb() {
        return thumb;
    }

    /**
     * Sets the actor thumbnail location.
     *
     * @param thumb the thumbnail URL or path to store
     * @since 1.0
     * @see #getThumb()
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
