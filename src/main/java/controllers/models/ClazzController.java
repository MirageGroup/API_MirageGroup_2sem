package controllers.models;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import gui.ClienteGUI;

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

    public static void saveClazz() throws SQLException{
        if(ClienteGUI.CadSalas.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo não pode estar vazio");
        } else {
            Clazz clazz = new Clazz();
            clazz.setName(ClienteGUI.CadSalas.getText());

            ClazzDAO clazzdao = new ClazzDAO();
            clazzdao.save(clazz);
            JOptionPane.showMessageDialog(null, "Turma "+ClienteGUI.CadSalas.getText()+" cadastrada");
            ClienteGUI.CadSalas.setText("");
            
            clazzdao.closeConn();

            ClienteGUI.ComboSalas.setModel(new javax.swing.DefaultComboBoxModel<>( ClazzController.GetAllClazzesName() ));
            ClienteGUI.ComboSalasCad.setModel(new javax.swing.DefaultComboBoxModel<>( ClazzController.GetAllClazzesName() ));
        }
    }

    public static void selectCurrentClazz(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        ClazzDAO dao = new ClazzDAO();
        ArrayList<Clazz> list = dao.getByWeekday(dayOfWeek);
        for (Clazz clazz : list) {
            System.out.println(clazz.getId());
            System.out.println(clazz.getName());
            System.out.println(clazz.getTime());
            System.out.println(clazz.getWeekday());
        } 
    }

}
