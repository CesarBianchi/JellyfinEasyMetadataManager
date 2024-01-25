
package com.lariflix.jemm.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.Locale;


/**
 * The TransformDateFormat class provides methods to transform dates between different formats.
 *
 * @author Cesar Bianchi
 */
public class TransformDateFormat {

    /**
     * Constructs a new TransformDateFormat object.
     */
    public TransformDateFormat() {
    }
    
    /**
     * Converts a full date to a simple date format (dd/MM/yyyy).
     * 
     * @param date the full date to be converted
     * @return the date in the simple format (dd/MM/yyyy)
     * @author Cesar Bianchi
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
     * Converts a simple date (dd/MM/yyyy) to a full date.
     * 
     * @param dt the simple date to be converted
     * @return the full date
     * @throws ParseException if the date cannot be parsed
     * @author Cesar Bianchi
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
     * Converts a date to the full date format (yyyy-MM-dd'T'HH:mm:ss'Z').
     * 
     * @param dt the date to be converted
     * @return the date in the full format
     * @author Cesar Bianchi
     */
    public String convertToFull(Date dt){
        
        String dateReturn = new String();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateReturn = sdf.format(dt);
        
        return dateReturn;
    }
    
}
