import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteSingleLine {
    public static void main(String[] args) {
        // Open a file called "my-file.txt"
        // Write your name in it as a single line
        // If the program is unable to write the file,
        // then it should print an error message like: "Unable to write file: my-file.txt"

        ArrayList<String> lines = new ArrayList<>();
        lines.add("Zétényi Emese");

        Path filePath = Paths.get("src/my-second-file.txt");

        try {
            Files.write(filePath, lines); //opens this file or creates it if it doesn't exist
        } catch (IOException e) {
            System.out.println("Unable to write file: my-second-file.txt");
        }
    }
}
