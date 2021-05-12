
/*
 * Anusha Peddigari
 * 001023769
 */
package Test;
/**
 *
 * @author 16175
 */
public class CircularQueue {

    int MAX_SIZE;
    private int a[];
    int front, rear;

    public CircularQueue(int size) {
        this.MAX_SIZE = size;
        a = new int[MAX_SIZE];
        front = -1;
        rear = -1;
    }

    
    boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    
    boolean isFull() {
        return (rear + 1) % MAX_SIZE == front ? true : false;
    }

    
    void enqueue(int x) {

        if (isFull()) {
            System.out.println("\nQueue is Full");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % MAX_SIZE;
        }
        a[rear] = x;
        System.out.println("Enqueued " + x + " at position " + rear);
    }

    
    void dequeue() {
        if (isEmpty()) {
            System.out.println("\nQueue is Empty");
            return;
        } else if (front == rear) {
            System.out.println("Dequeued " + a[front] + " from position " + front);
            System.out.println("Queue is reset");
            rear = front = -1;
        } else {
            front = (front + 1) % MAX_SIZE;

            System.out.println("Dequeued " + a[front] + " from position " + front);
        }
    }
    

    int front() {
        if (front == -1) {
            System.out.println("\nCannot return front from empty queue");
            return -1;
        }
        return a[front];
    }

    void displayQueue() {
        if (isEmpty()) {
            System.out.println("\nQueue is Empty");
            return;
        }
        
        int count = (rear + MAX_SIZE - front) % MAX_SIZE + 1;

        System.out.println("\nHead position: " + front);
        System.out.print("\nQueue elements: \n");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % MAX_SIZE; // Index of element while travesing circularly from front
            System.out.println(a[index] + " ");
        }
        System.out.println();

        System.out.println("Tail position: " + rear);
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(10); // creating an instance of Queue. 
        System.out.println("Queue size: 10");

        System.out.println();
        cq.enqueue(2);
        cq.enqueue(8);
        cq.enqueue(8);
        cq.enqueue(43);
        cq.enqueue(94);
        cq.enqueue(84);
        cq.enqueue(1);
        cq.enqueue(51);
        cq.enqueue(65);
        cq.enqueue(9);

        System.out.println();
        cq.displayQueue();

        System.out.println();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();

        System.out.println();
        cq.displayQueue();

        System.out.println();
        cq.enqueue(1);
        cq.enqueue(60);

        System.out.println();
        cq.displayQueue();

        System.out.println();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();

        System.out.println();
        cq.displayQueue();
    }

}
