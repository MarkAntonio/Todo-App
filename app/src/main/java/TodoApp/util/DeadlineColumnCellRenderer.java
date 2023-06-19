/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodoApp.util;

import TodoApp.model.Task;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author marco
 */
public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel jLabel;
        jLabel = (JLabel) super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);

        jLabel.setHorizontalAlignment(CENTER);
        TaskTableModel taskTableModel = (TaskTableModel) table.getModel();
        Task task = taskTableModel.getTasks().get(row);

        if (task.getDeadLine().after(new Date())) {
            jLabel.setBackground(new Color(39,228,157 )); //GREEN
        } 
        else {
            jLabel.setBackground(new Color(255,102,102)); //RED
        }
        return jLabel;
    }
}
