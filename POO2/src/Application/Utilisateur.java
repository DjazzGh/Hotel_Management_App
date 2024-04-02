package Application;
import Application.Date;
public abstract class Utilisateur {
 String NomUtilisateur;
 String motdepasse;
  
 static final String Admin1="Rania";
 static final String Admin2="Racha";
 static final String Admin3="Djazia";
 
 static final String password1="123";
 static final String password2="456";
 static final String password3="789";
 
 public String getUsername() {
	 return NomUtilisateur;}
 public String getPassword() {
	 return motdepasse;}
  
 
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

 public static boolean SubscriptionCheck(String Nom, String Prenom, String Email, String NumeroTelephone, String datenaissance, String username, String password) {
  //Si l'utilisateur n'entre pas une information
  if(Nom.isEmpty() || Prenom.isBlank() || Email.isBlank() || NumeroTelephone.isBlank() || datenaissance.isBlank() || username.isBlank() || password.isBlank()) {
   return false;
  }
  //Vérification du numéro de telephone
  if( NumeroTelephone.length()!= 10 || !NumeroTelephone.startsWith("0") )
  {
   return false;
  }
  Client cl = new Client(Nom,Prenom,Email,NumeroTelephone,datenaissance,username,password);
  Hotel.listClients.add(cl);
  return true;
 }

 public static boolean AuthentificationClient(String username, String password) {
  for (Client client : Hotel.listClients) {
	  String nomutilisateur=client.getUsername();
	  String motdepasse=client.getPassword();
   if (nomutilisateur.equals(username) && motdepasse.equals(password)) {
    return true;
   }
  }
  return false;
 }
}
