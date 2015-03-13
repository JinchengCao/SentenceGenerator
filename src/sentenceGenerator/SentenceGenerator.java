package sentenceGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFileChooser;

/**
 * This is my version of a CIT594 assignment to read in a BNF grammar and
 * produce sentences from that grammar.
 */
public class SentenceGenerator {
	private Grammar grammar;
	private Random random = new Random();
	String name;

	/**
	 * Prompts the user for a file containing a BNF grammar, then generates
	 * several sentences from that grammar.
	 * 
	 * @param args
	 *            Unused.
	 */
	public static void main(String[] args) {
		try {
			new SentenceGenerator().run();
		} catch (IOException e) {
			System.out.println("list");
			e.printStackTrace();
		}
	}

	/**
	 * Does the work of this class.
	 * 
	 * @throws IOException
	 *             If an input exception occurs.
	 */
	private void run() throws IOException {

		// TODO: Your code goes here
		BufferedReader reader = getFileReader();

		try {
			grammar = new Grammar(reader);
			for (int i = 0; i < 20; i++) {
				List<String> list = generate("<sentence>");
				printAsSentence(list);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Expands the given term into a list of terminals. If the given term is
	 * already a terminal, a list containing this single term is returned.
	 * 
	 * @param term
	 *            A terminal or nonterminal to expand into a list.
	 * @return A list of terminals.
	 */
	List<String> generate(String term) {
		List<String> result = new ArrayList<String>();

		// TODO: Your code goes here
		if (grammar.isNonterminal(term) == false) result.add(term);
		else {
			List<String> l = (List<String>) chooseRandomElement(grammar.getDefinitions(term));
			result.addAll(l);
		}
		while (!allTerminal(result)) {
			List<String> newlist = new ArrayList<String>();
			for (String s : result) {
				if (grammar.isNonterminal(s)) 
					newlist.addAll((List<String>) chooseRandomElement(grammar.getDefinitions(s)));
			    else
					newlist.add(s);
			}
			result = new ArrayList<String>(newlist);
		}
		return result;
	}

	public boolean allTerminal(List<String> list) {
		for (String l : list) {
			if (grammar.isNonterminal(l))
				return false;
		}
		return true;
	}

	/**
	 * Randomly choose and return one element from a list.
	 * 
	 * @param list
	 *            The list from which the selection is to be made.
	 * @return The randomly selected element.
	 */
	private Object chooseRandomElement(List list) {
		return (list.get(random.nextInt(list.size())));
	}

	/**
	 * Prints the given list of words as a sentence. The first word is
	 * capitalized, and a period is printed at the end.
	 * 
	 * @param list
	 *            The words to be printed.
	 */
	void printAsSentence(List<String> list) {
		// TODO: Your code goes here
		for (String l : list) {
			System.out.print(l + " ");
		}
		System.out.print("\n");
	}

	/**
	 * Prompts the user to choose a file, which should contain a BNF grammar.
	 * 
	 * @return The chosen file, or <code>null</code> if none is chosen.
	 * @throws IOException
	 */
	private BufferedReader getFileReader() throws IOException {
		BufferedReader reader = null;

		// TODO: Your code goes here
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Choose a file");
			int result = chooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				name = file.getCanonicalPath();
				reader = new BufferedReader(new FileReader(name));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reader;
	}
}
