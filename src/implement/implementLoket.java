/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import enkapsulasi.enkapsulasiLoket;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface implementLoket {
    
    public boolean save(String idtiket, String nik, String nama, String totalbayar, String uangbayar, String uangkembali);
    public boolean update(String idtiket, String nik, String nama, String totalbayar, String uangbayar, String uangkembali);
    public List<enkapsulasiLoket> search(String idtiket, String nik, String nama, String totalbayar, String uangbayar, String uangkembali);
    public boolean delete (String idtiket);
    public List<enkapsulasiLoket> getAllLoket();
}
