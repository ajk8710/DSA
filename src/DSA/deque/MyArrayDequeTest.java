package DSA.deque;

public class MyArrayDequeTest {

    public static void main(String[] args) {
        
        MyArrayDeque<Integer> deque = new MyArrayDeque<>(10);
        
        System.out.println("Add front:");
        deque.addFront(0);
        System.out.println(deque.toStringArr());
        deque.addFront(-1);
        System.out.println(deque.toStringArr());
        deque.addFront(-2);
        System.out.println(deque.toStringArr());
        deque.addFront(-3);
        System.out.println(deque.toStringArr());
        deque.addFront(-4);
        System.out.println(deque.toStringArr());
        
        System.out.println("Add rear:");
        deque.push(1);
        System.out.println(deque.toStringArr());
        deque.push(2);
        System.out.println(deque.toStringArr());
        deque.push(3);
        System.out.println(deque.toStringArr());
        deque.addFront(-5);
        System.out.println(deque.toStringArr());
        deque.push(4);
        System.out.println(deque.toStringArr());
        System.out.println("Display from front to rear:");
        deque.display();
        System.out.println();
        
        System.out.println("Removed front: " + deque.removeFront());
        System.out.println(deque.toStringArr());
        System.out.println("Removed front: " + deque.removeFront());
        System.out.println(deque.toStringArr());
        System.out.println("Removed front: " + deque.removeFront());
        System.out.println(deque.toStringArr());
        System.out.println("Removed front: " + deque.removeFront());
        System.out.println(deque.toStringArr());
        System.out.println("Removed front: " + deque.removeFront());
        System.out.println(deque.toStringArr());
        System.out.println("Removed front: " + deque.removeFront());
        System.out.println(deque.toStringArr());
        System.out.println("Removed front: " + deque.removeFront());
        System.out.println(deque.toStringArr());
        System.out.println();
        
        System.out.println("Add front:");
        deque.addFront(1);
        System.out.println(deque.toStringArr());
        deque.addFront(0);
        System.out.println(deque.toStringArr());
        deque.addFront(-1);
        System.out.println(deque.toStringArr());
        deque.addFront(-2);
        System.out.println(deque.toStringArr());
        System.out.println("Display from front to rear:");
        deque.display();
        System.out.println();
        
        System.out.println("Removed rear: " + deque.pop());
        System.out.println(deque.toStringArr());
        System.out.println("Removed rear: " + deque.pop());
        System.out.println(deque.toStringArr());
        System.out.println("Removed rear: " + deque.pop());
        System.out.println(deque.toStringArr());
        System.out.println("Removed rear: " + deque.pop());
        System.out.println(deque.toStringArr());
        System.out.println("Removed rear: " + deque.pop());
        System.out.println(deque.toStringArr());
        System.out.println("Removed rear: " + deque.pop());
        System.out.println(deque.toStringArr());
        System.out.println("Display from front to rear:");
        deque.display();
        System.out.println("Removed rear: " + deque.pop());
        System.out.println(deque.toStringArr());

    }

}
