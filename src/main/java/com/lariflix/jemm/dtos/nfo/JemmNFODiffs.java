
package com.lariflix.jemm.dtos.nfo;

/**
 * Represents a field-level change record used to compare an original NFO value
 * with a new value after metadata processing.
 * <p>
 * This DTO is primarily used to track differences between an original value and
 * a target value for a specific property in the metadata model.
 * </p>
 *
 * @author Cesar Bianchi
 * @since 1.0
 * @see JemmNFO
 */
public class JemmNFODiffs {
    /** Name of the metadata property being compared. */
    private String property = new String();

    /** Original value before the update. */
    private String asis = new String();

    /** New value after the update. */
    private String tobe = new String();

    /**
     * Creates an empty diff record.
     *
     * @since 1.0
     * @see JemmNFO
     */
    public JemmNFODiffs() {
    }

    /**
     * Creates a diff record for a property with both current and target values.
     *
     * @param prop the metadata property name
     * @param currentValue the original value
     * @param newValue the target value
     * @since 1.0
     * @see #setProperty(String)
     */
    public JemmNFODiffs(String prop, String currentValue, String newValue) {
        this.setProperty(prop);
        this.setAsis(currentValue);
        this.setTobe(newValue);
    }

    /**
     * Returns the metadata property name involved in the diff.
     *
     * @return the property name
     * @since 1.0
     * @see #setProperty(String)
     */
    public String getProperty() {
        return property;
    }

    /**
     * Sets the metadata property name involved in the diff.
     *
     * @param property the property name to store
     * @since 1.0
     * @see #getProperty()
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * Returns the original value before the metadata update.
     *
     * @return the original value
     * @since 1.0
     * @see #setAsis(String)
     */
    public String getAsis() {
        return asis;
    }

    /**
     * Sets the original value before the metadata update.
     *
     * @param asis the original value to store
     * @since 1.0
     * @see #getAsis()
     */
    public void setAsis(String asis) {
        this.asis = asis;
    }

    /**
     * Returns the target value after the metadata update.
     *
     * @return the new value
     * @since 1.0
     * @see #setTobe(String)
     */
    public String getTobe() {
        return tobe;
    }

    /**
     * Sets the target value after the metadata update.
     *
     * @param tobe the new value to store
     * @since 1.0
     * @see #getTobe()
     */
    public void setTobe(String tobe) {
        this.tobe = tobe;
    }
}
