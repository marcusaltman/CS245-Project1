package project1;

public class Project1 {

	public static void main(String[] args) {
		ActorDatabase database = new ActorDatabase(args[0]);
		MovieWall.start(database);
	}
}
