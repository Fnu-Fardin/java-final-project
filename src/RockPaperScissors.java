package src;

import java.util.Scanner;

// Child class - inherits from Game
// This is the Rock, Paper, Scissors game

public class RockPaperScissors extends Game {

	// Constructor - passes the game name up to the parent class using super()
	public RockPaperScissors() {
		super("Rock, Paper, Scissors");
	}


	// Instance Methods - overriding the parent class methods

	// start method - introduces the game to the player before it begins
	@Override
	public void start() {
		System.out.println("===========================================");
		System.out.println("      Welcome to Rock, Paper, Scissors!   ");
		System.out.println("===========================================");
		System.out.println("Beat the computer in Rock, Paper, Scissors!");
		System.out.println("Enter rock, paper, or scissors to play.");
		System.out.println();
	}

	// play method - runs the actual game logic
	@Override
	public void play() {

		// use the shared scanner from GameHub to avoid input conflicts
		Scanner input = GameHub.input;

		// keep looping so the player can play multiple rounds
		while (true) {

			// --- GET AND VALIDATE PLAYER CHOICE ---
			// keep looping until the player enters a valid choice or quit
			String playerChoice = "";
			boolean validInput = false;

			while (!validInput) {
				try {
					System.out.print("Enter your choice (rock, paper, scissors) or type quit to stop: ");
					playerChoice = input.nextLine().toLowerCase();

					if (playerChoice.equals("rock") || playerChoice.equals("paper") || playerChoice.equals("scissors") || playerChoice.equals("quit")) {
						validInput = true;
					} else {
						System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
						System.out.println();
					}

				} catch (Exception e) {
					System.out.println("Something went wrong. Please try again.");
				}
			}

			// let the player quit back to the main menu
			if (playerChoice.equals("quit")) {
				System.out.println("Thanks for playing Rock, Paper, Scissors!");
				System.out.println();
				break;
			}

			// --- GENERATE COMPUTER CHOICE using Math.random() ---
			// Math.random() returns a double between 0.0 and 1.0
			// multiply by 3 to get 0, 1, or 2 and map each to a choice
			int randomNum = (int)(Math.random() * 3);
			String computerChoice = "";

			if (randomNum == 0) {
				computerChoice = "rock";
			} else if (randomNum == 1) {
				computerChoice = "paper";
			} else {
				computerChoice = "scissors";
			}

			System.out.println("Computer chose: " + computerChoice);
			System.out.println();

			// --- DETERMINE THE WINNER ---

			if (playerChoice.equals(computerChoice)) {
				// tie - both chose the same thing
				System.out.println("It's a tie!");

			} else if (playerChoice.equals("rock") && computerChoice.equals("scissors")) {
				System.out.println("You win! Rock beats scissors.");

			} else if (playerChoice.equals("paper") && computerChoice.equals("rock")) {
				System.out.println("You win! Paper beats rock.");

			} else if (playerChoice.equals("scissors") && computerChoice.equals("paper")) {
				System.out.println("You win! Scissors beats paper.");

			} else {
				// computer wins
				System.out.println("Computer wins! Better luck next time.");
			}

			System.out.println();

		} // end of round loop

	} // end of play method

}
