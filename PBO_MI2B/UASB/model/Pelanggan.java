/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UASB.model;

/**
 *
 * @author satri
 */
public class Pelanggan {
    private String kode;
    private String nama;
    private int jenispelanggan;
    
    public Pelanggan() {
    
    }
    
    public Pelanggan(String kode, String nama, int jenispelanggan) {
        this.kode = kode;
        this.nama = nama;
        this.jenispelanggan = jenispelanggan;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJenispelanggan() {
        return jenispelanggan;
    }

    public void setJenispelanggan(int jenispelanggan) {
        this.jenispelanggan = jenispelanggan;
    }
    
    
}
