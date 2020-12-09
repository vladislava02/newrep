package PointTable;

import javax.swing.*;
import java.awt.*;


public class FuncPanel extends JPanel { //класс - наследует панель и вставляет в себя кнопки
    private JButton addButton;
    private JButton delButton;
    private JButton redactButton;
    private JButton searchButton;
    private JButton sortButton;
    public FuncPanel(PointTableModel pointTableModel, JFrame owner){ //принимаются модель таблицы и ссылка на основной фрейм
        setLayout(new GridLayout(1,5,50,0));
        addButton = new JButton("Добавить");
        delButton = new JButton("Удалить");
        redactButton = new JButton("Изменить");
        searchButton = new JButton("Найти записи");
        sortButton = new JButton("Отсортировать записи по уб. X");
        addButton.addActionListener(new buttons.AddButton(pointTableModel, owner)); //слушатели кнопок - классы в пакете buttons
        delButton.addActionListener(new buttons.DelButton(pointTableModel, owner));
        redactButton.addActionListener(new buttons.RedactButton(pointTableModel, owner));
        searchButton.addActionListener(new buttons.SearchButton(pointTableModel, owner));
        sortButton.addActionListener(new buttons.SortButton(pointTableModel, owner));
        this.add(addButton);
        this.add(delButton);
        this.add(redactButton);
        this.add(searchButton);
        this.add(sortButton);
    }
}
