import java.io.Serializable;

public class Todo implements Serializable {

    private String description;
    private boolean completed;

    public Todo(String description) {
        this.description = description;
        this.completed = false;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + description;
        //return description;
    }

}
