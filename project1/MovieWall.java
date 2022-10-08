package project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieWall {
	
	public static void start(ActorDatabase database) {
		System.out.println("Welcome to the Movie Wall!");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		boolean repeat = true;
		
		while (repeat) {
			System.out.print("Enter the name of an actor (or \"Exit\" to quit): ");
			
			try {
				String userInput = input.readLine().toLowerCase();
				
				if (userInput.equals("exit")) {
					repeat = false;
					input.close();
				}
				else {
					Actor actor = database.getActor(userInput);
					
					if (actor.getLowercaseName().equals(userInput)) {
						System.out.println(actor);
					}
					else {
						System.out.print("No such actor. Did you mean " + actor.getName() + " (Y/N)? ");
						if (input.readLine().equalsIgnoreCase("Y")) {
							System.out.println(actor);
						}
					}
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}
