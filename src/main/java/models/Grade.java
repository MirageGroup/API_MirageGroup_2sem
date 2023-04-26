package models;

public class Grade {

    private double grade;
    private int fk_Students_id_student;
    private String fk_Assignments_id_assignment;
    private String delivered;

    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public int getFkStu(){
        return fk_Students_id_student;
    }
    public void setFkStu(int fk_Students_id_student) {
        this.fk_Students_id_student = fk_Students_id_student;
    }
    public String getFkAss() {
        return fk_Assignments_id_assignment;
    }
    public void setFkAss(String fk_Assignments_id_assignment ) {
        this.fk_Assignments_id_assignment = fk_Assignments_id_assignment;
    }
    public String getDelivered() {
        return delivered;
    }
    public void setDelivered(String delivered) {
        this.delivered = delivered;
    }
    

}
