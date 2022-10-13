# CS245-Project1
Marcus Altman
10/8/2022

I broke this project down into 5 classes. The Project1 class contains the main method, which creates an ActorDatabase object using the csv file supplied as an argument and then starts the MovieWall user interface. The ActorDatabase class has an ArrayList instance variable that is used to store all of the Actors in the provided file in alphabetical order. The Actor class has three instance variables, a name, a lowerCaseName, and an ArrayList. The name variable stores the name as it is written in the csv file and is for printing only. The lowerCaseName variable is used for sorting and searching because it ensures that actors with capital letters in the middle of their name, like Matt LeBlanc, are stored in correct alphabetical order, which helps with the "Did you mean" function and also allows the program to ignore case in the user input by just converting it to lower case when it is received. The ArrayList stores the movies the actor starred in in no particular order. The Movie class has a title instance variable and a Hashtable containing key:value pairs of all the characters in the movie, where the actor's name is the key and their character's name is the value. The MovieWall class is the user interface for the project. It allows the user to search the database for an actor's "movie wall" by their name. If the actor is found in the database, the actor's movie wall is displayed. If the actor is not found in the database, the actor at the position where the searched name would have been is presented to the user to check if there was a spelling error. Based on the user's answer, the program either presents the actor's movie wall or asks the user to enter a new name or exit the program.


Time Complexity:

Creating the Database: If t is the total number of characters (not chars) in the csv file and n is the number of actors in the database, building the database from the csv file has a time complexity of 𝜽(t log n) because reading and writing the characters is 𝜽(t) and searching for the correct position to add each character using binary search is 𝜽(log n).

Searching the Database: The list is sorted alphabetically by actor name, so when the user searches for an actor in the database, the program uses binary search to find the actor, which is 𝜽(log n).

Printing the Movie Wall: Printing all of the movies in the actor's movie list is O(m), where m is the number of movies they have starred in.
