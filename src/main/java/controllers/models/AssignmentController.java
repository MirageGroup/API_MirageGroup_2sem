package controllers.models;

import dao.AssignmentDAO;
import gui.ClienteGUI;
import models.Assignment;

public class AssignmentController {
    public static void addAssignment(Assignment assignment) {
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        assignmentDAO.save(assignment);
        
    }
}