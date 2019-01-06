public class WarApp {

    public static void main(String[] args) {
        Armada redArmada = new Armada("Red Armada");
        for (int i = 0; i < 3; i++) {
            Ship ship = new Ship();
            ship.fillShip();
            redArmada.add(ship);
        }
        System.out.println(redArmada);

        Armada blackArmada = new Armada("Black Armada");
        for (int i = 0; i < 3; i++) {
            Ship ship = new Ship();
            ship.fillShip();
            blackArmada.add(ship);
        }
        System.out.println(blackArmada);

        if (redArmada.war(blackArmada)) {
            System.out.println("Red Armada wins!!!\n");
        } else {
            System.out.println("Black Armada wins!!!\n");
        }

        System.out.println(redArmada);
        System.out.println(blackArmada);
    }

}
