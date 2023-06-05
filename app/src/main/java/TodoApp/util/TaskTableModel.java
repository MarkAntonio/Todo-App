/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodoApp.util;

import TodoApp.model.Task;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public class TaskTableModel extends AbstractTableModel{
    String[] columns = {"Name", "Description", "Notes", "Deadline", "Completed Task", "Edit", "Delete"};
    List<Task> tasks = new ArrayList();
    
    @Override
    public int getRowCount() {
        return tasks.size(); //O número de linhas é o número de tarefas
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                return tasks.get(rowIndex).getNotes();
            case 3:
                return tasks.get(rowIndex).getDeadLine();
            case 4:
                return tasks.get(rowIndex).isCompleted();
            case 5:
                return "";
            case 6:
                return "";
            default:
                return "Data not found";
       }
    }

    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 4;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (tasks.isEmpty())
            return Object.class;
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setCompleted((boolean) aValue);
    }
    
    
    
    
    public List<Task> getTasks(){
        return this.tasks;
    }
    
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }
    
    
    
}
