package Application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Facture {

    public static void calculer_la_facture_des_clients(){

        try {
            boolean finished = false;
            int clientId = 1;
            while (!finished) {
                String clientReservationId = String.valueOf(clientId);

                List<String> lines = Fichier.findLinesWithPrefix("Reservations_Clients", clientReservationId);
                if (lines.isEmpty()) {
                    finished = true;
                } else {
                	boolean hasPrices = false;
                    double totalAmount = 0;
                    for (String line : lines) {
                    	String[] words = line.split(" ");
                        if (words.length > 1) { // Check if line has at least price information
                            String priceString = words[words.length - 1];
                            try {
                                double price = Double.parseDouble(priceString);
                                totalAmount += price;
                                hasPrices = true;
                            } catch (NumberFormatException e) {
                                // Handle invalid price format (optional)
                            }
                        }
                    }
                    if (hasPrices) {
                        Fichier.addToFile("Factures_Clients", clientReservationId + " " + String.valueOf(totalAmount));
                    }
                    clientId++;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while processing files: " + e.getMessage());
        }

        try {
            Fichier.AfficherContenuFichier("Factures_Clients");
        } catch (FileNotFoundException e) {
            System.out.println("Factures_Clients file not found.");
        }
    }
}
