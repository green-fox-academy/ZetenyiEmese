import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReversedLines {
    public static void main(String[] args) {
        // Create a method that decrypts reversed-lines.txt

        String fileFrom = "reversed-lines.txt";
        String fileTo = "decrypted-reversed-lines.txt";

        System.out.println("Decryption succeeded: " + decryptFromTo(fileFrom, fileTo));
    }

    public static boolean decryptFromTo(String fileFrom, String fileTo) {
        ArrayList<String> lines = readFile(fileFrom);
        ArrayList<String> decryptedLines = reverseLines(lines);
        return writeFile(fileTo, decryptedLines);
    }

    public static ArrayList<String> reverseLines(ArrayList<String> lines) {
        ArrayList<String> newLines = new ArrayList<>();

        for (String line : lines) {
            StringBuilder newLine = new StringBuilder(line);
            newLine.reverse(); //reverses the order of characters
            newLines.add(newLine.toString());
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