import java.util.ArrayList;

public class TodoList {

    private String fileName;
    private ArrayList<Todo> list;

    public TodoList() {
        this.fileName = "todos.txt";
        this.list = FileIO.readArrayListOfTodosFromFile2(fileName);
        //this.list = FileIO.readArrayListOfTodosFromFile(fileName);
    }

    public void add(Todo todo) {
        list.add(todo);
        FileIO.writeArrayListOfTodosToFile2(fileName, list);
        //FileIO.writeArrayListOfTodosToFile(fileName, list);
    }

    public void remove(int which) {
        try {
            list.remove(which - 1);
        } catch (Exception e) {
            System.out.println("Unable to remove: index is out of bound");
        }
        FileIO.writeArrayListOfTodosToFile2(fileName, list);
        //FileIO.writeArrayListOfTodosToFile(fileName, list);
    }

    public void check(int which) {
        try {
            list.get(which - 1).complete();
        } catch (Exception e) {
            System.out.println("Unable to check: index is out of bound");
        }
        FileIO.writeArrayListOfTodosToFile2(fileName, list);
        //FileIO.writeArrayListOfTodosToFile(fileName, list);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean hasUndoneTasks() {
        for (Todo todo : list) {
            if (!todo.isCompleted()) {
                return true;
            }
        }

        return false;
    }

    public String getUndoneTasks() {
        String result = "";
        int i = 0;

        for (Todo todo : list) {
            if (!todo.isCompleted()) {
                result += (i+1) + " - " + todo.toString() + "\n";
                i++;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "";

        for(int i = 0; i < list.size(); i++) {
            result += (i+1) + " - " + list.get(i).toString() + "\n";
        }

        return result;
    }

}
