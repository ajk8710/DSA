package DSA.deque;

public class MyArrayDeque<T> {
    
    private Object[] arr = new Object[5];
    private int front = -1;
    private int rear = -1;
    private int size = 0;  // number of elements
    
    public MyArrayDeque() {
    }
    
    public MyArrayDeque(int capacity) {
        arr = new Object[capacity];
    }
    
    public void addFront(T item) {
        if (front == rear + 1 || front == 0 && rear == arr.length - 1) {  // was full. using short circuit. could use size == arr.length.
            throw new IndexOutOfBoundsException("Deque is full");
        }
        else if (front == -1) {  // was empty. could use isEmpty().
            front = 0;
            rear = 0;
        }
        else if (front == 0) {
            front = arr.length - 1;
        }
        else {
            front--;
        }
        
        arr[front] = item;
        size++;
    }
    
    public void push(T item) {  // addRear. same as normal enqueue operation of ArrayQueue.
        if (size == arr.length) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        
        if (rear == -1) {  // was empty
            front = 0;
            rear = 0;
        }
        else if (rear == arr.length - 1) {  // rear == arr.length - 1, but front != 0
            rear = 0;
        }
        else {
            rear++;
        }
        
        arr[rear] = item;
        size++;
    }
    
    @SuppressWarnings("unchecked")  // same as normal dequeue operation of ArrayQueue.
    public T removeFront() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Deque is empty");
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
    
    @SuppressWarnings("unchecked")  // tweak of removeFront
    public T pop() {
        if (rear == -1) {  // could use size == 0
            throw new ArrayIndexOutOfBoundsException("Deque is empty");
        }
        
        T item = (T) arr[rear];
        arr[rear] = null;
        
        if (front == rear) {  // if there was only one element
            front = -1;
            rear = -1;
        }
        else if (rear == 0) {
            rear = arr.length - 1;
        }
        else {
            rear--;
        }
        
        size--;
        return item;
    }
    
    public String toStringArr() {
        String str = "";
        for (Object item : arr) {
            str += item + " ";
        }
        return str;
    }
    
    public void display() {  // same display function as ArrayQueue
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
            System.out.println("Deque is empty");
        }
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
}
