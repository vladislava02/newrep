package PointTable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;

public class PointTableModel extends AbstractTableModel { //модель для создания таблицы(содержит методы для работы с таблицей)

    private int colls;
    private ArrayList<Point> arrayList; //используем коллекцию ArrayList для хранения объектов
    private Object[] collNames;

    public PointTableModel(Object []newCollNames){
        colls = newCollNames.length;
        arrayList = new ArrayList<>();
        collNames = newCollNames.clone();
    }

    @Override
    public int getRowCount() {
        return arrayList.size();
    }

    @Override
    public int getColumnCount() {
        return collNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return arrayList.get(rowIndex).getSomeInfo(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex){
        return String.valueOf(collNames[columnIndex]);
    }

    public boolean addData(Point newData){ //программа ищет место, чтобы вставить сразу в алфавитном порядке
        int i=0;
        Point point;
        ListIterator<Point> iterator = arrayList.listIterator();
        while(iterator.hasNext()){
            point = (Point) iterator.next();
            if(newData.getName().equals(point.getName())) //Если объект с таким именем уже существует, то мы его не вставляем
                return false;
        }
        iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){ //Ищем в цикле место, куда вставить элемент
            point = (Point) iterator.next();
            if(newData.getDistance() - point.getDistance() > 0)
                break;
        }
        arrayList.add(i, newData);
        return true;
    }

    public boolean removeData(String nameToDel){  //удаление элемента из списка
        int i=0;
        Point point;
        boolean chekFound=false;
        ListIterator<Point> iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){
            point = (Point) iterator.next();
            if(nameToDel.equals(point.getName())) {
                chekFound = true;
                break;
            }
        }
        if(!chekFound){
            return false;
        }
        arrayList.remove(i);
        return true;
    }

    public boolean redactData(String nameToRedact, String chosenField, String newStr){ //Рекадактируем элемент в списке
        int i=0;
        Point point;
        boolean chekFound=false;
        ListIterator<Point> iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){   //ищем позицию элемента
            point = (Point) iterator.next();
            if(nameToRedact.equals(point.getName())) {
                chekFound = true;
                break;
            }
        }
        if(!chekFound){
            return false;
        }
        point = arrayList.get(i);  //редактируем метод в зависимости от поля
        switch (chosenField){
            case "Имя точки" : point.setName(newStr);
            break;
            case "по x":   point.setX(Double.parseDouble(newStr));
            break;
            case "по y": point.setY(Double.parseDouble(newStr));
            break;
            default: break;
        }
        arrayList.set(i, point); //заменяем старый элемент на новый
        return true;
    }

    public boolean searchData(String name, JFrame owner){ //ищем элемент по названию и выводим его в диалоговом окне
        int i=0;
        Point point;
        boolean chekFound=false;
        ListIterator<Point> iterator = arrayList.listIterator();
        for(i=0; iterator.hasNext();i++){
            point = (Point) iterator.next();
            if(name.equals(point.getName())) {
                chekFound = true;
                JOptionPane.showMessageDialog(owner,
                        point.toString(),
                        "Вывод назденный записей",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
        return chekFound;
    }

    public void sortDataByX(){
        Collections.sort(arrayList);
    } //вызываем стандартный метод для сортировки коллекции
}
