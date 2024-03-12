public class Teacher extends Person{
    private String subject;
    private double salary;

    public Teacher(String name, String id, String dateOfBirth, String[] email, String phoneNumber, double salary, String subject) {
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

    public void showAllInfoTeacher() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Subject: " + getSubject());
        System.out.println("Salary: " + getSalary());
    }
}