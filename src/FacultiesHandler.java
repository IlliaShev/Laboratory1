import utils.ConsoleRequest;
import utils.DataInput;

public class FacultiesHandler {
    /**
     * Array with faculties
     */
    private Faculty[] faculties;
    /**
     * Maximum size of array
     */
    private int maximumSize;
    /**
     * Index of the last faculties
     */
    private int currentFaculty;

    /**
     * Create handler for faculties
     *
     * @param maximumSize - maximum size of the array
     */
    public FacultiesHandler(int maximumSize) {
        this.maximumSize = maximumSize;
        faculties = new Faculty[maximumSize];
    }

    /**
     * Create default faculties handler
     */
    public FacultiesHandler(){ this(10);}

    /**
     * Get maximum size of the faculties array
     *
     * @return maximum size
     */
    public int getMaximumSize() {
        return maximumSize;
    }

    /**
     * Print to the console all the faculty that was added
     */
    public void showFaculty() {
        for (int i = 0; i < currentFaculty; i++) {
            System.out.println((i + 1) + ": " + faculties[i]);
        }
    }

    /**
     * Add faculty to the handler
     *
     * @param faculty - faculty
     */
    public void addFaculty(Faculty faculty) {
        faculties[currentFaculty++] = faculty;
    }

    /**
     * Add faculty to the handler
     */
    public void addFaculty() {
        faculties[currentFaculty++] = buildFaculty();
    }

    /**
     * Delete faculties from the handler
     *
     * @param facultiesIndex - faculty index
     */
    public void deleteFaculty(int facultiesIndex) {
        Faculty[] newFacultyTeam = new Faculty[maximumSize];
        System.arraycopy(faculties, 0, newFacultyTeam, 0, facultiesIndex);
        System.arraycopy(faculties, facultiesIndex + 1, newFacultyTeam, facultiesIndex, maximumSize - facultiesIndex - 1);
        faculties = newFacultyTeam;
        currentFaculty--;
    }


    /**
     * Edit faculty
     *
     * @param facultyIndex - faculty index
     */
    public void editFaculty(int facultyIndex) {
        System.out.println("Факультет: " + faculties[facultyIndex]);
        if (ConsoleRequest.askUserTF("Бажаєте змінити назву факультету?")) {
            faculties[facultyIndex].setName(getValidName());
        }
    }

    /**
     * Create new faculty
     */
    private Faculty buildFaculty() {
        String name = getValidName();
        return new Faculty(name);
    }

    /**
     * Get valid name faculty
     *
     * @return valid name
     */
    private String getValidName() {
        return DataInput.getString("Введіть назву факультету");
    }

    /**
     *
     * @return information about new faculty
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < currentFaculty; i++) {
            res.append(i + 1).append(": ").append(faculties[i]).append("\n");
        }
        return res.toString();
    }
}
