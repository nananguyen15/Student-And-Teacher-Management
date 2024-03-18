public abstract class Person{
    private String name;
    private String id;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;

    public Person(String name, String id, String dateOfBirth, String email, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void showAllInfo() {
        System.out.printf("| %-24s | %-8s | %-16s | %-30s| %-11s |", name,id, dateOfBirth, email, phoneNumber);
    }

    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", dateOfBirth='" + getDateOfBirth() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }
}
