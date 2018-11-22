public class Station {
    private static int MinGasAmount = 1000;
    private int gasAmount;

    public Station(int gasAmount) {
        if (gasAmount < MinGasAmount){
            gasAmount = MinGasAmount;
        }
        this.gasAmount = gasAmount;
    }

    public void refill(Car car) {
        car.refill();
        gasAmount -= car.getCapacity();
    }

    @Override
    public String toString() {
        return "Station{" +
                "gasAmount=" + gasAmount +
                '}';
    }

    public static void main(String[] args) {
        Station station = new Station(800);
        Car car = new Car();

        System.out.println(station);
        System.out.println(car);

        station.refill(car);

        System.out.println(station);
        System.out.println(car);
    }
}