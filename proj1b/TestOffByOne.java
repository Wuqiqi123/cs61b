import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertEquals(true, offByOne.equalChars('x', 'y'));
        assertEquals(false, offByOne.equalChars('x', 'z'));
        assertEquals(true, offByOne.equalChars('1', '2'));
    }
}