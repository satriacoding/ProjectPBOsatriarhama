/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PraktekPakAzda.SatriaRhama241022;

/**
 *
 * @author satri
 */
public class MVCDemo {
    public static void main(String[] args) { 
	Mobil model = retriveMobilFromDatabase(); 
	MobilView view = new MobilView(); 
	MobilController controller = new MobilController(model, view); 	
        controller.updateView(); 

        
	controller.setMobilName("Lamborghini");
        controller.setMobilKode("002");
	controller.updateView(); 
    } 

    
    private static Mobil retriveMobilFromDatabase(){ 
	Mobil mobil = new Mobil(); 
	mobil.setName("Ferrari"); 
	mobil.setKode("003"); 
        mobil.setWarna("Biru");
	return mobil; 
    }
}