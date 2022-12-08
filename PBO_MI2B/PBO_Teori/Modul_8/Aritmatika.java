
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul9;

/**
 *
 * @author ASUS
 */
public class Aritmatika {
    public int tambah(int a, int b){
        return a + b;
    }
    
    public static int kurang(int a, int b){
        return a - b;
    }
    
    public static int kali(int a, int b){
        return a * b;
    }
    
    public static int bagi(int a, int b){
        return a / b;
    }
    public static void main (String[] args){
        Aritmatika aritmatika = new Aritmatika();
        int a = 20;
        int b = 4;
        int hasiltambah = aritmatika.tambah(a,b);
        int hasilkurang = Aritmatika.kurang(a,b);
        int hasilkali = Aritmatika.kali(a,b);
        int hasilbagi = Aritmatika.bagi(a,b);
        System.out.println(hasiltambah);
        System.out.println(hasilkurang);
        System.out.println(hasilkali);
        System.out.println(hasilbagi);
    }
}
