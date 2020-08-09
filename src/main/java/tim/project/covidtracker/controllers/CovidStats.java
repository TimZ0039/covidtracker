package tim.project.covidtracker.controllers;

public class CovidStats {
    int date;
    String state;
    int total;
    int positive;
    int negative;
    int hospitalizedCurrently;
    int death;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

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

    public int getHospitalizedCurrently() {
        return hospitalizedCurrently;
    }

    public void setHospitalizedCurrently(int hospitalizedCurrently) {
        this.hospitalizedCurrently = hospitalizedCurrently;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }
}


