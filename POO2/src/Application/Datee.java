package Application;
import java.util.*;
public class Datee {
int jour;
int mois;
int année;

public Datee() {}
public Datee(int jour,int mois,int année) {
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

public static int DatetoInt(Date date) {
	return date.getannée()*360+date.getmois()*30+date.getjour();
}
public static boolean avant(Date date1,Date date2) {
	int a =DatetoInt(date1);
	int b =DatetoInt(date2);
	if(a<b) return true;
	else return false;
}
	public static boolean isBlank(Date date) {
	if(DatetoInt(date)==0) {
		return true;
	}
	return false;
}
		public String toString() {
			return jour+"/"+mois+"/"+année;
		}
		public static Datee toDatee(String date) {
		    int jour = 0, mois = 0, année = 0;
		    boolean isJour = true;

		    for (int i = 0; i < date.length(); i++) {
		        char c = date.charAt(i);

		        if (c == '/') {
		            if (isJour) {
		                mois = Integer.parseInt(date.substring(i - 2, i));
		                isJour = false;
		            } else {
		                année = Integer.parseInt(date.substring(i - 4, i));
		                break;
		            }
		        } else if (Character.isDigit(c)) {
		            if (isJour) {
		                jour = jour * 10 + c - '0';
		            } else {
		                mois = mois * 10 + c - '0';
		            }
		        }
		    }

		    return new Datee(jour, mois, année);
		}

}
