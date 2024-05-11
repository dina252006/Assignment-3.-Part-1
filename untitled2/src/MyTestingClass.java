import java.util.Random;

public class MyTestingClass {

    public static void main(String[] args) {
        // Creating hash table with TestingClass keys and Student values
        MyHashTable<TestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        // Populating hash table with random key-value pairs
        for (int i = 0; i < 10000; i++) {
            TestingClass key = new TestingClass(random.nextInt(1000));
            Student value = new Student("Student " + i);
            table.put(key, value);
        }

        // Counting elements in each hash table bucket
        MyHashTable.HashNode<TestingClass, Student>[] chainArray = table.getChainArray();
        for (int i = 0; i < chainArray.length; i++) {
            int count = 0;
            MyHashTable.HashNode<TestingClass, Student> current = chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }

        BST<Integer, String> bst = new BST<>();

        // Populating BST with random key-value pairs
        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt(1000);
            String value = "Value " + i;
            bst.put(key, value);
        }

        System.out.println("Size of BST: " + bst.size());

        // Iterating through BST and printing key-value pairs
        for (Integer key : bst.iterator()) {
            System.out.println("Key is " + key + " and value is " + bst.get(key));
        }
    }

    static class TestingClass {
        int value;

        public TestingClass(int value) {
            this.value = value;
        }

        // Custom hashCode method
        @Override
        public int hashCode() {
            // Your custom hash code implementation
            return value;
        }
    }

    // Custom class Student with a name
    static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }
    }
}
