/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import enkapsulasi.enkapsulasiDataKereta;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface implementDataKereta {
 
    public boolean save(String kodekereta, String namakereta, String jurusan, String keberangkatan, String jenis, String nomorkursi, String harga);
    public boolean update(String kodekereta, String namakereta, String jurusan, String keberangkatan, String jenis, String nomorkursi, String harga);
    public List<enkapsulasiDataKereta> search(String kodekereta, String namakereta, String jurusan, String keberangkatan, String jenis, String nomorkursi, String harga);
    public boolean delete (String kodekereta);
    public List<enkapsulasiDataKereta> getAllDataKereta();
}
