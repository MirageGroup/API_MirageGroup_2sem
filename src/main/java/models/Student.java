package models;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_student;

    @Column(name = "name_student")
    private String name_student;

    @Column(name = "grade_student")
    private double grade_student;

    public double getGrade() {
        return this.grade_student;
    }

    public void setGrade(double grade_student) {
        this.grade_student = grade_student;
    }

    public int getId() {
        return id_student;
    }
    public void setId(int id_student) {
        this.id_student = id_student;
    }
    public String getName() {
        return name_student;
    }
    public void setName(String name_student) {
        this.name_student = name_student;
    }

    

}
