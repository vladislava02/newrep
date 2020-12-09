package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PointTable.*;

import javax.swing.*;

public class DelButton implements ActionListener {
    private PointTableModel pointTableModel;
    private JFrame owner;

    public DelButton(PointTableModel newPointTableModel, JFrame owner){
        pointTableModel = newPointTableModel;
        this.owner = owner;
    }
    public void actionPerformed(ActionEvent e){
        String name = (String)JOptionPane.showInputDialog( //с помощью диалоговых окон пользовтель вводит элемент для удаления
                owner,
                "Введите имя точки",
                "Удаление",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "Имя точки");
        if(name.equals("")){
            return;
        }
        if(!pointTableModel.removeData(name)){
            JOptionPane.showMessageDialog(owner,
                    "Такой записи не было найдено",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        pointTableModel.fireTableDataChanged(); //обновляем таблицу
    }
}
