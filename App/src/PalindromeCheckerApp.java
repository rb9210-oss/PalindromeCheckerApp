import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String word) {
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

    // Deque-based palindrome check
    public static boolean dequePalindrome(String word) {
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

    // Two-pointer palindrome check
    public static boolean twoPointerPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        String word = "madamimadam";

        // Stack performance
        long start1 = System.nanoTime();
        stackPalindrome(word);
        long end1 = System.nanoTime();

        // Deque performance
        long start2 = System.nanoTime();
        dequePalindrome(word);
        long end2 = System.nanoTime();

        // Two-pointer performance
        long start3 = System.nanoTime();
        twoPointerPalindrome(word);
        long end3 = System.nanoTime();

        // Display results
        System.out.println("Stack Algorithm Time: " + (end1 - start1) + " ns");
        System.out.println("Deque Algorithm Time: " + (end2 - start2) + " ns");
        System.out.println("Two Pointer Algorithm Time: " + (end3 - start3) + " ns");
    }
}