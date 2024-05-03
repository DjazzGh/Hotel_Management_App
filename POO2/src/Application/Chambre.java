package Application;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chambre {
	  int numero;
	  Type typechambre;
	  static HashMap<Datee,Datee> DisponibilitéDansLeTemps=new HashMap<>();
	  double prix;
	  static int numerochambre=1;
	  
	    
	  public Chambre(Type typechambre,double prix) {
		  this.numero=numerochambre;
		  numerochambre++;
		  this.typechambre =typechambre;
		  this.prix=prix;
	  }

	  
	  
	  public Chambre(int num,Type typechambre,double prix) {
		  this.numero=num;
		  this.typechambre =typechambre;
		  this.prix=prix;
	  }
	  
	  public int getnumerochambre() {
		  return this.numero;
	  }
	  public int getNumero() {
		  return this.numerochambre;
	  }
	  public Type gettypechambre() {
		  return typechambre;
	  }
	  public void setNumero(int num) {
		  this.numero=num;
	  }
	  public HashMap<Datee,Datee> getDisponibilitéDansLeTemps(){
		  return DisponibilitéDansLeTemps;
	  }
	  
	  public boolean getdisponibiltéchambre(Datee debut, Datee fin) {
		  Datee cléRecherchée = debut;
		  Datee valeurRecherchée =fin;
		  // Parcours de chaque entrée du HashMap
		  for (Map.Entry<Datee, Datee> entry : DisponibilitéDansLeTemps.entrySet()) {
		    // Vérification de la clé
		    if (entry.getKey().toString().equals(cléRecherchée.toString()) &&entry.getValue().toString().equals(valeurRecherchée.toString() )) {
		     return false;}
		    if(Datee.entre(entry.getKey(),entry.getValue(),cléRecherchée,valeurRecherchée )==true) {
		     return false;
		  }}return true;  
	  }
	  
	  public double getprix() {
		  return this.prix;
	  }
	  public void setTypeChambre(Type t) {
		  this.typechambre=t;
	  }
	  public void setDisponibilitéfalse(Datee debut, Datee fin) {
		  DisponibilitéDansLeTemps.put(debut,fin);	  
		  
	  }
	  public void setDisponibilitétrue(Datee debut, Datee fin) {
		  DisponibilitéDansLeTemps.remove(debut, fin) ;		  
	  }
	  
	  public void setPrix(double p) {
		  this.prix=p;
	  }
	  public String afficherHashMap(HashMap<Datee,Datee> map) { 
	       
			    if (map.isEmpty()) {
			        return "Dates: Vide"; 
			    } else {
			        StringBuilder sb = new StringBuilder("Dates:");
			        for (Map.Entry<Datee, Datee> entry : map.entrySet()) {
			        	 Datee key = entry.getKey();
				            Datee value = entry.getValue();
				            sb.append(" Début: ").append(Datee.formatDate(key.toString())).append("-Fin: ").append(Datee.formatDate(value.toString())).append(" ");
				        }
			        return sb.toString();
			    }
			}

	    
	  
	  public String toString1() {

		  return numero + " "+ typechambre+" "+prix+" " +afficherHashMap(DisponibilitéDansLeTemps);
	  }
	  public String toString2() {

		  return numerochambre + " "+ typechambre+" "+prix;
	  }
	  
	  public static void updateRoomavailability(int c) {
		List<String> liste= Fichier.findLinesWithLastWord("Reservations_Clients", String.valueOf(c));
		String dispo="";
		 if (liste.isEmpty()) {
			     dispo="Vide"; // Room is available if no reservations found
			  }

			 
			  for (String line : liste) {
			    String[] parts = line.split("\\s+", 4); // Split on whitespace, limit to 3 parts
			    if (parts.length >= 3) {
			        String startDate = parts[1];
			        String endDate = parts[2];
			        dispo += "Début: " + startDate + "-Fin: " + endDate + " ";
			      }
			  }

			  String l=Fichier.findFirstLineWithPrefix("Chambres",String.valueOf(c) );
			  String parts[]=l.split("Dates: ");
			  //parts[1]=dispo;
			  String newline=parts[0]+"Dates: "+dispo+"\n";
			  try {
			  Fichier.replaceLineInFile("Chambres", l, newline);}
			  catch(IOException ex) {
				  System.out.println("Erreur");
			  }
			
	  }
	  
	  public static void main(String [] args) {
		  
		  Chambre.updateRoomavailability(2);
		 /* List<String> liste= Fichier.findLinesWithLastWord("Reservations_Clients", "2");
		  for (String line : liste) {
              System.out.println(line);
          }
		  try {
		  Fichier.replaceLineInFile("Chambres", "4 Simple 150.0 Dates: NOT Vide", "4 Simple 150.0 Dates: Vide");}
		  catch(IOException ex) {
			  System.out.println("Erreur");
		  }*/
		  
	  }

}
