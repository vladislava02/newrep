package PointTable;

import javax.swing.*;
import java.awt.*;

public class PointTable extends JFrame{ //основной фрейм, в него будут добавляться панели
    PointTable(){
        try {
            setTitle("Points on the plane");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLayout(new BorderLayout());
            ScrollTablePanel tablePanel = new ScrollTablePanel(this);
            add(tablePanel, BorderLayout.CENTER);
            setVisible(true);
        }catch(Exception ex){System.out.println("It`s in main table"+ ex);}
    }
    public static void main(String args[]) {
        new PointTable();
    }
}
