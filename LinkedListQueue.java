/*
 *Shiva Mahitha Maddi
 * NU ID : 001061161
 */
package Test;

import java.util.NoSuchElementException;

/**
 *
 * @author mahit
 */
public class LinkedListQueue {

    private Node front, rear; //rear is last...front is first

    private class Node {

        String data;
        Node next;
    }

    LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(String str) {

        // If queue is empty, then new node is front and rear both 
        if (this.rear == null) {
            Node node = new Node();
            node.data = str;
            node.next = null;
            this.front = this.rear = node;
            System.out.println("Enqueued: " + node.data);
            return;
        }

        Node node = new Node();
        node.data = str;
        node.next = null;
        System.out.println("Enqueued: " + node.data);

        // Add the new node at the end of queue and change rear 
        this.rear.next = node;
        this.rear = node;
    }

    public void dequeue() {
        // If queue is empty, return NULL. 
        if (this.front == null) {
            return;
        }
        System.out.println("\nDequeued: " + this.front.data);
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL 
        if (this.front == null) {
            this.rear = null;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return front.data;
    }

    public void display() {
        if (front == null) {
            System.out.println("\nQueue Underflow");
        } else {
            Node temp = front;
            System.out.println("\nElements in the queue:");
            while (temp != null) {

                System.out.println(temp.data + "->");
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();
        q.enqueue("Hi");
        q.display();
        q.dequeue();
        q.display();
        q.enqueue("Hello");
        q.display();
    }

}
