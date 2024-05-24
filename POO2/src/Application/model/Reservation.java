package Application.model;


public class Reservation {
	int ID;
	Datee debut;
	Datee fin;
	Chambre c;
	int numChambre;
	public Reservation(int ID,Datee debut, Datee fin,Chambre c) {
		this.ID=ID;
		this.debut=debut;
		this.fin=fin;
		this.c=c;
	}
	public Reservation(int ID,Datee debut, Datee fin,int numChambre) {
		this.ID=ID;
		this.debut=debut;
		this.fin=fin;
		this.c.numerochambre=numChambre;
	}
	public Chambre getchambre() {
		return this.c;
	}
	public int getId() {
		return this.ID;
	}
	public int getroomnumber() {
		return this.c.getnumerochambre();
	}
	
	/*public void setDisponibilitétrue(Reservation r,Datee debut, Datee fin) {
		  r.c.DisponibilitéDansLeTemps.remove(debut, fin) ;		  
	  }*/
	
	//It works
	public String toString() {
		return ID+" "+Datee.formatDate(debut.toString())+" "+Datee.formatDate(fin.toString())+" "+this.c.getnumerochambre();
	}
	


}
