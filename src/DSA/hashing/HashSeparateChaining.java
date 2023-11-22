package DSA.hashing;

// Use hash function to get a hash code of a key to store. Hash code represents an index of array.
// (Or do additional compression calculation (such as golden ratio) to turn hash code into an index.)
// Save to the index. Hash function example: mod the key by prime number.
// If collision happens: Separate chaining (using linked list): An index has a pointer (a node = entry point = bucket) to actual nodes with key.
public class HashSeparateChaining {
    
    // node for separate chaining
    class dataNode {
        int data;
        dataNode next;
        
        public dataNode() {}
        
        public dataNode(int data) {
            this.data = data;
        }
    }
    
    public dataNode[] hashTable;
    public int mode = 31;
    
    public HashSeparateChaining() {  // constructor
        hashTable = new dataNode[mode];
        for (int i = 0; i < mode; i++) {
            hashTable[i] = new dataNode();  // initialize buckets
        }
    }
    
    public void insert(int data) {
        int hashcode = data % mode;  // hash function
        dataNode bucket = hashTable[hashcode];
        
        dataNode curr = bucket;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new dataNode(data);
    }
    
    public int find(int data) {  // if found return index position, else -1
        int hashcode = data % mode;  // hash function
        dataNode bucket = hashTable[hashcode];
        
        dataNode curr = bucket;
        while (curr.next != null) {
            if (curr.next.data == data) {
                return hashcode;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        HashSeparateChaining vault = new HashSeparateChaining();
        System.out.println("Find 1000: " + vault.find(1000));
        vault.insert(1000);
        vault.insert(200);
        System.out.println("Find 1000: " + vault.find(1000));
        
        vault.insert(202);
        vault.insert(1);
        vault.insert(31);
        System.out.println("Find 202: " + vault.find(202));
        System.out.println("Find 1: " + vault.find(1));
        System.out.println("Find 31: " + vault.find(31));
        System.out.println("Find 200: " + vault.find(200));
        
        vault.insert(32);
        vault.insert(63);
        System.out.println("Find 32: " + vault.find(32));
        System.out.println("Find 33: " + vault.find(63));
    }

}
