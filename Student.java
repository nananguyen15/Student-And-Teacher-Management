public class Student extends Person {
    private Double GPA;
    private List<Double> subjectScores; // List to store scores of 5 subjects


    public Student(String name, String id, String dateOfBirth, String[] email, String phoneNumber, Double GPA) {
        super (name, id, dateOfBirth, email, String.valueOf(phoneNumber));
        this.GPA = GPA;
        this.subjectScores = new ArrayList<>();
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    // Method to add score for each subject
    public void addScore(double score) {
        subjectScores.add(score);
    }

    // Method to get average score for all subjects
    public double getAverageScore() {
        double sum = 0.0;
        for (Double score : subjectScores) {
            sum += score;
        }
        double GPA = sum/5;
        return GPA;
    }

    // Method to calculate GPA based on average score
}