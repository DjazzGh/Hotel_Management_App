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
	public Reservation(int ID,Datee debut, Datee fin,int numChambre) {
		this.ID=ID;
		this.debut=debut;
		this.fin=fin;
		this.c.numero=numChambre;
	}
	public Chambre getchambre() {
		return this.c;
	}
	public int getId() {
		return this.ID;
	}
	public String toString ()  {
		return  debut + " "+fin+" "+c+" "+ID+" ";
	}
		public static Reservation creerReservation(String[] champs) {		  
		 String ID = champs[1];
		 int id=Integer.valueOf(ID);

		 String [] date_debut = champs[2].split("/");
		 int jour = Integer.parseInt(date_debut[0]);
		 int mois = Integer.parseInt(date_debut[1]);
		 int annee = Integer.parseInt(date_debut[2]);
		 
		 String [] date_fin = champs[3].split("/");
		 int jour2 = Integer.parseInt(date_fin[0]);
		 int mois2 = Integer.parseInt(date_fin[1]);
		 int annee2 = Integer.parseInt(date_fin[2]);
		
		 String numero_chambre = champs[4];
		 int num=Integer.valueOf(numero_chambre);

			 
		 Datee date_start = new Datee(jour, mois, annee); 
		 Datee date_end = new Datee(jour2, mois2, annee2);
		 return new Reservation(id,date_start,date_end,num);
		}
}
