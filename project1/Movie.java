package project1;

import java.util.Hashtable;

/**
 * This class creates objects that represent movies. Each object contains a Hashtable of all of the characters in the respective movie.
 * @author marcusaltman
 */
public class Movie {
	private String title;
	private Hashtable<String, String> characters = new Hashtable<>();
	
	public Movie(String movieTitle) {
		title = movieTitle;
	}
	
	public String getTitle() {
		return title;
	}

	public void addCharacter(String actorName, String characterName) {
		characters.put(actorName, characterName);
	}
	
	public String getCharacter(String actorName) {
		return characters.get(actorName);
	}
}
