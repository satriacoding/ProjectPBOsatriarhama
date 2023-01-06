/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PraktekPakAzda.SatriaRhama081222;

/**
 *
 * @author satri
 */
public class Aritmatika {
    public int tambah(int a, int b){
        return a + b;
    }
    
    public static int kurang(int a, int b){
        return a - b;
    }
    
    public static void main(String[] args){
        Aritmatika aritmatika = new Aritmatika(); // ini adalah instance //Aritmatika nama class , aritmatika nama instance
        int a, b;
        a = 4;
        b = 3;
        
        int hasil = aritmatika.tambah(a,b);
        int kurang = Aritmatika.kurang(a,b); // kalau static boleh langsung nama class bukan nama instance
        
        System.out.println(hasil);
        System.out.println(kurang);
        
        
    }
}
