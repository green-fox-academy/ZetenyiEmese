public class Manipulator {

    public static void addTask(String taskDescription) {
        Todo newTodo = new Todo(taskDescription);
        TodoList todoList = FileIO.readTodoListFromFile("todos.txt");
        todoList.add(newTodo);
        FileIO.writeTodoListToFile("todos.txt", todoList);
    }

    public static void removeTask(String index) {
        //TODO
    }

}
