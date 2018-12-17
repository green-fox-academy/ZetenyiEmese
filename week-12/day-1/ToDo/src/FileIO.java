import java.io.*;

public class FileIO {

    public static TodoList readTodoListFromFile(String filename) {
        TodoList todoList = new TodoList();

        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            todoList = (TodoList) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }

        return todoList;
    }

    public static void writeTodoListToFile(String filename, TodoList todoList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(todoList);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}
