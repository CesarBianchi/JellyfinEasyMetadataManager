package com.lariflix.jemm.dtos.nfo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * Represents a unique identifier entry for a media item in an NFO document.
 * <p>
 * This DTO maps the XML element used to describe an external identifier, such as
 * a provider type and the actual identifier value, while also indicating whether
 * it is the default ID for the item.
 * </p>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JemmNFO
 */
@JacksonXmlRootElement(localName = "uniqueid")
public class Uniqueid {
    /** Identifier type, such as the provider or source name. */
    @JacksonXmlProperty(isAttribute = true)
    private String type;

    /** Indicates whether this identifier is the default one for the media item. */
    @JacksonXmlProperty(localName = "default", isAttribute = true)
    private Boolean defaultValue;

    /** The actual unique identifier value embedded as the text node. */
    @JacksonXmlText
    private String value;

    /**
     * Creates a new empty unique identifier definition.
     *
     * @since 1.0
     * @see JemmNFO
     */
    public Uniqueid() {
    }

    /**
     * Returns the identifier type.
     *
     * @return the identifier type, or {@code null} if not set
     * @since 1.0
     * @see #setType(String)
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the identifier type.
     *
     * @param type the identifier type to store
     * @since 1.0
     * @see #getType()
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns whether this identifier is the default one.
     *
     * @return {@code true} if this is the default identifier, otherwise {@code false}
     * @since 1.0
     * @see #setDefault(boolean)
     */
    public boolean isDefault() {
        return defaultValue;
    }

    /**
     * Sets whether this identifier is the default one.
     *
     * @param _default {@code true} if it is the default identifier
     * @since 1.0
     * @see #isDefault()
     */
    public void setDefault(boolean _default) {
        this.defaultValue = _default;
    }

    /**
     * Returns the raw unique identifier value.
     *
     * @return the identifier value, or {@code null} if not set
     * @since 1.0
     * @see #setValue(String)
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the raw unique identifier value.
     *
     * @param value the identifier value to store
     * @since 1.0
     * @see #getValue()
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Returns whether this identifier is marked as default.
     *
     * @return the default flag, or {@code null} if not set
     * @since 1.0
     * @see #setDefaultValue(Boolean)
     */
    public Boolean getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets whether this identifier is marked as default.
     *
     * @param defaultValue the default flag to store
     * @since 1.0
     * @see #getDefaultValue()
     */
    public void setDefaultValue(Boolean defaultValue) {
        this.defaultValue = defaultValue;
    }
}
