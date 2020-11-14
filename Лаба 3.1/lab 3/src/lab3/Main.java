
class L3_1{
    public static class Room{
        private int number;
        private int floor;
        private double area;

        Room(int number,int floor,double area){
            this.number=number;
            this.floor=floor;
            this.area=area;

        }
        double getCapacity(){
            return this.area;
        }
    }
    public static class LectureRoom extends Room{
        private int rows;
        private boolean hasProjector;
        private int personPerRow;

        LectureRoom(int number,int floor,double area,int rows,boolean hasProjector,int p){
            super(number,floor,area);
            this.rows=rows;
            this.personPerRow=p;
            this.hasProjector=hasProjector;
        }
        double getCapacity(){
            return this.rows*this.personPerRow;
        }
    }
    public static class StudyRoom extends Room{
        private int tablesCount;
        private boolean hasComputer;
        StudyRoom(int number,int floor,double area,int tables,boolean computer){
            super(number,floor,area);
            this.tablesCount=tables;
            this.hasComputer=computer;
        }
        double getCapacity(){
            return this.tablesCount*2;
        }
    }
    public static class Lab extends Room{
        private int computersCount;
        Lab(int number,int floor,double area,int computers){
            super(number,floor,area);
            this.computersCount=computers;
        }
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

