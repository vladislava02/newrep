package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PointTable.*;

import javax.swing.*;

public class RedactButton implements ActionListener {
    private PointTableModel pointTableModel;
    private JFrame owner;

    public RedactButton(PointTableModel newPointTableModel, JFrame owner){
        pointTableModel = newPointTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = (String)JOptionPane.showInputDialog(
                owner,
                "Введите имя точки, которую нужно изменить",
                "Редактирование",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "имя");
        if(name.equals("")){
            return;
        }
        Object []buffer = Point.getNames();
        Object []redactNames = new Object[buffer.length-1]; //массив содержит названия полей, чтобы из них пользователь выбрал поле для редактирования
        for(int i=0;i< buffer.length-1;i++){  ///Добавляем все поля, кроме последнего, т.к. оно изменяется само
            redactNames[i] = buffer[i];
        }
        String chosenField = (String)JOptionPane.showInputDialog(
                owner,
                "Выберите поле для редактирования",
                "Редактирование",
                JOptionPane.QUESTION_MESSAGE,
                null,
                redactNames,
                "Имя точки");
        if(chosenField.equals("")){
            return;
        }
        String newStr = (String)JOptionPane.showInputDialog(
                owner,
                "Введите новые данные",
                "Редактирование",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "новые данные");
        if(newStr.equals("")){
            return;
        }
        if(!pointTableModel.redactData(name, chosenField, newStr)){
            JOptionPane.showMessageDialog(owner,
                    "Такой записи не было найдено",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        pointTableModel.fireTableDataChanged(); //обновляем таблицу
    }
}
