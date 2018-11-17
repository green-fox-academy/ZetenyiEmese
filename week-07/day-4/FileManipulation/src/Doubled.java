import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Doubled {
    public static void main(String[] args) {
        // Create a method that decrypts the duplicated-chars.txt

        String fileFrom = "duplicated-chars.txt";
        String fileTo = "decrypted-duplicated-chars.txt";

        System.out.println("Decryption succeeded: " + decryptFromTo(fileFrom, fileTo));
    }

    public static ArrayList<String> readFile(String fileName){
        Path filePath = Paths.get("src/" + fileName);
        ArrayList<String> lines = new ArrayList<>();

        try {
            lines = (ArrayList<String>) Files.readAllLines(filePath); //converting List to ArrayList
        } catch (IOException e) {
            System.out.println("Unable to read file: " + fileName);
        }
        return lines;
    }

    public static boolean decryptFromTo(String fileFrom, String fileTo){
        try {
            Files.write(Paths.get("src/" + fileTo), decrypt(fileFrom));
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<String> decrypt(String fileName){
        ArrayList<String> lines = readFile(fileName);
        ArrayList<String> newLines = new ArrayList<>();

        for (String line : lines) {
            StringBuilder newLine = new StringBuilder(line);
            for (int i = 1; i < newLine.length(); i += 2) {
                newLine.deleteCharAt(i);
                i--;
            }
            newLines.add(newLine.toString());
        }

        return newLines;
    }
}