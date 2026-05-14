package src;

import java.util.Scanner;

// Child class - inherits from Game
// This is the Guess the Number game

public class GuessTheNumber extends Game {

	// Constructor - passes the game name up to the parent class using super()
	public GuessTheNumber() {
		super("Guess the Number");
	}


	// Instance Methods - overriding the parent class methods

	// start method - introduces the game to the player before it begins
	@Override
	public void start() {
		System.out.println("===========================================");
		System.out.println("       Welcome to Guess the Number!       ");
		System.out.println("===========================================");
		System.out.println("I am thinking of a number between 1 and 100.");
		System.out.println("Try to guess it!");
		System.out.println();
	}

	// play method - runs the actual game logic
	@Override
	public void play() {

		// use the shared scanner from GameHub to avoid input conflicts
		Scanner input = GameHub.input;

		// generate a random secret number between 1 and 100 using Math.random()
		// Math.random() returns a double between 0.0 and 1.0
		// multiply by 100 and add 1 to get a number between 1 and 100
		int secretNumber = (int)(Math.random() * 100) + 1;

		// count how many attempts the player has made
		int attempts = 0;

		// keep looping until the player guesses correctly
		while (true) {

			// --- GET AND VALIDATE USER GUESS ---
			// wrapped in try/catch so typing letters won't crash the game
			int guess = 0;
			boolean validInput = false;

			while (!validInput) {
				try {
					System.out.print("Enter your guess: ");
					guess = Integer.parseInt(input.nextLine());
					validInput = true;

				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a number.");
				}
			}

			// add 1 to attempts every time the player guesses
			attempts = attempts + 1;

			// --- CHECK THE GUESS ---

			if (guess < secretNumber) {
				System.out.println("Too low! Try again.");
				System.out.println();
			} else if (guess > secretNumber) {
				System.out.println("Too high! Try again.");
				System.out.println();
			} else {
				// guess is correct - print result and break out of loop
				System.out.println();
				System.out.println("Correct! You guessed the number in " + attempts + " attempts!");
				System.out.println();
				break;
			}

		} // end of guess loop

	} // end of play method

}
