package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel();
	JLabel livesLeft = new JLabel();
	JLabel usedWords = new JLabel();
	String selectedWord;
	String blank = "";
	char[] word;
	char[] show;
	int lives = 9;
	int index = 0;
	Stack<String> list = new Stack<String>();
	void hangMan() {
		// list
		Utilities util = new Utilities();
		boolean used = false;
		for (int i = 0; i < util.getTotalWordsInFile("dictionary.txt"); i++) {
			String currentWord = util.readRandomLineFromFile("dictionary.txt");

			for (int o = 0; o < list.size(); o++) {
				if (o <= list.size() && o >= 0) {
					if (list.get(o).equals(currentWord)) {

						used = true;
						System.out.println("reapeat");
					}
				}
			}
			if (used == true) {
				i = 0;
				used = false;
			} else {
				list.add(currentWord);
				System.out.println("added to list");
			}
			System.out.println(list.get(i));
			System.out.println(list.size());
			if (list.size() == util.getTotalWordsInFile("dictionary.txt")) {
				i = util.getTotalWordsInFile("dictionary.txt");
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		String qS = JOptionPane.showInputDialog("pick a number bwtween 1-100");
		int q = Integer.parseInt(qS);
		selectedWord = list.get(q);
		//System.out.println("SELECTED WORD: " + selectedWord);
		System.out.println(list.size());
		// game

		String under = "";
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(label1);
		panel.add(livesLeft);
		panel.add(usedWords);
		livesLeft.setText("Lives Left: " + lives);
		frame.pack();
		frame.resize(500, 50);
		frame.setVisible(true);

		frame.addKeyListener(this);
		for (int i = 0; i < selectedWord.length(); i++) {
			blank = blank + "_";
		}
		label1.setText(blank);
		usedWords.setText("Used Letters: ");
		show = blank.toCharArray();
		word = selectedWord.toCharArray();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		char input = arg0.getKeyChar();
		String inputS = input + "";
		if (selectedWord.contains(inputS)) {
			System.out.println("CORRECT");

			for (int i = 0; i < word.length; i++) {
				if (word[i] == input) {
					show[i] = word[i];
					String output = "";
					for (int o = 0; o < show.length; o++) {
						output = output + show[o];
					}
					label1.setText(output);
				}
			}
		} else {
			lives--;
			livesLeft.setText("Lives Left: " + lives);
			System.out.println("INCORRECT");
			if (usedWords.getText().length() > 14) {
			usedWords.setText(usedWords.getText()+", "+inputS);
			}
			else {
				usedWords.setText(usedWords.getText()+inputS);
			}
			
		}
		String output2 = "";
		for (int o = 0; o < show.length; o++) {
			output2 = output2 + show[o];
		}
		if (output2.contains("_")) {
			
		}
		else {
			System.out.println("you win");
			usedWords.setText("Used Letters: ");
			restart(false);
		}
		if (lives == 0) {
			int playAgain = JOptionPane.showConfirmDialog(frame, "Game Over! \n Would You Like to Play Again?");
			System.out.println(playAgain);
			if (playAgain == 0) {
				restart(true);
			}
			else {
				System.exit(0);
			}
		}
	}
	void restart(boolean yes) {
		selectedWord = list.pop();
		for (int i = 0; i < selectedWord.length(); i++) {
			blank = blank + "_";
		}
		label1.setText(blank);
		show = blank.toCharArray();
		word = selectedWord.toCharArray();
		if (yes) {
			lives = 9;
			livesLeft.setText("Lives Left: " + lives);
			usedWords.setText("Used Letters: ");
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
