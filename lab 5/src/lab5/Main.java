package lab5;

import java.io.*;

import static lab5.Main.Student.OutputOfFile;

public class Main {

    public static void main(String[] args) throws IOException {
        Student[] students; //Создание массива объектов
        students = new Student[3];
        for (int i = 0; i < 3; i++)
            students[i] = new Student(); 
        for (int i = 0; i < 3; i++)
            students[i].InputInFile();
        Student.hasLic(students);
        Student.avrg(students);
        Student.OutputOfFile();

    }


    public static class Student {
        String name;
        int age;
        boolean license;

        Student() throws IOException {
            String bolv;
//открываем символьный поток ввода
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
            System.out.print("\nВведите фамилию: ");
            this.name = input.readLine();
            System.out.print("\nВведите возраст: ");
            this.age = Integer.parseInt(input.readLine());
            while (true) {
                System.out.print("\nНаличие задолженности(Пожалуйста,выберите Да/Нет): ");
                bolv = input.readLine();
                if ("Да".equals(bolv)) {
                    this.license = true;
                    break;
                }
                if ("Нет".equals(bolv)) {
                    this.license = false;
                    break;
                }
                System.out.print("\nОшибка! Повторите ввод");
            }
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean getLicense() {
            return license;
        }

        //записываем информацию в файл document.doc
        public void InputInFile() throws IOException {
            File file = new File("document.doc");
            file.deleteOnExit(); //файл удалится после завершения работы виртуальной машины Java
//поток для записи в файл
            FileWriter writer;
            writer = new FileWriter(file, true);
            writer.append("ФИО студента " + this.name + "; возраст: " + this.age + "; ");
            if (this.license)
                writer.append("есть задолженность.\n");
            else writer.append("нет задолженности.\n");
            writer.flush();
            writer.close();
        }

        //статический метод вывода информации из файла
        public static void OutputOfFile() throws IOException {
            File file = new File("document.doc");
//поток для вывода информации
            FileReader reader;
            char buffer[];// //создание массива, с помощью которого считывается информация из файла
            int numb;
            buffer = new char[1];
            reader = new FileReader(file);
            do {
                numb = reader.read(buffer);
                System.out.print(buffer[0]);
            } while (numb == 1);
            reader.close();
        }


        public static void avrg(Student[] students) throws IOException {
// Статический метод для подсчёта среднего возраста и записи его в файл

// Выполняется подсчёт среднего возраста

            int avrg = 0;
            for (int i = 0; i < students.length; i++) {
                avrg += students[i].getAge();
            }
            File f1 = new File("document.doc");
            FileWriter writer = new FileWriter(f1, true);
            writer.append("\nСредний возраст: " + avrg / students.length + "\n");
            writer.flush();
            writer.close();
        }


        //статический метод подсчета студентов с задолженностью и записи его в файл
        public static void hasLic (Student[]students) throws IOException {
            int d = 0;
            for (int i = 0; i < 3; i++)
                if (students[i].license == true) {
                    d++;
                }
            File file = new File("document.doc");
            file.deleteOnExit();
            FileWriter writer;
            writer = new FileWriter(file,true);
            writer.append("\nКоличество с задолженностями: "+d);
            writer.flush();
            writer.close();
        }
    }
}
