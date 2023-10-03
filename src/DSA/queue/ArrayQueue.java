package DSA.queue;

public class ArrayQueue<T> {
    
    private Object[] arr = new Object[5];
    private int front = -1;
    private int rear = -1;
    private int size = 0;  // number of elements
    
    public ArrayQueue() {
    }
    
    public ArrayQueue(int capacity) {
        arr = new Object[capacity];
    }
    
    public void enqueue(T item) {
        if (size == arr.length) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        
        if (rear == -1) {  // adding to empty queue
            front = 0;
            rear = 0;
        }
        else if (rear == arr.length - 1) {
            rear = 0;
        }
        else {
            rear++;
        }
        
        arr[rear] = item;
        size++;
    }
    
    // 0 1 n
    // f = 2->0
    // r = 1
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        
        T item = (T) arr[front];
        arr[front] = null;
        
        if (front == rear) {  // if there was only one element
            front = -1;
            rear = -1;
        }
        else if (front == arr.length - 1) {
            front = 0;
        }
        else {
            front++;
        }
        
        size--;
        return item;
    }
    
    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            return null;
        }
        return (T) arr[front];
    }
    
    public int size() {
        return size;
    }
    
    public String toString() {
        String str = "";
        for (Object t : arr) {
            str += t + " ";
        }
        return str;
    }
    
    public void display() {
        if (front > -1) {
            if (rear < front) {  // if to print from front to last index then 0 to rear
                for (int i = front; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
            else {               // if to print from front to rear
                for (int i = front; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
        else {
            System.out.println("Queue is empty");
        }
    }

}
