package com.labaratory1.handler;

import utils.ConsoleRequest;
import utils.DataInput;
import com.labaratory1.abstractions.*;

public class DisciplineHandler {
    /**
     * Array for storing disciplines
     */
    private Discipline[] disciplines;

    /**
     * Index of the last added discipline
     */
    private int currentDiscipline;
    /**
     * Maximum size of the array with disciplines
     */
    private int maxDisciplines;

    public DisciplineHandler(int maxDisciplines) {
        this.maxDisciplines = maxDisciplines;
        disciplines = new Discipline[maxDisciplines];
        currentDiscipline = 0;
    }

    public DisciplineHandler() {
        this(5);
    }

    /**
     * Get size of discipline array
     *
     * @return maximum size of discipline array
     */
    public int getMaxDisciplines() {
        return maxDisciplines;
    }

    /**
     * Add discipline to the Array
     */
    public void addDiscipline() {
        if (currentDiscipline < maxDisciplines)
            disciplines[currentDiscipline++] = buildDiscipline();
        else
            System.out.println("Досягнута максимальна кількість дисциплін, які може вести викладач");
    }

    /**
     * Add discipline to the Array
     *
     * @param discipline - discipline
     */
    public void addDiscipline(Discipline discipline) {
        if (currentDiscipline < maxDisciplines)
            disciplines[currentDiscipline++] = discipline;
        else
            System.out.println("Досягнута максимальна кількість дисциплін, які може вести викладач");
    }

    /**
     * Print all the disciplines to the console
     */
    public void showAllDisciplines() {
        for (int i = 0; i < currentDiscipline; i++) {
            System.out.println((i + 1) + ": " + disciplines[i]);
        }
    }

    /**
     * Delete discipline in the specific index
     *
     * @param indexOfDiscipline - index of the discipline to delete
     */
    public void deleteDiscipline(int indexOfDiscipline) {
        Discipline[] newDisciplines = new Discipline[maxDisciplines];
        System.arraycopy(disciplines, 0, newDisciplines, 0, indexOfDiscipline);
        System.arraycopy(disciplines, indexOfDiscipline + 1, newDisciplines, indexOfDiscipline, maxDisciplines - indexOfDiscipline - 1);
        disciplines = newDisciplines;
        currentDiscipline--;
    }

    /**
     * Delete discipline in the specific index
     *
     * @param indexOfDiscipline - index of the discipline
     */
    public void editDiscipline(int indexOfDiscipline) {
        if (ConsoleRequest.askUserTF("Бажаєте змінити назву дисципліни?")) {
            disciplines[indexOfDiscipline].setName(getValidName());
        }
        if (ConsoleRequest.askUserTF("Бажаєте змінити кількість кредитів за курс?")) {
            disciplines[indexOfDiscipline].setCredits(getValidCredits());
        }
        if (ConsoleRequest.askUserTF("Бажаєте змінити кількість годин за курс?")) {
            disciplines[indexOfDiscipline].setHours(getValidHours());
        }
        System.out.println("Відредагований курс:");
        System.out.println(disciplines[indexOfDiscipline]);
    }

    /**
     * Get discipline in a specific index
     *
     * @param indexOfDiscipline - index of the discipline you want to get
     * @return discipline in that index
     */
    public Discipline getDiscipline(int indexOfDiscipline) {
        return disciplines[indexOfDiscipline];
    }

    /**
     * Print to the console discipline in a specific index
     *
     * @param indexOfDiscipline - index of the discipline you want to see
     */
    public void showDiscipline(int indexOfDiscipline) {
        System.out.println(disciplines[indexOfDiscipline]);
    }


    /**
     * Create new discipline
     *
     * @return new created discipline
     */
    private Discipline buildDiscipline() {
        String name = getValidName();
        double credits = getValidCredits();
        double hours = getValidHours();
        return new Discipline(name, credits, hours);
    }

    /**
     * Get valid name of the discipline
     *
     * @return valid name
     */
    private String getValidName() {
        return DataInput.getString("Введіть назву дісципліни");
    }

    /**
     * Get valid hours for the discipline
     *
     * @return valid value of hours
     */
    private double getValidHours() {
        double hours;
        while (true) {
            hours = DataInput.getDouble("Введіть кількість годин на тиждень за курс");
            if (hours >= 1 && hours <= 8)
                break;
            System.out.println("Неправильне введення даних");
        }
        return hours;
    }

    /**
     * Get valid credits for the discipline
     *
     * @return valid value of credits
     */
    private double getValidCredits() {
        double credits;
        while (true) {
            credits = DataInput.getDouble("Введіть кількість кредитів за цей курс");
            if (credits >= 2 && credits <= 6)
                break;
            System.out.println("Неправильне введення даних");
        }
        return credits;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < currentDiscipline; i++) {
            res.append(i + 1).append(": ").append(disciplines[i]).append("\n");
        }
        return res.toString();
    }
}
