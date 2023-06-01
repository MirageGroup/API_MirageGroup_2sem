package controllers.models;

import java.util.ArrayList;

import dao.AssignmentDAO;
import gui.ClienteGUI;
import models.Assignment;

public class AssignmentController {
    public static void addAssignment(Assignment assignment) {
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        assignmentDAO.save(assignment);
        // ClienteGUI.addAssignment.setText("");
    }

    public static String[] GetAllAssignmentName() {
        AssignmentDAO dao = new AssignmentDAO();

        ArrayList<Assignment> list = dao.getAssignments();
        String assignments[] = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            assignments[i] = list.get(i).getName();
        }

        return assignments;

    }
}