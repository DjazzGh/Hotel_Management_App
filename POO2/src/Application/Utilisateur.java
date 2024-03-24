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
  
 
 public boolean AuthentificationAdmin(String username,String password) {
	 if(username!=Admin1 && username!=Admin2 && username!= Admin3) {
		 return false;
	 }
	 if(password!=password1 && password!=password2 && password!=password3) {
		 return false;
	 }
	 return true;
	 
 }

 public boolean SubscriptionCheck(String Nom,String Prenom,String Email,String NumeroTelephone,Date datenaissance,String username, String password) {
	 //Si l'utilisateur n'entre pas une information
	 if(Nom.isEmpty() || Prenom.isBlank() || Email.isBlank() || NumeroTelephone.isBlank() || Date.isBlank(datenaissance) || username.isBlank() || password.isBlank()) {
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

 public boolean AuthentificationClient(String username, String password) {
	 for (Client client : Hotel.listClients) {
		    if (client.getUsername().equals(username) && client.getPassword().equals(password)) {
		      return true;
		    }
		  }
		  return false;
		}
 
}
