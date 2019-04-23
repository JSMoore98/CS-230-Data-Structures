import java.util.Scanner;
import java.io.*;

/**
 * Uses a Binary Search Tree to read in a dictionary file, then finds any
 * misspelled words in a text document
 * 
 * @author Josiah Moore
 */

public class SpellCheck {
	public static void main(String[] args) throws FileNotFoundException {
		File text = new File("dictionary.txt");
		Scanner file = new Scanner(text);
		BST<String> dic = new BST<String>();
		BST<String> words = new BST<String>();
		String line = "";

		while (file.hasNext()) {
			line = file.next();
			if (line.contains("﻿"))
				line = line.substring(3, line.length());
			dic.insert(line);
		}

		file.close();
		text = new File("sampleText.txt");
		file = new Scanner(text);

		while (file.hasNext()) {
			line = file.next();
			if (!dic.searchFor(line))
				words.insert(line);
		}

		if (words.isEmpty())
			System.out.println("No spelling errors were detected.");
		else {
			System.out.println("The following words may have been misspelled: ");
			words.inOrderTraversal();
		}

		file.close();
	}
}