public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        // Check palindrome using recursion
        boolean result = isPalindrome(word, 0, word.length() - 1);

        // Print result
        if (result) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }
    }

    // Recursive method
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // Check characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }
}