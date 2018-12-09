public class Domino implements Comparable<Domino> {

    private final int left;
    private final int right;

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeftSide() {
        return left;
    }

    public int getRightSide() {
        return right;
    }

    @Override
    public int compareTo(Domino otherDomino) {
        int diff = left - otherDomino.getLeftSide();
        if (diff == 0) {
            diff = right - otherDomino.getRightSide();
        }
        return diff;
    }

    @Override
    public String toString() {
        return "[" + left + ", " + right + "]";
    }

}
