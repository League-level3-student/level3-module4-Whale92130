package _03_Hangman;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JTextField text = new JTextField();
	void Hangman() {
		Utilities util = new Utilities();
		boolean used = false;
		ArrayList<String> list = new ArrayList<String>();
	for (int i = 0; i < util.getTotalWordsInFile("dictionary.txt")+1; i++) {
		String currentWord = util.readRandomLineFromFile("dictionary.txt");
		for (int o = 0; o < list.size(); o++) {
			if (currentWord.equals(list.get(o))) {
				used = true;
			}
			
		}
		if (used = true) {
			i--;
			used = false;
		}
		else {
			list.add(currentWord);
			
		}
		System.out.println(list.get(i));
	}
	String qS = JOptionPane.showInputDialog("pick a number bwtween 1-100");
	int q = Integer.parseInt(qS);
		String selectedWord = list.get(q);
		System.out.println(list.size());
	}
}
