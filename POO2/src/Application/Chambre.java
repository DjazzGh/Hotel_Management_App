package Application;

import java.util.HashMap;
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
	  
	  public int getnumerochambre() {
		  return numero;
	  }
	  public Type gettypechambre() {
		  return typechambre;
	  }
	  
	  public boolean getdisponibiltéchambre(Datee debut, Datee fin) {
		  Datee cléRecherchée = debut;
		  Datee valeurRecherchée =fin;
		  // Parcours de chaque entrée du HashMap
		  for (Map.Entry<Datee, Datee> entry : DisponibilitéDansLeTemps.entrySet()) {
		    // Vérification de la clé
		    if (entry.getKey().toString().equals(cléRecherchée.toString()) &&entry.getValue().toString().equals(valeurRecherchée.toString() )) {
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
	  public static String afficherHashMap(HashMap<Datee,Datee> map) { // Assuming String keys and values
	       
			    if (map.isEmpty()) {
			        return "Disponible"; // More descriptive message
			    } else {
			        StringBuilder sb = new StringBuilder("Dates réservés: ");
			        for (Map.Entry<Datee, Datee> entry : map.entrySet()) {
			            Datee key = entry.getKey();
			            Datee value = entry.getValue();
			            sb.append("Début: ").append(key.toString()).append("- Fin: ").append(value.toString()).append(" ");
			        }
			        return sb.toString();
			    }
			}

	    
	  
	  public String toString() {

		  return numero + " "+ typechambre+" "+ afficherHashMap(DisponibilitéDansLeTemps)+" "+prix+" ";
	  }

}
