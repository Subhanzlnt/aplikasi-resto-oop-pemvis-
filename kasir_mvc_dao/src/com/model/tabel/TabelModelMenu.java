
package com.model.tabel;

import com.model.Menu;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author asus
 */
public class TabelModelMenu extends AbstractTableModel{
    private static final long serialVersionUID = 1L;

    List<Menu> list ;

    public TabelModelMenu(List<Menu> list) {
        this.list = list;
    }
       
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getHarga();
                default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "NAMA";
            case 2 : return "HARGA";
                default:return null;
        }
    }
    
    

}
