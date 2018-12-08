public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student john = new Student("John", 20, "male", "BME");
        john.introduce();

        Student johnTheClone = john.clone();
        johnTheClone.introduce();
    }

}
