package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PointTable.*;

import javax.swing.*;

public class SortButton implements ActionListener {
    private PointTableModel pointTableModel;
    private JFrame owner;

    public SortButton(PointTableModel newPointTableModel, JFrame owner){
        pointTableModel = newPointTableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        pointTableModel.sortDataByX(); //вызываем метод сортировки
        pointTableModel.fireTableDataChanged(); //обновляем таблицу
    }
}
