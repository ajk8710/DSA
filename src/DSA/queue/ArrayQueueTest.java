package DSA.queue;

public class ArrayQueueTest {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        System.out.println(queue.toString());
        System.out.println("Peek: " + queue.peek());
        queue.enqueue(Integer.valueOf(5));
        System.out.println("Peek: " + queue.peek());
        queue.enqueue(Integer.valueOf(4));
        System.out.println("Peek: " + queue.peek());
        queue.enqueue(Integer.valueOf(3));
        queue.enqueue(Integer.valueOf(2));
        queue.enqueue(Integer.valueOf(1));
        System.out.println(queue.toString());
        try {
            queue.enqueue(Integer.valueOf(1));
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        
        queue.dequeue();
        System.out.println("Dequeue: " + queue.toString());
        queue.display();
        queue.dequeue();
        System.out.println("Dequeue: " + queue.toString());
        queue.display();
        queue.dequeue();
        System.out.println("Dequeue: " + queue.toString());
        queue.display();
        queue.dequeue();
        System.out.println("Dequeue: " + queue.toString());
        queue.display();
        queue.dequeue();
        System.out.println("Dequeue: " + queue.toString());
        queue.display();
        try {
            queue.dequeue();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        ArrayQueue<Character> que = new ArrayQueue<>(3);
        System.out.println(que.toString());
        que.display();
        que.enqueue('0');
        System.out.println(que.toString());
        que.display();
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.display();
        que.enqueue('0');
        que.enqueue('1');
        System.out.println(que.toString());
        que.display();
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.display();
        que.enqueue('2');
        que.enqueue('3');
        System.out.println(que.toString());
        que.display();
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.display();
        que.enqueue('4');
        System.out.println(que.toString());
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.display();
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.display();
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.display();
        que.enqueue('a');
        System.out.println(que.toString());
        que.enqueue('b');
        System.out.println(que.toString());
        que.display();
    }

}
