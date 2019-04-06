import java.util.Random;
import java.util.Scanner;

public class SimpleAdditionProblems {

	public static void main(String[] args) {

		int operand1;
		int operand2;
		int studentAnswer = 0;
		int correctAnswers = 0;
		int incorrectAnswers = 0;
		boolean invalid = true;
		Random rand = new Random();
		final int MAX_PROBLEMS = 5;
		Scanner keyboard = new Scanner(System.in);
		ABQueue<AdditionProblem> queue = new ABQueue<AdditionProblem>(MAX_PROBLEMS);

		System.out.println("I am going to give you " + MAX_PROBLEMS + " simple addition problems.");
		System.out.println("I will display a problem. You need to type the answer.");
		for (int count = 1; count <= MAX_PROBLEMS; count++) {
			invalid = true;
			operand1 = rand.nextInt(10);
			operand2 = rand.nextInt(10);
			AdditionProblem problem = new AdditionProblem(operand1, operand2);

			while (invalid) {
				System.out.println(problem.toString());
				try {
					studentAnswer = keyboard.nextInt();
					invalid = false;
				} catch (Exception InputMismatchException) {
					System.out.println("Please enter an integer");
					keyboard.nextLine();
				}
			}
			if (studentAnswer == problem.getAnswer()) {
				System.out.println("Correct!");
				correctAnswers++;
			} else {
				System.out.println("Incorrect");
				incorrectAnswers++;
				queue.enqueue(problem);
			}
		}

		System.out.println();
		if (!queue.isEmpty()) {
			System.out.println("You missed " + incorrectAnswers + " problems");
			System.out.println("You now have a second chance to get them right");
		}

		while (!queue.isEmpty()) {
			invalid = true;
			AdditionProblem retry = queue.dequeue();

			while (invalid) {
				System.out.println(retry.toString());
				try {
					studentAnswer = keyboard.nextInt();
					invalid = false;
				} catch (Exception InputMismatchException) {
					System.out.println("Please enter an integer");
					keyboard.nextLine();
				}
			}

			if (studentAnswer == retry.getAnswer()) {
				System.out.println("Correct!");
				correctAnswers++;
			} else {
				System.out.println("Incorrect");
				incorrectAnswers++;
				System.out.println("The correct answer is: ");
				System.out.println(retry.displayAnswer());
				System.out.println();
			}

		}

		System.out.println("You got " + correctAnswers + " correct answers");
		System.out.println("You missed " + incorrectAnswers + " problems");

		System.out.println("The program is now finished, great job!");
		keyboard.close();
		return;
	}

}
