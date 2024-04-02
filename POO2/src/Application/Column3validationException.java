package Application;

public class Column3validationException extends Exception{
    public Column3validationException() {
        super("L'attribut de la colonne 3 doit être vrai pour modifier la valeur.");
    }
}
