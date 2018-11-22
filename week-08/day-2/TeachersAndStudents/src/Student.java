public class Student {
    private String name;
    private int knowledge;
    private int questions;

    public Student(String name) {
        this.name = name;
        this.knowledge = 0;
        this.questions = 0;
    }

    public void learn(){
        knowledge++;
    }

    public void question(){
        questions++;
    }

    public void question(Teacher teacher){
        question();
        teacher.answer();
        learn();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", knowledge=" + knowledge +
                ", questions=" + questions +
                '}';
    }
}