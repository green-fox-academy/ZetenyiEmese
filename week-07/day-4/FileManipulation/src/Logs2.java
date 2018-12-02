import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Logs2 {
    public static void main(String[] args) {
        // Read all data from 'log.txt'.
        // Each line represents a log message from a web server
        // Write a function that returns an array with the unique IP adresses.
        // Write a function that returns the GET / POST request ratio.

        String fileName = "log.txt";
        ArrayList<String> fileLines = readFile(fileName);

        String[] adresses = getIPAdresses(fileLines);
        System.out.println(Arrays.toString(adresses));

        System.out.println("GET/POST ratio: " + countGetPostRatio(fileLines));
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

    public static double countGetPostRatio(ArrayList<String> fileLines) {
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

        return (double) sumGET / sumPOST;
    }

    public static boolean contains(String searchMe, String findMe) {
        return searchMe.contains(findMe);
    }

    public static String[] getIPAdresses(ArrayList<String> fileLines) {
        ArrayList<String> listUniqueIPAdresses = getListUniqueIPadresses(fileLines);

        String[] arrayIPAdresses = new String[listUniqueIPAdresses.size()];

        for (int i = 0; i < listUniqueIPAdresses.size(); i++) {
            arrayIPAdresses[i] = listUniqueIPAdresses.get(i);
            //System.out.println(arrayIPAdresses[i]);
        }

        return arrayIPAdresses;
    }

    public static ArrayList<String> getListUniqueIPadresses(ArrayList<String> fileLines) {
        ArrayList<String> listIPAdresses = new ArrayList<>();

        for (int i = 0; i < fileLines.size(); i++) {
            String[] lineParts = fileLines.get(i).split(" ");
            listIPAdresses.add(lineParts[8]);
        }

        return getUniqueElements(listIPAdresses);
    }

    public static ArrayList<String> getUniqueElements(ArrayList<String> list) {
        ArrayList<String> listUniqueElements = new ArrayList<>();

        for (String element : list) {
            if (!listUniqueElements.contains(element)) {
                listUniqueElements.add(element);
            }
        }

        return listUniqueElements;
    }
}
