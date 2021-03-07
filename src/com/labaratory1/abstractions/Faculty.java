package com.labaratory1.abstractions;

import com.labaratory1.handler.*;
import utils.ConsoleRequest;

/**
 * Faculty class
 */
public class Faculty {

    /**
     * Faculty name
     */
    private String name;
    /**
     * ChairHandler
     */
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

    /**
     * Return indexChair
     *
     * @param indexChair indexChair
     * @return indexChair
     */
    public Chair getChair(int indexChair) {
        return chairs.getChair(indexChair);
    }

    /**
     * Getter Chairs
     *
     * @return arr chair
     */
    public Chair[] getChairs() {
        return chairs.getChairs();
    }

    /**
     * Change faculty name
     *
     * @param name faculty name
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

    /**
     * Getter CurrentChair
     *
     * @return CurrentChair
     */
    public int getNumberOfChairs() {
        return chairs.getCurrentChair();
    }

    /**
     * Add students
     */
    public void addChair() {
        chairs.addChair();
    }

    public void addChair(Chair chair) {
        chairs.addChair(chair);
    }

    /**
     * Delete students
     */
    public void deleteChair() {
        chairs.showChairs();
        chairs.deleteChair(ConsoleRequest.getValidIndex(1, chairs.getCurrentChair(), "Введіть індекс кафедри для видалення") - 1);

    }

    /**
     * showChairs
     */
    public void showChairs() {
        chairs.showChairs();
    }

    @Override
    public String toString() {
        return "Факультет: " +
                "Назва - " + name;
    }
}
