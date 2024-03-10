public class Teacher extends Person{
    private String subject;
    private double salary;

    public Teacher(String name, String id, String dateOfBirth, String email, int phoneNumber, String subject, double salary) {
        super(name, id, dateOfBirth, email, phoneNumber);
        this.subject = subject;
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void showInfo() {

    }
}
