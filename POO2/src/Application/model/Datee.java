package Application.model;

public class Datee {
	int jour;
	int mois;
	int année;

	public Datee() {}
	public Datee(int jour, int mois, int année) {
		this.jour=jour;
		this.mois=mois;
		this.année=année;
	}
	public int getjour() {
		return this.jour;
	}
	public int getmois() {
		return this.mois;
	}
	public int getannée() {
		return this.année;
	}

	public static int DatetoInt(Datee date) {
		return date.getannée()*360+date.getmois()*30+date.getjour();
	}
	public static boolean avant(Datee date1, Datee date2) {
		int a =DatetoInt(date1);
		int b =DatetoInt(date2);
		if(a<b) return true;
		else return false;
	}
	
	//Méthode pour vérifier si 2 dates sont entre 2 dates
	public static boolean entre(Datee dateoriginaldebut,Datee dateoriginalfin,Datee dateajoutédebut, Datee dateajoutéfin ) {
		int a =DatetoInt(dateoriginaldebut);
		int b =DatetoInt(dateoriginalfin);
		int c =DatetoInt(dateajoutédebut);
		int d =DatetoInt(dateajoutéfin);
		if(c>=a && d>a && c<b && d<=b ) {
			return true;
		}
		else {
			return false;
		}
	}
	

	
public static boolean isBlank(Datee date) {
	if(DatetoInt(date)==0) {
				return true;
			}
			return false;
		}
		
public String toString() {
	  String jourStr = String.valueOf(jour);  // Convert jour to String
	  if (jour < 10) {
	    jourStr = "0" + jourStr;
	  }
	  String moisStr = String.valueOf(mois);  // Convert mois to String
	  if (mois < 10) {
	    moisStr = "0" + moisStr;
	  }
	  return jourStr + "/" + moisStr + "/" + année;
	}
		
		
//Méthode pour transformer une chaine de caractere en date 
public static Datee toDatee(String date) {
    String[] dateParts = date.split("/");
    if (dateParts.length != 3) {
        throw new IllegalArgumentException("Invalid date format. Expected format is dd/MM/yyyy");
    }
    for (String part : dateParts) {
        if (part.isEmpty()) {
            throw new IllegalArgumentException("Date part is empty. Check your date string.");
        }
    }
    int jour = Integer.valueOf(dateParts[0]);
    int mois = Integer.valueOf(dateParts[1]);
    int année = Integer.valueOf(dateParts[2]);
    return new Datee(jour, mois, année);
}

public static String formatDate(String date) {
	  String[] parts = date.split("/");
	  if (parts.length != 3) {
	    throw new IllegalArgumentException("Invalid date format. Please use MM/DD/YYYY");
	  }
	  
	  String month = parts[0];
	  String day = parts[1];
	  String year = parts[2];

	  // Add leading zeros for month and day if needed
	  month = month.length() == 1 ? "0" + month : month;
	  day = day.length() == 1 ? "0" + day : day;

	  return month + "/" + day + "/" + year;
	}







}
