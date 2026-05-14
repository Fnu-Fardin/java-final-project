package src;

import java.util.Scanner;

// Main class - runs the game hub and displays the main menu
// Creates game objects and launches the selected game using polymorphism

public class GameHub {

	// shared scanner - created once here and used by all games
	// this prevents input issues that happen when multiple scanners read from the same source
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		// --- CREATE GAME OBJECTS ---
		// polymorphism - each object is a Game but runs its own version of start() and play()
		Game guessTheNumber = new GuessTheNumber();
		Game rockPaperScissors = new RockPaperScissors();
		Game triviaGame = new TriviaGame();
		Game wordScramble = new WordScramble();
		Game highLowCardGame = new HighLowCardGame();


		System.out.println("==========================================");
		System.out.println("       Welcome to the Java Game Hub!      ");
		System.out.println("==========================================");
		System.out.println();


		// --- MAIN MENU LOOP - keeps running until the user chooses to quit ---
		while (true) {

			// display the menu options
			displayMenu();

			// get the user's menu selection - wrapped in try/catch so a non-number won't crash the program
			System.out.print("Enter your choice: ");

			int selection = 0;
			boolean validInput = false;

			while (!validInput) {
				try {
					String userInput = input.nextLine();
					selection = Integer.parseInt(userInput);
					validInput = true;

				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a number between 1 and 6.");
					System.out.print("Enter your choice: ");
				}
			}

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
				// launch Trivia Game
				triviaGame.start();
				triviaGame.play();

			} else if (selection == 4) {
				// launch Word Scramble
				wordScramble.start();
				wordScramble.play();

			} else if (selection == 5) {
				// launch High-Low Card Game
				highLowCardGame.start();
				highLowCardGame.play();

			} else if (selection == 6) {
				// quit the system
				System.out.println("Thanks for visiting the Java Game Hub. Goodbye!");
				System.exit(0);

			} else {
				// invalid selection - ask again
				System.out.println("Invalid option. Please enter a number between 1 and 6.");
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
		System.out.println("3. Trivia Game");
		System.out.println("4. Word Scramble");
		System.out.println("5. High-Low Card Game");
		System.out.println("6. Quit");
		System.out.println("------------------------------------------");
	}

}
