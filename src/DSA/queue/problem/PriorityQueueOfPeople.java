package DSA.queue.problem;

import java.util.PriorityQueue;

/*
Queues: A queue of people.
You are given the names of N people and the time at which they arrive.
You have an empty queue.
As soon as a person arrives, you add their name to the queue.
Given the names of the people and their arrival times print the final queue after all N people have arrived.

Note:
1. No two people have the same name. 
2. No two people have the same arrival time. 
3. The input arrival time is not sorted (See sample input). 

Input:
Name={Jim ,Sam, Roy ,John}
Time={5, 1, 4, 2}

Output:
Sam John Roy Jim
Explanation:
There are 4 people with names Jim, Sam, Ray, John, Jim arrives at t=5 minutes,
Sam arrives at t=1 minutes, Ray arrives at t=4 minutes and John arrives at t=2 minutes.
 */

// Solving problem by priority queue.
// Person class with arrivalTime as value to compare.
class Person implements Comparable<Person> {
    
    String name;
    int arrivalTime;
    
    public Person(String name, int arrivalTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int compareTo(Person other) {
        return this.arrivalTime - other.arrivalTime;
    }
    
}

public class PriorityQueueOfPeople {
    
    // Create priority queue of person.
    // Poll while printing their names.
    public static void printInOrder(String[] people, int[] arrivalTimes) {
        
        // add person to priority queue according to their compare value (arrivalTime)
        PriorityQueue<Person> peopleQueue = new PriorityQueue<>();
        for (int i = 0; i < people.length; i++) {
            peopleQueue.add(new Person(people[i], arrivalTimes[i]));
        }
        
        while (!peopleQueue.isEmpty()) {
            System.out.print(peopleQueue.poll().name + " ");
        }
        
    }

    public static void main(String[] args) {
        String[] people = new String[] {"Jim", "Sam", "Roy", "John"};
        int[] arrivalTimes = {5, 1, 4, 2};
        
        printInOrder(people, arrivalTimes);
    }

}
