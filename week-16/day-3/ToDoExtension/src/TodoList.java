import java.util.ArrayList;
import java.util.stream.Collectors;

public class TodoList {

  private String fileName;
  private ArrayList<Todo> list;

  public TodoList() {
    this.fileName = "todos.txt";
    this.list = FileIO.readArrayListOfTodosFromFile2(fileName);
    //this.list = FileIO.readArrayListOfTodosFromFile(fileName);
  }

  public int createNextTodoId() {
    int nextTodoId;
    if (isEmpty()) {
      nextTodoId = 1;
    } else {
      nextTodoId = list.get(list.size() - 1).getId() + 1;
    }
    return nextTodoId;
  }

  public void add(Todo todo) {
    list.add(todo);
    FileIO.writeArrayListOfTodosToFile2(fileName, list);
    //FileIO.writeArrayListOfTodosToFile(fileName, list);
  }

  public void remove(int which) {
    try {
      list.remove(which - 1);
      FileIO.writeArrayListOfTodosToFile2(fileName, list);
      //FileIO.writeArrayListOfTodosToFile(fileName, list);
    } catch (Exception e) {
      System.out.println("Unable to remove: index is out of bound!");
    }
  }

//  public void remove(int id) {
//    list = (ArrayList<Todo>) list.stream().filter(todo -> todo.getId() != id).collect(Collectors.toList());
//    FileIO.writeArrayListOfTodosToFile2(fileName, list);
//  }

  public void check(int which) {
    try {
      list.get(which - 1).complete();
      FileIO.writeArrayListOfTodosToFile2(fileName, list);
      //FileIO.writeArrayListOfTodosToFile(fileName, list);
    } catch (Exception e) {
      System.out.println("Unable to check: index is out of bound!");
    }
  }

  public void update(int id, String newDescription) {
    if (newDescription.isEmpty()) {
      System.out.println("Enter the new description!");
      return;
    }

    for (Todo todo : list) {
      if (todo.getId() == id) {
        todo.setDescription(newDescription);
        FileIO.writeArrayListOfTodosToFile2(fileName, list);
        //FileIO.writeArrayListOfTodosToFile(fileName, list);
        return;
      }
    }

    System.out.println("Unable to update: id is not found!");
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
        result += (i + 1) + " - " + todo.toString() + "\n";
        i++;
      }
    }

    return result;
  }

  @Override
  public String toString() {
    String result = "";

    for (int i = 0; i < list.size(); i++) {
      result += (i + 1) + " - " + list.get(i).toString() + "\n";
    }

    return result;
  }

}
