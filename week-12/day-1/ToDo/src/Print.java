public class Print {

    public static void printUsage() {
        String usage = "Command Line Todo application\n" +
                "=============================\n" +
                "\n" +
                "Command line arguments:\n" +
                " -l   Lists all the tasks\n" +
                " -a   Adds a new task\n" +
                " -r   Removes a task\n" +
                " -c   Completes a task";
        System.out.println(usage);
    }

    public static void printTasks() {
        TodoList todoList = FileIO.readTodoListFromFile("todos.txt");

        if (todoList.isEmpty()) {
            System.out.println("No todos for today! :)");
        } else {
            System.out.println(todoList);
        }
    }

}
