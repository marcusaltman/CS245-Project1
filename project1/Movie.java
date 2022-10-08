package project1;

import java.util.Hashtable;

public class Movie {
	private String title;
	private Hashtable<String, String> characters = new Hashtable<>();
	
	public Movie(String movieTitle) { // Used in ActorDatabase
		title = movieTitle;
	}
	
	public String getTitle() { // Used in Actor
		return title;
	}

	public void addCharacter(String actorName, String characterName) { // Used in ActorDatabase
		characters.put(actorName, characterName);
	}
	
	public String getCharacter(String actorName) { // Used in Actor
		return characters.get(actorName);
	}

}
