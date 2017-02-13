/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TableSearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.swingx.JXLabel;

public class MyTableRenderer {

    public static class IDRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(new Color(153, 0, 0));
            super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);
            return this;
        }
    }
}