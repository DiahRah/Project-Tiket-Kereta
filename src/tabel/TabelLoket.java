/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabel;

import enkapsulasi.enkapsulasiLoket;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class TabelLoket extends AbstractTableModel{
    private List<enkapsulasiLoket>List;
    
    public TabelLoket(List<enkapsulasiLoket> List) {
        this.List = List;
    }

    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
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
                return List.get(rowIndex).getTotalbayar();
            case 4:
                return List.get(rowIndex).getUangbayar();
            case 5:
                return List.get(rowIndex).getUangkembali();
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
                return "TOTAL BAYAR";
            case 4:
                return "UANG BAYAR";
            case 5:
                return "UANG KEMBALI";
            default:
                return null;
        }
    }

}
    

