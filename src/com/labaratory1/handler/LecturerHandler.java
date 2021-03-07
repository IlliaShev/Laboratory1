package com.labaratory1.handler;

import utils.ConsoleRequest;
import utils.DataInput;
import com.labaratory1.abstractions.*;

public class LecturerHandler {
    /**
     * Array with lecturers
     */
    private Lecturer[] lecturers;
    /**
     * Index of the last lecturer
     */
    private int currentLecturer;
    /**
     * Maximum size of array
     */
    private int maximumSize;

    /**
     * Create handler for lecturers
     *
     * @param maximumSize - maximum size of the array
     */
    public LecturerHandler(int maximumSize) {
        this.maximumSize = maximumSize;
        lecturers = new Lecturer[maximumSize];
        currentLecturer = 0;
    }

    /**
     * Create default lecturer handler
     */
    public LecturerHandler() {
        this(10);
    }

    /**
     * Get maximum size of the lecturer array
     *
     * @return maximum size
     */
    public int getMaximumSize() {
        return maximumSize;
    }

    /**
     * Get number of current lecture
     *
     * @return current lecture
     */
    public int getCurrentLecturer() {
        return currentLecturer;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    /**
     * Print to the console all the lecturers that was added
     */
    public void showLecturers() {
        for (int i = 0; i < currentLecturer; i++) {
            System.out.println((i + 1) + ": " + lecturers[i]);
        }
    }

    /**
     * Add lecturer to the handler
     *
     * @param lecturer - lecturer
     */
    public void addLecturer(Lecturer lecturer) {
        lecturers[currentLecturer++] = lecturer;
    }

    /**
     * Add lecturer to the handler
     */
    public void addLecturer() {
        if (currentLecturer < maximumSize)
            lecturers[currentLecturer++] = buildLecturer();
        else
            System.out.println("Досягнута максимальна кількість лекторів");
    }

    /**
     * Delete lecturer from the handler
     *
     * @param lecturerIndex - lecturer index
     */
    public void deleteLecturer(int lecturerIndex) {
        Lecturer[] newLecturerTeam = new Lecturer[maximumSize];
        System.arraycopy(lecturers, 0, newLecturerTeam, 0, lecturerIndex);
        System.arraycopy(lecturers, lecturerIndex + 1, newLecturerTeam, lecturerIndex, maximumSize - lecturerIndex - 1);
        lecturers = newLecturerTeam;
        currentLecturer--;
    }

    /**
     * Edit lecturer
     *
     * @param lecturerIndex - lecturer index
     */
    public void editLecturer(int lecturerIndex) {
        System.out.println("Викладач: " + lecturers[lecturerIndex]);
        if (ConsoleRequest.askUserTF("Бажаєте змінити ім'я викладача?")) {
            lecturers[lecturerIndex].setName(getValidName());
        }
        if (ConsoleRequest.askUserTF("Бажаєете змінити вік викладача?")) {
            lecturers[lecturerIndex].setAge(getValidAge());
        }
        if (ConsoleRequest.askUserTF("Бажаете редагувати курси викладача?")) {
            int choice = 0;
            while (choice != 5) {
                System.out.println("1 - Додати новий курс");
                System.out.println("2 - Редагувати існуючий курс");
                System.out.println("3 - Видалити курс");
                System.out.println("4 - Вивести список курсів");
                System.out.println("5 - Закінчити редагувати курси");
                choice = DataInput.getInt("Оберіть дію");
                switch (choice) {
                    case 1 -> lecturers[lecturerIndex].addDiscipline();
                    case 2 -> lecturers[lecturerIndex].editDiscipline();
                    case 3 -> lecturers[lecturerIndex].deleteDiscipline();
                    case 4 -> lecturers[lecturerIndex].showDisciplines();
                    case 5 -> {
                    }
                    default -> System.out.println("Неправильне введення даних");
                }
            }
        }
    }

    /**
     * Create new lecturer
     */
    private Lecturer buildLecturer() {
        String name = getValidName();
        int age = getValidAge();
        int maxDisciplines = getValidMaximumDisciplines();
        return new Lecturer(name, age, maxDisciplines);
    }

    /**
     * Get valid value of the maximum quantity of the disciplines
     *
     * @return maximum quantity of the disciplines
     */
    private int getValidMaximumDisciplines() {
        int maxDisciplines;
        while (true) {
            maxDisciplines = DataInput.getInt("Введіть максимальну кількість курсів яку може вести викладач");
            if (maxDisciplines < 1 || maxDisciplines > 5) {
                System.out.println("Неправильне введення даних");
            } else
                break;
        }
        return maxDisciplines;
    }

    /**
     * Get valid age
     *
     * @return valid age
     */
    private int getValidAge() {
        int age;
        while (true) {
            age = DataInput.getInt("Введіть вік викладача");
            if (age < 20 || age > 100) {
                System.out.println("Неправильне введення даних");
            } else {
                break;
            }
        }
        return age;
    }

    /**
     * Get valid name
     *
     * @return valid name
     */
    private String getValidName() {
        return DataInput.getString("Введіть ім'я викладача");
    }

    /**
     *
     * @return information about new lecture
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < currentLecturer; i++) {
            res.append(i + 1).append(": ").append(lecturers[i]).append("\n");
        }
        return res.toString();
    }
}
