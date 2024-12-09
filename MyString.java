/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(countChar("CHocholete", 'c'));
        System.out.println(countChar("", 'c'));
        System.out.println(countChar("CHocholete", 'o'));
        System.out.println(subsetOf("sub", "subways"));
        System.out.println(subsetOf("pass", "space")); 
        System.out.println(subsetOf("", "space")); 
        System.out.println(spacedString("element"));
        System.out.println(spacedString("0"));
        System.out.println(spacedString(""));
        System.out.println(spacedString("no"));
        System.out.println(randomStringOfLetters(10));
        System.out.println(randomStringOfLetters(0));
        System.out.println(remove("committee", "meet"));
        System.out.println(remove("abc", "b"));
        System.out.println(remove("hello", ""));
        System.out.println(insertRandomly('s', "cat"));
        System.out.println(insertRandomly('x', ""));
        System.out.println(insertRandomly('0', "h"));
        System.out.println(subsetOf("runi","running"));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        ////
        String chosenWord = str;
        char chr = ch;
        int counter = 0;

        for (int i = 0; i < chosenWord.length(); i ++) {
            if (chosenWord.charAt(i) == chr) counter += 1;
        }

        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        ////
        String sub = str1;
        String set = str2;
        int counter = 0;

        for (int i = 0; i < sub.length(); i ++) {
            for (int j = 0; j < set.length(); j ++) {
                if (set.charAt(j) == sub.charAt(i)) {
                    if (j == 0) {
                        set = set.substring(j);
                    }
                    else {
                        set = set.substring(0, j - 1) + set.substring(j);
                    }
                    counter += 1;
                    break;
                }
            }
        }

        if (counter == sub.length()) return true;
        else return false;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        ////
        String origin = str;
        String spaced = "";

        for (int i = 0; i < origin.length(); i ++) {
            if (origin.length() == i + 1) {
                spaced += origin.charAt(i); 
                return spaced;
            }

            else {
                spaced += origin.charAt(i) + " "; 
            }
        }

        return spaced;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        ////
        String letterBase = "abcdefghijklmnopqrstuvwxyz";
        int num = n;
        String randString = "";

        for (int i = 0; i < num; i ++) {
            int randChar = (int) (Math.random() * letterBase.length());
            randString += letterBase.charAt(randChar);
        }

        return randString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
       ////
       String set = str1;
       String toSub = str2;

       for (int i = 0; i < toSub.length(); i ++) {
           for (int j = 0; j < set.length(); j ++) {
               if (set.charAt(j) == toSub.charAt(i)) {
                   if (j == 0) {
                       set = set.substring(j+1);
                   }
                   else if ( j + 1 == set.length()) {
                        set = set.substring(0, j);
                   }
                   else {
                        set = set.substring(0, j) + set.substring(j+1);
                   }
                   break;
                }
           }
       }

        return set;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
