//import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class Student extends Person implements GPACalculate{
    private Double GPA;
    private List<Double> subjectScores; // List to store scores of 5 subjects

    public Student(String name, String id, String dateOfBirth, String email, String phoneNumber, List<Double> subjectScores, Double GPA) {
        super(name, id, dateOfBirth, email, String.valueOf(phoneNumber));
        this.subjectScores = subjectScores;
        this.GPA = GPA;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    @Override
    public double calculateGPA(List<Double> scores) {
        double totalScore = 0;
        for (Double score : scores) {
            totalScore += score;
        }
        return totalScore / scores.size();
    }

    @Override
    public double ConvertGPA(double score) {
        return GPACalculate.super.ConvertGPA(score);
    }

    @Override
    public void showAllInfo() {
        super.showAllInfo();
        for (int i = 0; i < 5; i++) { // Assuming there are 5 subjects
            if (i < subjectScores.size()) {
                System.out.printf(" %-5.2f |", subjectScores.get(i));
            } else {
                System.out.printf(" %-5s |", "N/A");
            }
        }
        System.out.printf(" %-5.2f |\n", getGPA());
    }

    @Override
    public String toString() {
        String formattedEmail = String.format("%-30s", getEmail());
        return "Student{" +
                super.toString() +
                ", GPA=" + GPA +
                ", subjectScores=" + subjectScores +
                '}';
    }
}
