# CS245-Project1
Marcus Altman
10/8/2022

I broke this project down into 5 classes. The Project1 class contains the main method, which creates an ActorDatabase object using the file supplied as an argument and then starts the MovieWall user interface. The ActorDatabase class has an ArrayList instance variable that is used to store all of the Actors in the provided csv file. The Actor class has a name instance variable and an ArrayList that stores the movies the actor starred in. The Movie class has a title instance variable and a Hashtable containing key:value pairs of all the characters in the movie, where the actor's name is the key and their character's name is the value. The MovieWall class is the user interface for the project. It allows the user to search the database for an actor's "movie wall" by their name. If the actor is found in the database, the actor's movie wall is displayed. If the actor is not found in the database, the actor at the position where the searched name would have been is presented to the user to check if there was a spelling error. Based on the user's answer, the program either presents the actor's movie wall or asks the user to enter a new name or exit the program.


Time Complexity:

Creating the Database: If t is the total number of characters (not chars) in the csv file and n is the number of actors in the database, building the database from the csv file has a time complexity of 𝜽(t log n) because reading and writing the characters is O(t) and searching for the correct position to add each character using binary search is O(log n).

Searching the Database: When the user searches for an actor in the database, the program uses binary search to find them, which is O(log n)

Printing the Movie Wall: Printing all of the movies in the actor's movie list is O(m), where m is the number of movies they have starred in
