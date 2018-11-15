import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class WriteMultipleLines {
    public static void main(String[] args) {
        // Create a function that takes 3 parameters: a path, a word and a number,
        // than it should write to a file.
        // The path parameter should be a string, that describes the location of the file.
        // The word parameter should be a string, that will be written to the file as lines
        // The number paramter should describe how many lines the file should have.
        // So if the word is "apple" and the number is 5, than it should write 5 lines
        // to the file and each line should be "apple"
        // The function should not raise any error if it could not write the file.

        String path = "src/my-third-file.txt";
        String word = "apple";
        int number = 5;

        writeToFile(path, word, number);
    }

    public static void writeToFile(String path, String word, int number){
        Path filePath = Paths.get(path);

        ArrayList<String> lines = new ArrayList<>();
        lines.add(word); //one line is added to the list

        try {
            Files.write(filePath, lines); //opens this file or creates it if it doesn't exist
            for (int i = 0; i <= number - 2; i++) {
                Files.write(filePath, lines, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {

        }
    }
}
