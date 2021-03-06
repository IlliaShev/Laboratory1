public class Faculty {

    /**
     * Faculty name
     */
    private String name;

    /**
     * Create faculty
     * @param name - faculty name
     */
    public Faculty(String name){
        this.name = name;
    }

    /**
     * Return faculty name
     *
     * @return faculty name
     */
    public String getName() {
        return name;
    }

    /**
     * Change faculty name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Факультет: " +
                "Назва - " + name;
    }
}
