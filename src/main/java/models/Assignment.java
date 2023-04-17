package models;

import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name_assignment")
    private String name;

    @Column(name = "desc_assignment")
    private String description;

    @Column(name = "date_assigned")
    private Time date_assigned;

    @Column(name = "date_due")
    private Time date_due;

    @Column(name = "max_grade")
    private double max_grade;
    


    public Time getDate_assigned() {
        return date_assigned;
    }

    public void setDate_assigned(Time date_assigned) {
        this.date_assigned = date_assigned;
    }

    public Time getDate_due() {
        return date_due;
    }

    public void setDate_due(Time date_due) {
        this.date_due = date_due;
    }

    public double getMax_grade() {
        return max_grade;
    }

    public void setMax_grade(double max_grade) {
        this.max_grade = max_grade;
    }

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

}
