package DSA.stack.problems;

// Design a stack that supports push, pop, peek, and find min and find max in constant time
public class MinMaxStack {
    
    public static void main(String[] args) {
        
        // Tests of MinMaxArrayStack
        System.out.println("Test of MinMaxArrayStack");
        
        MinMaxArrayStack arrayStack = new MinMaxArrayStack();
        
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
        System.out.println("Find Min: " + arrayStack.findMin());
        System.out.println("Find Max: " + arrayStack.findMax());
        System.out.print("Push 7: ");
        arrayStack.push('7');
        arrayStack.display();
        System.out.println("Find Min: " + arrayStack.findMin());
        System.out.println("Find Max: " + arrayStack.findMax());
        System.out.print("Push 5: ");
        arrayStack.push('5');
        arrayStack.display();
        System.out.println("Find Min: " + arrayStack.findMin());
        System.out.println("Find Max: " + arrayStack.findMax());
        System.out.print("Push 1: ");
        arrayStack.push('1');
        arrayStack.display();
        System.out.println("Find Min: " + arrayStack.findMin());
        System.out.println("Find Max: " + arrayStack.findMax());
        System.out.print("Push 2: ");
        arrayStack.push('2');
        arrayStack.display();
        System.out.println("Find Min: " + arrayStack.findMin());
        System.out.println("Find Max: " + arrayStack.findMax());
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
        System.out.println("Find Min: " + arrayStack.findMin());
        System.out.println("Find Max: " + arrayStack.findMax());
        
        System.out.print("Peek: ");
        System.out.println(arrayStack.peek());
        System.out.print("Pop: ");
        arrayStack.pop();
        arrayStack.display();
        System.out.println("Find Min: " + arrayStack.findMin());
        System.out.println("Find Max: " + arrayStack.findMax());
        
        System.out.print("Peek: ");
        System.out.println(arrayStack.peek());
        System.out.print("Pop: ");
        arrayStack.pop();
        arrayStack.display();
        System.out.println("Find Min: " + arrayStack.findMin());
        System.out.println("Find Max: " + arrayStack.findMax());
        
        System.out.print("Peek: ");
        System.out.println(arrayStack.peek());
        System.out.print("Pop: ");
        arrayStack.pop();
        arrayStack.display();
        System.out.println("Find Min: " + arrayStack.findMin());
        System.out.println("Find Max: " + arrayStack.findMax());
        
        System.out.print("Peek: ");
        System.out.println(arrayStack.peek());
        System.out.print("Pop: ");
        arrayStack.pop();
        arrayStack.display();
        
        // Tests of MinMaxListStack
        System.out.println("\nTest of MinMaxListStack");
        
        MinMaxListStack listStack = new MinMaxListStack();
        
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
        System.out.println("Find Min: " + listStack.findMin());
        System.out.println("Find Max: " + listStack.findMax());
        System.out.print("Push 7: ");
        listStack.push('7');
        listStack.display();
        System.out.println("Find Min: " + listStack.findMin());
        System.out.println("Find Max: " + listStack.findMax());
        System.out.print("Push 5: ");
        listStack.push('5');
        listStack.display();
        System.out.println("Find Min: " + listStack.findMin());
        System.out.println("Find Max: " + listStack.findMax());
        System.out.print("Push 1: ");
        listStack.push('1');
        listStack.display();
        System.out.println("Find Min: " + listStack.findMin());
        System.out.println("Find Max: " + listStack.findMax());
        System.out.print("Push 2: ");
        listStack.push('2');
        listStack.display();
        System.out.println("Find Min: " + listStack.findMin());
        System.out.println("Find Max: " + listStack.findMax());
        
        System.out.print("Peek: ");
        System.out.println(listStack.peek());
        System.out.print("Pop: ");
        listStack.pop();
        listStack.display();
        System.out.println("Find Min: " + listStack.findMin());
        System.out.println("Find Max: " + listStack.findMax());
        
        System.out.print("Peek: ");
        System.out.println(listStack.peek());
        System.out.print("Pop: ");
        listStack.pop();
        listStack.display();
        System.out.println("Find Min: " + listStack.findMin());
        System.out.println("Find Max: " + listStack.findMax());
        
        System.out.print("Peek: ");
        System.out.println(listStack.peek());
        System.out.print("Pop: ");
        listStack.pop();
        listStack.display();
        System.out.println("Find Min: " + listStack.findMin());
        System.out.println("Find Max: " + listStack.findMax());
        
        System.out.print("Peek: ");
        System.out.println(listStack.peek());
        System.out.print("Pop: ");
        listStack.pop();
        listStack.display();
        System.out.println("Find Min: " + listStack.findMin());
        System.out.println("Find Max: " + listStack.findMax());
        
        System.out.print("Peek: ");
        System.out.println(listStack.peek());
        System.out.print("Pop: ");
        listStack.pop();
        listStack.display();
    }
    
}
// Have three stacks that maintains main stack, min stack and max stack
// When push an item, push to all three stacks, but:
// Main stack pushes the item.
// Max stack pushes max between its top and item.
// Min stack pushes min between its top and item.
// When pop, pop from all three stacks.
// This way it keeps records of current min and max from remaining items,
// and to not need to look up second max when current max is popped, etc.
class MinMaxArrayStack {
    
    private char[] arr = new char[5];
    private char[] min = new char[5];
    private char[] max = new char[5];
    private int top = -1;  // -1 represents empty stack.
    private int len = 0;   // number of elements in stack
    
    public MinMaxArrayStack() {
    }
    
    public MinMaxArrayStack(int size) {
        arr = new char[size];
        min = new char[size];
        max = new char[size];
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
        arr[top] = item;  // push to main array
        
        if (top == 0) {
            min[top] = item;
            max[top] = item;
        }
        else {  // top >= 1
            char curMin = min[top - 1];
            char curMax = max[top - 1];
            
            if (Character.compare(item, curMin) < 0) {  // push to min array
                min[top] = item;
            }
            else {
                min[top] = curMin;
            }
            
            if (Character.compare(item, curMax) > 0) {  // push to max array
                max[top] = item;
            }
            else {
                max[top] = curMax;
            }
        }
        
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
    
    public char findMin() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException("find on empty stack");
        }
        return min[top];
    }
    
    public char findMax() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException("find on empty stack");
        }
        return max[top];
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

class NodeMM {
    char val;
    NodeMM next;
    
    public NodeMM() {
    }
    
    public NodeMM(char val) {
        this.val = val;
    }
    
    public NodeMM(char val, NodeMM next) {
        this.val = val;
        this.next = next;
    }
}

class MinMaxListStack {
    NodeMM head;  // head represents top of the stack
    NodeMM minHead;
    NodeMM maxHead;
    int len;    // number of elements in stack
    
    public MinMaxListStack() {
    }
    
    public MinMaxListStack(NodeMM head) {
        this.head = head;
        
        // h->1 2 3
        // n->1 2 3
        // x->1 2 3
        // c
        if (head != null) {  // make deep copies
            
            minHead = new NodeMM(head.val);
            maxHead = new NodeMM(head.val);
            NodeMM cur1 = head;
            NodeMM cur2 = minHead;
            NodeMM cur3 = maxHead;
            while (cur1.next != null) {
                cur2.next = new NodeMM(cur1.next.val);
                cur3.next = new NodeMM(cur1.next.val);
                cur1 = cur1.next;
                cur2 = cur2.next;
                cur3 = cur3.next;
            }
        }
    }
    
    public char peek() {
        if (head == null) {
            throw new NullPointerException("Peak on empty stack");
        }
        return head.val;
    }
    
    public void push(char val) {
        if (head == null) {
            minHead = new NodeMM(val);
            maxHead = new NodeMM(val);
        }
        else {            
            if (Character.compare(val, minHead.val) < 0) {  // push to min list
                NodeMM newMinHead = new NodeMM(val, minHead);
                minHead = newMinHead;
            }
            else {
                NodeMM newMinHead = new NodeMM(minHead.val, minHead);
                minHead = newMinHead;
            }
            
            if (Character.compare(val, maxHead.val) > 0) {  // push to max list
                NodeMM newMaxHead = new NodeMM(val, maxHead);
                maxHead = newMaxHead;
            }
            else {
                NodeMM newMaxHead = new NodeMM(maxHead.val, maxHead);
                maxHead = newMaxHead;
            }
        }
        
        NodeMM newTop = new NodeMM(val, head);  // push to head
        head = newTop;

        len++;
    }
    
    public char pop() {
        if (head == null) {
            throw new NullPointerException("Pop on empty stack");
        }
        char curTop = head.val;
        head = head.next;
        minHead = minHead.next;
        maxHead = maxHead.next;
        
        len--;
        return curTop;
    }
    
    public int len() {
        return len;
    }
    
    public char findMin() {
        if (head == null) {
            throw new NullPointerException("Find on empty stack");
        }
        return minHead.val;
    }
    
    public char findMax() {
        if (head == null) {
            throw new NullPointerException("Find on empty stack");
        }
        return maxHead.val;
    }
    
    public void display() {
        NodeMM curr = head;
        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println("Length: " + len);
    }
}
