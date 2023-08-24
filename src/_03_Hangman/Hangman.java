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
	JLabel label2 = new JLabel();
	StringBuilder build = new StringBuilder();
	String selectedWord;
	String blank = "";
	int lives = 9;
	int index = 0;
	void hangMan() {
		//list
		Utilities util = new Utilities();
		boolean used = false;
		Stack<String> list = new Stack<String>();
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
				i=0;
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
		System.out.println("SELECTED WORD: " + selectedWord);
		System.out.println(list.size());
		//game
		
		String under = "";
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(label1);
		panel.add(label2);
		label2.setText("Lives Left: " + lives);
		frame.pack();
		frame.resize(500, 50);
		frame.setVisible(true);
		
		frame.addKeyListener(this);
		for (int i = 0; i < selectedWord.length()+1; i++) {
			blank=blank+"_";
		}
		build.append(blank);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		char input = arg0.getKeyChar();
		String inputS = input+"";
		if (selectedWord.contains(inputS)) {
			System.out.println("CORRECT");
			char[] chars = selectedWord.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				
			}
		}
		else {
			lives--;
			label2.setText("Lives Left: " + lives);
			System.out.println("INCORRECT");
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
