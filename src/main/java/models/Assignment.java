package models;

public class Assignment {
    private int id;
    private String name;
    private String description;
    private String date_assigned;
    private String date_due;
    private double max_grade;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDate_assigned() {
        return date_assigned;
    }
    public void setDate_assigned(String date_assigned) {
        this.date_assigned = date_assigned;
    }
    public String getDate_due() {
        return date_due;
    }
    public void setDate_due(String date_due) {
        this.date_due = date_due;
    }
    public double getMax_grade() {
        return max_grade;
    }
    public void setMax_grade(double max_grade) {
        this.max_grade = max_grade;
    }
}