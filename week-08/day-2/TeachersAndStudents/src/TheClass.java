import java.util.ArrayList;
import java.util.List;

public class TheClass {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Peter", "mathematics");
        System.out.println(teacher);

        List<Student> theClass = initializeClass();
        System.out.println(theClass);

        for (Student student : theClass) {
            student.question(teacher);
        }

        System.out.println(teacher);
        System.out.println(theClass);

        teacher.teach(theClass.get(1));
        System.out.println(teacher);
        System.out.println(theClass.get(1));
    }

    public static List<Student> initializeClass(){
        List<Student> theClass = new ArrayList<>();
        theClass.add(new Student("George"));
        theClass.add(new Student("Mary"));
        theClass.add(new Student("Paul"));
        theClass.add(new Student("Susan"));
        theClass.add(new Student("Sam"));
        return theClass;
    }
}