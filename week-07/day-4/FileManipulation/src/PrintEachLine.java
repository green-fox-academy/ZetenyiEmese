import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class PrintEachLine {
    public static void main(String[] args) {
        // Write a program that opens a file called "my-file.txt", then prints
        // each of the lines form the file.
        // If the program is unable to read the file (for example it does not exists),
        // then it should print an error message like: "Unable to read file: my-file.txt"

        Path filePath = Paths.get("src/my-file.txt");
        List<String> lines = null;

        //try to read from the file and put the lines as strings into a stringlist
        try {
            lines = Files.readAllLines(filePath);
        } catch (Exception e) {
            System.out.println("Unable to read file: my-file.txt!");
        }

        //try to print each of the strings from the stringlist
        try {
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (NullPointerException e){
            System.out.println("HU-ha");
        }
    }
}
