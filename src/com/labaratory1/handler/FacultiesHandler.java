package com.labaratory1.handler;

import utils.ConsoleRequest;
import utils.DataInput;
import com.labaratory1.abstractions.*;

public class FacultiesHandler {
    /**
     * Array with faculties
     */
    private Faculty[] faculties;
    /**
     * Maximum size of array
     */
    private int maximumSize;
    /**
     * Index of the last faculties
     */
    private int currentFaculty;

    /**
     * Create handler for faculties
     *
     * @param maximumSize - maximum size of the array
     */
    public FacultiesHandler(int maximumSize) {
        this.maximumSize = maximumSize;
        faculties = new Faculty[maximumSize];
    }

    /**
     * Create default faculties handler
     */
    public FacultiesHandler(){ this(10);}

    /**
     * Get maximum size of the faculties array
     *
     * @return maximum size
     */
    public int getMaximumSize() {
        return maximumSize;
    }

    /**
     * Get number of current faculty
     *
     * @return current faculty
     */
    public int getCurrentFaculty() { return currentFaculty; }

    /**
     * Print to the console all the faculty that was added
     */
    public void showFaculty() {
        for (int i = 0; i < currentFaculty; i++) {
            System.out.println((i + 1) + ": " + faculties[i]);
        }
    }

    public Faculty getFaculty(int facultyIndex) {
        return faculties[facultyIndex];
    }

    /**
     * Add faculty to the handler
     *
     * @param faculty - faculty
     */
    public void addFaculty(Faculty faculty) {
        faculties[currentFaculty++] = faculty;
    }

    /**
     * Add faculty to the handler
     */
    public void addFaculty() {
        if (currentFaculty < maximumSize)
            faculties[currentFaculty++] = buildFaculty();
        else
            System.out.println("Досягнута максимальна кількість факультетів");
    }

    /**
     * Delete faculties from the handler
     *
     * @param facultiesIndex - faculty index
     */
    public void deleteFaculty(int facultiesIndex) {
        Faculty[] newFacultyTeam = new Faculty[maximumSize];
        System.arraycopy(faculties, 0, newFacultyTeam, 0, facultiesIndex);
        System.arraycopy(faculties, facultiesIndex + 1, newFacultyTeam, facultiesIndex, maximumSize - facultiesIndex - 1);
        faculties = newFacultyTeam;
        currentFaculty--;
    }


    /**
     * Edit faculty
     *
     * @param facultyIndex - faculty index
     */
    public void editFaculty(int facultyIndex) {
        System.out.println("Факультет: " + faculties[facultyIndex]);
        int choice = 0;
        while (choice != 2) {
            System.out.println("1 - Змінити назву факультету");
            System.out.println("2 - Закінчити редагування факультету");
            choice = DataInput.getInt("Оберіть дію");
            switch (choice) {
                case 1 -> faculties[facultyIndex].setName(getValidName());
                case 2 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    /**
     * Create new faculty
     */
    private Faculty buildFaculty() {
        String name = getValidName();
        return new Faculty(name);
    }

    /**
     * Get valid name faculty
     *
     * @return valid name
     */
    private String getValidName() {
        return DataInput.getString("Введіть назву факультету");
    }

    /**
     *
     * @return information about new faculty
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < currentFaculty; i++) {
            res.append(i + 1).append(": ").append(faculties[i]).append("\n");
        }
        return res.toString();
    }
}
