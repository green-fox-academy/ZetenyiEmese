import reservations.Reservation;

import java.util.ArrayList;

public class AppReservation {

    public static void main(String[] args) {
        ArrayList<Reservation> reservations = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            reservations.add(new Reservation());
        }

        System.out.println(reservations.get(0).getCodeBooking());
        System.out.println(reservations.get(0).getDowBooking());

        display(reservations);
    }

    public static void display(ArrayList<Reservation> reservations) {
        for (Reservation res : reservations) {
            System.out.println(res);
        }
    }

}
