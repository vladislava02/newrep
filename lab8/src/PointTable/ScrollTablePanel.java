package PointTable;

import javax.swing.*;
import java.awt.*;

public class ScrollTablePanel extends JPanel{ //здесь создается объект модели таблицы, передается к jtable, jtable передается к JScrollPane
    PointTableModel pointTableModel;
    public ScrollTablePanel(JFrame owner) {
        try {
            this.setLayout(new BorderLayout());
            pointTableModel = new PointTableModel(Point.getNames());
            JTable table = new JTable(pointTableModel);
            JScrollPane scrollTable = new JScrollPane(table);
            scrollTable.setPreferredSize(new Dimension(400,400));
            FuncPanel funcPanel = new FuncPanel(pointTableModel, owner); //создается панель с кнопками
            this.add(scrollTable, BorderLayout.CENTER);
            this.add(funcPanel, BorderLayout.SOUTH);
        }catch(Exception ex){System.out.println("It`s in scrol table panel "+ex); throw(ex);}
    }
}


