package com.labaratory1;

import com.labaratory1.abstractions.Chair;
import com.labaratory1.abstractions.Faculty;
import com.labaratory1.abstractions.Student;
import com.labaratory1.comparators.StudentNameComparator;
import com.labaratory1.handler.FacultiesHandler;
import utils.ConsoleRequest;
import utils.DataInput;
import utils.Quicksort;

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
            if (faculties.getCurrentFaculty() == 0 && choice > 1 && choice < 11) {
                System.out.println("Жодного факультету ще не було створено");
                continue;
            }
            switch (choice) {
                case 1 -> workWithFaculty();
                case 2 -> workWithChair();
                case 3 -> {
                    workWithChairSL();
                }
                case 9 -> getStudentsFromChairByCourse();
                case 10 -> task10();
                case 11 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    private static void task10() {
        Student[] students = getArrStudentsFromChairByCours();
        students = (Student[]) Quicksort.quickSort(students, 0, students.length - 1, new StudentNameComparator());
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void getStudentsFromChairByCourse() {
        Student[] students = getArrStudentsFromChairByCours();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static Student[] getArrStudentsFromChairByCours() {
        Faculty faculty = getFaculty();
        Chair chair = getChair(faculty);
        return chair.getStudentsByCourse(ConsoleRequest.getValidIndex(1, 6, "Введіть курс, студентів якого ви хочете побачити"));
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
                case 1 -> workWithStudents(chair);
                case 2 -> workWithLecturers(chair);
                case 3 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    private static void workWithLecturers(Chair chair) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("1 - Додати лектора до кафедри");
            System.out.println("2 - Редагувати лектора кафедри");
            System.out.println("3 - Видалити лектора кафедри");
            System.out.println("4 - Показати лекторів кафедри");
            System.out.println("5 - Повернутися до меню");
            choice = DataInput.getInt("Оберіть дію");
            if (chair.getCurrentLecturers() == 0 && choice > 1 && choice < 5) {
                System.out.println("На даний момент кафедра не містить жодного вчителя");
                continue;
            }
            switch (choice) {
                case 1 -> chair.addLecturer();
                case 2 -> chair.editLecturer();
                case 3 -> chair.deleteLecturer();
                case 4 -> chair.showLectures();
                case 5 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    private static void workWithStudents(Chair chair) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("1 - Додати cтудента до кафедри");
            System.out.println("2 - Редагувати cтудента кафедри");
            System.out.println("3 - Видалити cтудента кафедри");
            System.out.println("4 - Показати cтудентів кафедри");
            System.out.println("5 - Повернутися до меню");
            choice = DataInput.getInt("Оберіть дію");
            if (chair.getCurrentStudents() == 0 && choice > 1 && choice < 5) {
                System.out.println("На даний момент кафедра не містить жодного студента");
                continue;
            }
            switch (choice) {
                case 1 -> chair.addStudent();
                case 2 -> chair.editStudent();
                case 3 -> chair.deleteStudent();
                case 4 -> chair.showStudents();
                case 5 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
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
            if (faculty.getNumberOfChairs() == 0 && choice > 1 && choice < 5) {
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
            if (faculties.getCurrentFaculty() == 0 && choice > 1 && choice < 5) {
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
