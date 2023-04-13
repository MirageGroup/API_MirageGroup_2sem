package models;

import java.util.LinkedList;
import java.util.List;

public class Task {
    private int id;
    private String name;
    private String description;
    private Boolean delivered;
    private List<Student> student_list = new LinkedList<Student>();
    
    public List<Student> get_student_list(){
        return this.student_list;
    }

    public void add_student_list(Student student){
        this.student_list.add(student);
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

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(boolean value) {
        this.delivered = value;
    }

}
