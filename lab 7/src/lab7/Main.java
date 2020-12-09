package lab7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

class User {
    public static void main(String[] args) {
        Reader med = new Reader("Регистрация поступления игрушек"); //создание объекта - окно со всеми компонентами
        med.setVisible(true); //делаем его видимым
        med.setResizable(false);
        med.setLocationRelativeTo(null);

    }
}

class Reader extends JFrame { //наследуем класс с окном
    int k;
    Object boxA, boxB, boxC; //объекты для получения значений элементов списков
    String boxC1, boxC2, boxC3;
    File file = new File("D://GUI.txt"); //создаем файл
    static JLabel l1, l2, l3, l4, l5; // лейблы
    JComboBox box_1, box_2, box_3; //раскрывающиеся списки
    JRadioButton flag1, flag2; //радиокнопки
    JCheckBox cb1, cb2, cb3;//флажки
    ButtonGroup bg; //для группировки радиокнопок
    static JButton b, del; //кнопки
    static JTextField text; // текстовое поле
    static JTextArea area; // текстовая область
    static String[] box1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    static String[] box2 = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
    static String[] box3 = {"2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
//списко с числами месяца


    public Reader(String str) { //конструктор класса
        super(str); //вызываем конструктор суперкласса и называеи окнопараметром str
        setSize(550, 600); //размер окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершениепрограммы при нажатии крестика


        b = new JButton("Внесение в базу"); //создание объектов кнопок, впараметрах указываются имена
        del = new JButton("Очистить");
        text = new JTextField(9);
        area = new JTextArea(9, 9);

        l1 = new JLabel("Название игрушки"); //созданеи объектов лейблов
        l2 = new JLabel("Характеристики игрушки");
        l3 = new JLabel("Дата поступления");
        l4 = new JLabel("Пол");
        l5 = new JLabel("Питание");
        box_1 = new JComboBox(box1); //создание объектов списков, в параметрахсписки (массивы строк, созданные выше)
        box_2 = new JComboBox(box2);
        box_3 = new JComboBox<Object>(box3);
        flag1 = new JRadioButton("Для мальчика"); //создание объектоврадиокнопок, в параметрах указываются имена
        flag2 = new JRadioButton("Для девочки");
        bg = new ButtonGroup();//объединение радиокнопок, чтобы выбирать одиниз вариантов
        bg.add(flag1);
        bg.add(flag2);
        cb1 = new JCheckBox("сеть 220В");
        cb2 = new JCheckBox("аккумуляторы");
        cb3 = new JCheckBox("батарейки");

        b.setSize(180, 30);
        b.setLocation(300, 500);
        del.setSize(100, 30);
        del.setLocation(100, 500);
        text.setSize(220, 25);
        text.setLocation(250, 20);
        area.setSize(220, 150);
        area.setLocation(250, 60);
        l1.setSize(200, 25);
        l1.setLocation(30, 20);
        l2.setSize(220, 25);
        l2.setLocation(30, 60);
        l3.setSize(200, 25);
        l3.setLocation(30, 250);
        l4.setSize(200, 25);
        l4.setLocation(30, 310);
        l5.setSize(200, 25);
        l5.setLocation(30, 350);
        box_1.setSize(40, 25);
        box_1.setLocation(250, 250);
        box_2.setSize(100, 25);
        box_2.setLocation(300, 250);
        box_3.setSize(70, 25);
        box_3.setLocation(410, 250);
        flag1.setSize(120, 25);
        flag1.setLocation(250, 310);
        flag2.setSize(120, 25);
        flag2.setLocation(390, 310);
        cb1.setSize(150, 25);
        cb1.setLocation(250, 350);
        cb2.setSize(150, 25);
        cb2.setLocation(250, 380);
        cb3.setSize(150, 25);
        cb3.setLocation(250, 410);
        b.setBackground(Color.red); //цвет кнопок
        flag1.setBackground(Color.cyan);
        flag2.setBackground(Color.pink);


        setLayout(null);//установка менеджера управления как null, чтобысамому задавать размер и расположение компонентов
        setVisible(true);


        add(b);//добавление компонентов на панель

        add(del);
        add(text);
        add(area);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(box_1);
        add(box_2);
        add(box_3);
        add(flag1);
        add(flag2);
        add(l5);
        add(cb1);
        add(cb2);
        add(cb3);


        b.addActionListener(new ButtonActionListener());//добавление блоковпрослушивания для обработки событий типа ActionListener (нажатие кнопки)
        flag1.addActionListener(new FlagActionListener());
        flag2.addActionListener(new FlagActionListener());
        del.addActionListener(new DelActionListener());
        box_1.addActionListener(new BoxActionListener());
        box_2.addActionListener(new BoxActionListener());
        box_3.addActionListener(new BoxActionListener());
        cb1.addActionListener(new CbActionListener());
        cb2.addActionListener(new CbActionListener());
        cb3.addActionListener(new CbActionListener());

    }
    

    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter out = new FileWriter(file, true);
                try {
                    String text1 = text.getText();
                    String area2 = area.getText();
                    out.write(text1 + " - ");
                    out.write(area2 + "\n");
                    if (k == 1)
                        out.write("Для мальчиков. " + "\n");
                    else if (k == -1)
                        out.write("Для девочек. " + "\n");
                    out.write(" (Дата поступления:" + boxA + " " + boxB + " " + boxC + ")");
//запись данных в файл//
                    out.write("(Тип питания " + (boxC1== null ? "none" : boxC1) + ", " + (boxC2 == null ? "none" : boxC2) + ", " + (boxC3 == null? "none" : boxC3) + ");");
                } finally {
                    out.close(); //закрытие потока
                }
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }

        }
    }

    public class FlagActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            k = 0;
            if (e.getSource() == flag1) {
                k++;
            } else if (e.getSource() == flag2) {
                k--;
            }
        }
    }

    //создание блоков прослушивания для компонентов, классы реализуют интерфейс ActionListener, реализуют 1 метод actionPerformed
    public class DelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == del) {
                text.setText(null);
                area.setText(null);

            }

        }
    }

    public class BoxActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == box_1) {
                boxA = box_1.getSelectedItem(); //при выборе элементаодного из списков соответствующему обЪекту присваивается значение элементасписка
            }
            if (e.getSource() == box_2) {
                boxB = box_2.getSelectedItem();
            }
            if (e.getSource() == box_3) {
                boxC = box_3.getSelectedItem();

            }
        }
    }

    public class CbActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cb1) {
                boxC1 = cb1.getText();
            }
            if(e.getSource() == cb2) {
                boxC2 = cb2.getText();
            }
            if(e.getSource() == cb3) {
                boxC3 = cb3.getText();
            }
        }
    }
}
