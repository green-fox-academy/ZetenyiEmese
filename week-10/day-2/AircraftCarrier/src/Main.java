public class Main {
    public static void main(String[] args) {

        Carrier carrier1 = new Carrier(100, 5000);
        carrier1.add(new F35());
        carrier1.add(new F35());
        carrier1.add(new F35());
        carrier1.add(new F16());
        carrier1.add(new F16());
        System.out.println(carrier1.getStatus());

        Carrier carrier2 = new Carrier(70, 3000);
        carrier2.add(new F35());
        carrier2.add(new F35());
        carrier2.add(new F16());
        carrier2.add(new F16());
        System.out.println(carrier2.getStatus());

        System.out.println("Filling the aircrafts on both of the carriers:");
        carrier1.fill();
        System.out.println(carrier1.getStatus());
        carrier2.fill();
        System.out.println(carrier2.getStatus());

        System.out.println("Carrier1 fights against carrier2:");
        carrier1.fight(carrier2);
        System.out.println(carrier1.getStatus());
        System.out.println(carrier2.getStatus());

        System.out.println("Carrier2 fights against carrier1:");
        carrier2.fight(carrier1);
        System.out.println(carrier1.getStatus());
        System.out.println(carrier2.getStatus());

        System.out.println("Filling the aircrafts on both of the carriers:");
        carrier1.fill();
        System.out.println(carrier1.getStatus());
        carrier2.fill();
        System.out.println(carrier2.getStatus());

        System.out.println("Carrier1 fights against carrier2:");
        carrier1.fight(carrier2);
        System.out.println(carrier1.getStatus());
        System.out.println(carrier2.getStatus());
    }

}
