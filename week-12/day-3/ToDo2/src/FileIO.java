import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileIO {

    public static ArrayList<Todo> readArrayListOfTodosFromFile(String fileName) {
        ArrayList<Todo> list = new ArrayList<>(); //empty arraylist

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (ArrayList<Todo>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }

        return list;
    }

    public static void writeArrayListOfTodosToFile(String fileName, ArrayList<Todo> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public static ArrayList<Todo> readArrayListOfTodosFromFile2(String fileName) {
        Path filePath = Paths.get(fileName);
        ArrayList<String> todoLines;
        ArrayList<Todo> list = new ArrayList<>(); //empty arraylist

        try {
            todoLines = (ArrayList<String>) Files.readAllLines(filePath); //converting List to ArrayList

            for (String todoLine : todoLines) {
                String[] todoParts = todoLine.split(";");
                Todo todo = new Todo(todoParts[0]);
                if (Boolean.parseBoolean(todoParts[1])) {
                    todo.complete();
                }
                list.add(todo);
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }

        return list;
    }

    public static void writeArrayListOfTodosToFile2(String fileName, ArrayList<Todo> list) {
        Path filePath = Paths.get(fileName);
        ArrayList<String> todoLines = new ArrayList<>();

        for (Todo todo : list) {
            todoLines.add(todo.getDescription() + ";" + todo.isCompleted());
        }

        try {
            Files.write(filePath, todoLines);
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}
