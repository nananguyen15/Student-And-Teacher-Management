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

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void showAllInfo() {
        System.out.printf("| %-24s | %-7s | %-16s | %-25s | %-11s |", name, id, dateOfBirth, email, phoneNumber);
    }

}
