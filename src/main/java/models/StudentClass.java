package models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_class")
public class StudentClass {
    
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_student_id_student", nullable = false)
    private Student student;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_class_id_class", nullable = false)
    private Classes classes;
 
    @Column(name = "delivered")
    private boolean delivered;
 
    @Column(name = "grade")
    private int grade;
}
