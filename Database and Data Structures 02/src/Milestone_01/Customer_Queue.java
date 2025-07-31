package Milestone_01;

public class Customer_Queue {

    private Node front;
    private Node rear;

    // Constructor to initialize the queue
    public Customer_Queue() {
        front = null;
        rear = null;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return rear == null;
    }

    // Enqueue a value to the rear of the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue and remove the front value from the queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty, Nothing to delete.");
        } else {
            if (front == rear) {
                // If there is only one element in the queue, set front and rear to null
                front = rear = null;
            } else {
                front = front.next;
            }
        }
    }

    // Print the elements in the queue
    public void printElement() {
        Node temp = front;
        if (isEmpty()) {
            System.out.println("The queue is empty, Cannot print any value.");
        } else {
            System.out.print("Queue Elements:");
            while (temp != null) {
                System.out.print(" " + temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Get the value at the front of the queue
    public void front() {
        if (isEmpty()) {
            System.out.println("The queue is empty, No first order.");
        } else {
            System.out.println("First order: " + front.data);
        }
    }

    // Get the value at the rear of the queue
    public void getRear() {
        if (isEmpty()) {
            System.out.println("The queue is empty, No last order.");
        } else {
            System.out.println("Last order: " + rear.data);
        }
    }

    // Search for a value in the queue and return its position (1-based)
    // Return -1 if the value is not found
    public int search(int valueToSearch) {
        Node temp = front;
        int position = 1;
        while (temp != null) {
            if (temp.data == valueToSearch) {
                return position;
            }
            temp = temp.next;
            position++;
        }
        return -1;
    }
}
