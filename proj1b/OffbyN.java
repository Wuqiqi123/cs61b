public class OffbyN implements CharacterComparator{

    private final int n;

    public OffbyN(int N) {
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y) == n || (y - x) == n;
    }
}
