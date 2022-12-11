package Sorting;

import java.util.Random;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        SortingStudent sort = new SortingStudent();

        Student[] students_1 = getStudents();
        outStudents(students_1);
        sort.mergeSort(students_1);
        outStudents(students_1);

        Student[] students_2 = getStudents();
        outStudents(students_2);
        sort.quickSort(students_2);
        outStudents(students_2);
    }

    public static Student[] getStudents() {
        int count = Integer.parseInt(getString("Количесто студентов: "));
        Student[] students = new Student[count];
        for (int i = 0; i < count; i++) {
            students[i] = getStudent();
        }
        return students;
    }

    public static void outStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(i + 1 + ". " + students[i]);
            System.out.println();
        }
    }

    public static Student getStudent() {
        Random random = new Random();
        int id = random.nextInt(1, 1000);
        String firstName = "Tom_" + id;
        String lastName = "Tobasco " + id;
        String specialization = "Программная инженерия";
        String group = "ИКБО-" + id + "-00";
        int course = id % 100 + 1;
        double GPA = random.nextFloat(1F, 5F);

        return new Student(id, firstName, lastName,
                specialization, group, course, GPA);
    }

    public static String getString(String interaction) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(interaction);
        return scanner.nextLine();
    }

    public static Student[] sortingArray(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            while(j >= 0 && students[j].compareTo(key) > 0) {
                students[j+1] = students[j];
                j--;
            }
            students[j+1] = key;
        }
        return students;
    }
}
