package controllers.models;
import java.util.ArrayList;

import dao.ClazzDAO;
import dao.StudentDAO;
import models.Clazz;
import models.Student;

public class ClazzController {

    public static String[] GetAllClazzesName() {
        ClazzDAO dao = new ClazzDAO();

        ArrayList<Clazz> list = dao.getAll();
        String clazzes[] = new String[list.size()];

        for(int i = 0; i < list.size(); i++){
            clazzes[i] = list.get(i).getName();
        }

        return clazzes;

    }

    public class StudentController{
        public  String[] GetAllStudentsName(){
            StudentDAO dao = new StudentDAO();
            
            ArrayList<Student> list = dao.getAll();
            String students[] = new String[list.size()];

            for(int i = 0; i < list.size(); i++){
                students[i] = list.get(i).getName();
            }

            return students;
        }
    }
}
