package com.labaratory1.handler;

import com.labaratory1.abstractions.*;
import utils.DataInput;

public class ChairHandler {
    private Chair[] chairs;
    private int maximumSize;
    private int currentChair;


    public ChairHandler(int maximumSize) {
        this.maximumSize = maximumSize;
        chairs = new Chair[maximumSize];
        currentChair = 0;
    }

    public int getMaximumSize() { return maximumSize; }

    public int getCurrentChair() { return currentChair; }

    public ChairHandler() {
        this(10);
    }

    public void showChairs() {
        for (int i = 0; i < currentChair; i++) {
            System.out.println((i + 1) + ". " + chairs[i]);
        }
    }


    public void addChair() {
        if (currentChair < maximumSize)
            chairs[currentChair++] = buildChair();
        else
            System.out.println("Досягнута максимальна кількість кафедр");
    }


    public void editChair(int indexChair) {

    }

    public void deleteChair(int indexChair) {

    }

    private Chair buildChair() {
        String nameChair = getValidNameChair();
        int maxStudents = getValidMaxStudents();
        int maxLecturers = getValidLecturers();
        return new Chair(nameChair, maxStudents, maxLecturers);
    }

    private int getValidLecturers() {
        int maxLecturers = DataInput.getInt("Введіть максимальну кількість лекторів");
        while (maxLecturers < 1) {
            System.out.println("Неправильне введення даних");
            maxLecturers = DataInput.getInt("Введіть максимальну кількість лекторів");
        }
        return maxLecturers;
    }

    private int getValidMaxStudents() {
        int maxStudents = DataInput.getInt("Введіть максимальну кількість студентів");
        while (maxStudents < 1) {
            System.out.println("Неправильне введення даних");
            maxStudents = DataInput.getInt("Введіть максимальну кількість студентів");
        }
        return maxStudents;
    }

    private String getValidNameChair() {
        return DataInput.getString("Введіть ім'я кафедри");
    }


}
