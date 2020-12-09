package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PointTable.*;

import javax.swing.*;

public class SearchButton implements ActionListener {
    private PointTableModel pointTableModel;
    private JFrame owner;

    public SearchButton(PointTableModel newPointTableModel, JFrame owner){
        pointTableModel = newPointTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = (String)JOptionPane.showInputDialog(
                owner,
                "Введите имя точки",
                "Поиск",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                "Имя точки");
        if(name.equals("")){
            return;
        }
        if(!pointTableModel.searchData(name, owner)){
            JOptionPane.showMessageDialog(owner,
                    "Такой записи не было найдено",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        pointTableModel.fireTableDataChanged(); //обновляем таблицу
    }
}
