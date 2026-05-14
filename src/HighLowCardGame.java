package src;

import java.util.Scanner;

// Child class - inherits from Game
// This is the High-Low Card Game

public class HighLowCardGame extends Game {

	// Constructor - passes the game name up to the parent class using super()
	public HighLowCardGame() {
		super("High-Low Card Game");
	}


	// Instance Methods - overriding the parent class methods

	// start method - introduces the game to the player before it begins
	@Override
	public void start() {
		System.out.println("===========================================");
		System.out.println("       Welcome to High-Low Card Game!     ");
		System.out.println("===========================================");
		System.out.println("A card between 1 and 13 will be shown to you.");
		System.out.println("Guess if the next card will be Higher (H) or Lower (L)!");
		System.out.println();
	}

	// play method - runs the actual game logic
	@Override
	public void play() {

		// use the shared scanner from GameHub to avoid input conflicts
		Scanner input = GameHub.input;

		// keep looping so the player can play multiple rounds
		while (true) {

			// --- GENERATE THE FIRST CARD ---
			// Math.random() returns a double between 0.0 and 1.0
			// multiply by 13 and add 1 to get a number between 1 and 13
			int currentCard = (int)(Math.random() * 13) + 1;
			System.out.println("Current card: " + currentCard);

			// --- GET AND VALIDATE USER GUESS ---
			// keep looping until the user enters H or L
			String userGuess = "";
			boolean validInput = false;

			while (!validInput) {
				try {
					System.out.print("Will the next card be Higher (H) or Lower (L)? ");
					userGuess = input.nextLine().toUpperCase();

					if (userGuess.equals("H") || userGuess.equals("L")) {
						validInput = true;
					} else {
						System.out.println("Invalid input. Please enter H or L.");
					}

				} catch (Exception e) {
					System.out.println("Something went wrong. Please try again.");
				}
			}

			// --- GENERATE THE NEXT CARD ---
			int nextCard = (int)(Math.random() * 13) + 1;
			System.out.println("Next card: " + nextCard);
			System.out.println();

			// --- DETERMINE THE RESULT ---

			if (nextCard == currentCard) {
				// tie - neither higher nor lower
				System.out.println("It's a tie! No winner this round.");

			} else if (nextCard > currentCard && userGuess.equals("H")) {
				// user guessed higher and next card was higher
				System.out.println("Correct! The next card was higher.");

			} else if (nextCard < currentCard && userGuess.equals("L")) {
				// user guessed lower and next card was lower
				System.out.println("Correct! The next card was lower.");

			} else {
				// user guessed wrong
				System.out.println("Wrong! Better luck next time.");
			}

			System.out.println();

			// --- ASK IF THEY WANT TO PLAY AGAIN ---
			System.out.print("Play another round? (yes or no): ");
			String playAgain = "";

			try {
				playAgain = input.nextLine();
			} catch (Exception e) {
				System.out.println("Something went wrong.");
			}

			if (playAgain.equalsIgnoreCase("no")) {
				System.out.println("Thanks for playing High-Low Card Game!");
				System.out.println();
				break;
			}

			System.out.println();

		} // end of round loop

	} // end of play method

}
