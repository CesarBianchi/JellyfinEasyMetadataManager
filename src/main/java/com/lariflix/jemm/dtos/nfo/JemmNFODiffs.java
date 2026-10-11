/*
 * Copyright (C) 2026 cesarbianchi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.lariflix.jemm.dtos.nfo;

/**
 *
 * @author cesarbianchi
 */
public class JemmNFODiffs {
    private String property = new String();
    private String asis = new String();
    private String tobe = new String();

    public JemmNFODiffs() {
    }

    public JemmNFODiffs(String prop, String currentValue, String newValue) {
        this.setProperty(prop);
        this.setAsis(currentValue);
        this.setTobe(newValue);
    }

    
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getAsis() {
        return asis;
    }

    public void setAsis(String asis) {
        this.asis = asis;
    }

    public String getTobe() {
        return tobe;
    }

    public void setTobe(String tobe) {
        this.tobe = tobe;
    }
    
    
}
