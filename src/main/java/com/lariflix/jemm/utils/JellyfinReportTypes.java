package com.lariflix.jemm.utils;

/**
 * The JellyfinReportTypes enumeration is used to represent the types of reports in the Jellyfin application.
 *
 * This enumeration contains a list of all possible report types that can be generated in the Jellyfin application. 
 * Each report type is represented as an enum constant.
 *
 * INVENTORY_BASIC: This report type represents a basic inventory report.
 * INVENTORY_FULL: This report type represents a full inventory report.
 * GENRES_BASIC: This report type represents a basic genres report.
 * GENRES_FULL: This report type represents a full genres report.
 * PEOPLE_BASIC: This report type represents a basic people report.
 * PEOPLE_FULL: This report type represents a full people report.
 * TAGS_BASIC: This report type represents a basic tags report.
 * TAGS_FULL: This report type represents a full tags report.
 * YEARS_FULL: This report type represents a full years report.
 * STUDIOS_BASIC: This report type represents a basic studios report.
 * STUDIOS_FULL: This report type represents a full studios report.
 *
 * @author Cesar Bianchi
 */
public enum JellyfinReportTypes {
    INVENTORY_BASIC,
    INVENTORY_FULL,
    GENRES_BASIC,
    GENRES_FULL,
    PEOPLE_BASIC,
    PEOPLE_FULL,
    TAGS_BASIC,
    TAGS_FULL,
    YEARS_FULL,
    STUDIOS_BASIC,
    STUDIOS_FULL;

    /**
     * Constructor for the JellyfinReportTypes enumeration.
     *
     * This is a no-argument constructor that initializes a new instance of the JellyfinReportTypes enumeration. It doesn't perform any specific actions.
     *
     * @since 1.1
     * @author Cesar Bianchi
     */
    public static void JellyfinReportTypes() {        
    }
}
