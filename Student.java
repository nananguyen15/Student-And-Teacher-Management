import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements GPACalculate{
    private Double GPA;
    private List<Double> subjectScores; // List to store scores of 5 subjects

    public Student(String name, String id, String dateOfBirth, String email, String phoneNumber, Double GPA, List<Double> subjectScores) {
        super(name, id, dateOfBirth, email, String.valueOf(phoneNumber));
        this.GPA = GPA;
        this.subjectScores = subjectScores;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public List<Double> getSubjectScores() {
        return subjectScores;
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

    public void setScores(List<Double> scores) {
        this.subjectScores = scores;
    }
    @Override
    public void showAllInfo() {
        super.showAllInfo();
        for (Double score : subjectScores) {
            System.out.printf(" %-5.2f |", score);
        }
        System.out.printf(" %-5.2f |\n", getGPA());
    }


}
