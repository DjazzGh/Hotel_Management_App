package Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fichier {

    //Méthode pour afficher le contenu entier d'un fichier
    public static void AfficherContenuFichier(String filename) throws FileNotFoundException{
    	File f = new File("Clients");
		  Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());	
			}
			sc.close();
    }
	
	//Methode pour ecrire dans un fichier (en ecrasant les données précédemment écrites)
	public static void writeToFile(String filename, String content) {
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			  writer.write(content + "\n");
		  } catch (IOException e) {
		    e.printStackTrace();
		  }
		}
		
	//Methode pour ecrire dans un fichier (sans ecrasant les données)
	public static void addToFile(String filename, String content) {
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
			  writer.write(content + "\n");
		  } catch (IOException e) {
		    e.printStackTrace();
		  }
		}
    	
	//Methode pour chercher si un mot existe dans un fichier
    public static boolean findWordInFile(String filename, String word) {
    	  try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
    	    String line;
    	    while ((line = reader.readLine()) != null) {
    	      if (line.contains(word)) {
    	        return true;
    	      }
    	    }
    	  } catch (IOException e) {
    	    e.printStackTrace();
    	  }
    	  return false;
    	}
    
    //Methode pour retourner la ligne ou se trouve un mot donné en paramétre
    public static String findLineContainingWord(String filename, String word) throws IOException {
    	  try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
    	    String line;
    	    while ((line = reader.readLine()) != null) {
    	      if (line.contains(word)) {
    	        return line; // Return the line immediately when the word is found
    	      }
    	    }
    	  }
    	  return null; // Return null if the word is not found
    	}

    //Methode pour retourner le NOMBRE de la ligne ou se trouve un mot donné en paramétre
    public static int findLineNumberWithWord(String filename, String word) throws IOException {
    	  try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
    	    String line;
    	    int lineNumber = 0;
    	    while ((line = reader.readLine()) != null) {
    	      lineNumber++;
    	      if (line.contains(word)) {
    	        return lineNumber; // Numéro de la ligne si le mot est trouvé
    	      }
    	    }
    	  }
    	  return -1; // -1 si le mot n'est trouvé dans aucune ligne
    	}
    
    //Methode pour supprimer une ligne qui contient un mot precis
    public static void deleteLineContainingWord(String filename, String word) throws IOException {
    	  // Create temporary file
    	  String tempFilename = "temp_" + filename;
    	  File tempFile = new File(tempFilename);

    	  try (BufferedReader reader = new BufferedReader(new FileReader(filename));
    	       BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
    	    String line;
    	    while ((line = reader.readLine()) != null) {
    	      if (!line.contains(word)) {
    	        writer.write(line + System.lineSeparator()); // Write line if it doesn't contain the word
    	      }
    	    }
    	  }

    	  // Delete original file and rename temporary file
    	  File originalFile = new File(filename);
    	  if (!originalFile.delete()) {
    	    throw new IOException("Could not delete original file: " + filename);
    	  }
    	  if (!tempFile.renameTo(originalFile)) {
    	    throw new IOException("Could not rename temporary file: " + tempFilename);
    	  }

    	  System.out.println("Line containing word '" + word + "' deleted from " + filename);
    	}


    //Méthode pour remplacer un mot par un autre
    public static void replaceWordInFile(String filename, String oldWord, String newWord) throws IOException {
    	  // Créer un fichier temporaire
    	  String tempFilename = "temp_" + filename;
    	  File tempFile = new File(tempFilename);

    	  try (BufferedReader reader = new BufferedReader(new FileReader(filename));
    	       BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
    	    String line;
    	    while ((line = reader.readLine()) != null) {
    	      line = line.replace(oldWord, newWord); // Remplacer le mot
    	      writer.write(line + System.lineSeparator()); // Écrire la ligne avec le mot remplacé
    	    }
    	  }

    	  // Supprimer le fichier original et renommer le fichier temporaire
    	  File originalFile = new File(filename);
    	  if (!originalFile.delete()) {
    	    throw new IOException("Impossible de supprimer le fichier original : " + filename);
    	  }
    	  if (!tempFile.renameTo(originalFile)) {
    	    throw new IOException("Impossible de renommer le fichier temporaire : " + tempFilename);
    	  }

    	  System.out.println("Le mot '" + oldWord + "' a été remplacé par '" + newWord + "' dans " + filename);
    	}

    
    
    public static void AddLineInFile(String filePath, int lineNumber, String newLine) throws IOException {
        // Create temporary file
        File tempFile = new File(filePath + ".tmp");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            int currentLine = 1;
            while ((line = reader.readLine()) != null) {
                if (currentLine == lineNumber) {
                    writer.write(newLine);
                } else {
                    writer.write(line);
                    writer.newLine(); // Add line separator for new lines
                }
                currentLine++;
            }
        }

        // Replace original file with temporary file
        if (tempFile.exists() && tempFile.renameTo(new File(filePath))) {
            System.out.println("Line replaced successfully!");
        } else {
            System.out.println("Error replacing line in file!");
        }
    }
public static String findLineWithoutWord(String filePath, String excludedWord) throws IOException {
        String line;
        String regex = "(?!.*\\b" + excludedWord + "\\b)";  

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                if (line.matches(regex)) {
                    return line;
                }
            }
        }

        return null; 
    }
	public static ArrayList<String> findalltheLinesContainingWord(String filename, String word) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
          String line;
          while ((line = reader.readLine()) != null) {
            if (line.contains(word)) {
                lines.add(line);
              
            }
          }
        return lines;
        }
      
      }
public static void remplacerMotLigneSpecifique(String fichier, int indexLigne, String motARemplacer, String motRemplacement) throws IOException {
		String ligne = lireLigne(indexLigne, fichier); // Fonction fournie pour récupérer la ligne
		if (ligne != null) {
			String ligneModifiee = ligne.replace(motARemplacer, motRemplacement);
			// Ecrire la ligne modifiée dans le fichier d'origine
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
				writer.write(ligneModifiee);
			}
		} else {
			System.out.println("Ligne non trouvée à l'index : " + indexLigne);
		}
     }
	public static void main(String [] args) throws FileNotFoundException{
		/*
		Pour les methodes qui ont throws IOException a la fin, il faut les appeler de cette facon :
		try {
		replaceWordInFile("Clients","test", "nothing");}
		catch(IOException e) {
			System.err.println("Error deleting line from file: " + e.getMessage());
		}*/
		
		AfficherContenuFichier("Clients");

	}		
}
