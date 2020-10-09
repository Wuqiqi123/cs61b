import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offbyN = new OffbyN(5);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertEquals(true, offbyN.equalChars('a', 'f'));
        assertEquals(true, offbyN.equalChars('f', 'a'));
        assertEquals(false, offbyN.equalChars('f', 'h'));
    }
}