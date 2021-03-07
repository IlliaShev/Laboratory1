package com.labaratory1.handler;

import com.labaratory1.abstractions.*;
import utils.DataInput;

/**
 * ChairHandler class
 */
public class ChairHandler {
    /**
     * chairs
     */
    private Chair[] chairs;
    /**
     * maximumSize
     */
    private int maximumSize;
    /**
     * currentChair
     */
    private int currentChair;

    /**
     * Create ChairHandler
     * @param maximumSize maximumSize
     */
    public ChairHandler(int maximumSize) {
        this.maximumSize = maximumSize;
        chairs = new Chair[maximumSize];
        currentChair = 0;
    }

    /**
     * Getter maximumSize
     * @return getMaximumSize
     */
    public int getMaximumSize() {
        return maximumSize;
    }

    /**
     * Getter getCurrentChair
     * @return getCurrentChair
     */
    public int getCurrentChair() {
        return currentChair;
    }

    /**
     * Create ChairHandler
     */
    public ChairHandler() {
        this(10);
    }

    /**
     * Getter getChair
     * @param indexChair indexChair
     * @return Chair
     */
    public Chair getChair(int indexChair) {
        return chairs[indexChair];
    }

    /**
     * Getter Chair
     *
     * @return Chair
     */
    public Chair[] getChairs() {
        return chairs;
    }

    /**
     * showChairs
     */
    public void showChairs() {
        for (int i = 0; i < currentChair; i++) {
            System.out.println((i + 1) + ". " + chairs[i]);
        }
    }

    /**
     * addChair
     */
    public void addChair() {
        if (currentChair < maximumSize)
            chairs[currentChair++] = buildChair();
        else
            System.out.println("Досягнута максимальна кількість кафедр");
    }

    /**
     * editChair
     * @param indexChair indexChair
     */
    public void editChair(int indexChair) {
        System.out.println(chairs[indexChair]);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1 - Змінити назву кафедри");
            System.out.println("2 - Змінити максимальну кількість студентів");
            System.out.println("3 - Змінити максимальну кількість лекторів");
            System.out.println("4 - Закінчити редагування кафедри");
            choice = DataInput.getInt("Оберіть дію");
            switch (choice) {
                case 1 -> chairs[indexChair].setChairName(getValidNameChair());
                case 2 -> chairs[indexChair].setMaximumStudentSize(getValidMaxStudents());
                case 3 -> chairs[indexChair].setMaximumLecturerSize(getValidLecturers());
                case 4 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    /**
     * deleteChair
     *
     * @param indexChair indexChair
     */
    public void deleteChair(int indexChair) {
        Chair[] newChairs = new Chair[maximumSize];
        System.arraycopy(chairs, 0, newChairs, 0, indexChair);
        System.arraycopy(chairs, indexChair + 1, newChairs, indexChair, maximumSize - indexChair - 1);
        chairs = newChairs;
        currentChair--;
    }

    /**
     * buildChair
     *
     * @return Chair
     */
    private Chair buildChair() {
        String nameChair = getValidNameChair();
        int maxStudents = getValidMaxStudents();
        int maxLecturers = getValidLecturers();
        return new Chair(nameChair, maxStudents, maxLecturers);
    }

    /**
     * getValidLecturers
     *
     * @return maxLecturers
     */
    private int getValidLecturers() {
        int maxLecturers = DataInput.getInt("Введіть максимальну кількість лекторів");
        while (maxLecturers < 1) {
            System.out.println("Неправильне введення даних");
            maxLecturers = DataInput.getInt("Введіть максимальну кількість лекторів");
        }
        return maxLecturers;
    }

    /**
     * getValidMaxStudents
     *
     * @return maxStudents
     */
    private int getValidMaxStudents() {
        int maxStudents = DataInput.getInt("Введіть максимальну кількість студентів");
        while (maxStudents < 1) {
            System.out.println("Неправильне введення даних");
            maxStudents = DataInput.getInt("Введіть максимальну кількість студентів");
        }
        return maxStudents;
    }

    /**
     * getValidNameChair
     * 
     * @return getValidNameChair
     */
    private String getValidNameChair() {
        return DataInput.getString("Введіть ім'я кафедри");
    }


}
