package _01_TestMatchingBrackets;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {
		StringBuilder build = new StringBuilder();
		build.append(b);
		char[] chars;
		int brack1 = 0;
		int brack2 = 0;
		int index1 = 0;
		int index2 = 0;
		int correct = 0;
		if (b.contains("{") || b.contains("}")) {
			chars = b.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == '{') {
					brack1++;
					index1 = i;
				}
				if (chars[i] == '}') {
					brack2++;
					index2 = i;
				}
				if (index1 < index2) {
					correct++;
				}
			}
		}
		System.out.println(brack1 + " " + brack2);
		if (brack1 == brack2 && correct == b.length()/2) {
			return true;
		} else {
			return false;
		}
	}
}