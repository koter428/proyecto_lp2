package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel{
    int colnum;
    int rownum;
    String[] colNames;
    ArrayList<String[]> resultSet;
    public ModeloTabla(int col, String[] nom, ArrayList<String[]> val){
        this.colnum = col;
        this.colNames = nom;
        this.resultSet = val;
    }
    public int getRowCount() {return resultSet.size(); }

    public int getColumnCount() {return colnum; }

    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] aux = resultSet.get(rowIndex);
        return aux[columnIndex];
    }
    public String toString(){
        return super.toString();
    }
    public int findColumn(String columnName){
        return super.findColumn(columnName);
    }
    public String getColumnName(int param){
        return colNames[param];
    }
}
