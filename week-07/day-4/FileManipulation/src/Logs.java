import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logs {
    public static void main(String[] args) {
        // Read all data from 'log.txt'.
        // Each line represents a log message from a web server
        // Write a function that returns an array with the unique IP adresses.
        // Write a function that returns the GET / POST request ratio.

        String fileName = "log.txt";
        ArrayList<String> fileLines = readFile(fileName);
        getIPAdresses(fileLines);
        System.out.println("GET/POST ratio: " + countGetPostRatio(fileLines));
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

    public static double countGetPostRatio(ArrayList<String> fileLines){
        int sumGET = 0;
        int sumPOST = 0;

        for (String line : fileLines) {
            if (contains(line, "GET")) {
                sumGET++;
            }
            if (contains(line, "POST")) {
                sumPOST++;
            }
        }

        return (double)sumGET/sumPOST;
    }

    public static boolean contains(String searchMe, String findMe){
        return searchMe.contains(findMe);
    }

    public static String[] getIPAdresses(ArrayList<String> fileLines){
        ArrayList<String> listIPAdresses = new ArrayList<>();

        for (int i = 0; i < fileLines.size(); i++) {
            String[] lineParts = fileLines.get(i).split(" ");
            listIPAdresses.add(lineParts[8]);
        }

        //removing multiple elements
        for (int i = 0; i <= listIPAdresses.size() - 2; i++) {
            for (int j = i + 1; j <= listIPAdresses.size() - 1; j++) {
                if (listIPAdresses.get(j).equals(listIPAdresses.get(i))){
                    listIPAdresses.remove(j);
                    j--;
                }
            }
        }

        //System.out.println(listIPAdresses.size());

        String[] arrayIPAdresses = new String[listIPAdresses.size()];

        for (int i = 0; i < listIPAdresses.size(); i++) {
            arrayIPAdresses[i] = listIPAdresses.get(i);
            System.out.println(arrayIPAdresses[i]);
        }

        return arrayIPAdresses;
    }
}
