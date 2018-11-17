import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TicTacToe {
    public static void main(String[] args) {
        // Write a function that takes a filename as a parameter
        // The file contains an ended Tic-Tac-Toe match
        // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
        // Return "X", "O" or "Draw" based on the input file

        System.out.println(ticTacResult("win-o.txt")); // Should print "O"
        System.out.println(ticTacResult("win-x.txt")); // Should print "X"
        System.out.println(ticTacResult("draw.txt")); // Should print "Draw"
    }

    public static ArrayList<String> readFile(String fileName){
        Path filePath = Paths.get("src/" + fileName);
        ArrayList<String> lines = new ArrayList<>();

        try {
            lines = (ArrayList<String>)Files.readAllLines(filePath); //converting List to ArrayList
        } catch (IOException e) {
            System.out.println("Unable to read file: " + fileName);
        }
        return lines;
    }

    public static String ticTacResult(String fileName) {
        ArrayList<String> lines = readFile(fileName);
        for (String line : lines) {
            System.out.println(line);
        }

        int size = lines.size();

        for (int i = 0; i < size; i++) {
            boolean isRow = true;
            for (int j = 0; j < size - 1; j++) {
                isRow = isRow && (lines.get(i).charAt(j) == lines.get(i).charAt(j + 1));
            }
            if (isRow) {
                return String.valueOf(lines.get(i).charAt(0));
            }
        }

        for (int j = 0; j < size; j++) {
            boolean isColumn = true;
            for (int i = 0; i < size - 1; i++) {
                isColumn = isColumn && (lines.get(i).charAt(j) == lines.get(i + 1).charAt(j));
            }
            if (isColumn) {
                return String.valueOf(lines.get(0).charAt(j));
            }
        }

        boolean isDiagonal1 = true;
        for (int i = 0; i < size - 1; i++) {
            isDiagonal1 = isDiagonal1 && (lines.get(i).charAt(i) == lines.get(i + 1).charAt(i + 1));
        }
        if (isDiagonal1) {
            return String.valueOf(lines.get(0).charAt(0));
        }

        boolean isDiagonal2 = true;
        for (int i = 0; i < size - 1; i++) {
            isDiagonal2 = isDiagonal2 && (lines.get(i).charAt(size - 1 - i) == lines.get(i + 1).charAt(size - 2 - i));
        }
        if (isDiagonal2) {
            return String.valueOf(lines.get(0).charAt(size - 1));
        }

        return "Draw";
    }
}
