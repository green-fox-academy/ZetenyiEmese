public class ToDo implements Comparable<ToDo> {

    private String description;
    private boolean completed;

    public ToDo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public int compareTo(ToDo otherToDo) {
        if (!completed) {
            if (otherToDo.isCompleted()) {
                return -1;
            } else {
                return description.compareTo(otherToDo.getDescription());
            }
        } else {
            if (!otherToDo.isCompleted()) {
                return 1;
            } else {
                return description.compareTo(otherToDo.getDescription());
            }
        }
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + description;
    }

}
