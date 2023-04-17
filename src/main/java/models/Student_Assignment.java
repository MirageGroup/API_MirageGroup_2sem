package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_assignment")
public class Student_Assignment {
    
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "fk_Students_id_student")
    private int id_student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_Assignments_id_assignment")
    private int id_assignment;

    @Column(name = "delivered")
    private boolean delivered;

    @Column(name = "grade")
    private double grade;



    public int getId_student() {
        return id_student;
    }
    public void setId_student(int id_student) {
        this.id_student = id_student;
    }
    public int getId_assignment() {
        return id_assignment;
    }
    public void setId_assignment(int id_assignment) {
        this.id_assignment = id_assignment;
    }
    public boolean isDelivered() {
        return delivered;
    }
    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }

}
