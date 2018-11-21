public class Counter {
    private int count;
    private int initialValue;

    public Counter() {
        count = 0;
        initialValue = count;
    }

    public Counter(int count) {
        this.count = count;
        initialValue = count;
    }

    public void add() {
        count++;
    }

    public void add(int number ) {
        count += number;
    }

    public int get(){
        return count;
    }

    public void reset(){
        count = initialValue;
    }
}