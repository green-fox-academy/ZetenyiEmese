public class Manipulator {

    public static void addTask(String taskDescription) {
        Todo newTodo = new Todo(taskDescription);
        TodoList todoList = FileIO.readTodoListFromFile("todos.txt");
        todoList.add(newTodo);
        FileIO.writeTodoListToFile("todos.txt", todoList);
    }

    public static void removeTask(String whichTask) {
        TodoList todoList = FileIO.readTodoListFromFile("todos.txt");

        try {
            int which = Integer.parseInt(whichTask);
            todoList.remove(which);
        } catch (NumberFormatException e) {
            System.out.println("Unable to remove: index is not a number");
        }

        FileIO.writeTodoListToFile("todos.txt", todoList);
    }

    public static void checkTask(String whichTask) {
        TodoList todoList = FileIO.readTodoListFromFile("todos.txt");

        try {
            int which = Integer.parseInt(whichTask);
            todoList.check(which);
        } catch (NumberFormatException e) {
            System.out.println("Unable to check: index is not a number");
        }

        FileIO.writeTodoListToFile("todos.txt", todoList);
    }

}
