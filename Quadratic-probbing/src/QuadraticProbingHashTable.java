public class QuadraticProbingHashTable {
    private static final int TABLE_SIZE = 11;
    private Integer[] hashTable;

    public QuadraticProbingHashTable() {
        hashTable = new Integer[TABLE_SIZE];
    }

    // Hash function
    private int hashFunction(int key) {
        return key % TABLE_SIZE;
    }

    // Insert function using Quadratic Probing
    public void insert(int key) {
        int hashValue = hashFunction(key);
        int i = 0;

        while (hashTable[(hashValue + i * i) % TABLE_SIZE] != null) {
            i++;
            if (i == TABLE_SIZE) {
                System.out.println("Hash table is full, cannot insert " + key);
                return;
            }
        }

        hashTable[(hashValue + i * i) % TABLE_SIZE] = key;
    }

    // Display the hash table
    public void displayHashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (hashTable[i] != null) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }

    public static void main(String[] args) {
        QuadraticProbingHashTable qph = new QuadraticProbingHashTable();

        int[] keys = {3, 17, 9, 4, 23, 5, 7};

        for (int key : keys) {
            qph.insert(key);
        }

        qph.displayHashTable();
    }
}
