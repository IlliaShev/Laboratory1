package com.labaratory1.handler;

import utils.ConsoleRequest;
import utils.DataInput;
import com.labaratory1.abstractions.*;

/**
 * StudentHandler class
 */
public class StudentHandler {
    /**
     * Array with students
     */
    private Student[] students;
    /**
     * Maximum size of array
     */
    private int maximumSize;
    /**
     * Index of the last students
     */
    private int currentStudent;

    /**
     * Get number of current student
     *
     * @return current student
     */
    public int getCurrentStudent() {
        return currentStudent;
    }

    /**
     * Get maximum size of the faculties array
     *
     * @return maximum size
     */
    public int getMaximumSize() {
        return maximumSize;
    }

    /**
     * Create handler for students
     *
     * @param maximumSize - maximum size of the array
     */
    public StudentHandler(int maximumSize) {
        this.maximumSize = maximumSize;
        students = new Student[maximumSize];
    }

    /**
     * Create default students handler
     */
    public StudentHandler() {
        this(10);
    }


    /**
     * getStudents
     *
     * @return Student
     */
    public Student[] getStudents() { return students; }

    /**
     * Add student to the handler
     *
     * @param student - student
     */
    public void addStudent(Student student) {
        students[currentStudent++] = student;
    }

    /**
     * Add student to the handler
     */
    public void addStudent() {
        if (currentStudent < maximumSize)
            students[currentStudent++] = buildStudent();
        else
            System.out.println("Досягнута максимальна кількість студентів");
    }

    /**
     * Edit student
     *
     * @param studentIndex - student index
     */
    public void editStudent(int studentIndex) {
        System.out.println(students[studentIndex]);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1 - змінити ім'я студента");
            System.out.println("2 - змінити групу студента");
            System.out.println("3 - змінити курс студента");
            System.out.println("4 - закінчити редагування студента");
            choice = DataInput.getInt("Оберіть дію");
            switch (choice) {
                case 1 -> students[studentIndex].setName(getValidName());
                case 2 -> students[studentIndex].setGroup(getValidGroup());
                case 3 -> students[studentIndex].setCourse(getValidCourse());
                case 4 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    /**
     * Delete student from the handler
     *
     * @param studentIndex - student index
     */
    public void deleteStudent(int studentIndex) {
        Student[] newStudents = new Student[maximumSize];
        System.arraycopy(students, 0, newStudents, 0, studentIndex);
        System.arraycopy(students, studentIndex + 1, newStudents, studentIndex, maximumSize - studentIndex + 1);
        students = newStudents;
        currentStudent--;
    }

    /**
     * Print to the console all the student that was added
     */
    public void showStudents() {
        for (int i = 0; i < currentStudent; i++) {
            System.out.println((i + 1) + ": " + students[i]);
        }
    }

    /**
     * Create new student
     *
     * @return Student
     */
    private Student buildStudent() {
        String name = getValidName();
        String group = getValidGroup();
        int course = getValidCourse();
        return new Student(name, group, course);
    }

    /**
     * Get valid name student
     *
     * @return valid name
     */
    private String getValidName() {
        return DataInput.getString("Введіть ім'я студента");
    }

    /**
     * Get valid group student
     *
     * @return valid group
     */
    private String getValidGroup() {
        return DataInput.getString("Введіть групу студента");
    }

    /**
     * Get array students by course
     *
     * @param course - course
     * @return array students by course
     */
    public Student[] getStudentsByCourse(int course) {
        int arrSize = 0;
        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getCourse() == course)
                arrSize++;
        }
        Student[] res = new Student[arrSize];
        int currIn = 0;
        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getCourse() == course)
                res[currIn++] = students[i];
        }
        return res;
    }

    /**
     * Get array students by group
     *
     * @param group - group
     * @return array students by course
     */
    public Student[] getStudentsByGroup(String group) {
        int arrSize = 0;
        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getGroup().equals(group))
                arrSize++;
        }
        Student[] res = new Student[arrSize];
        int currIn = 0;
        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getGroup().equals(group))
                res[currIn++] = students[i];
        }
        return res;
    }


    /**
     * Get array students by name
     *
     * @param name - name
     * @return array students by name
     */
    public Student[] getStudentsByName(String name) {
        int arrSize = 0;
        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getName().equals(name))
                arrSize++;
        }
        Student[] res = new Student[arrSize];
        int currIn = 0;
        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getName().equals(name))
                res[currIn++] = students[i];
        }
        return res;
    }

    /**
     * Get valid course student
     *
     * @return valid course
     */
    private int getValidCourse() {
        int course = DataInput.getInt("Введіть курс студента");
        while (course < 1 || course > 6) {
            System.out.println("Неправильне введення даних");
            course = DataInput.getInt("Введіть курс студента");
        }
        return course;
    }

    /**
     *
     * @return information about new students
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < currentStudent; i++) {
            res.append(i + 1).append(": ").append(students[i]).append("\n");
        }
        return res.toString();
    }

}
