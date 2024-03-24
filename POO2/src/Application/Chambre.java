package Application;

public class Chambre {
  int numero;
  Type typechambre;
  boolean disponibilité;
double prix;
  public Chambre(int numero,Type typechambre,boolean disponibilité,double prix) {
	  this.numero=numero;
	  this.typechambre =typechambre;
	  this.disponibilité=disponibilité;
	  this.prix=prix;
  }
  
  public int getnumerochambre() {
	  return numero;
  }
  public Type gettypechambre() {
	  return typechambre;
  }
  public boolean getdisponibiltéchambre() {
	  return disponibilité;
  }
	  public double getprix() {
	  return this.prix;
  }
}
