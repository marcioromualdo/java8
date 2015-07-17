package lesson1;

public class Student {
    int gradYear;
    double grade;

    public Student(int gradYear, double grade) {
        this.gradYear = gradYear;
        this.grade = grade;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student [gradYear=");
        builder.append(gradYear);
        builder.append(", grade=");
        builder.append(grade);
        builder.append("]");
        return builder.toString();
    }

}
