public interface GPACalculate{
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

    double calculateGPA(double score);
}

class MAD implements GPACalculate{
    @Override
    public double calculateGPA(double score) {
        return ConvertGPA(score);
    }
}

class OSG implements GPACalculate{

    @Override
    public double calculateGPA(double score) {
        return ConvertGPA(score);
    }
}

class NWC implements GPACalculate{

    @Override
    public double calculateGPA(double score) {
        return ConvertGPA(score);
    }
}

class PRO implements GPACalculate{

    @Override
    public double calculateGPA(double score) {
        return ConvertGPA(score);
    }
}

class SSG implements GPACalculate{
    @Override
    public double calculateGPA(double score) {
        return ConvertGPA(score);
    }
}


