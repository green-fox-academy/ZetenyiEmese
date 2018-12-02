import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class EncodedLines {
    public static void main(String[] args) {
        // Create a method that decrypts encoded-lines.txt

        String fileFrom = "encoded-lines.txt";
        String fileTo = "decrypted-encoded-lines.txt";

        System.out.println("Decryption succeeded: " + decryptFromTo(fileFrom, fileTo));
    }

    public static boolean decryptFromTo(String fileFrom, String fileTo) {
        ArrayList<String> lines = readFile(fileFrom);
        ArrayList<String> decryptedLines = shiftCharacters(lines);
        return writeFile(fileTo, decryptedLines);
    }

    public static ArrayList<String> shiftCharacters(ArrayList<String> lines) {
        ArrayList<String> newLines = new ArrayList<>();

        for (String line : lines) {
            StringBuilder newLine = new StringBuilder(line);
            for (int i = 0; i < newLine.length(); i++) {
                char c = newLine.charAt(i);
                //c--;
                newLine.setCharAt(i, --c);
            }
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
