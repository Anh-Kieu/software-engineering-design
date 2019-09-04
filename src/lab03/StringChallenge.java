/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2019
* Instructor: Prof. King
* Section: 9 am
*
* Name: Anh Kieu
* Date: 09/02/2019
*
* Lab / Assignment: lab03
*
* Description: Git, Methods and String class
*
* *****************************************/
package lab03;

/**
 * The StringChallenge class is used to evaluate several different string
 * exercises from lab03.
 *
 * @author brk009
 * @version 0.1
 */
public class StringChallenge {

    /**
     * Count the number of non-vowels (consonants) out of all letters in a string.
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countNonVowels(String s) {
        int notNonVowel = 0;
        for (int i=0; i<s.length(); i++) {
          if (s.charAt(i) == 'a' || s.charAt(i) == 'u' || s.charAt(i) == 'e' || s.charAt(i) == 'o' ||  s.charAt(i) == 'i' || !Character.isLetter(s.charAt(i))) notNonVowel ++;
        }
        return s.length() - notNonVowel;
    }

    /**
     * Count the number of non-vowels (consonants) out of all letters in a string.
     * However, this solution uses recursion.
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countNonVowelsRec(String s) {
        if (s.length() == 0) return 0;
        else {
          char first_char = s.charAt(0);
          if (!(first_char == 'a' || first_char == 'u' || first_char == 'e' || first_char == 'o' ||  first_char == 'i' || !Character.isLetter(first_char))) return 1 + countNonVowelsRec(s.substring(1));
          return countNonVowels(s.substring(1));
        }
    }

    /**
     * Check if the input String s is a palindrome
     * This solution uses recursion
     *
     * @param s The string to test
     * @return true if the String is palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
      if (s.length() == 0 || s.length() == 1) return true;
      else {
        if (s.charAt(0) == s.charAt(s.length()-1)) return isPalindrome(s.substring(1,s.length()-1));
        else {
          return false;
        }
      }
    }

    /**
     * Swap the first and the last letter if they are letters
     * Otherwise return the same String
     *
     * @param s The string to test
     * @return return the swapped String or the same String depending on the condition above
     */
    public static String swapLastAndFirstLetter(String s) {
      char first = s.charAt(0);
      char last = s.charAt(s.length()-1);
      if (Character.isLetter(first) && Character.isLetter(last)) {
        if (Character.isUpperCase(first) && Character.isLowerCase(last)) {
          return Character.toUpperCase(last) + s.substring(1,s.length()-1) + Character.toLowerCase(first);
        } else if (Character.isUpperCase(last) && Character.isLowerCase(first)) {
          return Character.toLowerCase(last) + s.substring(1,s.length()-1) + Character.toUpperCase(first);
        } else
          return s.charAt(s.length()-1) + s.substring(1,s.length()-1) + s.charAt(0);
      }
      else
        return s;
    }

    /**
     * Remove a String occurence in another String
     *
     * @param s The string to be removed
     * @param sRemove The removed pattern
     * @return return the new removed string
     */
    public static String withoutString(String s, String sRemove) {
      return s.replace(sRemove, "");
    }

    /**
     * Remove a String occurence in another String
     *
     * @param s The string to be removed
     * @param sRemove The removed pattern
     * @return return the new removed string
     */
    public static int sumNumbersInString(String s) {
      int sum = 0;
      String num = "";
      for (int i = 0; i < s.length(); i ++) {
        if (Character.isDigit(s.charAt(i))) num = num + s.charAt(i);
        else {
          if (num.length() != 0) sum += Integer.parseInt(num);
          num = "";
        }
      }
      if (num.length() != 0) sum += Integer.parseInt(num);
      return sum;
    }

    /**
     * Calculate the sum of the unicdoe of each character in the string
     *
     * @param s The string to be tested
     * @return the unicode sum
     */
    public static int addUnicodeValues(String s) {
      int sum = 0;
      for (int i = 0; i < s.length(); i ++) {
        sum += s.codePointAt(i);
      }
      return sum;
    }
    /**
     * Main program to test out each String processing method
     */
    public static void main(String[] args) {

        String sTest = "Mississippi River";
        System.out.printf("countNonVowels(\"%s\") = %d\n", sTest, countNonVowels(sTest));
        System.out.printf("countNonVowelsRec(\"%s\") = %d\n", sTest, countNonVowelsRec(sTest));

       System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));
       sTest = "amanapanama";
       System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));

       sTest = "Testing";
       System.out.printf("swapLastAndFirstLetter(\"%s\") = \"%s\"\n", sTest, swapLastAndFirstLetter(sTest));
       sTest = "Testing123";
       System.out.printf("swapLastAndFirstLetter(\"%s\") = \"%s\"\n", sTest, swapLastAndFirstLetter(sTest));

       sTest = "Testing Running Walking Jumping";
       System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "ing", withoutString(sTest, "ing"));
       System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "Sleep", withoutString(sTest, "Sleep"));

       sTest = "a1b2c3";
       System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
       sTest = "aa12bb34cc56dd78";
       System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
       sTest = "a9D>Zc8";
       System.out.printf("addUnicodeValues(\"%s\") = %d\n", sTest, addUnicodeValues(sTest));
    }
}
