package Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
  	  //return null; // Return null if the word is not found
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
                // Only write the line if it does not contain the word
                if (!line.contains(word)) {
                    writer.write(line);
                    writer.write(System.lineSeparator());
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
    	  StringBuilder sb = new StringBuilder();
    	  try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
    	    String line;
    	    while ((line = reader.readLine()) != null) {
    	      sb.append(line.replace(oldWord, newWord)).append(System.lineSeparator());
    	    }
    	  }

    	  try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
    	    writer.write(sb.toString());
    	  }

    	  System.out.println("Le mot '" + oldWord + "' a été remplacé par '" + newWord + "' dans " + filename);
    	}

    public static void replaceLineInFile(String filePath, String oldLine, String newLine) throws IOException {
    	  // Use a temporary file to avoid modifying the original file during read/write
    	  File tempFile = File.createTempFile("replaceLine", ".tmp");

    	  BufferedReader reader = new BufferedReader(new FileReader(filePath));
    	  BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    	  String currentLine;

    	  try {
    	    while ((currentLine = reader.readLine()) != null) {
    	      // Check if the current line matches the line to be replaced
    	      if (currentLine.equals(oldLine)) {
    	        writer.write(newLine);
    	      } else {
    	        writer.write(currentLine);
    	        writer.newLine(); // Add newline character for compatibility
    	      }
    	    }
    	  } finally {
    	    // Close resources even if there are exceptions
    	    reader.close();
    	    writer.close();
    	  }

    	  // Delete the original file
    	  File originalFile = new File(filePath);
    	  if (!originalFile.delete()) {
    	    throw new IOException("Could not delete original file: " + filePath);
    	  }

    	  // Rename the temporary file to the original file name
    	  if (!tempFile.renameTo(originalFile)) {
    	    throw new IOException("Could not rename temporary file to original file: " + filePath);
    	  }
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
    public static String lireLigne(int numeroLigne, String cheminFichier) throws IOException {

        // Vérifier si le numéro de ligne est positif
        if (numeroLigne <= 0) {
            throw new IllegalArgumentException("Le numéro de ligne doit être positif");
        }

        // Ouvrir un flux de lecture sur le fichier
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {

            // Parcourir le fichier ligne par ligne
            for (int i = 1; i < numeroLigne; i++) {
                reader.readLine();
            }

            // Lire la ligne spécifiée
            return reader.readLine();

        } catch (IOException e) {
            throw new IOException("Impossible de lire le fichier : " + cheminFichier, e);
        }
    }

    public static List<String> findLinesWithPrefix(String filePath, String prefix) throws IOException {
        List<String> matchingLines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
          if (line.startsWith(prefix)) {
            matchingLines.add(line);
          }
        }

        reader.close();
        return matchingLines;
      }
    public static String findFirstLineWithPrefix(String filePath, String prefix) {
    	  // Read the file line by line
    	  try (Scanner scanner = new Scanner(new File(filePath))) {
    	    while (scanner.hasNextLine()) {
    	      String line = scanner.nextLine();
    	      if (line.startsWith(prefix)) {
    	        return line; // Return the first match
    	      }
    	    }
    	  } catch (FileNotFoundException e) {
    	    // Handle file not found exception
    	    System.err.println("Error: File not found: " + filePath);
    	    return ""; // Or throw an alternative exception if needed
    	  }

    	  // No line found with the prefix
    	  return "";
    	}
    public static int findLineNumberWithPrefix(String filePath, String prefix) {
    	  int lineNumber = 1; // Start counting from line 1
    	  // Read the file line by line
    	  try (Scanner scanner = new Scanner(new File(filePath))) {
    	    while (scanner.hasNextLine()) {
    	      String line = scanner.nextLine();
    	      if (line.startsWith(prefix)) {
    	        return lineNumber; // Return the line number of the first match
    	      }
    	      lineNumber++;
    	    }
    	  } catch (FileNotFoundException e) {
    	    // Handle file not found exception
    	    System.err.println("Error: File not found: " + filePath);
    	    return -1; // Or throw an alternative exception if needed
    	  }

    	  // No line found with the prefix
    	  return -1;
    	}
    public static int findLineNumberWithLastWord(String filePath, String targetWord) {
    	  int lineNumber = 1; // Start counting from line 1
    	  String lastWord = null;
    	  // Read the file line by line
    	  try (Scanner scanner = new Scanner(new File(filePath))) {
    	    while (scanner.hasNextLine()) {
    	      String line = scanner.nextLine();
    	      // Update lastWord with the current line's last word
    	      lastWord = extractLastWord(line);
    	      if (lastWord != null && lastWord.equals(targetWord)) {
    	        return lineNumber; // Return the line number of the match
    	      }
    	      lineNumber++;
    	    }
    	  } catch (FileNotFoundException e) {
    	    // Handle file not found exception
    	    System.err.println("Error: File not found: " + filePath);
    	    return -1; // Or throw an alternative exception if needed
    	  }

    	  // No line found with the target word
    	  return -1;
    	}

    	// Helper method to extract the last word from a line
    	private static String extractLastWord(String line) {
    	  if (line.isEmpty()) {
    	    return null; // Handle empty line
    	  }
    	  // Split the line using whitespace as delimiter
    	  String[] words = line.split("\\s+");
    	  return words[words.length - 1]; // Return the last element (last word)
    	}

    	public static List<String> findLinesWithLastWord(String filePath, String targetWord) {
    		  List<String> linesWithTargetWord = new ArrayList<>();
    		  int lineNumber = 1; // Start counting from line 1
    		  String lastWord = null;
    		  
    		  try (Scanner scanner = new Scanner(new File(filePath))) {
    		    while (scanner.hasNextLine()) {
    		      String line = scanner.nextLine();
    		      // Update lastWord with the current line's last word
    		      lastWord = extractLastWord(line);
    		      if (lastWord != null && lastWord.equals(targetWord)) {
    		        linesWithTargetWord.add(line); // Add the line to the list
    		      }
    		      lineNumber++;
    		    }
    		  } catch (FileNotFoundException e) {
    		    // Handle file not found exception
    		    System.err.println("Error: File not found: " + filePath);
    		    return linesWithTargetWord; // Return the empty list
    		  }

    		  return linesWithTargetWord;
    		}

    public static String findLinesWithPrefixCombined(String filePath, String prefix) {

    	  // Read the file content into a list of lines
    	  List<String> lines = new ArrayList<>();
    	  try (Scanner scanner = new Scanner(new File(filePath))) {
    	    while (scanner.hasNextLine()) {
    	      lines.add(scanner.nextLine());
    	    }
    	  } catch (FileNotFoundException e) {
    	    // Handle file not found exception
    	    System.err.println("Error: File not found: " + filePath);
    	    return ""; // Or throw an alternative exception if needed
    	  }

    	  // Filter lines with the prefix
    	  StringBuilder matchingLines = new StringBuilder();
    	  for (String line : lines) {
    	    if (line.startsWith(prefix)) {
    	      matchingLines.append(line).append("\n");
    	    }
    	  }

    	  return matchingLines.toString();
    	}

    public static List<String> filterLines(String filePath, String stringToExclude) throws IOException {
        List<String> filteredLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, Charset.forName("UTF-8")))) {
          String line;
          while ((line = reader.readLine()) != null) {
            if (!line.trim().contains(stringToExclude.trim())) {
              filteredLines.add(line);
            }
          }
        }
        return filteredLines;
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
    
    public static void removeDuplicates(String filename) {
        File file = new File(filename);
        Set<String> lines = new LinkedHashSet<String>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String unique : lines) {
                writer.write(unique);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  /*  public static void remplacerMotLigneSpecifique(String fichier, int indexLigne, String motARemplacer, String motRemplacement) throws IOException {
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
     }*/
    public static void replaceInLine(String filePath, int lineNumber, String oldWord, String newWord) throws IOException {
    	  // Read the file content into a list of lines
    	  List<String> lines = new ArrayList<>();
    	  try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
    	    String line;
    	    int blankLineCount = 0;
    	    while ((line = reader.readLine()) != null) {
    	      lines.add(line);
    	      if (line.isBlank()) {
    	        blankLineCount++;
    	      }
    	    }
    	  }

    	 

    	  // Replace the word in the specified line
    	  lines.set(lineNumber - 1, lines.get(lineNumber - 1).replaceAll(oldWord, newWord));

    	  // Write the modified lines back to the file
    	  try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
    	    for (String line : lines) {
    	      writer.write(line);
    	      writer.newLine();
    	    }
    	  }
    	}
    public static void removeBlankLinesInPlace(String filePath) throws IOException {
    	  // Open reader and writer for the same file
    	  BufferedReader reader = new BufferedReader(new FileReader(filePath));
    	  StringBuilder content = new StringBuilder();

    	  String line;
    	  // Read line by line and build content
    	  while ((line = reader.readLine()) != null) {
    	    if (!line.isBlank()) {
    	      content.append(line).append(System.lineSeparator()); // Add newline character
    	    }
    	  }

    	  // Close the reader (writer not needed as we modify the same file)
    	  reader.close();

    	  // Overwrite the file content
    	  Files.writeString(Paths.get(filePath), content.toString());
    	}





  
    public static String replaceText(String input, String newText) {
        String result = input;
        if (input.contains("Dates: ")) {
            result = input.substring(0, input.indexOf("Dates: ")) + newText;
        }
        return result;
    }

    public static boolean CheckAvailabilityofRoom(String text, String startDate, String endDate) {
    
    	  if (text.contains("Dates: Vide")) {
    	    return true;}
    	  if (text.contains("Début: "+startDate+"-Fin: "+endDate)) {
      	    return false;}
    	  else {
    		/*String parts[]=text.split("Dates: ");
            String[] dateRanges = parts[1].split(" "); // Split by spaces

            for (String dateRange : dateRanges) {
                String[] parts2 = dateRange.split("-");  // Split by "-"

                // Manual date parsing (without libraries)
                int dayStart = Integer.parseInt(parts2[1].substring(0, 2));
                int monthStart = Integer.parseInt(parts2[1].substring(3, 5));
                int yearStart = Integer.parseInt(parts2[1].substring(6));

                int dayEnd = Integer.parseInt(parts2[3].substring(0, 2));
                int monthEnd = Integer.parseInt(parts2[3].substring(3, 5));
                int yearEnd = Integer.parseInt(parts2[3].substring(6));

                // Process the extracted dates (comparison, storing in variables, etc.)
                String datedebut="Start Date: " + dayStart + "/" + monthStart + "/" + yearStart;
               String datefin="End Date: " + dayEnd + "/" + monthEnd + "/" + yearEnd;
               if(Datee.entre(Datee.toDatee(datedebut), Datee.toDatee(datedebut), Datee.toDatee(startDate), Datee.toDatee(endDate))) {
            	   return false; 
               }    		  
    		  
    	  }*/return true;
    	  }

    	}
    public static String updateLineWithDates(String line, String stringDateDebut, String stringDateFin) {
    	  if (line.contains("Dates: Vide")) {
    	    // Replace "Dates : Vide" with dates information
    	    return line.replace("Dates: Vide", "Dates: Début: " + stringDateDebut + "-Fin: " + stringDateFin);
    	  } else {
    	    // Add dates information to the end of the line
    	    return line + " Début: " + stringDateDebut + "-Fin: " + stringDateFin;
    	  }
    	}
    public static String removeolddate(String line, String stringDateDebut, String stringDateFin) {
  	
  		String originalString = line;
  		String substringToRemove = "Dates:"+ " Début: " + stringDateDebut + "-Fin: " + stringDateFin;
  		return originalString.replace(substringToRemove, "");
  	  
  	  
  	}

    
    
    
    
	public static void main(String [] args) throws FileNotFoundException{

	boolean b=Fichier.CheckAvailabilityofRoom("2 Double 90.0 Dates: Début: 20/02/2024-Fin: 25/02/2024","21/02/2024", "22/02/2024");
	System.out.println(b);

	}}	
