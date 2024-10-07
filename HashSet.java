import java.util.HashMap;

// Custom HashSet class using HashMap for internal storage
class CustomHashSet<T> {
    private HashMap<T, Boolean> hashTable;

    // Constructor to initialize the hash table
    public CustomHashSet() {
        hashTable = new HashMap<>();
    }

    // Method to add an element to the hash set
    public void add(T element) {
        if (!hashTable.containsKey(element)) {
            hashTable.put(element, true);
            System.out.println(element + " added to the HashSet.");
        } else {
            System.out.println(element + " already exists in the HashSet.");
        }
    }

    // Method to remove an element from the hash set
    public void remove(T element) {
        if (hashTable.containsKey(element)) {
            hashTable.remove(element);
            System.out.println(element + " removed from the HashSet.");
        } else {
            System.out.println(element + " does not exist in the HashSet.");
        }
    }

    // Method to check if an element exists in the hash set
    public boolean contains(T element) {
        return hashTable.containsKey(element);
    }

    // Method to display all elements in the hash set
    public void display() {
        System.out.println("HashSet elements: " + hashTable.keySet());
    }
}

// Main class to demonstrate the CustomHashSet functionality
public class HashSet {
    public static void main(String[] args) {
        // Create an instance of CustomHashSet
        CustomHashSet<String> mySet = new CustomHashSet<>();

        // Perform add operations
        mySet.add("Apple");
        mySet.add("Banana");
        mySet.add("Strawberry");

        // Try to add a duplicate element
        mySet.add("Apple");

        // Display elements in the HashSet
        mySet.display();

        // Check if an element exists
        System.out.println("Contains 'Banana': " + mySet.contains("Banana"));
        System.out.println("Contains 'Mango': " + mySet.contains("Mango"));

        // Remove an element
        mySet.remove("Banana");

        // Try to remove an element that does not exist
        mySet.remove("Mango");

        // Display elements again after removal
        mySet.display();
    }
}