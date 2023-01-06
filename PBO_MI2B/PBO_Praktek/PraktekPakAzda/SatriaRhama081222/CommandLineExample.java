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
public class CommandLineExample {
     public static void main(String[] args) {
        int kali,a,b;
       String bil1, bil2;
       
       bil1 = args[0];
       bil2 = args[1];
       
       a = Integer.parseInt(bil1);
       b = Integer.parseInt(bil2);
       
       kali = a * b;
       
        System.out.println("Number of arguments = " + 
        args.length); 
        System.out.println("First Argument = "+ args[0]); 
        System.out.println("Second Argument = "+ args[1]);
        
        System.out.println("Argument 1 * Argument 2 = "+kali);
   
    }
    
}
