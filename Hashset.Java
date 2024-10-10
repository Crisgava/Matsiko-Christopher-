import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> uniqueFruits = new HashSet<>();

        // Adding elements
        uniqueFruits.add("Matooke");
        uniqueFruits.add("Jackfruit");
        uniqueFruits.add("Pawpaw"); // Duplicate

        // Displaying unique elements
        System.out.println("Unique Fruits: " + uniqueFruits);
    }
}