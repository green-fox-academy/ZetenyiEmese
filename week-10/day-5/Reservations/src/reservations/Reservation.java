package reservations;

public class Reservation implements Reservationy {

    private String dowBooking;
    private String codeBooking;

    public Reservation() {
        dowBooking = generateDowBooking();
        codeBooking = generateCodeBooking2();
    }

    private String generateDowBooking() {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int randomIndex = (int)(Math.random() * 7); // an integer between 0, 6
        return days[randomIndex];
    }

    private String generateCodeBooking1() {
        String code = "";
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < 8; i++) {
            int randomIndex =(int)(Math.random() * chars.length);
            code += chars[randomIndex];
        }

        return code;
    }

    private String generateCodeBooking2() {
        String code = "";
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < 8; i++) {
            int randomIndex =(int)(Math.random() * chars.length());
            code += chars.charAt(randomIndex);
        }

        return code;
    }

    @Override
    public String getDowBooking() {
        return dowBooking;
    }

    @Override
    public String getCodeBooking() {
        return codeBooking;
    }

    @Override
    public String toString() {
        return String.format("Booking# %s for %s", codeBooking, dowBooking);
    }

}
