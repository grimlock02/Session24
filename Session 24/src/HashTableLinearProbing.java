public class HashTableLinearProbing {
    private static final int SIZE = 8;
    private static Integer[] hashTable = new Integer[SIZE];

    // Fungsi hash h(k) = k mod 8
    private static int hashFunction(int key) {
        return key % SIZE;
    }

    // Fungsi insert dengan Linear Probing
    public static void insert(int key) {
        int index = hashFunction(key);
        int originalIndex = index;

        // Linear probing jika terjadi collision
        while (hashTable[index] != null) {
            index = (index + 1) % SIZE;
            if (index == originalIndex) {
                System.out.println("Tabel Hash penuh! Tidak bisa memasukkan " + key);
                return;
            }
        }

        hashTable[index] = key;
        System.out.println("Key " + key + " dimasukkan ke indeks " + index);
    }

    // Menampilkan isi tabel hash
    public static void displayTable() {
        System.out.println("\n--- Isi Tabel Hash ---");
        System.out.println("Indeks\tData");
        System.out.println("----------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.println("  " + i + "\t " + (hashTable[i] != null ? hashTable[i] : "Kosong"));
        }
    }

    public static void main(String[] args) {
        int[] keys = {72, 27, 36, 45, 63, 82, 94, 105};

        System.out.println("Proses Insertion:");
        for (int key : keys) {
            insert(key);
        }

        displayTable();
    }
}