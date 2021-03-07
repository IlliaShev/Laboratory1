package com.labaratory1.abstractions;

/**
 * Student class
 */
public class Student {
    /**
     * Student name
     */
    private String name;
    /**
     * Student course
     */
    private String group;
    /**
     * Student course
     */
    private int course;

    /**
     * Create student
     *
     * @param name   - student name
     * @param course - student course
     * @param group  - student group
     */
    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
    }

    /**
     * Return student name
     *
     * @return student name
     */
    public String getName() {
        return name;
    }

    /**
     * Change student name
     *
     * @param name - new student name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return student group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Change student group
     *
     * @param group - new student group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * @return student course
     */
    public int getCourse() {
        return course;
    }

    /**
     * Change student course
     *
     * @param course - new student course
     */
    public void setCourse(int course) {
        this.course = course;
    }

    /**
     * @return String with info about student (name, group and course)
     */
    @Override
    public String toString() {
        return "Студент: " +
                "Ім'я - " + name + ';' +
                " Група - " + group + ';' +
                " Курс - " + course +
                '.';
    }
}
