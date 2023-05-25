package controllers.models;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

    public static void selectCurrentClazz() throws ParseException{
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        ClazzDAO dao = new ClazzDAO();
        ArrayList<Clazz> list = dao.getByWeekday(dayOfWeek);        
        
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        
        SimpleDateFormat inputParser = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date now = inputParser.parse(hour+":"+minute+":"+second);

        for (Clazz clazz : list) {
            Date clazzTimeStart = inputParser.parse(clazz.getTime_start());
            Date clazzTimeEnd = inputParser.parse(clazz.getTime_end());

            if( clazzTimeStart.before(now) && clazzTimeEnd.after(now) ){
                
            }
        }

    }

}
