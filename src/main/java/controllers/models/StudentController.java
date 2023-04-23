package controllers.models;

import java.util.ArrayList;

import dao.StudentDAO;
import models.Student;

public class StudentController {

    public static String[] GetAllStudentsName(){
        StudentDAO dao = new StudentDAO();

        ArrayList<Student> list = dao.getAll();
        String students[] = new String[list.size()];

        for(int i = 0; i < list.size(); i++){
            students[i] = list.get(i).getName();
        }

        return students;
    }

}
