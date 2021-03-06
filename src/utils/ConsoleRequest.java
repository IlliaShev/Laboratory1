package utils;

public class ConsoleRequest {
    /**
     * Ask user question with yes/no answer
     *
     * @return true - uf user answer is "yes", otherwise false
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

    public static int getValidIndex(int leftBorder, int rightBorder, String text) {
        int index = DataInput.getInt(text);
        while (index < leftBorder || index > rightBorder) {
            System.out.println("Неправильне введення даних");
            index = DataInput.getInt(text);
        }
        return index;
    }
}
