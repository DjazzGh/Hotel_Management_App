package Application;
import java.util.*;
public class Date {
int jour;
int mois;
int année;

public Date() {}
public Date(int jour,int mois,int année) {
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

}
