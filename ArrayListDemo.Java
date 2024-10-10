import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Creating an ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Matooke");
        fruits.add("Jackfruit");
        fruits.add("Pawpaw");

        // Accessing elements
        System.out.println("First fruit: " + fruits.get(0)); // Output: Matooke

        // Removing an element
        fruits.remove("Jackfruit");

        // Displaying all elements
        System.out.println("Fruits: " + fruits);
    }
}