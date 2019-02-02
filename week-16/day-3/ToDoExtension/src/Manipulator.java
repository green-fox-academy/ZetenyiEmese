public class Manipulator {

  public static void addTask(String taskDescription) {
    TodoList todoList = new TodoList();
    todoList.add(new Todo(todoList.createNextTodoId(), taskDescription));
  }

  public static void removeTask(String whichTask) {
    try {
      int which = Integer.parseInt(whichTask);
      new TodoList().remove(which);
    } catch (NumberFormatException e) {
      System.out.println("Unable to remove: index is not a number!");
    }
  }

  public static void checkTask(String whichTask) {
    try {
      int which = Integer.parseInt(whichTask);
      new TodoList().check(which);
    } catch (NumberFormatException e) {
      System.out.println("Unable to check: index is not a number!");
    }
  }

  public static void updateTask(String whichId, String newDescription) {
    try {
      int id = Integer.parseInt(whichId);
      new TodoList().update(id, newDescription);
    } catch (NumberFormatException e) {
      System.out.println("Unable to update: id is not a number!");
    }
  }

}
