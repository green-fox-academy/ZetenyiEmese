public class ToDo implements Printable {

    private String description;
    private boolean completed;

    public ToDo(String description) {
        this.description = description;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + description;
    }

    @Override
    public void printAllFields() {
        System.out.println((completed ? "[x] " : "[ ] ") + description);
    }

}
