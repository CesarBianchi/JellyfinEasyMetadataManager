
package com.lariflix.jemm.dtos.nfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Represents a thumbnail metadata entry within an NFO document.
 * <p>
 * This DTO stores thumbnail attributes such as the aspect ratio and the text
 * associated with the thumbnail representation used by Jellyfin.
 * </p>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JemmNFO
 */
@JacksonXmlRootElement(localName = "thumb")
public class Thumb {
    /** Aspect ratio associated with the thumbnail. */
    public String aspect;

    /** Descriptive text associated with the thumbnail element. */
    public String text;

    /**
     * Creates a new empty thumbnail definition.
     *
     * @since 1.0
     * @see JemmNFO
     */
    public Thumb() {
    }

    /**
     * Returns the thumbnail aspect ratio.
     *
     * @return the aspect ratio, or {@code null} if not set
     * @since 1.0
     * @see #setAspect(String)
     */
    public String getAspect() {
        return aspect;
    }

    /**
     * Sets the thumbnail aspect ratio.
     *
     * @param aspect the aspect ratio to store
     * @since 1.0
     * @see #getAspect()
     */
    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    /**
     * Returns the thumbnail descriptive text.
     *
     * @return the thumbnail text, or {@code null} if not set
     * @since 1.0
     * @see #setText(String)
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the thumbnail descriptive text.
     *
     * @param text the thumbnail text to store
     * @since 1.0
     * @see #getText()
     */
    public void setText(String text) {
        this.text = text;
    }
}
