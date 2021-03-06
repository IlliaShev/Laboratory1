import utils.ConsoleRequest;
import utils.DataInput;

public class StudentHandler {
    /**
     * Array with students
     */
    private Student[] students;
    /**
     * Maximum size of array
     */
    private int maximumSize;
    /**
     * Index of the last students
     */
    private int currentStudent;

    /**
     * Create handler for students
     *
     * @param maximumSize - maximum size of the array
     */
    public StudentHandler(int maximumSize) {
        this.maximumSize = maximumSize;
        students = new Student[maximumSize];
    }

    /**
     * Create default students handler
     */
    public StudentHandler() {
        this(10);
    }

    /**
     * Get maximum size of the faculties array
     *
     * @return maximum size
     */
    public int getMaximumSize() {
        return maximumSize;
    }

    /**
     * Add student to the handler
     *
     * @param student - student
     */
    public void addStudent(Student student) {
        students[currentStudent++] = student;
    }

    /**
     * Add student to the handler
     */
    public void addStudent() {
        students[currentStudent++] = buildStudent();
    }

    /**
     * Edit student
     *
     * @param studentIndex - student index
     */
    public void editStudent(int studentIndex) {
        if (ConsoleRequest.askUserTF("Бажаєте змінити ім'я студента?"))
            students[studentIndex].setName(getValidName());
        if (ConsoleRequest.askUserTF("Бажаєете змінити групу студента?"))
            students[studentIndex].setGroup(getValidGroup());
        if (ConsoleRequest.askUserTF("Бажаєте змінити курс студента?"))
            students[studentIndex].setCourse(getValidCourse());
    }

    /**
     * Delete student from the handler
     *
     * @param studentIndex - student index
     */
    public void deleteStudent(int studentIndex) {
        Student[] newStudents = new Student[maximumSize];
        System.arraycopy(students, 0, newStudents, 0, studentIndex);
        System.arraycopy(students, studentIndex + 1, newStudents, studentIndex, maximumSize - studentIndex + 1);
        students = newStudents;
        currentStudent--;
    }

    /**
     * Print to the console all the student that was added
     */
    public void showStudents() {
        for (int i = 0; i < currentStudent; i++) {
            System.out.println((i + 1) + ": " + students[i]);
        }
    }

    /**
     * Create new student
     */
    private Student buildStudent() {
        String name = getValidName();
        String group = getValidGroup();
        int course = getValidCourse();
        return new Student(name, group, course);
    }

    /**
     * Get valid name student
     *
     * @return valid name
     */
    private String getValidName() {
        return DataInput.getString("Введіть ім'я студента");
    }

    /**
     * Get valid group student
     *
     * @return valid group
     */
    private String getValidGroup() {
        return DataInput.getString("Введіть групу студента");
    }

    /**
     * Get array students by course
     *
     * @param course - course
     * @return array students by course
     */
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

    /**
     * Get valid course student
     *
     * @return valid course
     */
    private int getValidCourse() {
        int course = DataInput.getInt("Введіть курс студента");
        while (course < 1 || course > 6) {
            System.out.println("Неправильне введення даних");
            course = DataInput.getInt("Введіть курс студента");
        }
        return course;
    }

    /**
     *
     * @return information about new students
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < currentStudent; i++) {
            res.append(i + 1).append(": ").append(students[i]).append("\n");
        }
        return res.toString();
    }

}
