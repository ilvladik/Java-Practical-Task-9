package Sorting;

public class Student implements Comparable<Student> {

    private int id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String group;
    private int course;
    private double GPA;

    public Student(int id, String firstName, String lastName,
                   String specialization, String group,
                   int course, double GPA) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.group = group;
        this.course = course;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return " Student: " + lastName + " " + firstName + "\n"
                + " id: " + id + "\n"
                + " group: " + group + "\n"
                + " course: " + course + "\n"
                + " specialization: " + specialization + "\n"
                + " GPA: " + GPA;
    }

    @Override
    public int compareTo(Student o) {
        if (id > o.id) {
            return 1;
        } else if (id < o.id) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
