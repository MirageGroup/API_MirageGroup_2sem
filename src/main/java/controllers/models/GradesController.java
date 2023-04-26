package controllers.models;


import java.util.ArrayList;

import dao.GradeDAO;
import models.Grade;

public class GradesController {
    
    public static int[] GetAllStudentGrades() {
        GradeDAO dao = new GradeDAO();

        ArrayList<Grade> list = dao.getAllGrades();
        int grades[] = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            grades[i] = (int) list.get(i).getGrade();
        }

        return grades;

    }

}
