package Challenges;

import Utils.InOutUtils;
import Utils.StringUtils;

public class isPalindromeTest {
    public void run() {
        System.out.println("Palindrome checker");
        String word = InOutUtils.read("Give me a string to check");
        String ret = "false";
        boolean isPalindrome;
        isPalindrome = StringUtils.isPalindrome(word);
        if(isPalindrome){
            ret = "true";
        }
        System.out.println(ret);
    }
}
