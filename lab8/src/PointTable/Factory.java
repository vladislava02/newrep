package PointTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Factory { //Класс в котором создаются новые объеты Point

    public Point createPoint(JFrame owner){ //метод вернет созданный объект
        Object []names = Point.getNames();
        JLabel labName = new JLabel(names[0].toString());
        JTextField textName = new JTextField(50);
        JLabel labX = new JLabel(names[1].toString());
        JTextField textX = new JTextField(50);
        JLabel labY = new JLabel(names[2].toString());
        JTextField textY = new JTextField(50);
        JButton completeButton = new JButton("Добавить");
        JLabel labRes =  new JLabel ("Впишите данные");

        Point mainPoint = new Point();

        JDialog dialog = new JDialog(owner,"Окно добавления записи" , Dialog.ModalityType.DOCUMENT_MODAL); //создааем модальное диалоговое окно
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //модальное - значит будет перекрывать основное окно
        dialog.setSize(500, 200);
        dialog.setLayout(new GridLayout(5,2,10,7));
        completeButton.addActionListener(new ActionListener() { //описываем дейсвтия при нажатии кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textName.getText().equals("")||textX.getText().equals("")||textY.getText().equals("")){
                    labRes.setText("Необходимо ввести все данные!");
                }
                else{
                    mainPoint.setName(textName.getText());
                    mainPoint.setX(Double.parseDouble(textX.getText()));
                    mainPoint.setY(Double.parseDouble(textY.getText()));
                    mainPoint.resetDistance();
                    dialog.dispose();
                }
            }
        });
        dialog.add(labName); //добавляем элементы в диалоговое окно
        dialog.add(textName);
        dialog.add(labX);
        dialog.add(textX);
        dialog.add(labY);
        dialog.add(textY);
        dialog.add(labRes);
        dialog.add(completeButton);
        dialog.setVisible(true);
        return mainPoint;
    }
}
