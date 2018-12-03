public class Sponsor {
    private String name;
    private int age;
    private String gender;
    private String company;
    private int hiredStudents;

    public Sponsor() {
        this("Jane Doe", 30, "female", "Google");
    }

    public Sponsor(String name, int age, String gender, String company) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.company = company;
        this.hiredStudents = 0;
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + " who represents " + company + " and hired " + hiredStudents + " students so far.");
    }

    public void getGoal() {
        System.out.println("My goal is: Hire brilliant junior software developers.");
    }

    public void hire() {
        hiredStudents++;
    }
}
