package chrisV2;

/**
 * 
 * @author Chris
 * 
 *
 */
public class Analyze {
	
	private static int count;
	private static int bigCount;
	private static String password;
	private static String text;
	public static String result;
	private static int block;
	

	/**
	 * password gets passed here to make sure its a good one
	 * 
	 * @param y password thats been passed here
	 */
	public static void analyze(String y) {
		password = y;
		block = strength(password);
		result = check(block);

	}

	/**
	 * 
	 * @param str The password
	 * @param spot First check at password
	 * @param spot2 Second check at password
	 * @return block consecutive char in a row
	 */
	private static int strength(String str) {
		bigCount = 0;
		char c;
		for(int i = 0; i < str.length()-1; i++) {
			c = str.charAt(i);
			count = countChars(str, c);
			if(count > bigCount) {
				bigCount = count;
			}
		}
		return bigCount;
	}

	private static String check(int strength) {
		text = "";
		if (strength >= 3) {
			int diff = strength - 2;
			text = ("The largest block in the password is " + strength + " This password " + '\n'
					+ " can be made stronger by reducing this block by " + diff + " or more");
		} else {
			text = ("The largest block in the password is " + strength + " This is a decent password.");
		}
		return text;

	}

	public static String getResult() {
		return result;
	}
	
	public static int countChars(String text, char c ) {
		char now;
		count = 0;
		for (int i = 0; i < text.length(); i++) {
			now = text.charAt(i);
			 if(text.charAt(i) == c) {
				if(i > 0 && text.charAt(i-1) == c ) {
					count ++;
				}else if(i < text.length()-1 && text.charAt(i+1) == c) {
					count++;
				}
			 }
		     
		}
		
		return count;
		
	}

}
