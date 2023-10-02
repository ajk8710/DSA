package DSA.queue;

public class ListQueueTest {

    public static void main(String[] args) {
        ListQueue<Integer> queue = new ListQueue<>();
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
        
        queue.dequeue();
        System.out.println("Dequeue: " + queue.toString());
        queue.dequeue();
        System.out.println("Dequeue: " + queue.toString());
        queue.dequeue();
        System.out.println("Dequeue: " + queue.toString());
        queue.dequeue();
        System.out.println("Dequeue: " + queue.toString());
        queue.dequeue();
        System.out.println("Dequeue: " + queue.toString());
        try {
            queue.dequeue();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        ListQueue<Character> que = new ListQueue<>();
        System.out.println(que.toString());
        que.enqueue('0');
        System.out.println(que.toString());
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.enqueue('0');
        que.enqueue('1');
        System.out.println(que.toString());
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.enqueue('2');
        que.enqueue('3');
        System.out.println(que.toString());
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.enqueue('4');
        System.out.println(que.toString());
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.dequeue();
        System.out.println("Dequeue: " + que.toString());
        que.enqueue('a');
        System.out.println(que.toString());
        que.enqueue('b');
        System.out.println(que.toString());
    }

}
