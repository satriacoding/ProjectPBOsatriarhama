/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SatriaRhama_08122022;

/**
 *
 * @author satri
 */
public class Aritmatika {
      public int tambah(int a, int b){
       return a + b;
   } 
   public static int kurang (int a, int b){
       return a- b;
   }
   
   public static void main(String[] args){
       Aritmatika aritmatika = new aritmatika ();
       int a = 6;
       int b = 10;
       int hasiltambah = aritmatika.tambah(a,b);
       int hasilkurang = aritmatika.kurang(a,b);
       System.out.println(hasiltambah);
       System.out.println(hasilkurang);
   }
}
