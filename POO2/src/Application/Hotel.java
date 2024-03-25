package Application;
import java.util.*;


public class Hotel {
static HashMap<Integer,List<Reservation>> listClientsReservations =new HashMap<>();
static ArrayList<Chambre> listChambres =new ArrayList<>();
static ArrayList <Client> listClients = new ArrayList<>();


	
	static final int annee =2024;
	public static void main(String [] args) {

System.out.println("Affichage de la hashmap de la liste des reservations de chaque client :");		
		for (Map.Entry<Integer, List<Reservation>> entry : listClientsReservations.entrySet()) {
		    int clientId = entry.getKey();
		    List<Reservation> reservations = entry.getValue();

		    // Print client ID and reservations:
		    System.out.println("Client ID: " + clientId);
		    for (Reservation reservation : reservations) {
		        System.out.println("  Reservation: " + reservation);
		    }
		}
		
System.out.println("Affichage de la liste des chambres :");
for (Chambre chambre : listChambres) {
	  System.out.println(chambre); 
	}

System.out.println("Affichage de la liste des clients :");
for (Client client : listClients) {
	  System.out.println(client); 
	}


		
	}
	

	
}
