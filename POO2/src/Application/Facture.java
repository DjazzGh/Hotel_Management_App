package Application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
public class Facture {
	
    public static void main(String[] args) throws FileNotFoundException {
    	

    	try {
    	boolean finish=false;
    	int Id=1;
    	while(finish==false) {
    	String ID=String.valueOf(Id);
    	
    	List<String> lines=Fichier.findLinesWithPrefix("Reservations_Clients",ID);
    	if (lines.isEmpty()) {
    		  finish=true;} 
    	else {
    		  
    	double facture=0;
    	for (String line : lines) {
    		// Découper la ligne en mots
            String[] mots = line.split(" ");
            String prix=mots[mots.length - 1];
            facture += Double.parseDouble(prix);
    		}
    	Fichier.addToFile("Factures_Clients",ID+" "+String.valueOf(facture));  	
    	Id++;
    	}}}catch(IOException e) {
    		System.out.println("Erreur");
    	}
    	try {
    		Fichier.AfficherContenuFichier("Factures_Clients");}
    		catch(FileNotFoundException exep) {
    			System.out.println("fichier n'existe pas");
    		}
    
    
    
    
    
    
    }}
