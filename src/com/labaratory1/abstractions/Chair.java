package com.labaratory1.abstractions;

import utils.ConsoleRequest;
import com.labaratory1.handler.*;

/**
 * Chair class
 */
public class Chair {
    /**
     * Chair name
     */
    private String chairName;
    /**
     * Handler Student
     */
    private final StudentHandler students;
    /**
     * Handler Lecture
     */
    private final LecturerHandler lectures;
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
     * @param chairName - name chair
     */
    public Chair(String chairName) {
        this(chairName, 10, 10);
    }

    /**
     * Getter chairName
     *
     * @return chairName
     */
    public String getChairName() {
        return chairName;
    }

    /**
     * Setter chairName
     *
     * @param chairName - chair name
     */
    public void setChairName(String chairName) {
        this.chairName = chairName;
    }

    /**
     * Getter maximumStudentSize
     *
     * @return maximumStudentSize
     */
    public int getMaximumStudentSize() {
        return maximumStudentSize;
    }

    /**
     * Setter maximumStudentSize
     *
     * @param maximumStudentSize - maximumStudentSize
     */
    public void setMaximumStudentSize(int maximumStudentSize) {
        this.maximumStudentSize = maximumStudentSize;
    }

    /**
     * Getter getMaximumLecturerSize
     *
     * @return getMaximumLecturerSize
     */
    public int getMaximumLecturerSize() {
        return maximumLecturerSize;
    }

    /**
     * Setter maximumLecturerSize
     *
     * @param maximumLecturerSize - maximumLecturerSize
     */
    public void setMaximumLecturerSize(int maximumLecturerSize) {
        this.maximumLecturerSize = maximumLecturerSize;
    }

    /**
     * Getter getCurrentStudents
     *
     * @return getCurrentStudents
     */
    public int getCurrentStudents() {
        return students.getCurrentStudent();
    }

    /**
     * Getter getCurrentLecturers
     *
     * @return getCurrentLecturers
     */
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
     * Getter Students
     * @return Student
     */
    public Student[] getStudents() {
        return students.getStudents();
    }

    /**
     * Getter Lecturer
     * @return Lecturer
     */
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
     * Get students by group
     *
     * @param group - group
     * @return students by group
     */
    public Student[] getStudentsByGroup(String group){return students.getStudentsByGroup(group);}

    /**
     * Get students by name
     *
     * @param name - name
     * @return students by name
     */
    public Student[] getStudentsByName(String name){return students.getStudentsByName(name);}

    /**
     * Get students by name
     *
     * @param name - name
     * @return students by name
     */
    public Lecturer[] getLecturersByName(String name){return lectures.getLecturersByName(name);}

    /**
     * Information about chair
     *
     * @return Information about chair
     */
    @Override
    public String toString() {
        String res = "";
        res += "Кафедра - " + chairName;
        return res;
    }
}
