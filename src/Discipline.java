public class Discipline {
    /**
     * Name of the current discipline
     */
    private String name;
    /**
     * Credits provided by this discipline
     */
    private double credits;
    /**
     * Hours per week demanded for this discipline
     */
    private double hours;

    public Discipline(String name, double credits, double hours) {
        this.name = name;
        this.credits = credits;
        this.hours = hours;
    }

    /**
     * Get discipline name
     *
     * @return String - name of discipline
     */
    public String getName() {
        return name;
    }

    /**
     * Set new name to the discipline
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get credits for the discipline
     *
     * @return credits for the discipline(data type - double)
     */
    public double getCredits() {
        return credits;
    }


    /**
     * Change value of credits for discipline
     */
    public void setCredits(double credits) {
        this.credits = credits;
    }

    /**
     * Get hours of the discipline
     *
     * @return hours for the discipline(data type - double)
     */
    public double getHours() {
        return hours;
    }

    /**
     * Set new value of hours to the discipline
     */
    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        String res = "";
        res += "Назва - " + name + "; Кредитів - " + credits + "; Годин - " + hours;
        return res;
    }
}
