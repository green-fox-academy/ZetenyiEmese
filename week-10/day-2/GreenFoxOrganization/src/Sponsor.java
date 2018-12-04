public class Sponsor extends Person{
    private String company;
    private int hiredStudents;

    public Sponsor() {
        this("Jane Doe", 30, "female", "Google");
    }

    public Sponsor(String name, int age, String gender, String company) {
        super(name, age, gender);
        this.company = company;
        this.hiredStudents = 0;
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + getName() + ", a " + getAge() + " year old " + getGender() + " who represents " + company + " and hired " + hiredStudents + " students so far.");
    }

    @Override
    public void getGoal() {
        System.out.println("My goal is: Hire brilliant junior software developers.");
    }

    public void hire() {
        hiredStudents++;
    }
}
