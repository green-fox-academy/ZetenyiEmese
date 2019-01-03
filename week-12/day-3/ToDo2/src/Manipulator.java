public class Manipulator {

    public static void addTask(String taskDescription) {
        Todo newTodo = new Todo(taskDescription);
        new TodoList().add(newTodo);
    }

    public static void removeTask(String whichTask) {
        try {
            int which = Integer.parseInt(whichTask);
            new TodoList().remove(which);
        } catch (NumberFormatException e) {
            System.out.println("Unable to remove: index is not a number");
        }
    }

    public static void checkTask(String whichTask) {
        try {
            int which = Integer.parseInt(whichTask);
            new TodoList().check(which);
        } catch (NumberFormatException e) {
            System.out.println("Unable to check: index is not a number");
        }
    }

}
