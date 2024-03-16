package Application;
import java.util.*;


public class Hotel {
	HashMap<Integer,Reservation> h =new HashMap<>();
	ArrayList<Chambre> h2 =new ArrayList<>();
	public static void main(String [] args) {
		
		//Afficher les hashmaps
		System.out.println(" les reservations:");
	for (Map.Entry<Integer, Reservation> entry : h.entrySet()) {
	    Integer key = entry.getKey();
	    Reservation reservation = entry.getValue();
	    System.out.println("Key: " + key + ", Reservation: " + reservation);
	}
	System.out.println("\n les chambres:");
	for (Chambre chambre : h2) {
	    System.out.println(chambre);
	}
	}
	

	
}
