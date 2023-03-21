package classes;

import java.util.LinkedList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Class> class_list = new LinkedList<Class>();

    public List<Class> getClasses() {
        return this.class_list;
    }

    public Class getClassPerName(String name) {
        for (Class eachClass : this.class_list) {
            if (eachClass.getName().equals(name)) {
                return eachClass;
            }else{
                return null;
            }
        }
        return null; //in case no class has the name in question
    }

    public void add_class(Class adding_class){
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
