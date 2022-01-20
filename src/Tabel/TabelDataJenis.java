package Tabel;
import Bean.DataJenis;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TabelDataJenis extends AbstractTableModel {
    
    private List<DataJenis> list = new ArrayList<DataJenis>();
    
    @Override
    public int getRowCount () {
        return list.size();
    }
    
    @Override
    public int getColumnCount() {
                return 2;
    }
    
    @Override
    public Object getValueAt (int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getKodeJenis();
            case 1:
                return list.get(rowIndex).getJenis();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName (int kolom){
        switch (kolom) {
            case 0:
                return "Kode Jenis";
            case 1:
                return "Jenis";
            default:
                return null;
       }
    }
    
    public void add(DataJenis jenis) {
        list.add(jenis);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    
    public void delete(int i, int baris) {
        list.remove(i);
        fireTableRowsDeleted(i, baris);
    }
    
    public DataJenis get(int baris){
        return (DataJenis) list.get(baris);
    }
}
