import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertEquals(true, palindrome.isPalindrome(""));
        assertEquals(true, palindrome.isPalindrome("1"));
        assertEquals(true, palindrome.isPalindrome("121"));
        assertEquals(false, palindrome.isPalindrome("122"));
    }

    @Test
    public void testIsPalindromeOffOne() {
        CharacterComparator cc = new OffByOne();
        assertEquals(true, palindrome.isPalindrome("", cc));
        assertEquals(true, palindrome.isPalindrome("1", cc));
        assertEquals(true, palindrome.isPalindrome("122", cc));
        assertEquals(false, palindrome.isPalindrome("123", cc));
    }
}