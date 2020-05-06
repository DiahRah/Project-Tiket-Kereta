/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabel;

import enkapsulasi.enkapsulasiPesan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class TabelPesan extends AbstractTableModel{
    private List<enkapsulasiPesan>List;
    
    public TabelPesan(List<enkapsulasiPesan> List) {
        this.List = List;
    }

    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return List.get(rowIndex).getNik();
            case 1:
                return List.get(rowIndex).getNama();
            case 2:
                return List.get(rowIndex).getAlamat();
            case 3:
                return List.get(rowIndex).getGender();
            case 4:
                return List.get(rowIndex).getTelepon();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NIK";
            case 1:
                return "NAMA";
            case 2:
                return "ALAMAT";
            case 3:
                return "GENDER";
            case 4:
                return "TELEPON";
            default:
                return null;
        }
    }

}

