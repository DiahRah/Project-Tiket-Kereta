/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import enkapsulasi.enkapsulasiPesan;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface implementPesan {

    public boolean save(String nik, String nama, String alamat, String gender, String telepon);
    public boolean delete(String nik);    
    public List<enkapsulasiPesan> search(String nik, String nama, String alamat, String gender, String telepon);
    public boolean update(String nik, String nama, String alamat, String gender, String telepon);
    
    //public boolean reset(String nik, String nama, String alamat, String gender, String telepon);

    public List<enkapsulasiPesan> getAllPesan();

    
    
}
