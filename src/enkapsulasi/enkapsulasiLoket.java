/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enkapsulasi;

/**
 *
 * @author ASUS
 */
public class enkapsulasiLoket {
    private String idtiket, nik, nama, totalbayar, uangbayar, uangkembali;
    private static String kode_kereta, session_nik, session_nama;
    
    public String getIdtiket() {
        return idtiket;
    }

    public void setIdtiket(String idtiket) {
        this.idtiket = idtiket;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTotalbayar() {
        return totalbayar;
    }

    public void setTotalbayar(String totalbayar) {
        this.totalbayar = totalbayar;
    }

    public String getUangbayar() {
        return uangbayar;
    }

    public void setUangbayar(String uangbayar) {
        this.uangbayar = uangbayar;
    }

    public String getUangkembali() {
        return uangkembali;
    }

    public void setUangkembali(String uangkembali) {
        this.uangkembali = uangkembali;
    }

    public static String getKode_kereta() {
        return kode_kereta;
    }
    
    public static String getSession_nik(){
        return session_nik;
    }
    
    public static void setKode_kereta(String kode_kereta) {
        enkapsulasiLoket.kode_kereta = kode_kereta;
    }

    public static void setSession_nik(String session_nik) {
        enkapsulasiLoket.session_nik = session_nik;
    }

    public static String getSession_nama() {
        return session_nama;
    }

    public static void setSession_nama(String session_nama) {
        enkapsulasiLoket.session_nama = session_nama;
    }
    
    
    
}
