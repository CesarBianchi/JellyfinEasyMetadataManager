
package com.lariflix.jemm.utils;

/**
 * The JellyfimParameters enumeration is used to represent the parameters for a Jellyfin instance.
 *
 * This enumeration contains a list of all possible parameters that can be used to configure a Jellyfin instance. Each parameter is represented as an enum constant.
 *
 * JUST_ROOT_FOLDERS: This parameter is used to indicate that only root folders should be considered (Used for the root folders of the library).
 * FOLDERS_AND_SUBFOLDERS: This parameter is used to indicate that both folders and subfolders should be considered. (Used for the root folders of the library).
 * JUST_ITEMS: This parameter is used to indicate that only items should be considered. (Used for the items of the root-library).
 * JUST_SUBFOLDERS: This parameter is used to indicate that only subfolders should be considered. (Used for the items of the root-library)
 *
 * @author Cesar Bianchi
 */
public enum JellyfimParameters {
    JUST_ROOT_FOLDERS,
    FOLDERS_AND_SUBFOLDERS,
    JUST_ITEMS,
    JUST_SUBFOLDERS;
}