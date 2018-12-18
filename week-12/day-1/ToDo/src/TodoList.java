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

    public void remove(int which) {
        try {
            list.remove(which - 1);
        } catch (Exception e) {
            System.out.println("Unable to remove: index is out of bound");
        }
    }

    public void check(int which) {
        try {
            list.get(which - 1).complete();
        } catch (Exception e) {
            System.out.println("Unable to check: index is out of bound");
        }
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
