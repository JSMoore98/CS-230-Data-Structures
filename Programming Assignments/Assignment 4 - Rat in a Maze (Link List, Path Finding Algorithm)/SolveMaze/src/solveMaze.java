import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * This program randomly generates a maze, and then follows an algorithm that utilizes a link list stack.
 * The algorithm checks for a solution to the maze, displaying it as it goes
 * @author Josiah Moore
 */

public class solveMaze {

	public static void main(String[] args) throws InterruptedException {

		Random rand = new Random();
		// Generates a random maze size within a given range
		int randomSize = rand.nextInt(10) + 10;

		mazeGenerator(randomSize, rand);

	}

	public static void mazeGenerator(int size, Random rand) throws InterruptedException {
		char[][] maze = new char[size][size];
		int randomNumber, start1, start2, end1, end2;

		// Fills the maze with #'s
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[row].length; col++) {
				maze[row][col] = '#';
			}
		}

		// Adds a random amount of .'s
		for (int row = 1; row < maze.length - 1; row++) {
			for (int col = 1; col < maze[row].length - 1; col++) {
				randomNumber = rand.nextInt(10);
				if (randomNumber <= 7)
					maze[row][col] = '.';
				else
					maze[row][col] = '#';
			}
		}

		// Creates the starting and ending points of the maze
		start1 = rand.nextInt(size - 2) + 1;
		end1 = rand.nextInt(size - 2) + 1;
		start2 = 0;
		end2 = size - 1;

		// Guarantees that the start and ends have an open spot next to them which
		// significantly increases the chance of a valid path
		maze[start1][start2] = '.';
		maze[start1][start2 + 1] = '.';
		maze[end1][end2] = '.';
		maze[end1][end2 - 1] = '.';

		mazeTraverse(maze, start1, start2, end1, end2, size);

		// Displays the final version of the maze
		TimeUnit.MILLISECONDS.sleep(150);
		System.out.println();
		System.out.println();
		System.out.println();
		for (int row = 0; row < maze.length; row++) {
			System.out.println();
			for (int col = 0; col < maze[row].length; col++) {
				System.out.print(maze[row][col]);
			}
		}
		System.out.println();

	}

	public static void mazeTraverse(char[][] maze, int start1, int start2, int end1, int end2, int size)
			throws InterruptedException {
		int pos1 = start1;
		int pos2 = start2 + 1;
		boolean finish = false;

		LinkedStack<Integer> rows = new LinkedStack<Integer>();
		LinkedStack<Integer> cols = new LinkedStack<Integer>();

		maze[start1][start2] = '@';
		maze[start1][start2 + 1] = '@';

		while (!finish) {
			// Checks Right
			if (maze[pos1][pos2 + 1] == '.') {
				rows.push(pos1);
				cols.push(pos2);
				pos2 = pos2 + 1;
				maze[pos1][pos2] = '@';
			}
			// Checks Left
			else if (maze[pos1][pos2 - 1] == '.') {
				rows.push(pos1);
				cols.push(pos2);
				pos2 = pos2 - 1;
				maze[pos1][pos2] = '@';
			}
			// Checks Down
			else if (maze[pos1 + 1][pos2] == '.') {
				rows.push(pos1);
				cols.push(pos2);
				pos1 = pos1 + 1;
				maze[pos1][pos2] = '@';
			}
			// Checks Up
			else if (maze[pos1 - 1][pos2] == '.') {
				rows.push(pos1);
				cols.push(pos2);
				pos1 = pos1 - 1;
				maze[pos1][pos2] = '@';
			}
			// Else it Backtracks
			else {
				// Checks if it's back at the start
				if (rows.isEmpty() && cols.isEmpty()) {
					maze[start1][start2 + 1] = 'X';
					return;
				}
				maze[pos1][pos2] = 'X';
				pos1 = rows.pop();
				pos2 = cols.pop();
			}

			// Displays Maze
			TimeUnit.MILLISECONDS.sleep(150);
			System.out.println();
			System.out.println();
			System.out.println();
			for (int row = 0; row < maze.length; row++) {
				System.out.println();
				for (int col = 0; col < maze[row].length; col++) {
					System.out.print(maze[row][col]);
				}
			}
			System.out.println();

			//Check if it's at the end
			if (pos1 == end1) {
				if (pos2 == end2)
					finish = true;
			}
		}

	}

}