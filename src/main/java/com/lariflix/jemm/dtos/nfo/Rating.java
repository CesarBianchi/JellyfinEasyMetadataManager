
package com.lariflix.jemm.dtos.nfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Represents a rating element inside an NFO metadata document.
 * <p>
 * This DTO stores the rating metadata used by Jellyfin, including the rating
 * name, maximum value, default indicator, current value, and vote count.
 * </p>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JemmNFO
 */
@JacksonXmlRootElement(localName = "rating")
public class Rating {
    /** Name of the rating source, such as the platform or rating system. */
    @JacksonXmlProperty(isAttribute = true)
    private String name;

    /** Maximum allowed value for the rating scale. */
    @JacksonXmlProperty(isAttribute = true)
    private Integer max;

    /** Indicates whether this rating is the default value for the media item. */
    @JacksonXmlProperty(localName = "default", isAttribute = true)
    private Boolean defaultValue;

    /** Current rating value assigned to the media item. */
    private String value;

    /** Number of votes attributed to the rating. */
    private Integer votes;

    /**
     * Creates an empty rating definition.
     *
     * @since 1.0
     * @see JemmNFO
     */
    public Rating() {
    }

    /**
     * Returns the rating source name.
     *
     * @return the rating name, or {@code null} if not set
     * @since 1.0
     * @see #setName(String)
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the rating source name.
     *
     * @param name the rating name to store
     * @since 1.0
     * @see #getName()
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the maximum value allowed by the rating scale.
     *
     * @return the maximum rating value, or {@code null} if not set
     * @since 1.0
     * @see #setMax(Integer)
     */
    public Integer getMax() {
        return max;
    }

    /**
     * Sets the maximum value allowed by the rating scale.
     *
     * @param max the maximum rating value
     * @since 1.0
     * @see #getMax()
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * Indicates whether this rating is the default one for the media item.
     *
     * @return {@code true} if this is the default rating, otherwise {@code false}
     * @since 1.0
     * @see #setDefaultValue(Boolean)
     */
    public Boolean getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets whether this rating is the default rating for the media item.
     *
     * @param defaultValue {@code true} if this is the default rating
     * @since 1.0
     * @see #getDefaultValue()
     */
    public void setDefaultValue(Boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Returns the current rating value.
     *
     * @return the rating value, or {@code null} if not set
     * @since 1.0
     * @see #setValue(String)
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the current rating value.
     *
     * @param value the rating value to store
     * @since 1.0
     * @see #getValue()
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Returns the number of votes for this rating.
     *
     * @return the vote count, or {@code null} if not set
     * @since 1.0
     * @see #setVotes(Integer)
     */
    public Integer getVotes() {
        return votes;
    }

    /**
     * Sets the number of votes for this rating.
     *
     * @param votes the vote count to store
     * @since 1.0
     * @see #getVotes()
     */
    public void setVotes(Integer votes) {
        this.votes = votes;
    }
}
