/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanperpangkatan;

/**
 *
 * @author hp
 */
import java.util.Scanner;
public class latihanperpangkatan {
     public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int bil,pangkat,hasil = 1,i = 1;
		
		System.out.print("Masukkan Bilangan : ");
		bil = input.nextInt();
		System.out.print("Masukkan Pangkat : ");
		pangkat = input.nextInt();
		
		while(i<=pangkat)
		{
			hasil = hasil * bil;
			i++;
		}
		
		System.out.println("Hasil  " +bil+ " pangkat " +pangkat+ " = " +hasil);
	}
}
