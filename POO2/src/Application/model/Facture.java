package Application.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList; // Use ArrayList for efficiency
import java.util.List;

public class Facture {

    public static void calculer_la_facture_des_clients() {

        try {
            int numberOfClients = Fichier.compterLignesFichier("Clients");

            for (int clientId = 1; clientId <= numberOfClients; clientId++) {
                String clientReservationId = String.valueOf(clientId);
                List<String> reservations = Fichier.findLinesWithPrefix("Reservations_Clients", clientReservationId);

                double totalAmount = 0.0; // Use double for currency precision

                for (String reservationLine : reservations) {
                    String[] reservationInfo = reservationLine.split(" ");

                    if (reservationInfo.length < 4) { // Handle invalid reservation lines
                        System.err.println("Warning: Skipping invalid reservation line: " + reservationLine);
                        continue;
                    }

                    String roomNumber = reservationInfo[3];

                    try {
                        String roomLine = Fichier.findFirstLineWithPrefix("Chambres", roomNumber);
                        String[] roomInfo = roomLine.split(" ");

                        if (roomInfo.length < 3) { // Handle invalid room lines
                            System.err.println("Warning: Skipping invalid room line: " + roomLine);
                            continue;
                        }

                        double price = Double.parseDouble(roomInfo[2]);
                        totalAmount += price;
                    } catch (NumberFormatException e) {
                        System.err.println("Warning: Invalid price format in room line for room " + roomNumber + ". Skipping.");
                    }
                }

                Fichier.addToFile("Factures_Clients", clientReservationId + " " + String.valueOf(totalAmount));
            }
        } catch (IOException e) {
            System.err.println("An error occurred while processing files: " + e.getMessage());
        }
    }
}


    



	
