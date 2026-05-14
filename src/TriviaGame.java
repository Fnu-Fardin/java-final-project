package src;

import java.util.Scanner;

// Child class - inherits from Game
// This is the Trivia Game - converted from the earlier assignment

public class TriviaGame extends Game {

	// Constructor - passes the game name up to the parent class using super()
	public TriviaGame() {
		super("Trivia Game");
	}


	// --- ARRAYS ---

	// questions array
	String[] questions = {
		"What is the capital of France?",
		"Which planet is closest to the sun?",
		"What is the largest ocean on Earth?",
		"How many sides does a hexagon have?",
		"What is the chemical symbol for water?",
		"Who painted the Mona Lisa?"
	};

	// answer choice arrays - one per question
	String[] choices1 = {"A. Paris", "B. Rome", "C. Madrid"};
	String[] choices2 = {"A. Venus", "B. Mars", "C. Mercury"};
	String[] choices3 = {"A. Atlantic", "B. Pacific", "C. Indian"};
	String[] choices4 = {"A. Five", "B. Six", "C. Eight"};
	String[] choices5 = {"A. CO2", "B. H2O", "C. O2"};
	String[] choices6 = {"A. Van Gogh", "B. Picasso", "C. Leonardo da Vinci"};

	// correct answers array
	String[] correctAnswers = {"A", "C", "B", "B", "B", "C"};


	// Instance Methods - overriding the parent class methods

	// start method - introduces the game to the player before it begins
	@Override
	public void start() {
		System.out.println("===========================================");
		System.out.println("          Welcome to Trivia Game!         ");
		System.out.println("===========================================");
		System.out.println("Answer 6 trivia questions.");
		System.out.println("Enter A, B, or C for each question.");
		System.out.println();
	}

	// displayQuestion method - prints the question and its answer choices
	public void displayQuestion(String question, String[] choices) {
		System.out.println(question);
		for (int i = 0; i < choices.length; i++) {
			System.out.println(choices[i]);
		}
	}

	// play method - runs the actual game logic
	@Override
	public void play() {

		// use the shared scanner from GameHub to avoid input conflicts
		Scanner input = GameHub.input;

		int correct = 0;
		int incorrect = 0;

		// all 6 choice arrays stored so we can loop through them
		String[][] allChoices = {choices1, choices2, choices3, choices4, choices5, choices6};

		// loop through all 6 questions
		for (int i = 0; i < questions.length; i++) {

			System.out.println("Question " + (i + 1) + ": ");
			displayQuestion(questions[i], allChoices[i]);

			// --- GET AND VALIDATE USER ANSWER ---
			// keep looping until the user enters A, B, or C
			String userAnswer = "";
			boolean validAnswer = false;

			while (!validAnswer) {
				try {
					System.out.print("Enter A, B, or C: ");
					userAnswer = input.nextLine().toUpperCase();

					if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C")) {
						validAnswer = true;
					} else {
						System.out.println("Invalid input. Please enter A, B, or C.");
					}

				} catch (Exception e) {
					System.out.println("Something went wrong. Please try again.");
				}
			}

			// --- CHECK IF THE ANSWER IS CORRECT ---
			if (userAnswer.equals(correctAnswers[i])) {
				System.out.println("Correct!");
				correct = correct + 1;
			} else {
				System.out.println("Incorrect. The correct answer is " + correctAnswers[i] + ".");
				incorrect = incorrect + 1;
			}

			System.out.println();

		} // end of question loop

		// --- FINAL SCORE ---
		System.out.println("You answered " + correct + " out of " + questions.length + " questions correctly.");
		System.out.println();

	} // end of play method

}
