package tim.project.covidtracker.controllers;

public class CovidStatsOutput {
    int positive;
    int negative;
    double testPositiveRate;

    public int getPositive() {
        return positive;
    }

    public void setPositive(int positive) {
        this.positive = positive;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    public double getTestPositiveRate() {
        return testPositiveRate;
    }

    public void setTestPositiveRate(double testPositiveRate) {
        this.testPositiveRate = testPositiveRate;
    }
}


