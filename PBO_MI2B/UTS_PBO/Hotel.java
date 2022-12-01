/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_pbo;

import java.util.Scanner;

/**
 *
 * @author satri
 */

public class Hotel {
         public static void main(String[] args) 
    {
    Scanner masuktotal=new Scanner (System.in);
        int room = 0;
        int kodepesan,kodepelanggan,jeniskamar1=600000,jeniskamar2=700000,tarif,diskon,total, waktu, uang, kembali;
       
   
        System.out.println("WELCOME TO HOTEL AMARIS");
        System.out.println();
        System.out.println("DAPATKAN DISKON 2% JIKA ANDA BOOKING KAMAR 1 DAN DISKON 3% JIKA ANDA BOOKING KAMAR 2!!!");
        System.out.println();
        System.out.println("DAFTAR HARGA\n1. KAMAR 1 = Rp.600.000,-\n2. KAMAR 2 = Rp.700.000,-");
     
        System.out.print("Masukan Nomor Kamar = ");
        room = masuktotal.nextInt();
     
        switch (room){
            case 1: System.out.println("Anda akan memesan KAMAR 1");
            System.out.println();
                    System.out.print("Masukan Berapa Hari anda akan tinggal = ");
                    waktu = masuktotal.nextInt();
                    tarif = waktu*600000;
                    System.out.println("Harga = Rp."+tarif+",-");
                    if(waktu>=1){
                    diskon=((tarif*2)/100);  
                        System.out.println("Diskon = Rp."+diskon+",-");
                        tarif = (tarif-diskon);
                    System.out.println("Total Harga = Rp."+tarif+",-");
                    }
                    System.out.print("Masukan Uang yang Diberikan Rp.");
                    uang = masuktotal.nextInt();
                        kembali=(uang-tarif);
                    System.out.println("Kembalian Anda = Rp."+kembali+",-");
                    System.out.println();
                    System.out.println("TerimaKasih Atas Pemesanan Anda");
                    System.out.println("================================");
                    break;
            case 2: System.out.println("Anda akan memesan kamar KAMAR 2");
            System.out.println();
                    System.out.print("Silahkan Masukan Berapa Hari anda akan tinggal = ");
                    waktu = masuktotal.nextInt();
                    tarif = waktu*700000;
                    System.out.println("Harga = Rp."+tarif+",-");
                    if(waktu>=1){
                    diskon=((tarif*3)/100);  
                        System.out.println("Diskon = Rp."+diskon+",-");
                        tarif = (tarif-diskon);
                    System.out.println("Total Harga = Rp."+tarif+",-");
                    }
                    System.out.print("Masukan Uang yang Diberikan Rp.");
                    uang = masuktotal.nextInt();
                    kembali=(uang-tarif);
                    System.out.println("Kembalian Anda = Rp."+kembali+",-");
                    System.out.println();
                    System.out.println("TerimaKasih Atas Pemesanan Anda");
                    System.out.println("================================");
                    
    System.out.println("TerimaKasih Atas Pemesanan Anda");
                    }
        }
    
}

