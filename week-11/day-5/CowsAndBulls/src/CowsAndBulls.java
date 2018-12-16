public class CowsAndBulls {

    private String numberToGuess;
    private boolean playFinished;
    private int counter;

    public CowsAndBulls() {
        this.numberToGuess = generateNumber();
        this.playFinished = false;
        this.counter = 0;
    }

    private String generateNumber() {
        String digits = "0123456789";
        String numberGenerated = "";

        int randomIndexFirstDigit = 1 + (int)(Math.random() * 9); //an integer between 1 and 9
        numberGenerated += digits.charAt(randomIndexFirstDigit);

        for (int i = 0; i < 3 ; i++) {
            int randomIndex = (int)(Math.random() * 10); //an integer between 0 and 9
            numberGenerated += digits.charAt(randomIndex);
        }

        return numberGenerated;
    }

    public String checkGuess(String guess) {
        if (!isNumber(guess)) {
            System.out.println("This is not a number!");
            return "";
        }

        if (guess.length() != 4) {
            System.out.println("It has to be 4 digits long!");
            return "";
        }

        counter++;
        StringBuilder guessResult = new StringBuilder(guess);

        for (int i = 0; i < 4; i++) { //goes through the digits of the guess
            for (int j = 0; j < 4; j++) { //goes through the digits of the numberToGuess
                if (guess.charAt(i) == numberToGuess.charAt(j)) {
                    if (i == j) {
                        guessResult.setCharAt(i, 'C');
                        break;
                    } else {
                        guessResult.setCharAt(i, 'B');
                        //break;
                    }
                }
            }
        }

        if (new String(guessResult).equals("CCCC")) {
            playFinished = true;
        }

        return new String(guessResult);
    }

    public boolean isNumber(String string) {
        String digits = "0123456789";

        for (char c : string.toCharArray()) {
            if (!digits.contains("" + c)) {
                return false;
            }
        }
        return true;
    }

    public String getNumberToGuess() {
        return numberToGuess;
    }

    public boolean isPlayFinished() {
        return playFinished;
    }

    public int getCounter() {
        return counter;
    }

}
