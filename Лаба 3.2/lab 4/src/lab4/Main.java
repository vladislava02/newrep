package lab4;

class L3_1{
    public static interface Room{
        public abstract double getCapacity();

    }
    public static class LectureRoom implements Room{
        private int number;
        private int floor;
        private double area;

        private int rows;
        private boolean hasProjector;
        private int personPerRow;

        LectureRoom(int number,int floor,double area,int rows,boolean hasProjector,int p){
            this.number=number;
            this.floor=floor;
            this.area=area;
            this.rows=rows;
            this.personPerRow=p;
            this.hasProjector=hasProjector;
        }
        public double getCapacity(){
            return this.rows*this.personPerRow;
        }
    }
    public static class StudyRoom implements Room{

        private int number;
        private int floor;
        private double area;
        private int tablesCount;
        private boolean hasComputer;
        StudyRoom(int number,int floor,double area,int tables,boolean computer){
            this.number=number;
            this.floor=floor;
            this.area=area;
            this.tablesCount=tables;
            this.hasComputer=computer;
        }
        public double getCapacity(){
            return this.tablesCount*2;
        }
    }
    public static class Lab implements Room{
        private int number;
        private int floor;
        private double area;
        private int computersCount;
        Lab(int number,int floor,double area,int computers){
            this.number=number;
            this.floor=floor;
            this.area=area;
            this.computersCount=computers;
        }
        public double getCapacity(){return this.area;}
    }

    public static void main(String args[]){
        Lab l1=new Lab(423,4,75.4,5);
        StudyRoom l2=new StudyRoom(432,4,65,6,false);
        LectureRoom l3=new LectureRoom(362,3,102,8,true,12);
        System.out.println(l1.getCapacity());
        System.out.println(l2.getCapacity());
        System.out.println(l3.getCapacity());
    }
}


