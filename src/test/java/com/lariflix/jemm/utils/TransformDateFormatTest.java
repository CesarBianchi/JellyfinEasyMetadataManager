package com.lariflix.jemm.utils;

import com.lariflix.jemm.utils.TransformDateFormat;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class TransformDateFormatTest {

    @Test
    public void testGetSimpleDateFromFull() {
        TransformDateFormat transformDateFormat = new TransformDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = sdf.parse("25/12/2021");
            String result = transformDateFormat.getSimpleDateFromFull(date);
            assertEquals("25/12/2021", result);
        } catch (ParseException e) {
            fail("Exception should not have been thrown.");
        }
    }

    @Test
    public void testGetFullDateFromSimple() {
        TransformDateFormat transformDateFormat = new TransformDateFormat();

        try {
            Date result = transformDateFormat.getFullDateFromSimple("25/12/2021");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = sdf.format(result);
            assertEquals("25/12/2021", formattedDate);
        } catch (ParseException e) {
            fail("Exception should not have been thrown.");
        }
    }

    @Test
    public void testConvertToFull() {
        TransformDateFormat transformDateFormat = new TransformDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        try {
            Date date = sdf.parse("2021-12-25T00:00:00Z");
            String result = transformDateFormat.convertToFull(date);
            assertEquals("2021-12-25T00:00:00Z", result);
        } catch (ParseException e) {
            fail("Exception should not have been thrown.");
        }
    }
}