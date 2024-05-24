package Application.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
	
	static ArrayList<Reservation> listReservations =new ArrayList<>();
	static ArrayList<Chambre> listChambres =new ArrayList<>();
	static ArrayList<Client> listClients = new ArrayList<>();
	public static ArrayList<Chambre> getListChambres() {
		return listChambres;
	}
	public static ArrayList<Client> getMyList() {
	    return listClients;
	}
	public static ArrayList<Chambre> geListchambre() {
	    return listChambres;
	}
	public static ArrayList<Reservation> getListReservation() {
	    return listReservations;
	}


	public static void addToList(Client c) {
	    listClients.add(c);
	}
}
