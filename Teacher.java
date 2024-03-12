public class Teacher extends Person{
    private String subject;
    private double salary;

    public Teacher(String name, String id, String dateOfBirth, String email, String phoneNumber, double salary, String subject) {
        super(name, id, dateOfBirth, email, phoneNumber);
        this.salary = salary;
        this.subject = subject;

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public void showAllInfo() {
        super.showAllInfo();
        System.out.printf(" %-11.2f| %-11s|\n", getSalary(),getSubject());
    }
}