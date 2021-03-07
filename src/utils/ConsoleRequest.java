package utils;

/**
 * ConsoleRequest class
 */
public class ConsoleRequest {
    /**
     * Ask user question with yes/no answer
     *
     * @param question - string questions
     * @return true - if user answer is "yes", otherwise false
     */
    public static boolean askUserTF(String question) {
        String choice;
        while (true) {
            choice = DataInput.getString(question + "[Y/N]");
            if (choice.equals("Y"))
                return true;
            if (choice.equals("N"))
                return false;
            System.out.println("Неправильне введення даних");
        }
    }

    /**
     * Checkable index in range
     * @param leftBorder - left range
     * @param rightBorder - right range
     * @param text - message
     * @return index
     */
    public static int getValidIndex(int leftBorder, int rightBorder, String text) {
        int index = DataInput.getInt(text);
        while (index < leftBorder || index > rightBorder) {
            System.out.println("Неправильне введення даних");
            index = DataInput.getInt(text);
        }
        return index;
    }
}
