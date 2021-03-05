public class Chair {
    private String chairName;
    private StudentHandler students;
    private LecturerHandler lectures;

    public Chair(String chairName) {
        this.chairName = chairName;
        students = new StudentHandler(30);
        lectures = new LecturerHandler(30);
    }


}
