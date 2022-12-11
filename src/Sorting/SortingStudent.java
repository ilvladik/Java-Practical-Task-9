package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SortingStudent {

    private Student[] mergeByGPA(Student[] a, Student[] b) {
        Comparator<Student> comparator = Comparator.comparingDouble(Student::getGPA);
        Student[] merged = new Student[a.length+b.length];
        int count_a = 0;
        int count_b = 0;
        int count = 0;
        while (count_a < a.length && count_b < b.length) {
            if (comparator.compare(a[count_a], b[count_b]) > 0) {
                merged[count] = a[count_a];
                count_a++;
            } else {
                merged[count] = b[count_b];
                count_b++;
            }
            count++;
        }
        while (count_a < a.length) {
            merged[count] = a[count_a];
            count_a++;
            count++;
        }
        while (count_b < b.length) {
            merged[count] = b[count_b];
            count_b++;
            count++;
        }
        return merged;
    }

    private Student[] mergeSortInner(Student[] students) {
        if (students.length < 2) {
            return students;
        }
        Student[] sorted_a = mergeSortInner(Arrays.copyOfRange(students, 0, students.length/2));
        Student[] sorted_b = mergeSortInner(Arrays.copyOfRange(students, students.length/2, students.length));
        return mergeByGPA(sorted_a, sorted_b);
    }

    public void mergeSort(Student[] students) {
        Student[] sorted = mergeSortInner(students);
        System.arraycopy(sorted, 0, students, 0, sorted.length);
    }

    private void swap(Student[] array, int index_a, int index_b) {
        Student c = array[index_a];
        array[index_a] = array[index_b];
        array[index_b] = c;
    }

    private int partitionByGPA(Student[] students, int startIndex, int pivot) {
        Comparator<Student> comparator = Comparator.comparingDouble(Student::getGPA);
        int i = startIndex;
        while (i <= pivot) {
            if (comparator.compare(students[i], students[pivot]) < 0 && i == pivot - 1) {
                swap(students, i, pivot);
                pivot--;
            } else if (comparator.compare(students[i], students[pivot]) < 0) {
                swap(students, pivot-1, pivot);
                swap(students, i, pivot);
                pivot--;
            } else {
                i++;
            }
        }
        return pivot;
    }

    private void quickSortInner(Student[] students, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivot = partitionByGPA(students, startIndex, endIndex);

            quickSortInner(students, startIndex, pivot - 1);
            quickSortInner(students, pivot + 1, endIndex);
        }
    }

    public void quickSort(Student[] students) {
        quickSortInner(students, 0, students.length - 1);
    }
}
