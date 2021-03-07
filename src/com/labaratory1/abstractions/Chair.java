package com.labaratory1.abstractions;

import utils.ConsoleRequest;
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
     *
     * @param chairName
     */
    public Chair(String chairName) {
        this(chairName, 10, 10);
    }

    public String getChairName() {
        return chairName;
    }

    public void setChairName(String chairName) {
        this.chairName = chairName;
    }

    public int getMaximumStudentSize() {
        return maximumStudentSize;
    }

    public void setMaximumStudentSize(int maximumStudentSize) {
        this.maximumStudentSize = maximumStudentSize;
    }

    public int getMaximumLecturerSize() {
        return maximumLecturerSize;
    }

    public void setMaximumLecturerSize(int maximumLecturerSize) {
        this.maximumLecturerSize = maximumLecturerSize;
    }


    public int getCurrentStudents() {
        return students.getCurrentStudent();
    }

    public int getCurrentLecturers() {
        return lectures.getCurrentLecturer();
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
        students.editStudent(ConsoleRequest.getValidIndex(1, students.getCurrentStudent(), "Введіть індекс студента для редагування") - 1);
    }

    /**
     * Delete students
     */
    public void deleteStudent() {
        students.showStudents();
        students.deleteStudent(ConsoleRequest.getValidIndex(1, students.getCurrentStudent(), "Введіть індекс студента для видалення") - 1);
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
        lectures.editLecturer(ConsoleRequest.getValidIndex(1, lectures.getCurrentLecturer(), "Введіть індекс вчителя для редагування") - 1);
    }

    /**
     * Delete lecture
     */
    public void deleteLecturer() {
        lectures.showLecturers();
        lectures.deleteLecturer(ConsoleRequest.getValidIndex(1, lectures.getCurrentLecturer(), "Введіть індекс вчителя для видалення") - 1);
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


    public Student[] getStudents() {
        return students.getStudents();
    }

    public Lecturer[] getLecturers() {
        return lectures.getLecturers();
    }

    /**
     * Get students by course
     *
     * @param course - course
     * @return students by course
     */
    public Student[] getStudentsByCourse(int course) {
        return students.getStudentsByCourse(course);
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
