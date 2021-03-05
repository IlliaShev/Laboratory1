import utils.DataInput;

public class Chair {
    private String chairName;
    private StudentHandler students;
    private LecturerHandler lectures;
    private int maximumStudentSize;
    private int maximumLecturerSize;

    public Chair(String chairName, int maximumStudentSize, int maximumLecturerSize) {
        this.chairName = chairName;
        students = new StudentHandler(maximumStudentSize);
        lectures = new LecturerHandler(maximumLecturerSize);
    }

    public Chair(String chairName) {
        this(chairName, 10, 10);
    }


    public void addStudent() {
        students.addStudent();
    }

    public void editStudent() {
        students.showStudents();
        students.editStudent(getValidIndex(1, maximumStudentSize, "Введіть індекс студента для редагування") - 1);
    }

    public void deleteStudent() {
        students.showStudents();
        students.deleteStudent(getValidIndex(1, maximumStudentSize, "Введіть індекс студента для видалення") - 1);
    }

    public void addLecturer() {
        lectures.addLecturer();
    }

    public void editLecturer() {
        lectures.showLecturers();
        lectures.editLecturer(getValidIndex(1, maximumLecturerSize, "Введіть індекс вчителя для редагування") - 1);
    }

    public void deleteLecturer() {
        lectures.showLecturers();
        lectures.deleteLecturer(getValidIndex(1, maximumLecturerSize, "Введіть індекс вчителя для видалення") - 1);
    }

    private int getValidIndex(int leftBorder, int rightBorder, String text) {
        int index = DataInput.getInt(text);
        while (index < leftBorder || index > rightBorder) {
            System.out.println("Неправильне введення даних");
            index = DataInput.getInt(text);
        }
        return index;
    }


    public void showStudents() {
        students.showStudents();
    }

    public void showLectures() {
        lectures.showLecturers();
    }

    @Override
    public String toString() {
        String res = "";
        res += "Кафедра - " + chairName;
        return res;
    }
}
