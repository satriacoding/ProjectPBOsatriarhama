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
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException;  
public class latihan {
    public static void main( String[] args ){ 
        BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in) ); 
        String nama = "";
        int nilai = 0;
        
        System.out.print("Please Enter Your Name:");
        
        try{ 
            nama = dataIn.readLine();
            nilai =  Integer.parseInt(dataIn.readLine());
        }catch( IOException e ){ 
            System.out.println("Error!"); 
        } 
        System.out.println("Nama " + nama +"!"); 
        System.out.println("Nilai " + nilai +"!"); 
 } 
}