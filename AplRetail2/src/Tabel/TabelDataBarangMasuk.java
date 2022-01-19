 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel;

import Bean.DataBarangMasuk;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TabelDataBarangMasuk extends AbstractTableModel{
    private List<DataBarangMasuk> list = new ArrayList<DataBarangMasuk>();
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount() {
        return 6;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        switch (columnIndex) {
        case 0:
            return list.get(rowIndex).getKodeBrg();
        case 1:
            return list.get(rowIndex).getNamaBrg();
        case 2:
            return list.get(rowIndex).getHargaNet();
        case 3:
            return list.get(rowIndex).getStock();
        case 4:
            return list.get(rowIndex).getJumlah();
        case 5:
            return list.get(rowIndex).getSubTotal();
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
    return "Harga Net";
case 3:
    return "Stock";
case 4:
    return "Jumlah";
case 5:
    return "Sub Total";
default:
    return null;
}
}

public void add(DataBarangMasuk NamaBarang){
    list.add(NamaBarang);
    fireTableRowsInserted(getRowCount(), getColumnCount());
}

public void delete(int i, int baris){
    list.remove(i);
    fireTableRowsDeleted(i, baris);
}

public DataBarangMasuk get(int baris){
    return (DataBarangMasuk) list.get(baris);
}

}


