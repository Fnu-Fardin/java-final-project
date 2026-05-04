package src;

// Parent class (superclass) - the foundation for all games in the system
// Every game will inherit from this class

public class Game {

	// Private Field - holds the name of the game
	private String name;


	// Constructor - sets the name of the game
	public Game(String name) {
		this.name = name;
	}


	// Getter - read only access to the game name
	public String getName() {
		return name;
	}


	// Instance Methods - all child games will override these

	// start method - introduces the game to the player
	public void start() {
		System.out.println("Starting " + this.name + "...");
	}

	// play method - runs the actual game
	public void play() {
		System.out.println("Playing " + this.name + "...");
	}

	// end method - exits the game system
	public void end() {
		System.out.println("Thanks for playing " + this.name + "! Goodbye!");
		System.exit(0);
	}

}