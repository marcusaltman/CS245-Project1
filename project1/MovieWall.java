package project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * This class is the user interface for Movie Wall. It has a loop to continue prompting the user until they enter
 * "exit." It also has a very basic input error detection mechanism that tries to guess which actor the user
 * meant if the actor they entered is not found.
 */
public class MovieWall {
	
	public static void start(ActorDatabase database) {
		System.out.println("Welcome to the Movie Wall!");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		boolean done = false;
		
		while (!done) {
			// Prompt the user
			System.out.print("Enter the name of an actor (or \"Exit\" to quit): ");
			
			try {
				// Get user input and convert it to lower case to facilitate easier searching 
				String userInput = input.readLine().toLowerCase();
				
				// Set the loop exit flag if the user enters "exit"
				if (userInput.equals("exit")) {
					done = true;
					input.close();
				}
				else {
					// Search the database for the actor
					Actor actor = database.getActor(userInput); 
					
					// If the actor returned is correct, print their movie list
					if (actor.getLowercaseName().equals(userInput)) { 
						System.out.println(actor);
					}
					
					// If the actor returned is incorrect, check if the returned actor was the intended actor
					else {
						System.out.print("No such actor. Did you mean " + actor.getName() + " (Y/N)? ");
						
						// If the returned actor was the intended actor, print their movie list 
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
