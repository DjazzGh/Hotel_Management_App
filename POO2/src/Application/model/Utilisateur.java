package Application.model;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Utilisateur {
 String NomUtilisateur;
 String motdepasse;
 static final String Admin1="Rania";
 static final String Admin2="Racha";
 static final String Admin3="Djazia";

 static final String password1="123";
 static final String password2="456";
 static final String password3="789";




 public static boolean AuthentificationAdmin(String username,String password) {
	  if(username.equals(Admin1) && password.equals(password1))
	  {
	   return true;
	  }
	  else {

	     if(username.equals (Admin2) && password.equals(password2)){
	      return true ;
	     }
	     else {

	       if (username.equals(Admin3) && password.equals(password3) )
	      {
	       return true;
	      }
	       else {

	       return false ;}

	 }}}

 public static boolean SubscriptionCheck(String Nom, String Prenom, String Email, String NumeroTelephone, Datee datenaissance, String username, String password) {
  //Si l'utilisateur n'entre pas une information
  if(Nom.isEmpty() || Prenom.isBlank() || Email.isBlank() || NumeroTelephone.isBlank() || Datee.isBlank(datenaissance) || username.isBlank() || password.isBlank()) {
   return false;
  }
  //Vérification du numéro de telephone
  if( NumeroTelephone.length()!= 10 || !NumeroTelephone.startsWith("0") )
  {
   return false;
  }
  int n=0;
  try {
  n=Fichier.compterLignesFichier("Clients");}
  catch(IOException ex) {
	  System.out.println(ex);
  }
  Client cl = new Client(n,Nom,Prenom,Email,NumeroTelephone,datenaissance,username,password);
  Fichier.addToFile("Clients", cl.toString());
  return true;
 }

 public static boolean AuthentificationClient(String username, String password) {
	 try { 
		 int a=Fichier.findLineNumberWithWord("Clients",username);
		 int b=Fichier.findLineNumberWithWord("Clients",password);
		 if(a==b) {
			 return true;
		 }else { return false;}
		 }
			catch(IOException e) {
				return false;
				
			}

}

}

