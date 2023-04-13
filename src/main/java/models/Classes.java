package models;

import java.util.LinkedList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class Classes {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="name_class")
    private String name;

    @Column(name="time_class")
    private String hour;

    @Column(name="students")
    private List<Student> student_list = new LinkedList<Student>();


    public List<Student> get_student_list(){
        return this.student_list;
    }

    public Student get_student_per_id(int id){
        for (Student each_student : this.student_list) {
            if (each_student.getId() == id) {
                return each_student;
            }else{
                return null;
            }
        }
        return null; //in case no class has the name in question
    }
    
    public void add_Student_list(Student student){
        this.student_list.add(student);
    }

    public int getId(){
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
    public String getHour() {
        return hour;
    }
    public void setHour(String hour) {
        this.hour = hour;
    }
    
}
