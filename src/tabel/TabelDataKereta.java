/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabel;

import enkapsulasi.enkapsulasiDataKereta;;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class TabelDataKereta extends AbstractTableModel{
    private List<enkapsulasiDataKereta>List;
    
    public TabelDataKereta(List<enkapsulasiDataKereta> List) {
        this.List = List;
    }


    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return List.get(rowIndex).getKodekereta();
            case 1:
                return List.get(rowIndex).getNamakereta();
            case 2:
                return List.get(rowIndex).getJurusan();
            case 3:
                return List.get(rowIndex).getKeberangkatan();
            case 4:
                return List.get(rowIndex).getJenis();
            case 5:
                return List.get(rowIndex).getNomorkursi();
            case 6:
                return List.get(rowIndex).getHarga();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "KODE KERETA";
            case 1:
                return "NAMA KERETA";
            case 2:
                return "JURUSAN";
            case 3:
                return "KEBERANGKATAN";
            case 4:
                return "JENIS";
            case 5:
                return "NOMOR KURSI";
            case 6:
                return "HARGA";
            default:
                return null;
        }
    }

}

 
    

