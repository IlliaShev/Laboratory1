package com.labaratory1;

import com.labaratory1.handler.FacultiesHandler;
import utils.ConsoleRequest;
import utils.DataInput;

public class Tester {
    private static FacultiesHandler faculties = new FacultiesHandler();

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 11) {
            System.out.println("1 - Створити/видалити/редагувати факультет");
            System.out.println("2 - Створити/видалити/редагувати кафедру факультета");
            System.out.println("3 - Додати/видалити/редагувати студента/викладача до кафедри");
            System.out.println("4 - Знайти студента/викладача за ПІБ, курсом або групою");
            System.out.println("5 - Вивести всіх студентів впорядкованих за курсами");
            System.out.println("6 - Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом");
            System.out.println("7 - Вивести всіх студентів кафедри впорядкованих за курсами");
            System.out.println("8 - Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом");
            System.out.println("9 - Вивести всіх студентів кафедри вказаного курсу");
            System.out.println("10 - Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом");
            System.out.println("11 - Завершити роботу з програмою");
            choice = DataInput.getInt("Оберіть дію");
            switch (choice) {
                case 1 -> workWithFaculty();
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    private static void workWithFaculty() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("1 - Створити факультет");
            System.out.println("2 - Редагувати факультет");
            System.out.println("3 - Видалити факультет");
            System.out.println("4 - Закінчити роботу з факультетами");
            choice = DataInput.getInt("Оберіть дію");
            switch (choice) {
                case 1 -> faculties.addFaculty();
                case 2 -> {
                    if (faculties.getCurrentFaculty() == 0) {
                        System.out.println("Жодного факультету ще не було створено");
                    } else {
                        faculties.showFaculty();
                        faculties.editFaculty(ConsoleRequest.getValidIndex(
                                1, faculties.getCurrentFaculty(), "Введіть номер факультету") - 1);
                    }
                }
                case 3 -> {
                    faculties.showFaculty();
                    faculties.deleteFaculty(ConsoleRequest.getValidIndex(
                            1, faculties.getCurrentFaculty(), "Введіть номер факультету") - 1);
                }
                case 4 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }
}
