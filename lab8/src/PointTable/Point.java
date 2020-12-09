package PointTable;

public class Point implements Comparable<Point>{ //Класс содержит поля для описания точки, реализует интерфейс Comparable
    private String name;
    private double x;
    private double y;
    private double distance; //поле не вводится, а вычисляется по теореме Пифагора(как гипотенуза) - удаленность от начала координат

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        resetDistance(); //при изменении координат пересчитываем удаленность от начала координат
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        resetDistance(); //при изменении координат пересчитываем удаленность от начала координат
    }

    public double getDistance() {
        return distance;
    }

    public void resetDistance() { //Вызывается при изменении координат, для изменения дистанции
        distance = Math.sqrt(x*x+y*y);
    }

    public static Object[] getNames(){  //Метод возвращает названия для всех столбцов таблицы
        return new Object[]{"Имя точки", "по x", "по y", "удаленность от нач. коорд."};
    }

    public String toString(){
        return "Имя точки : "+name+", по x : "+x+", по y : "+y+", удаленность от нач. коорд. : "+distance;
    }

    public String getSomeInfo(int indexOfField){ //метод возвращает строку - поле объекта в зависимости от индекса поля
        switch(indexOfField){
            case 0 : return name;
            case 1 : return String.valueOf(x);
            case 2: return String.valueOf(y);
            case 3: return String.valueOf(distance);
            default: return "error(no field)";
        }
    }

    @Override
    public int compareTo(Point point) { //метод интерфейса Comparable для сравнения элементов
        if(point.x>this.x)
            return 1;
        if(point.x<this.x)
            return -1;
        return 0;
    }
}
