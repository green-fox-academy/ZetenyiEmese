public class Print {

    public static void printUsage() {
        String usage = "Command Line Todo application\n" +
                "=============================\n" +
                "\n" +
                "Command line arguments:\n" +
                " -l  or -list       Lists the undone tasks\n" +
                " -la or -listall    Lists all the tasks\n" +
                " -a  or -add        Adds a new task\n" +
                " -r  or -remove     Removes a task\n" +
                " -c  or -check      Completes a task";
        System.out.println(usage);
    }

    public static void printUndoneTasks() {
        TodoList todoList = FileIO.readTodoListFromFile("todos.txt");

        if (todoList.isEmpty()) {
            System.out.println("No todos for today! :)");
        } else {
            System.out.println(todoList.getUncheckedTodos());
        }
    }

    public static void printAllTasks() {
        TodoList todoList = FileIO.readTodoListFromFile("todos.txt");

        if (todoList.isEmpty()) {
            System.out.println("No todos for today! :)");
        } else {
            System.out.println(todoList);
        }
    }

}
