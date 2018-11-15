import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CountLines {
    public static void main(String[] args) {
        // Write a function that takes a filename as string,
        // then returns the number of lines the file contains.
        // It should return zero if it can't open the file, and
        // should not raise any error.

        String fileName = "my-file.txt";
        System.out.println(countLines(fileName));
    }

    public static int countLines(String fileName){
        Path filePath = Paths.get("src/" + fileName);
        List<String> lines = new ArrayList<>();

        //try to read from the file
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Unable to read file: " + fileName);
            return 0;
        }
        return lines.size(); //returns the number of lines in the file
    }
}
