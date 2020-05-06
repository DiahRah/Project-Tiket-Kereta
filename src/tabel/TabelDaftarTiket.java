/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabel;

import enkapsulasi.enkapsulasiDaftarTiket;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class TabelDaftarTiket extends AbstractTableModel{
    private List<enkapsulasiDaftarTiket>List;
    
    public TabelDaftarTiket(List<enkapsulasiDaftarTiket> List) {
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
                return List.get(rowIndex).getIdtiket();
            case 1:
                return List.get(rowIndex).getNik();
            case 2:
                return List.get(rowIndex).getNama();
            case 3:
                return List.get(rowIndex).getKodekereta();
            case 4:
                return List.get(rowIndex).getJurusan();
            case 5:
                return List.get(rowIndex).getKeberangkatan();
            case 6:
                return List.get(rowIndex).getNomorkursi();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID TIKET";
            case 1:
                return "NIK";
            case 2:
                return "NAMA";
            case 3:
                return "KODE KERETA";
            case 4:
                return "JURUSAN";
            case 5:
                return "KEBERANGKATAN";
            case 6:
                return "NOMOR KURSI";
            default:
                return null;
        }
    }  
}
