package Chris;

/**
 * 
 * @author  Chris
 * 
 *
 */
public class Scrabble {
	public static String result = "";
	public static void main(String text) {
		// TODO Auto-generated method stub
		int n = text.length();
		Scrabble combination = new Scrabble();
		combination.combine(text, 0, n-1);
	}
	 /** 
     * recursive combination function 
     * @param str string to calculate permutation for 
     * @param f starting index 
     * @param r end index 
     */
    private String combine(String str, int f, int r) {
    	
        if (f == r) {
        
        	if (str != null) {
        		result += "  " + str;
        	}
        }
        else{ 
            for (int i = f; i <= r; i++) { 
                str = scramble(str,f,i); 
                combine(str, f+1, r); 
                str = scramble(str,f,i); 
            } 
        }
		return result; 
    } 
    /**
     * getter for the text area text 
     * 
     * @return string of all combinations
     */
    public static String getResult() {
		return result;
	}

	/** 
     * scramble Characters at position 
     * @param a string value 
     * @param i position 1 
     * @param j position 2 
     * @return scrambled string 
     */
    public String scramble(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
  
} 
	


