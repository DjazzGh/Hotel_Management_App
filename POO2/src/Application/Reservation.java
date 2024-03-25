package Application;

public class Reservation {
	Date debut;
	Date fin;
	Chambre c;
	int ID;
	public Reservation(Date debut, Date fin,Chambre c,int ID) {
		this.debut=debut;
		this.fin=fin;
		this.c=c;
		this.ID=ID;
	}
	public Chambre getchambre() {
		return this.c;
	}
	public int getId() {
		return this.ID;
	}
}
