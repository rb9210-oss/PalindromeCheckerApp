import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    // Strategy Interface
    interface PalindromeStrategy {
        boolean checkPalindrome(String word);
    }

    // Stack Strategy
    static class StackStrategy implements PalindromeStrategy {

        public boolean checkPalindrome(String word) {

            Stack<Character> stack = new Stack<>();

            for (char c : word.toCharArray()) {
                stack.push(c);
            }

            for (char c : word.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // Deque Strategy
    static class DequeStrategy implements PalindromeStrategy {

        public boolean checkPalindrome(String word) {

            Deque<Character> deque = new LinkedList<>();

            for (char c : word.toCharArray()) {
                deque.addLast(c);
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    // Context Method
    public static boolean checkPalindrome(String word, PalindromeStrategy strategy) {
        return strategy.checkPalindrome(word);
    }

    public static void main(String[] args) {

        String word = "level";

        // Choose strategy dynamically
        PalindromeStrategy strategy = new StackStrategy();
        // PalindromeStrategy strategy = new DequeStrategy();

        boolean result = checkPalindrome(word, strategy);

        if (result) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }
    }
}