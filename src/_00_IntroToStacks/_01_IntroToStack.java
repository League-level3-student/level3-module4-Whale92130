package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	Stack<Double> DS = new Stack<Double>();
    	
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
    	while(DS.size() < 100) {
    		Random ran = new Random();
    		DS.push(ran.nextDouble()+ran.nextInt(101));
    		
    	}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
    	String q = JOptionPane.showInputDialog(" enter in two numbers between 0 and 100, inclusive. (# #)");
    	String[] nums = q.split(" ");
    	double num1 = Double.parseDouble(nums[0]);
    	double num2 = Double.parseDouble(nums[1]);
    	System.out.println(num1 + " " + num2);
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
    	System.out.println("Popping elements off stack...");
		System.out.println("Elements between " + num1 + " and " + num2);
    	while(DS.size() > 0) {
    		double popped = DS.pop();
    		if (popped >= num1 && popped <= num2) {
    			System.out.println(popped);
    		}
    	}

        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}
