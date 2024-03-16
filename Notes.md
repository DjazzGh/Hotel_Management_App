TO DO LIST:
-Dans la classe administrateur:
Finir 3 méthodes (Traiter demande, Ajouter chambre, Supprimer chambre)

-Dans la classe Client:
Finir 3 méthodes (ModifierDateReservation, ModifierchambreReservation,AnnulerReservation)
Ecrire une methode pour générer un ID unique pour chaque client et l’appeler dans le constructeur a argument
Ajouter une exception pour verifier la date naissance du client (il faut qu’il ait minimum 18 ans) et l’appeler dans le constructeur a arguments
Ajouter une exception pour verifier le numero de telephone du client (10 chiffres et commence par 0) et l’appeler dans le constructeur a arguments

-Dans la classe Date:
Ajouter des exceptions dans le constructeur avec arguments pour être sure que la date est juste (1<jour<=31,1<mois<=12,1900<année..)

-Dans la classe Utilisateur: Ecrire une methode pour l’authentification

-Remplir la classe Facture
-Remplir la classe Hotel
-Tester toutes les méthodes dans la classe Hotel




#Exceptions
-Quand l'utilisateur entre son nom, il faut que tous les caracteres soient des lettres
-Quand l'utilisateur reserve une chambre il faut que la date debut soit differente de la date fin et que la date fin soit apres la date debut
-l’administrateur ne peut pas modifier ou supprimer une chambre déjà réservée
-le client ne peut annuler sa réservation qu’avant la date de début de cette réservation
