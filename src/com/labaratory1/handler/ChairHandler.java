package com.labaratory1.handler;

import com.labaratory1.abstractions.*;

public class ChairHandler {
    private Chair[] chairs;
    private int maximumSize;
    private int currentChair;


    public ChairHandler(int maximumSize) {
        this.maximumSize = maximumSize;
        chairs = new Chair[maximumSize];
        currentChair = 0;
    }

    public ChairHandler() {
        this(10);
    }


    public void addStudent(int indexChair) {
        chairs[indexChair].addStudent();
    }

    public void addLecturer(int indexChair) {
        chairs[indexChair].addLecturer();
    }


    public void editLecturer(int indexChair) {
        chairs[indexChair].editLecturer();
    }

    public void editStudent(int indexChair) {
        chairs[indexChair].editStudent();
    }


    public void deleteStudent(int indexChair) {
        chairs[indexChair].deleteStudent();
    }

    public void deleteLecturer(int indexChair) {
        chairs[indexChair].deleteLecturer();
    }


}
