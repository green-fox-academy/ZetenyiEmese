import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FileIO {

  public static ArrayList<Todo> readArrayListOfTodosFromFile(String fileName) {
    ArrayList<Todo> list = new ArrayList<>();

    try {
      FileInputStream fileInputStream = new FileInputStream(fileName);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      list = (ArrayList<Todo>) objectInputStream.readObject();
      objectInputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
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
      e.printStackTrace();
    }
  }

  public static ArrayList<Todo> readArrayListOfTodosFromFile2(String fileName) {
    Path filePath = Paths.get(fileName);
    ArrayList<Todo> list = new ArrayList<>();

    try {
      ArrayList<String> todoLines = new ArrayList<>(Files.readAllLines(filePath));
      Todo todo;

      for (String todoLine : todoLines) {
        String[] todoParts = todoLine.split(";");

        if (Boolean.parseBoolean(todoParts[3])) {
          todo = new Todo(Integer.parseInt(todoParts[0]), todoParts[1], LocalDateTime.parse(todoParts[2]), LocalDateTime.parse(todoParts[4]));
        } else {
          todo = new Todo(Integer.parseInt(todoParts[0]), todoParts[1], LocalDateTime.parse(todoParts[2]));
        }
        list.add(todo);
      }

    } catch (IOException e) {
      System.out.println("Unable to read file!");
    }

    return list;
  }

  public static void writeArrayListOfTodosToFile2(String fileName, ArrayList<Todo> list) {
    Path filePath = Paths.get(fileName);
    ArrayList<String> todoLines = new ArrayList<>();

    for (Todo todo : list) {
      todoLines.add(todo.getId() + ";" + todo.getDescription() + ";" + todo.getCreatedAt().toString() + ";" + todo.isCompleted() + ";" +
              (todo.isCompleted() ? todo.getCompletedAt().toString() : ""));
    }

    try {
      Files.write(filePath, todoLines);
    } catch (IOException e) {
      System.out.println("Unable to write file!");
    }
  }

}
