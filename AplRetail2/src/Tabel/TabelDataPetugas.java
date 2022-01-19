/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel;

import Bean.DataPetugas;
import java.util.*;
import javax.swing.table.AbstractTableModel;


public class TabelDataPetugas extends AbstractTableModel {
    private List< DataPetugas > list = new ArrayList< DataPetugas >();

    public int getRowCount() {
        return list.size();
    }
 
    public int getColumnCount() {
        return 7;
    }
public Object getValueAt(int rowIndex, int columnIndex){
    switch (columnIndex) {
        case 0:
            return list.get(rowIndex).getIdPetugas();
        case 1:
            return list.get(rowIndex).getNamaPetugas();
        case 2:
            return list.get(rowIndex).getAlamat();
        case 3:
            return list.get(rowIndex).getEmail();
        case 4:
            return list.get(rowIndex).getTelepon();
        case 5:
            return list.get(rowIndex).getPassword();
        case 6:
            return list.get(rowIndex).getHakAkses();
        default :
            return null;
    }
}


public String getColumnName(int kolom){
    switch (kolom){
        case 0:
            return "Id Petugas";
        case 1:
            return "Nama Petugas";
        case 2:
            return "Alamat";
        case 3:
            return "Email";
        case 4:
            return "Telepon";
        case 5:
            return "Password";
        case 6:
            return "Hak Akses";
        default: 
            return null;
    }
}
    public void add (DataPetugas idpetugas){
        list.add(idpetugas);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    public void delete (int i, int baris){
        list.remove(i);
        fireTableRowsDeleted(i, baris);
    }
    
    public DataPetugas get(int baris){
        return (DataPetugas) list.get(baris);
    }
}