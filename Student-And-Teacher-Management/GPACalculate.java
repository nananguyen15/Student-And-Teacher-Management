import java.util.List;

public interface GPACalculate{
    double calculateGPA(List<Double> scores);
    default double ConvertGPA(double score) {
        if (score >= 9)
            return 4.0;
        else if (score >= 8)
            return 3.0;
        else if (score >= 7)
            return 2.0;
        else if (score >= 6)
            return 1.0;
        else
            return 0;
    }
}



