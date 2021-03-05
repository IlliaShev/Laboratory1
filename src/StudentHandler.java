import utils.ConsoleRequest;
import utils.DataInput;

import java.lang.reflect.Array;

public class StudentHandler {
    private Student[] students;
    private int maximumSize;
    private int currentStudent;

    public StudentHandler(int maximumSize) {
        this.maximumSize = maximumSize;
        students = new Student[maximumSize];
    }

    public StudentHandler() {
        this(10);
    }

    public int getMaximumSize() {
        return maximumSize;
    }

    public void addStudent(Student student) {
        students[currentStudent++] = student;
    }

    public void addStudent() {
        students[currentStudent++] = buildStudent();
    }

    public void editStudent(int studentIndex) {
        if (ConsoleRequest.askUserTF("Бажаєте змінити ім'я студента?"))
            students[studentIndex].setName(getValidName());
        if (ConsoleRequest.askUserTF("Бажаєете змінити групу студента?"))
            students[studentIndex].setGroup(getValidGroup());
        if (ConsoleRequest.askUserTF("Бажаєте змінити курс студента?"))
            students[studentIndex].setCourse(getValidCourse());
    }

    public void deleteStudent(int studentIndex) {
        Student[] newStudents = new Student[maximumSize];
        System.arraycopy(students, 0, newStudents, 0, studentIndex);
        System.arraycopy(students, studentIndex + 1, newStudents, studentIndex, maximumSize - studentIndex + 1);
        students = newStudents;
        currentStudent--;
    }

    public void showStudents() {
        for (int i = 0; i < currentStudent; i++) {
            System.out.println((i + 1) + ": " + students[i]);
        }
    }

    private Student buildStudent() {
        String name = getValidName();
        String group = getValidGroup();
        int course = getValidCourse();
        return new Student(name, group, course);
    }

    private String getValidName() {
        return DataInput.getString("Введіть ім'я студента");
    }

    private String getValidGroup() {
        return DataInput.getString("Введіть групу студента");
    }

    public Student[] getStudentsByCourse(int course) {
        int arrSize = 0;
        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getCourse() == course)
                arrSize++;
        }
        Student[] res = new Student[arrSize];
        int currIn = 0;
        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getCourse() == course)
                res[currIn++] = students[i];
        }
        return res;
    }

    private int getValidCourse() {
        int course = DataInput.getInt("Введіть курс студента");
        while (course < 1 || course > 6) {
            System.out.println("Неправильне введення даних");
            course = DataInput.getInt("Введіть курс студента");
        }
        return course;
    }

}
