package models;

import java.util.LinkedList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private double grade;
   
    private List<Classes> class_list = new LinkedList<Classes>();

    public List<Classes> getClasses() {
        return this.class_list;
    }

    public Classes getClassPerName(String name) {
        for (Classes eachClass : this.class_list) {
            if (eachClass.getName().equals(name)) {
                return eachClass;
            }else{
                return null;
            }
        }
        return null; //in case no class has the name in question
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void add_class(Classes adding_class){
        this.class_list.add(adding_class);
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

    

}
