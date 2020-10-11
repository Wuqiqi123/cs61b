import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
public class TestArrayDequeGold {
    @Test
    public void testArrayDeque() {
        int randomNum = new Random().nextInt(100);
        int num=1000000;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
            ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
            for (int i = 0; i < randomNum; i += 1) {
                double numberBetweenZeroAndOne = StdRandom.uniform();
                if (numberBetweenZeroAndOne < 0.5) {
                    sad1.addLast(i);
                    sad2.addLast(i);
                    sb.append("addLast(").append(i).append(")\n");
                } else {
                    sad1.addFirst(i);
                    sad2.addFirst(i);
                    sb.append("addFirst(").append(i).append(")\n");
                }
            }

            for (int i = 0; i < randomNum; i += 1) {
                double numberBetweenZeroAndOne = StdRandom.uniform();
                if (numberBetweenZeroAndOne < 0.5) {
                    sad1.addLast(i);
                    sad2.addLast(i);
                    sb.append("addLast(").append(i).append(")\n");
                } else {
                    Integer remove1 = sad1.removeFirst();
                    Integer remove2 = sad2.removeFirst();
                    sb.append("removeFirst(), student was " +remove1 + ", correct was " + remove2 +"\n");
                    assertEquals(sb.toString(), remove1, remove2);

                }
            }

            for (int i = 0; i < randomNum; i += 1) {
                double numberBetweenZeroAndOne = StdRandom.uniform();
                if (numberBetweenZeroAndOne < 0.5) {
                    sad1.addLast(i);
                    sad2.addLast(i);
                    sb.append("addLast(").append(i).append(")\n");
                } else {
                    Integer remove1 = sad1.removeLast();
                    Integer remove2 = sad2.removeLast();
                    sb.append("removeLast(), student was " +remove1 + ", correct was " + remove2 +"\n");
                    assertEquals(sb.toString(), remove1, remove2);

                }
            }

//            assertEquals(sad1.size(), sad2.size());
//
//            for (int i = 0; i < sad1.size(); i++) {
//                assertEquals(sad1.get(i), sad2.get(i));
//            }
            num--;
        }
    }
}
