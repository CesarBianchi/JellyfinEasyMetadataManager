
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
 *
 * @author cesarbianchi
 */
public class TransformDateFormat {

    public TransformDateFormat() {
    }
    
    
    public String getSimpleDateFromFull(Date date){
        String cBrazilianFormatDate = new String();
        
        if (date != null){            
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            cBrazilianFormatDate = formatter.format(date);
            
        }
        
        return cBrazilianFormatDate;
    }
    
    
    public Date getFullDateFromSimple(String dt) throws ParseException{
        
        //Convert From String to Date.
        String convertedDate = dt.substring(6, 10).concat("-").concat(dt.substring(3, 5)).concat("-").concat(dt.substring(0,2));        
        LocalDate date = LocalDate.parse(convertedDate);
        
        //Convert From Date to Datetime
        Date dateReturn = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        
        return dateReturn;
    }
    
    public String convertToFull(Date dt){
        
        String dateReturn = new String();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateReturn = sdf.format(dt);
        
        return dateReturn;
    }
    
}
