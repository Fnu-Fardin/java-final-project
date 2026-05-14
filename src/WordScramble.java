package src;

import java.util.Scanner;

// Child class - inherits from Game
// This is the Word Scramble game

public class WordScramble extends Game {

	// Constructor - passes the game name up to the parent class using super()
	public WordScramble() {
		super("Word Scramble");
	}


	// array of words the game will randomly pick from
	String[] words = {"java", "computer", "program", "keyboard", "monitor", "variable", "method", "class"};


	// Instance Methods - overriding the parent class methods

	// start method - introduces the game to the player before it begins
	@Override
	public void start() {
		System.out.println("===========================================");
		System.out.println("          Welcome to Word Scramble!       ");
		System.out.println("===========================================");
		System.out.println("A word will be scrambled and shown to you.");
		System.out.println("Try to guess the original word!");
		System.out.println();
	}

	// scrambleWord method - takes a word and randomly shuffles its letters
	public String scrambleWord(String word) {

		// convert the word into a char array so we can swap individual letters
		char[] letters = word.toCharArray();

		// loop through and randomly swap letters around
		for (int i = 0; i < letters.length; i++) {
			int randomIndex = (int)(Math.random() * letters.length);

			// swap letters[i] with letters[randomIndex]
			char temp = letters[i];
			letters[i] = letters[randomIndex];
			letters[randomIndex] = temp;
		}

		// convert the char array back into a String and return it
		return new String(letters);
	}

	// play method - runs the actual game logic
	@Override
	public void play() {

		// use the shared scanner from GameHub to avoid input conflicts
		Scanner input = GameHub.input;

		// keep looping so the player can play multiple rounds
		while (true) {

			// --- PICK A RANDOM WORD FROM THE ARRAY ---
			int randomIndex = (int)(Math.random() * words.length);
			String originalWord = words[randomIndex];

			// scramble the word
			String scrambled = scrambleWord(originalWord);

			// if the scrambled word is the same as the original, scramble it again
			while (scrambled.equals(originalWord)) {
				scrambled = scrambleWord(originalWord);
			}

			System.out.println("Scrambled word: " + scrambled);

			// --- GET AND VALIDATE USER GUESS ---
			// keep looping until the user enters something that is not empty
			String userGuess = "";
			boolean validInput = false;

			while (!validInput) {
				try {
					System.out.print("Enter your guess: ");
					userGuess = input.nextLine();

					// make sure the user actually typed something
					if (userGuess.equals("")) {
						System.out.println("Your guess cannot be empty. Please try again.");
					} else {
						validInput = true;
					}

				} catch (Exception e) {
					System.out.println("Something went wrong. Please try again.");
				}
			}

			// --- CHECK THE GUESS ---
			if (userGuess.equalsIgnoreCase(originalWord)) {
				System.out.println("Correct! The word was: " + originalWord);
			} else {
				System.out.println("Incorrect. The word was: " + originalWord);
			}

			System.out.println();

			// --- ASK IF THEY WANT TO PLAY AGAIN ---
			System.out.print("Play again? (yes or no): ");
			String playAgain = "";

			try {
				playAgain = input.nextLine();
			} catch (Exception e) {
				System.out.println("Something went wrong.");
			}

			if (playAgain.equalsIgnoreCase("no")) {
				System.out.println("Thanks for playing Word Scramble!");
				System.out.println();
				break;
			}

			System.out.println();

		} // end of round loop

	} // end of play method

}
