package com.lariflix.jemm.utils;

import com.lariflix.jemm.utils.JellyfinUtilFunctions;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JellyfinUtilFunctionsTest {

    @Test
    public void testEraseModel() {
        JellyfinUtilFunctions utilFunctions = new JellyfinUtilFunctions();
        DefaultTableModel model = new DefaultTableModel();

        // Add some rows to the model
        model.addRow(new Object[]{"Row1"});
        model.addRow(new Object[]{"Row2"});
        model.addRow(new Object[]{"Row3"});

        // Ensure the model has 3 rows
        assertEquals(3, model.getRowCount());

        // Erase the model
        model = utilFunctions.eraseModel(model);

        // Ensure the model has no rows
        assertEquals(0, model.getRowCount());
    }
}