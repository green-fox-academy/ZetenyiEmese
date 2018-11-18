import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReversedOrder {
    public static void main(String[] args) {
        // Create a method that decrypts reversed-order.txt

        String fileFrom = "reversed-order.txt";
        String fileTo = "decrypted-reversed-order.txt";

        System.out.println("Decryption succeeded: " + decryptFromTo(fileFrom, fileTo));
    }

    public static boolean decryptFromTo(String fileFrom, String fileTo) {
        ArrayList<String> lines = readFile(fileFrom);
        ArrayList<String> decryptedLines = reverseOrderOfLines(lines);
        return writeFile(fileTo, decryptedLines);
    }

    public static ArrayList<String> reverseOrderOfLines(ArrayList<String> lines) {
        ArrayList<String> newLines = new ArrayList<>();

        for (int i = lines.size() - 1; i >= 0; i--) {
            newLines.add(lines.get(i));
        }

        return newLines;
    }

    public static ArrayList<String> readFile(String fileName) {
        Path filePath = Paths.get("src/" + fileName);
        ArrayList<String> lines = new ArrayList<>();

        try {
            lines = (ArrayList<String>) Files.readAllLines(filePath); //converting List to ArrayList
        } catch (IOException e) {
            System.out.println("Unable to read file: " + fileName);
        }
        return lines;
    }

    public static boolean writeFile(String fileTo, ArrayList<String> lines) {
        try {
            Files.write(Paths.get("src/" + fileTo), lines);
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        }
    }
}