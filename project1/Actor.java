package project1;

import java.util.ArrayList;

/**
 * This class creates objects that represent Actors. Each actor has a name instance variable that matches exactly
 * what was in the csv file and is used for printing. They also have a lowerCaseName instance variable that is 
 * used for sorting and searching operations. Finally, they each have an ArrayList of movies they have starred in.
 * @author marcusaltman
 *
 */
public class Actor {
	private String name; // Used for printing
	private String lowerCaseName; // Used for sorting and searching
	private ArrayList<Movie> movies = new ArrayList<>();
	
	public Actor(String actorName, Movie movie) {
		name = actorName;
		lowerCaseName = name.toLowerCase();
		movies.add(movie);
	}
	
	public String getName() {
		return name;
	}
	
	public String getLowercaseName() {
		return lowerCaseName;
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	@Override
	public String toString() {
		String movieList = "";
		for (int i = 0; i < movies.size(); i++) {
			movieList += "* Movie: " + movies.get(i).getTitle() + " as " + movies.get(i).getCharacter(name) + "\n";
		}
		return "\nActor: " + name + "\n" + movieList;
	}
}
