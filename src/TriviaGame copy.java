package codingProjects;

import java.util.Scanner;

public class TriviaGame {

	static Scanner input = new Scanner(System.in);

	// --- ARRAYS ---

	// questions array
	static String[] questions = {
		"What is the capital of France?",
		"Which planet is closest to the sun?",
		"What is the largest ocean on Earth?",
		"How many sides does a hexagon have?",
		"What is the chemical symbol for water?",
		"Who painted the Mona Lisa?"
	};

	// answer choice arrays - one per question
	static String[] choices1 = {"A. Paris", "B. Rome", "C. Madrid"};
	static String[] choices2 = {"A. Venus", "B. Mars", "C. Mercury"};
	static String[] choices3 = {"A. Atlantic", "B. Pacific", "C. Indian"};
	static String[] choices4 = {"A. Five", "B. Six", "C. Eight"};
	static String[] choices5 = {"A. CO2", "B. H2O", "C. O2"};
	static String[] choices6 = {"A. Van Gogh", "B. Picasso", "C. Leonardo da Vinci"};

	// correct answers array
	static String[] correctAnswers = {"A", "C", "B", "B", "B", "C"};


	// --- METHODS ---

	// displays the question and its answer choices
	public static void displayQuestion(String question, String[] choices) {
		System.out.println(question);
		for (int i = 0; i < choices.length; i++) {
			System.out.println(choices[i]);
		}
	}

	// prompts user and validates input - keeps looping until A, B, or C is entered
	public static String getUserAnswer() {
		String answer = "";
		while (true) {
			System.out.print("Enter A, B, or C: ");
			answer = input.nextLine().toUpperCase();
			if (answer.equals("A") || answer.equals("B") || answer.equals("C")) {
				break;
			} else {
				System.out.println("Invalid input. Please enter A, B, or C.");
			}
		}
		return answer;
	}

	// checks if user answer matches correct answer
	public static boolean checkAnswer(String userAnswer, String correctAnswer) {
		if (userAnswer.equals(correctAnswer)) {
			return true;
		} else {
			return false;
		}
	}

	// runs the full trivia game
	public static void runTriviaGame() {

		int correct = 0;
		int incorrect = 0;

		// all 6 choice arrays stored so we can loop through them
		String[][] allChoices = {choices1, choices2, choices3, choices4, choices5, choices6};

		// loop through all 6 questions
		for (int i = 0; i < questions.length; i++) {

			System.out.println("Question " + (i + 1) + ": " + questions[i]);
			displayQuestion("", allChoices[i]);

			String userAnswer = getUserAnswer();

			if (checkAnswer(userAnswer, correctAnswers[i])) {
				System.out.println("Correct!");
				correct = correct + 1;
			} else {
				System.out.println("Incorrect. The correct answer is " + correctAnswers[i] + ".");
				incorrect = incorrect + 1;
			}

			System.out.println();
		}

		// final score
		System.out.println("You answered " + correct + " questions correctly.");
		System.out.println("You answered " + incorrect + " questions incorrectly.");
	}


	// --- MAIN ---

	public static void main(String[] args) {
		runTriviaGame();
	}

}