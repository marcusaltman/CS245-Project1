package project1;

public class Project1 {

	public static void main(String[] args) {
		ActorDatabase database = new ActorDatabase(args[0]); // Builds the database with the specified file
		MovieWall.start(database); // Starts the Movie Wall user interaction
	}
}
