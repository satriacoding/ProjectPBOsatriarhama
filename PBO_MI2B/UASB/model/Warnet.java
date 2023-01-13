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

public class Warnet {
    private String kodepelanggan;
    private String nama;
    private String tglmasuk;
    private String jammasuk;
    private String jamkeluar;
    private int jenispelanggan;
    private int lama;
    private int tarif;
    private int total;

    
    public Warnet() {
    }

    public Warnet(  String tglmasuk, String jammasuk, String jamkeluar, int tarif) {
        this.tglmasuk = tglmasuk;
        this.jammasuk = jammasuk;
        this.jamkeluar = jamkeluar;
        this.tarif = tarif;
    }
    
    public String getKodepelanggan() {
        return kodepelanggan;
    }

    public void setKodepelanggan(String kodepelanggan) {
        this.kodepelanggan = kodepelanggan;
    }

    public String getTglmasuk() {
        return tglmasuk;
    }

    public void setTglmasuk(String tglmasuk) {
        this.tglmasuk = tglmasuk;
    }

    public String getJammasuk() {
        return jammasuk;
    }

    public void setJammasuk(String jammasuk) {
        this.jammasuk = jammasuk;
    }

    public String getJamkeluar() {
        return jamkeluar;
    }

    public void setJamkeluar(String jamkeluar) {
        this.jamkeluar = jamkeluar;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getJenispelanggan() {
        return jenispelanggan;
    }

    public void setJenispelanggan(int jenispelanggan) {
        this.jenispelanggan = jenispelanggan;
    }

    public int getLama() {
        return lama;
    }

    public void setLama(int lama) {
        this.lama = lama;
    } 

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    
}
