package src;

import java.util.Scanner;

// Main class - runs the game hub and displays the main menu
// Creates game objects and launches the selected game using polymorphism

public class GameHub {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// --- CREATE GAME OBJECTS ---
		// polymorphism - each object is a Game but runs its own version of start() and play()
		Game guessTheNumber = new GuessTheNumber();
		Game rockPaperScissors = new RockPaperScissors();


		System.out.println("==========================================");
		System.out.println("       Welcome to the Java Game Hub!      ");
		System.out.println("==========================================");
		System.out.println();


		// --- MAIN MENU LOOP - keeps running until the user chooses to quit ---
		while (true) {

			// display the menu options
			displayMenu();

			// get the user's menu selection
			System.out.print("Enter your choice: ");
			int selection = Integer.parseInt(input.nextLine());

			System.out.println();

			// --- HANDLE MENU SELECTION ---

			if (selection == 1) {
				// launch Guess the Number
				guessTheNumber.start();
				guessTheNumber.play();

			} else if (selection == 2) {
				// launch Rock, Paper, Scissors
				rockPaperScissors.start();
				rockPaperScissors.play();

			} else if (selection == 3) {
				// quit the system
				System.out.println("Thanks for visiting the Java Game Hub. Goodbye!");
				System.exit(0);

			} else {
				// invalid selection - ask again
				System.out.println("Invalid option. Please enter 1, 2, or 3.");
				System.out.println();
			}

		} // end of main menu loop

	} // end of main method 


	// displayMenu - helper method to print the main menu options
	// called at the top of every loop so the menu always appears after a game ends
	public static void displayMenu() {
		System.out.println("------------------------------------------");
		System.out.println("Please select a game you would like to play: ");
		System.out.println();
		System.out.println("1. Guess the Number");
		System.out.println("2. Rock, Paper, Scissors");
		System.out.println("3. Quit");
		System.out.println("------------------------------------------");
	}

}