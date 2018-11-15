import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFile {
    public static void main(String[] args) {
        // Write a function that copies a file to an other
        // It should take the filenames as parameters
        // It should return a boolean that shows if the copy was successful

        String fileFrom = "my-file.txt";
        String fileTo = "my-fourth-file.txt";

        System.out.println("The copy was: " + copyFromTo(fileFrom, fileTo));
    }

    public static boolean copyFromTo(String fileFrom, String fileTo){
        Path fileFromPath = Paths.get("src/" + fileFrom);
        Path fileToPath = Paths.get("src/" + fileTo);

        try {
            Files.write(fileToPath, Files.readAllLines(fileFromPath));
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        }
    }
}
