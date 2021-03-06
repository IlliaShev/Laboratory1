package com.labaratory1;

import com.labaratory1.abstractions.Chair;
import com.labaratory1.abstractions.Faculty;
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
            if (faculties.getCurrentFaculty() == 0 && choice > 1) {
                System.out.println("Жодного факультету ще не було створено");
                continue;
            }
            switch (choice) {
                case 1 -> workWithFaculty();
                case 2 -> workWithChair();
                case 3 -> {
                    workWithChairSL();
                }
                case 11 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    private static void workWithChairSL() {
        Faculty faculty = getFaculty();
        Chair chair = getChair(faculty);
        int choice = 0;
        while (choice != 3) {
            System.out.println("1 - Робота зі студентами");
            System.out.println("2 - Робота з викладачами");
            System.out.println("3 - Закінчити роботу в даному блоці");
            choice = DataInput.getInt("Оберіть дію");
            switch (choice) {
                case 1 -> workWithStudents();
                case 2 -> workWithLecturers();
                case 3 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    private static void workWithLecturers() {
    }

    private static void workWithStudents() {
    }

    private static void workWithChair() {
        Faculty faculty = getFaculty();
        int choice = 0;
        while (choice != 5) {
            System.out.println("1 - Додати кафедру");
            System.out.println("2 - Редагувати кафедру");
            System.out.println("3 - Видалити кафедру");
            System.out.println("4 - Вивести кафедри факультету");
            System.out.println("5 - Завершити роботу з факультетом");
            choice = DataInput.getInt("Оберіть дію");
            if (faculty.getNumberOfChairs() == 0 && choice > 1) {
                System.out.println("На даний момент жодної кафедри не існує");
                continue;
            }
            switch (choice) {
                case 1 -> faculty.addChair();
                case 2 -> faculty.editChair();
                case 3 -> faculty.deleteChair();
                case 4 -> faculty.showChairs();
                case 5 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    private static Faculty getFaculty() {
        faculties.showFaculty();
        return faculties.getFaculty(ConsoleRequest.getValidIndex(1, faculties.getCurrentFaculty(), "Введіть номер факультету") - 1);
    }

    private static Chair getChair(Faculty faculty) {
        faculty.showChairs();
        return faculty.getChair(ConsoleRequest.getValidIndex(1, faculty.getNumberOfChairs(), "Введіть номер кафедри") - 1);
    }

    private static void workWithFaculty() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("1 - Створити факультет");
            System.out.println("2 - Редагувати факультет");
            System.out.println("3 - Видалити факультет");
            System.out.println("4 - Вивести всі факультети");
            System.out.println("5 - Закінчити роботу з факультетами");
            choice = DataInput.getInt("Оберіть дію");
            if (faculties.getCurrentFaculty() == 0 && choice > 1) {
                System.out.println("На даний момент жодного факультету не існує");
                continue;
            }
            switch (choice) {
                case 1 -> faculties.addFaculty();
                case 2 -> {
                    faculties.showFaculty();
                    faculties.editFaculty(ConsoleRequest.getValidIndex(
                            1, faculties.getCurrentFaculty(), "Введіть номер факультету") - 1);
                }
                case 3 -> {
                    faculties.showFaculty();
                    faculties.deleteFaculty(ConsoleRequest.getValidIndex(
                            1, faculties.getCurrentFaculty(), "Введіть номер факультету") - 1);
                }
                case 4 -> faculties.showFaculty();
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }
}
