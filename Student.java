public class Student extends Person {
    private GPACalculate GPA;

    public Student(String name, String id, String dateOfBirth, String email, int phoneNumber, GPACalculate GPA) {
        super (name, id, dateOfBirth, email, phoneNumber);
        this.GPA = GPA;
    }

    public GPACalculate getGPA() {
        return GPA;
    }

    public void setGPA(GPACalculate GPA) {
        this.GPA = GPA;
    }


    public void showIAllnfo() {

    }
}

