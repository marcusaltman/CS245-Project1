package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class ActorDatabase {
	
	private ArrayList<Actor> allActors = new ArrayList<>();
	
	
	// Creates a database and fills it with all of the actors in the file
	public ActorDatabase(String file) {
		parseCSV(new File(file));
		System.out.println(allActors.size()); // For Testing

	}
	
	public void addToDatabase(String name, Movie movie) {
		// Check to see if an actor is already in the array
		if (allActors.size() == 0) {
			allActors.add(new Actor(name, movie));
			return;
		}
		int index = search(name.toLowerCase()); // Search the ArrayList for the index of where the Actor is or should be
		
		// If the index is greater than the size of the ArrayList, add the new Actor to the end
		if (index >= allActors.size()) {
			allActors.add(new Actor(name, movie));
		}
		
		// If the index points to the correct actor, add the movie to their movie list
		if (allActors.get(index).getLowercaseName().equals(name.toLowerCase())) {
			allActors.get(index).addMovie(movie);
		}
		
		// 
		else {
			allActors.add(index, new Actor(name, movie));
		}
		
    }
	
	/**
	 * This method provides other classes with the size of the ActorDatabase
	 * @return Returns the size of the database
	 */
	public int getSize() {
		return allActors.size();
	}
		
		
	public Actor getActor(String name) {
		int index = search(name.toLowerCase());
		return allActors.get(index);
	}
	
	/**
	 * This method uses binary search to find the actor with the provided name in the database
	 * @param name The name of the actor being searched for
	 * @return Returns the index of the actor or, if not found, returns the index where the actor would have been in the ArrayList
	 */
	public int search(String name) {
		int max = allActors.size() - 1;
		int min = 0;
		int mid = (min + max) / 2;
		
		while (min <= max) {
			if (allActors.get(mid).getLowercaseName().compareTo(name) < 0) {
				min = mid + 1;
			}
			else if (allActors.get(mid).getLowercaseName().compareTo(name) > 0) {
				max = mid - 1;
			}
			else {
				return mid;
			}
			mid = (min + max) / 2;
		}
		if (allActors.get(mid).getLowercaseName().compareTo(name) < 0) {
			return mid + 1;
		}
		return mid;
	}
	
	private void parseCSV(File file) {
		try (Scanner scan = new Scanner(file)) {
			if (scan.hasNext()) {
				scan.nextLine(); // Reads and discards the header line
			}
			
			String title;
			
			while (scan.hasNext()) {
				scan.useDelimiter(",").next(); // Reads and discards the movie_id
				
				// Reads the title and creates a movie object
				title = scan.next().replaceAll("\"", "").strip(); // Saves the movie title
				Movie movie = new Movie(title);
				
				// Saves the JSON cast field and sends it to be parsed
				String cast = scan.useDelimiter("}]").next(); // Saves the entire cast field as a string
				if (parseJSON(movie, cast)) {
					scan.useDelimiter("\n").next(); // Reads and discards the crew ***THIS WILL CAUSE AN ISSUE
				}
			}
			scan.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File Not Found.");
		}
	}
	
	
	private boolean parseJSON(Movie movie, String cast) {
		cast = decode(cast); //Decodes Unicode escape sequences
		
		// Checks to see if the cast field is empty and skips the next steps if it is
		if (cast.startsWith(",[]")) {
			return false;
		}
		
		String name, role;
		String[] characters = cast.split("}");
		for (int i = 0; i < characters.length; i++) {
			String[] character = characters[i].split(", \""); // Breaks each character into their various fields
			String[] nameField = character[5].split(":"); // Splits the name field to isolate the name
			name = nameField[1].replaceAll("\"", "").strip(); // Removes the quotation marks from the name
			String[] roleField = character[1].split(":"); // Splits the role field to isolate the role
			role = roleField[1].replaceAll("\"",  "").strip(); //Removes the quotation marks from the role
			movie.addCharacter(name, role);
			addToDatabase(name, movie); // Adds the data to the database		
		}
		return true;
	}
	
	/**
	 * This method converts Unicode escape sequences to Unicode characters
	 * @param str A string that may contain Unicode escape sequences
	 * @return Returns a string with no Unicode escape sequences
	 */
	private static String decode(String str) {
		Properties p = new Properties();
		try {
			p.load(new StringReader("key=" + str));
		}
		catch (IOException e) {
			e.printStackTrace(); 
		}
		return p.getProperty("key");
	}
}


