package models;

public class Grade {

    private double grade;
    private double grade1;
    private double grade2;
    private double grade3;
    private double grade4;
    private int fk_Students_id_student;
    private String fk_Assignments_id_assignment;
    private String delivered;

    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public double getGrade1() {
        return grade1;
    }
    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }
    public double getGrade2() {
        return grade2;
    }
    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }
    public double getGrade3() {
        return grade3;
    }
    public void setGrade3(double grade3) {
        this.grade3 = grade3;
    }
    public double getGrade4() {
        return grade4;
    }
    public void setGrade4(double grade4) {
        this.grade4 = grade4;
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
    public void setFkAss(String fk_Assignments_id_assignment) {
        this.fk_Assignments_id_assignment = fk_Assignments_id_assignment;
    }
    public String getDelivered() {
        return delivered;
    }
    public void setDelivered(String delivered) {
        this.delivered = delivered;
    }
    

}
