package com.labaratory1.abstractions;

import com.labaratory1.handler.*;
import utils.ConsoleRequest;

public class Faculty {

    /**
     * Faculty name
     */
    private String name;
    private ChairHandler chairs;


    /**
     * Create faculty
     * @param name - faculty name
     */
    public Faculty(String name){
        this.name = name;
        chairs = new ChairHandler();
    }

    /**
     * Return faculty name
     *
     * @return faculty name
     */
    public String getName() {
        return name;
    }

    public Chair getChair(int indexChair) {
        return chairs.getChair(indexChair);
    }

    /**
     * Change faculty name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Edit students
     */
    public void editChair() {
        chairs.showChairs();
        chairs.editChair(ConsoleRequest.getValidIndex(1, chairs.getCurrentChair(), "Введіть індекс кафедри для редагування") - 1);


    }

    public int getNumberOfChairs() {
        return chairs.getCurrentChair();
    }

    /**
     * Add students
     */
    public void addChair() {
        chairs.addChair();
    }

    /**
     * Delete students
     */
    public void deleteChair() {
        chairs.showChairs();
        chairs.deleteChair(ConsoleRequest.getValidIndex(1, chairs.getCurrentChair(), "Введіть індекс кафедри для видалення") - 1);

    }

    public void showChairs() {
        chairs.showChairs();
    }

    /**
     * Information about faculty
     *
     * @return
     */
    @Override
    public String toString() {
        return "Факультет: " +
                "Назва - " + name;
    }
}
