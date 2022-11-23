/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LatihanModul5;

/**
 *
 * @author hp
 */
import java.util.Scanner;
public class LatihanCetakNamaWhile {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int i=0,batas;
        String nama="Satria Rhama";
        
        System.out.print("Masukkan Batas : ");
        batas = in.nextInt();
        
        do{
            System.out.println(nama);
            i++;
        } while(i<batas);
    }
}