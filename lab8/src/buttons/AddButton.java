package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PointTable.*;

import javax.swing.*;

public class AddButton implements ActionListener {
    private PointTableModel pointTableModel;
    private JFrame owner;

    public AddButton(PointTableModel newPointTableModel, JFrame owner){
        pointTableModel = newPointTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Point point = new Factory().createPoint(owner); //создается объект
        if(point.getName().equals("")) return;
        if(!pointTableModel.addData(point)){  //добавляем элемент в таблицу
            JOptionPane.showMessageDialog(owner,   //Вызывается диалоговое окно, если добавление элемента не удалось
                    "Объект на записан. Вещь с таким именем уже существует",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
        pointTableModel.fireTableDataChanged(); //обновляем таблицу
    }
}
