package Tabel;

import Bean.DataBarang;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TabelDataBarang extends AbstractTableModel{
    private List<DataBarang> list = new ArrayList<DataBarang>();
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount() {
        return 7;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        switch (columnIndex) {
        case 0:
            return list.get(rowIndex).getKodeBrg();
        case 1:
            return list.get(rowIndex).getNamaBrg();
        case 2:
            return list.get(rowIndex).getKode_jenis();
        case 3:
            return list.get(rowIndex).getJenisBrg();
        case 4:
            return list.get(rowIndex).getHargaNet();
        case 5:
            return list.get(rowIndex).getHargaJual();
        case 6:
            return list.get(rowIndex).getStock();
        default:
             return null;
    }
}

public String getColumnName(int kolom){
    switch (kolom){
case 0:
    return "Kode Barang";
case 1:
    return "Nama Barang";
case 2:
    return "Jenis Barang";
case 3:
    return "Jenis Barang";
case 4:
    return "Harga Net";
case 5:
    return "Harga Jual";
case 6:
    return "Stock";
default:
    return null;
}
}

public void add(DataBarang nama_brg){
    list.add(nama_brg);
    fireTableRowsInserted(getRowCount(), getColumnCount());
}

public void delete(int i, int baris){
    list.remove(i);
    fireTableRowsDeleted(i, baris);
}

public DataBarang get(int baris){
    return (DataBarang) list.get(baris);
}

}