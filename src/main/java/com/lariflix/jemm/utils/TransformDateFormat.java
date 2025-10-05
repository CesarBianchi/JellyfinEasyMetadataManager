
package com.lariflix.jemm.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


/**
 * Utility class for transforming date formats.
 * This class provides methods for converting dates between different formats.
 * 
 * @author Cesar Bianchi
 * @since 1.0
 
 */
public class TransformDateFormat {

    /**
     * Default constructor for the TransformDateFormat class.
     * This constructor is used when creating a new instance of this class without setting any initial values.
     * 
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public TransformDateFormat() {
    }
    
    /**
     * Converts a Date object into a simple date string in the format "dd/MM/yyyy".
     * If the provided date is null, an empty string is returned.
     * 
     * @param date The Date object to be converted.
     * @return A string representing the date in the format "dd/MM/yyyy", or an empty string if the date is null.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public String getSimpleDateFromFull(Date date){
        String cBrazilianFormatDate = new String();
        
        if (date != null){            
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            cBrazilianFormatDate = formatter.format(date);
            
        }
        
        return cBrazilianFormatDate;
    }
    
    /**
     * Converts a simple date string in the format "dd/MM/yyyy" into a Date object.
     * If the provided string is not in the correct format, a ParseException is thrown.
     * 
     * @param dt The date string to be converted.
     * @return A Date object representing the date, or null if the string is not in the correct format.
     * @throws ParseException if the string is not in the correct format.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public Date getFullDateFromSimple(String dt) throws ParseException{
        
        //Convert From String to Date.
        String convertedDate = dt.substring(6, 10).concat("-").concat(dt.substring(3, 5)).concat("-").concat(dt.substring(0,2));        
        LocalDate date = LocalDate.parse(convertedDate);
        
        //Convert From Date to Datetime
        Date dateReturn = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        
        return dateReturn;
    }
    
    /**
     * Converts a Date object into a full date string in the format "yyyy-MM-dd'T'HH:mm:ss'Z'".
     * If the provided date is null, an empty string is returned.
     * 
     * @param dt The Date object to be converted.
     * @return A string representing the date in the format "yyyy-MM-dd'T'HH:mm:ss'Z'", or an empty string if the date is null.
     * @author Cesar Bianchi
     * @since 1.0
     
     */
    public String convertToFull(Date dt){
        
        String dateReturn = new String();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateReturn = sdf.format(dt);
        
        return dateReturn;
    }
    
}
