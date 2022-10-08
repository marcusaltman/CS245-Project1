package project1;

import java.util.ArrayList;

public class Actor {
	private String name;
	private String lowercaseName;
	private ArrayList<Movie> movies = new ArrayList<>();
	
	public Actor(String actorName, Movie movie) {
		name = actorName;
		lowercaseName = name.toLowerCase();
		movies.add(movie);
	}
	
	public String getName() {
		return name;
	}
	
	public String getLowercaseName() {
		return lowercaseName;
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public ArrayList<Movie> getMovies() { // Do I need this?
		return movies;
	}
	
	
	@Override
	public String toString() {
		String movieList = "";
		for (int i = 0; i < movies.size(); i++) {
			movieList += "* Movie: " + movies.get(i).getTitle() + " as " + movies.get(i).getCharacter(name) + "\n";
		}
		//return "\nActor: " + name + "\n" + movieList;
		return movieList;
	}
}
