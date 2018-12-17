import java.io.Serializable;
import java.util.ArrayList;

public class TodoList implements Serializable {

    private ArrayList<Todo> list;

    public TodoList() {
        this.list = new ArrayList<>();
    }

    public void add(Todo todo) {
        list.add(todo);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < list.size(); i++) {
            result += (i+1) + " - " + list.get(i) + "\n";
        }
        return result;
    }

}
