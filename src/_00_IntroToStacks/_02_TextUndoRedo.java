package _00_IntroToStacks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	Stack<String> chars = new Stack<String>();
	String text;
	String undo;
	boolean doUndo = false;
	StringBuilder build = new StringBuilder();
	int count = 0;

	void textEditor() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		text = "";
		undo = "";
		frame.pack();
		frame.setSize(150,80);
		label.setText("Type any letter");
		panel.add(label2);
		label2.setText("|Press CTRL to Undo|");
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_A) {
			text = text + "a";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_B) {
			text = text + "b";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_C) {
			text = text + "c";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_D) {
			text = text + "d";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_E) {
			text = text + "e";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_F) {
			text = text + "f";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_G) {
			;
			text = text + "g";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_H) {
			;
			text = text + "h";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_I) {
			;
			text = text + "i";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_J) {
			text = text + "j";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_K) {
			text = text + "k";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_L) {
			text = text + "l";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_M) {
			text = text + "m";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_N) {
			text = text + "n";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_O) {
			text = text + "o";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_P) {
			text = text + "p";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_Q) {
			text = text + "q";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_R) {
			text = text + "r";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_S) {
			text = text + "s";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_T) {
			;
			text = text + "t";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_U) {
			text = text + "u";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_V) {
			text = text + "v";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_W) {
			text = text + "w";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_X) {
			text = text + "x";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_Y) {
			text = text + "y";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_Z) {
			text = text + "z";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			text = text + " ";
		}
		if (arg0.getKeyCode() == KeyEvent.VK_CONTROL) {
			if (chars.isEmpty() == false) {
				undo = chars.pop();
				System.out.println("popped");
				doUndo = true;
			}
		}
		build.replace(0, text.length(), text);
		if (doUndo) {
			build.append(undo);
			doUndo = false;
		}
		undo = "";
		if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (build.length() - 1 > 0) {
				build.deleteCharAt(build.length()-1);
				chars.push(build.charAt(build.length()-1) + "");
				System.out.println("char pushed");
			}
			else {
				build.delete(0, build.length());
			}
		}
		text = build.toString();
		count++;
		label.setText(build.toString());
		if (count < 7) {
			frame.pack();
		} else {
			frame.pack();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
