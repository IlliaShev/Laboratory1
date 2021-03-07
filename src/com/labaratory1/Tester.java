package com.labaratory1;

import com.labaratory1.abstractions.Chair;
import com.labaratory1.abstractions.Faculty;
import com.labaratory1.abstractions.Lecturer;
import com.labaratory1.abstractions.Student;
import com.labaratory1.comparators.LecturerNameComparator;
import com.labaratory1.comparators.StudentCourseComparator;
import com.labaratory1.comparators.StudentNameComparator;
import com.labaratory1.handler.FacultiesHandler;
import utils.ConsoleRequest;
import utils.DataInput;
import utils.Quicksort;

import java.util.ArrayList;

/**
 * Tester class
 */
public class Tester {
    /**
     * Init faculty
     */
    private static FacultiesHandler faculties = new FacultiesHandler();


    private static void initialAdding() {
        faculties.addFaculty(new Faculty("ФСНСТ"));
        Faculty facultyFirst = faculties.getFaculty(0);

        Chair firstChair = new Chair("Кафедра психології", 100, 10);
        Chair secondChair = new Chair("Кафедра соціології", 50, 8);
        facultyFirst.addChair(firstChair);
        facultyFirst.addChair(secondChair);

        Chair thirdChair = new Chair("Кафедра математики", 100, 10);
        Chair fourthChair = new Chair("Кафедра мультимедії", 50, 8);
        Faculty facultySecond = faculties.getFaculty(1);
        faculties.addFaculty(new Faculty("ФІ"));
        facultySecond.addChair(thirdChair);
        facultySecond.addChair(fourthChair);

        //students first chair first faculty
        firstChair.addStudent(new Student("Шевчик", "ФСНСТПСИХ1", 1));
        firstChair.addStudent(new Student("Мельник", "ФСНСТПСИХ2", 2));
        firstChair.addStudent(new Student("Шевчук", "ФСНСТПСИХ4", 4));
        firstChair.addStudent(new Student("Мороз", "ФСНСТПСИХ2", 2));
        firstChair.addStudent(new Student("Ткачук", "ФСНСТПСИХ3", 3));
        firstChair.addStudent(new Student("Бойко", "ФСНСТПСИХ2", 2));
        firstChair.addStudent(new Student("Кравчук", "ФСНСТПСИХ1", 1));
        firstChair.addStudent(new Student("Швець", "ФСНСТПСИХ6", 6));
        firstChair.addStudent(new Student("Гаврилюк", "ФСНСТПСИХ2", 2));
        firstChair.addStudent(new Student("Коломієць", "ФСНСТПСИХ3", 3));

        //students firstI chair second faculty
        thirdChair.addStudent(new Student("Шевчик", "ФІACД1", 1));
        thirdChair.addStudent(new Student("Мельник", "ФІACД2", 2));
        thirdChair.addStudent(new Student("Шевчук", "ФІACД4", 4));
        thirdChair.addStudent(new Student("Мороз", "ФІACД2", 2));
        thirdChair.addStudent(new Student("Ткачук", "ФІACД3", 3));
        thirdChair.addStudent(new Student("Бойко", "ФІACД2", 2));
        thirdChair.addStudent(new Student("Кравчук", "ФІACД1", 1));
        thirdChair.addStudent(new Student("Швець", "ФІACД6", 6));
        thirdChair.addStudent(new Student("Гаврилюк", "ФІACД2", 2));
        thirdChair.addStudent(new Student("Коломієць", "ФІACД3", 3));

        //lecturers first chair first faculty
        firstChair.addLecturer(new Lecturer("Попович", 45, 3));
        firstChair.addLecturer(new Lecturer("Марчук", 52, 5));
        firstChair.addLecturer(new Lecturer("Тищенко", 33, 2));
        firstChair.addLecturer(new Lecturer("Вовк", 39, 1));
        firstChair.addLecturer(new Lecturer("Білоус", 48, 3));
        firstChair.addLecturer(new Lecturer("Шевченко", 61, 2));
        firstChair.addLecturer(new Lecturer("Жорнік", 21, 1));
        firstChair.addLecturer(new Lecturer("Нестеренко", 29, 2));
        firstChair.addLecturer(new Lecturer("Макаренко", 36, 3));

        //lecturers firstI chair first faculty
        thirdChair.addLecturer(new Lecturer("Попович", 45, 3));
        thirdChair.addLecturer(new Lecturer("Марчук", 52, 5));
        thirdChair.addLecturer(new Lecturer("Тищенко", 33, 2));
        thirdChair.addLecturer(new Lecturer("Вовк", 39, 1));
        thirdChair.addLecturer(new Lecturer("Білоус", 48, 3));
        thirdChair.addLecturer(new Lecturer("Шевченко", 61, 2));
        thirdChair.addLecturer(new Lecturer("Жорнік", 21, 1));
        thirdChair.addLecturer(new Lecturer("Нестеренко", 29, 2));
        thirdChair.addLecturer(new Lecturer("Макаренко", 36, 3));

        //students second chair first faculty
        secondChair.addStudent(new Student("Романюк", "ФСНСТСОЦ1", 1));
        secondChair.addStudent(new Student("Мазур", "ФСНСТСОЦ1", 3));
        secondChair.addStudent(new Student("Кушнір", "ФСНСТСОЦ1", 2));
        secondChair.addStudent(new Student("Кірічок", "ФСНСТСОЦ1", 2));
        secondChair.addStudent(new Student("Сидорчук", "ФСНСТСОЦ1", 4));
        secondChair.addStudent(new Student("Павленко", "ФСНСТСОЦ1", 2));
        secondChair.addStudent(new Student("Фольга", "ФСНСТСОЦ1", 3));
        secondChair.addStudent(new Student("Савчук", "ФСНСТСОЦ1", 2));
        secondChair.addStudent(new Student("Дядюк", "ФСНСТСОЦ1", 4));
        secondChair.addStudent(new Student("Фомюк", "ФСНСТСОЦ1", 1));

        //students secondI chair second faculty
        fourthChair.addStudent(new Student("Романюк", "ФІММОЗ1", 1));
        fourthChair.addStudent(new Student("Мазур", "ФІММОЗ3", 3));
        fourthChair.addStudent(new Student("Кушнір", "ФІММОЗ2", 2));
        fourthChair.addStudent(new Student("Кірічок", "ФІММОЗ2", 2));
        fourthChair.addStudent(new Student("Сидорчук", "ФІММОЗ4", 4));
        fourthChair.addStudent(new Student("Павленко", "ФІММОЗ2", 2));
        fourthChair.addStudent(new Student("Фольга", "ФІММОЗ3", 3));
        fourthChair.addStudent(new Student("Савчук", "ФІММОЗ2", 2));
        fourthChair.addStudent(new Student("Дядюк", "ФІММОЗ4", 4));
        fourthChair.addStudent(new Student("Фомюк", "ФІММОЗ1", 1));

        //lecturers second chair first faculty
        secondChair.addLecturer(new Lecturer("Бабенко", 45, 2));
        secondChair.addLecturer(new Lecturer("Терещенко", 51, 1));
        secondChair.addLecturer(new Lecturer("Жмаков", 25, 1));
        secondChair.addLecturer(new Lecturer("Юрченко", 35, 2));
        secondChair.addLecturer(new Lecturer("Городович", 46, 4));
        secondChair.addLecturer(new Lecturer("Бабій", 48, 2));
        secondChair.addLecturer(new Lecturer("Москаленко", 61, 2));
        secondChair.addLecturer(new Lecturer("Молотобоєць", 44, 3));

        //lecturers second chair first faculty
        fourthChair.addLecturer(new Lecturer("Бабенко", 45, 2));
        fourthChair.addLecturer(new Lecturer("Терещенко", 51, 1));
        fourthChair.addLecturer(new Lecturer("Жмаков", 25, 1));
        fourthChair.addLecturer(new Lecturer("Юрченко", 35, 2));
        fourthChair.addLecturer(new Lecturer("Городович", 46, 4));
        fourthChair.addLecturer(new Lecturer("Бабій", 48, 2));
        fourthChair.addLecturer(new Lecturer("Москаленко", 61, 2));
        fourthChair.addLecturer(new Lecturer("Молотобоєць", 44, 3));
    }


    /**
     * Start program
     *
     * @param args string
     */
    public static void main(String[] args) {
        initialAdding();
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
                case 3 -> workWithChairSL();
                case 4 -> task4();
                case 5 -> task5();
                case 6 -> task6();
                case 7 -> task7();
                case 8 -> task8();
                case 9 -> getStudentsFromChairByCourse();
                case 10 -> task10();
                case 11 -> { }
                default -> System.out.println("Неправильне введення даних");
            }
        }
        System.out.println("Дякуємо, виконали Шевчик Ілля та Джос Олексій");
    }

    /**
     * task4
     * Find a student / teacher by name, course or group
     */
    private static void task4() {
        int choicePerson = 0;
        while(choicePerson != 3){
            System.out.println("1 - Робота зі студентами");
            System.out.println("2 - Робота з викладачами");
            System.out.println("3 - Закінчити роботу в даному блоці");
            choicePerson = DataInput.getInt("Оберіть");
            switch(choicePerson){
                case 1 -> searchByStudent();
                case 2 -> searchByLecture();
                case 3 -> { }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    /**
     * Search by Student
     */
    private static void searchByStudent() {
        int choice = 0;
        while(choice != 4){
            System.out.println("1 - Шукати студента по ПІБ");
            System.out.println("2 - Шукати студента по групі");
            System.out.println("3 - Шукати студента по курсу");
            System.out.println("4 - Закінчити роботу в даному блоці");
            choice = DataInput.getInt("Оберіть дію");
            switch(choice){
                case 1 -> searchByStudentName();
                case 2 -> searchByStudentGroup();
                case 3 -> searchByStudentCourse();
                case 4 -> {}
                default -> System.out.println("Неправильне введення даних");
            }
        }

    }

    /**
     * Search by Student use course
     */
    private static void searchByStudentCourse() {
        getStudentsFromChairByCourse();
    }

    /**
     * Search by Student use group
     */
    private static void searchByStudentGroup() {
        Faculty faculty = getFaculty();
        Chair chair = getChair(faculty);
        String group = DataInput.getString("Введіть групу, студентів яких ви хочете побачити");
        Student[] students = chair.getStudentsByGroup(group);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Search by Student use name
     */
    private static void searchByStudentName() {
        String name = DataInput.getString("Введіть прізвище студентів яких ви хочете побачити");
        Faculty[] facults = faculties.getFaculties();
        for (Faculty faculty : facults) {
            if (faculty == null)
                break;
            Chair[] chairs = faculty.getChairs();
            for (Chair chair : chairs) {
                if (chair == null)
                    break;
                Student[] students = chair.getStudents();
                for (Student student : students) {
                    if (student == null)
                        break;
                    if (student.getName().equals(name))
                        System.out.println(student);
                }
            }
        }
    }

    /**
     * Search by Lecture
     */
    private static void searchByLecture() {
        int choice = 0;
        while (choice != 2) {
            System.out.println("1 - Шукати викладача по ПІБ");
            System.out.println("2 - Закінчити роботу в даному блоці");
            choice = DataInput.getInt("Оберіть дію");
            switch (choice) {
                case 1 -> searchByLectureName();
                case 2 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }

    }

    /**
     * Search by Lecture use name
     */
    private static void searchByLectureName() {
        Faculty faculty = getFaculty();
        Chair chair = getChair(faculty);
        String name = DataInput.getString("Введіть прізвище, викладачів яких ви хочете побачити");
        Lecturer[] lecturers = chair.getLecturersByName(name);
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer);
        }
    }

    /**
     * Task5
     * Get all students in order for the courses.
     */
    private static void task5() {
        Faculty[] facults = faculties.getFaculties();
        Student[] students = new Student[0];
        for (Faculty faculty : facults) {
            if (faculty == null)
                continue;
            Chair[] chairs = faculty.getChairs();
            for (Chair chair : chairs) {
                if (chair == null)
                    continue;
                Student[] buffStudents = new Student[students.length + chair.getStudents().length];
                System.arraycopy(students, 0, buffStudents, 0, students.length);
                System.arraycopy(chair.getStudents(), 0, buffStudents, students.length, chair.getStudents().length);
                students = buffStudents;
            }
        }
        students = (Student[]) Quicksort.quickSort(students, 0, students.length - 1, new StudentCourseComparator());
        printArray(students);
    }

    /**
     * Task 6
     * List all students / faculty members in alphabetical order
     */
    private static void task6() {
        Faculty faculty = getFaculty();
        Chair[] chairs = faculty.getChairs();
        Lecturer[] lecturers = new Lecturer[0];
        Student[] students = new Student[0];
        for (Chair chair : chairs) {
            if (chair == null)
                continue;
            Lecturer[] buffLecturers = new Lecturer[lecturers.length + chair.getLecturers().length];
            System.arraycopy(lecturers, 0, buffLecturers, 0, lecturers.length);
            System.arraycopy(chair.getLecturers(), 0, buffLecturers, lecturers.length, chair.getLecturers().length);
            lecturers = buffLecturers;
            Student[] buffStudents = new Student[students.length + chair.getStudents().length];
            System.arraycopy(students, 0, buffStudents, 0, students.length);
            System.arraycopy(chair.getStudents(), 0, buffStudents, students.length, chair.getStudents().length);
            students = buffStudents;
        }
        lecturers = (Lecturer[]) Quicksort.quickSort(lecturers, 0, lecturers.length - 1, new LecturerNameComparator());
        students = (Student[]) Quicksort.quickSort(students, 0, students.length - 1, new StudentNameComparator());
        int choice = 0;
        while (choice != 3) {
            System.out.println("1 - Вивести всіх студентів факультета впорядкованих за алфавітом");
            System.out.println("2 - Вивести всіх викладачів факультета впорядкованих за алфавітом");
            System.out.println("3 - Повернутися до меню");
            choice = DataInput.getInt("Оберіть дію");
            switch (choice) {
                case 1 -> printArray(students);
                case 2 -> printArray(lecturers);
                case 3 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }

    }

    /**
     * Task 7
     * Bring all students of the department organized by courses
     */
    private static void task7() {
        Faculty faculty = getFaculty();
        Chair chair = getChair(faculty);
        Student[] students = (Student[]) Quicksort.quickSort(chair.getStudents(), 0, chair.getStudents().length - 1, new StudentCourseComparator());
        printArray(students);
    }

    /**
     * Task 8
     * List all students / teachers of the department in alphabetical order
     */
    private static void task8() {
        Faculty faculty = getFaculty();
        Chair chair = getChair(faculty);
        int choice = 0;
        while (choice != 3) {
            System.out.println("1 - Вивести студентів кафедри впорядкованих за алфавітом");
            System.out.println("2 - Вивести лекторів кафедри впорядкованих за алфавітом");
            System.out.println("3 - Повернутися до меню");
            choice = DataInput.getInt("Оберіть дію");
            switch (choice) {
                case 1 -> {
                    Student[] students = (Student[]) Quicksort.quickSort(chair.getStudents(), 0, chair.getStudents().length - 1, new StudentNameComparator());
                    printArray(students);
                }
                case 2 -> {
                    Lecturer[] lecturers = (Lecturer[]) Quicksort.quickSort(chair.getLecturers(), 0, chair.getLecturers().length - 1, new LecturerNameComparator());
                    printArray(lecturers);
                }
                case 3 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }

    /**
     * Task 10
     * List all students of the department of the specified course in alphabetical order.
     */
    private static void task10() {
        Student[] students = getArrStudentsFromChairByCourse();
        students = (Student[]) Quicksort.quickSort(students, 0, students.length - 1, new StudentNameComparator());
        printArray(students);
    }

    /**
     * Print array to console
     * @param objects object
     */
    private static void printArray(Object[] objects) {
        for (Object object : objects) {
            if (object != null)
                System.out.println(object);
        }
    }

    /**
     * Task 9
     * Withdraw all students of the department of the specified course
     */
    private static void getStudentsFromChairByCourse() {
        Student[] students = getArrStudentsFromChairByCourse();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Student array by course
     * @return Student array by course
     */
    private static Student[] getArrStudentsFromChairByCourse() {
        Faculty faculty = getFaculty();
        Chair chair = getChair(faculty);
        return chair.getStudentsByCourse(ConsoleRequest.getValidIndex(1, 6, "Введіть курс, студентів якого ви хочете побачити"));
    }

    /**
     * Task 2
     * Create / delete / edit the chair of the faculty.
     */
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

    /**
     * Task 3
     * Add / delete / edit teacher to the chair
     *
     * @param chair chair
     */
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

    /**
     * Add / delete / edit student to the chair.
     * @param chair - chair
     */
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

    /**
     * Add / delete / edit  chair.
     */
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

    /**
     * Return faculty
     * @return - faculty
     */
    private static Faculty getFaculty() {
        faculties.showFaculty();
        return faculties.getFaculty(ConsoleRequest.getValidIndex(1, faculties.getCurrentFaculty(), "Введіть номер факультету") - 1);
    }

    /**
     * Return chair
     * @param faculty - faculty
     * @return - chair
     */
    private static Chair getChair(Faculty faculty) {
        faculty.showChairs();
        return faculty.getChair(ConsoleRequest.getValidIndex(1, faculty.getNumberOfChairs(), "Введіть номер кафедри") - 1);
    }

    /**
     * Task 1
     * Create / delete / edit faculty
     */
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
                case 5 -> {
                }
                default -> System.out.println("Неправильне введення даних");
            }
        }
    }
}
