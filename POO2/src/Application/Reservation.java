package Application;

public class Reservation {
	Date debut;
	Date fin;
	Chambre c;
	public Reservation(Date debut, Date fin,Chambre c) {
		this.debut=debut;
		this.fin=fin;
		this.c=c;
	}
}
