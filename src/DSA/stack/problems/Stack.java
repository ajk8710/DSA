package DSA.stack.problems;

public class Stack {
    
    public static void main(String[] args) {
        
        // Tests of ArrayStack
        System.out.println("Test of ArrayStack");
        
        ArrayStack arrayStack = new ArrayStack();
        
        try {
            arrayStack.peek();  // Peek on empty stack
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            arrayStack.pop();   // Pop on empty stack
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.print("Push 3: ");
        arrayStack.push('3');
        arrayStack.display();
        System.out.print("Push 7: ");
        arrayStack.push('7');
        arrayStack.display();
        System.out.print("Push 5: ");
        arrayStack.push('5');
        arrayStack.display();
        System.out.print("Push 1: ");
        arrayStack.push('1');
        arrayStack.display();
        System.out.print("Push 2: ");
        arrayStack.push('2');
        arrayStack.display();
        System.out.print("Push 3: ");
        try {
            arrayStack.push('3');  // Push on full stack
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.print("Peek: ");
        System.out.println(arrayStack.peek());
        System.out.print("Pop: ");
        arrayStack.pop();
        arrayStack.display();
        
        System.out.print("Peek: ");
        System.out.println(arrayStack.peek());
        System.out.print("Pop: ");
        arrayStack.pop();
        arrayStack.display();
        
        System.out.print("Peek: ");
        System.out.println(arrayStack.peek());
        System.out.print("Pop: ");
        arrayStack.pop();
        arrayStack.display();
        
        System.out.print("Peek: ");
        System.out.println(arrayStack.peek());
        System.out.print("Pop: ");
        arrayStack.pop();
        arrayStack.display();
        
        System.out.print("Peek: ");
        System.out.println(arrayStack.peek());
        System.out.print("Pop: ");
        arrayStack.pop();
        arrayStack.display();
        
        // Tests of ListStack
        System.out.println("\nTest of ListStack");
        
        ListStack listStack = new ListStack();
        
        try {
            listStack.peek();  // Peek on empty stack
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            listStack.pop();   // Pop on empty stack
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.print("Push 3: ");
        listStack.push('3');
        listStack.display();
        System.out.print("Push 7: ");
        listStack.push('7');
        listStack.display();
        System.out.print("Push 5: ");
        listStack.push('5');
        listStack.display();
        System.out.print("Push 1: ");
        listStack.push('1');
        listStack.display();
        System.out.print("Push 2: ");
        listStack.push('2');
        listStack.display();
        
        System.out.print("Peek: ");
        System.out.println(listStack.peek());
        System.out.print("Pop: ");
        listStack.pop();
        listStack.display();
        
        System.out.print("Peek: ");
        System.out.println(listStack.peek());
        System.out.print("Pop: ");
        listStack.pop();
        listStack.display();
        
        System.out.print("Peek: ");
        System.out.println(listStack.peek());
        System.out.print("Pop: ");
        listStack.pop();
        listStack.display();
        
        System.out.print("Peek: ");
        System.out.println(listStack.peek());
        System.out.print("Pop: ");
        listStack.pop();
        listStack.display();
        
        System.out.print("Peek: ");
        System.out.println(listStack.peek());
        System.out.print("Pop: ");
        listStack.pop();
        listStack.display();
    }
    
}

class ArrayStack {
    
    private char arr[] = new char[5];
    private int top = -1;  // -1 represents empty stack.
    private int len = 0;   // number of elements in stack
    
    public ArrayStack() {
    }
    
    public ArrayStack(int size) {
        arr = new char[size];
    }
    
    public char peek()  {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException("Peek on empty stack");
        }
        return arr[top];
    }
    
    public void push(char item) {
        if (top == arr.length - 1) {  // already full
            throw new ArrayIndexOutOfBoundsException("Push on full stack");
        }
        top++;
        arr[top] = item;
        len++;
    }
    
    public char pop() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException("Pop on empty stack");
        }
        char curTop = arr[top];
        top--;
        len--;
        return curTop;
    }
    
    public int len() {
        return len;
    }
    
    public void display() {
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("Length: " + len);
    }
}

class Node {
    char val;
    Node next;
    
    public Node() {
    }
    
    public Node(char val) {
        this.val = val;
    }
    
    public Node(char val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class ListStack {
    Node head;  // head represents top of the stack
    int len;    // number of elements in stack
    
    public ListStack() {
    }
    
    public ListStack(Node head) {
        this.head = head;
    }
    
    public char peek() {
        if (head == null) {
            throw new NullPointerException("Peak on empty stack");
        }
        return head.val;
    }
    
    public void push(char val) {
        Node newTop = new Node(val, head);
        head = newTop;
        len++;
    }
    
    public char pop() {
        if (head == null) {
            throw new NullPointerException("Pop on empty stack");
        }
        char curTop = head.val;
        head = head.next;
        len--;
        return curTop;
    }
    
    public int len() {
        return len;
    }
    
    public void display() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println("Length: " + len);
    }
}
