public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        int secondsInADay = 24*60*60;

        int remainingSecondsFromTheDay = secondsInADay - (currentHours*60*60 + currentMinutes*60 + currentSeconds);

        System.out.println("The remaining seconds from the day: " + remainingSecondsFromTheDay + " seconds");
    }
}
