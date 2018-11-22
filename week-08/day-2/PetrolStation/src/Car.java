public class Car {
    private int gasAmount;
    private int capacity;

    public Car() {
        this.capacity = 100;
        this.gasAmount = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public void refill() {
        gasAmount = capacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "gasAmount=" + gasAmount +
                ", capacity=" + capacity +
                '}';
    }
}