public class Print {

  public static void printUsage() {
    String usage = "Command Line Todo application\n" +
            "=============================\n" +
            "\n" +
            "Command line arguments:\n" +
            " -l  or -list       Lists the undone tasks\n" +
            " -la or -listall    Lists all the tasks\n" +
            " -a  or -add        Adds a new task (enter the description)\n" +
            " -r  or -remove     Removes a task (enter the index)\n" +
            " -c  or -check      Completes a task (enter the index)\n" +
            " -u  or -update     Updates a task (enter the id and the new description)";
    System.out.println(usage);
  }

  public static void printUndoneTasks() {
    TodoList todoList = new TodoList();

    if (todoList.hasUndoneTasks()) {
      System.out.println(todoList.getUndoneTasks());
    } else {
      System.out.println("No undone tasks for today! :)");
    }
  }

  public static void printAllTasks() {
    TodoList todoList = new TodoList();

    if (todoList.isEmpty()) {
      System.out.println("No todos for today! :)");
    } else {
      System.out.println(todoList);
    }
  }

}
