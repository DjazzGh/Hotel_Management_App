package Application;

public class Chambre {
  int numero;
  Type typechambre;
  boolean disponibilité;
  public Chambre(int numero,Type typechambre,boolean disponibilité) {
	  this.numero=numero;
	  this.typechambre =typechambre;
	  this.disponibilité=disponibilité;
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
}
