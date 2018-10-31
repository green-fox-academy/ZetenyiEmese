public class TodoPrint {
    public static void main(String[] args) {
        String todoText = " - Buy milk\n";
        todoText = addTextTo(todoText);
        System.out.println(todoText);
    }

    public static String addTextTo(String text){
        return "My todo:\n" + text + " - Download games\n" + "\t- Diablo";
    }
}
