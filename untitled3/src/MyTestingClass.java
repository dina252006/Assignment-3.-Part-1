import java.util.Random;

public class MyTestingClass {
    public static void main(String[] args) {
        MyHashTable<Integer, Integer> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt(10000);
            int value = random.nextInt(10000);
            table.put(key, value);
        }

        System.out.println("Distribution of elements across the buckets:");
        for (int i = 0; i < table.getNumberOfBuckets(); i++) {
            System.out.println("Bucket " + i + ": " + table.getBucketSize(i) + " elements");
        }

        System.out.println("Total elements in the hash table: " + table.size());
    }
}
