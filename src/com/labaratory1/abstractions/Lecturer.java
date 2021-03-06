package com.labaratory1.abstractions;

import utils.DataInput;
import com.labaratory1.handler.*;

public class Lecturer {
    /**
     * Lecturer name
     */
    public String name;
    /**
     * Lecturer age
     */
    public int age;

    /**
     * Lecturer`s disciplines
     */
    public DisciplineHandler disciplines;

    /**
     * Create new lecturer
     *
     * @param name               - lecturer name
     * @param age                - lecturer age
     * @param maximumDisciplines - maximum quantity of disciplines
     */
    public Lecturer(String name, int age, int maximumDisciplines) {
        this.name = name;
        this.age = age;
        disciplines = new DisciplineHandler(maximumDisciplines);
    }

    /**
     * Get lecturer name
     *
     * @return lecturer name
     */
    public String getName() {
        return name;
    }

    /**
     * Set new name to the lecturer
     *
     * @param name - new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get lecturer age
     *
     * @return lecturer age
     */
    public int getAge() {
        return age;
    }


    /**
     * Set new age to the lecturer
     *
     * @param age - new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Add discipline
     */
    public void addDiscipline() {
        disciplines.addDiscipline();
    }

    /**
     * Delete discipline
     */
    public void deleteDiscipline() {
        showDisciplines();
        disciplines.deleteDiscipline(getValidDisciplineIndex());
    }

    /**
     * Edit discipline
     */
    public void editDiscipline() {
        showDisciplines();
        disciplines.editDiscipline(getValidDisciplineIndex());
    }

    private int getValidDisciplineIndex() {
        int choice;
        while (true) {
            choice = DataInput.getInt("Введіть індех дісципліни");
            if (choice < 0 || choice >= disciplines.getMaxDisciplines() || disciplines.getDiscipline(choice) == null) {
                System.out.println("Ви ввели ніснуючи дісципліну");
            } else
                break;
        }
        return choice;
    }

    /**
     * Show all lecturer`s disciplines
     */
    public void showDisciplines() {
        disciplines.showAllDisciplines();
    }


    /**
     * Get info about the lecturer
     *
     * @return String - info
     */
    @Override
    public String toString() {
        return "Викладач: " +
                "Ім'я - " + name + ';' +
                "Вік - " + age + ';';
    }
}
