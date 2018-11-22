public class Teacher {
    private String name;
    private String subject;
    private int answers;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
        this.answers = 0;
    }

    public void answer(){
        answers++;
    }

    public void teach (Student student){
        answer();
        student.learn();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", answers=" + answers +
                '}';
    }
}