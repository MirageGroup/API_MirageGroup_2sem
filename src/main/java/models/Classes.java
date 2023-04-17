package models;

import java.sql.Time;

import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_class;

    @Column(name="name_class")
    private String name_class;

    @Column(name="time_class")
    private Time time_class;

    public int getId(){
        return this.id_class;
    }
    public void setId(int id_class) {
        this.id_class = id_class;
    }
    public String getName() {
        return this.name_class;
    }
    public void setName(String name_class) {
        this.name_class = name_class;
    }
    public Time getTime() {
        return this.time_class;
    }
    public void setHour(Time time_class) {
        this.time_class = time_class;
    }
    
}
