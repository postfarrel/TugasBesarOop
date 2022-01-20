/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel;

import Bean.DataDistributor;
import java.util.*;
import javax.swing.table.AbstractTableModel;


public class TabelDataDistributor extends AbstractTableModel{
    private List< DataDistributor > list = new ArrayList< DataDistributor >();

    public int getRowCount() {
        return list.size();
    }
 
    public int getColumnCount() {
        return 6 ;
    }
public Object getValueAt(int rowIndex, int columnIndex){
    switch (columnIndex) {
        case 0:
            return list.get(rowIndex).getIdDistributor();
        case 1:
            return list.get(rowIndex).getNamaDistributor();
        case 2:
            return list.get(rowIndex).getAlamat();
        case 3:
            return list.get(rowIndex).getKotaAsal();
        case 4:
            return list.get(rowIndex).getEmail();
        case 5:
            return list.get(rowIndex).getTelepon();
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
            return "Kota Asal";
        case 4:
            return "Email";
        case 5:
            return "Telepon";
        default: 
            return null;
    }
}
    public void add (DataDistributor idpetugas){
        list.add(idpetugas);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    public void delete (int i, int baris){
        list.remove(i);
        fireTableRowsDeleted(i, baris);
    }
    
    public DataDistributor get(int baris){
        return (DataDistributor) list.get(baris);
    }
}