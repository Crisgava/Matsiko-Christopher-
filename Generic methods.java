public class GenericMethodDemo {
    // Generic method to display an array of any type
    public static <T> void displayArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"My ", "Pal"};

        // Calling the generic method
        displayArray(intArray);
        displayArray(strArray);
    }
}