import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> fruitPrices = new HashMap<>();

        // Adding key-value pairs
        fruitPrices.put("Matooke", 100);
        fruitPrices.put("Jackfruit", 50);
        fruitPrices.put("Pawpaw", 75);

        // Accessing values
        System.out.println("Price of Matooke: " + fruitPrices.get("Matooke"));

        // Displaying all key-value pairs
        System.out.println("Fruit Prices: " + fruitPrices);
    }
}