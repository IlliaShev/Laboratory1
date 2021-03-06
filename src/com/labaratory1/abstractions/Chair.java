package com.labaratory1.abstractions;

import utils.ConsoleRequest;
import utils.DataInput;
import com.labaratory1.handler.*;

public class Chair {
    /**
     * Chair name
     */
    private String chairName;
    /**
     * Handler Student
     */
    private StudentHandler students;
    /**
     * Handler Lecture
     */
    private LecturerHandler lectures;
    /**
     * Number of student size
     */
    private int maximumStudentSize;
    /**
     * Number of lecture size
     */
    private int maximumLecturerSize;


    /**
     * Create chair
     * @param chairName - chair name
     * @param maximumStudentSize - Number of student size
     * @param maximumLecturerSize -  Number of lecture size
     */
    public Chair(String chairName, int maximumStudentSize, int maximumLecturerSize) {
        this.chairName = chairName;
        students = new StudentHandler(maximumStudentSize);
        lectures = new LecturerHandler(maximumLecturerSize);
    }

    /**
     * Create chair
     * @param chairName
     */
    public Chair(String chairName) {
        this(chairName, 10, 10);
    }

    /**
     * Add students
     */
    public void addStudent() {
        students.addStudent();
    }

    /**
     * Edit students
     */
    public void editStudent() {
        students.showStudents();
        students.editStudent(ConsoleRequest.getValidIndex(1, students.getCurrentStudent()-1, "Введіть індекс студента для редагування") - 1);
    }

    /**
     * Delete students
     */
    public void deleteStudent() {
        students.showStudents();
        students.deleteStudent(ConsoleRequest.getValidIndex(1, students.getCurrentStudent()-1, "Введіть індекс студента для видалення") - 1);
    }

    /**
     * Add lecture
     */
    public void addLecturer() {
        lectures.addLecturer();
    }

    /**
     * Edit lecture
     */
    public void editLecturer() {
        lectures.showLecturers();
        lectures.editLecturer(ConsoleRequest.getValidIndex(1, maximumLecturerSize, "Введіть індекс вчителя для редагування") - 1);
    }

    /**
     * Delete lecture
     */
    public void deleteLecturer() {
        lectures.showLecturers();
        lectures.deleteLecturer(ConsoleRequest.getValidIndex(1, maximumLecturerSize, "Введіть індекс вчителя для видалення") - 1);
    }

    /**
     * Checkable correct
     * @param leftBorder
     * @param rightBorder
     * @param text
     * @return
     */


    /**
     * Show students
     */
    public void showStudents() {
        students.showStudents();
    }
    /**
     * Show lecture
     */
    public void showLectures() {
        lectures.showLecturers();
    }

    /**
     * Get students by course
     * @param course - course
     * @return students by course
     */
    public String getStudentsByCourse(int course) {
        StringBuilder res = new StringBuilder();
        for (Student student : students.getStudentsByCourse(course)) {
            res.append(student).append("\n");
        }
        return res.toString();
    }

    /**
     * Information about chair
     *
     * @return
     */
    @Override
    public String toString() {
        String res = "";
        res += "Кафедра - " + chairName;
        return res;
    }
}
