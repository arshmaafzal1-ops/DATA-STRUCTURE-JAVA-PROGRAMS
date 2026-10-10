// SCENARIO: Bank/Ticket counter. Customers token lete hain, jo pehle aaya
// wo pehle serve hota hai (FIFO). Circular array use kiya hai.
public class QueueArray {
    private int[] data;
    private int front = 0, rear = -1, count = 0;

    QueueArray(int size) { data = new int[size]; }

    void enqueue(int token) {
        if (count == data.length) { System.out.println("Counter full, token " + token + " wait kare"); return; }
        rear = (rear + 1) % data.length;
        data[rear] = token;
        count++;
    }
    int dequeue() {
        if (count == 0) { System.out.println("Koi customer nahi"); return -1; }
        int t = data[front];
        front = (front + 1) % data.length;
        count--;
        return t;
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(3);
        q.enqueue(101); q.enqueue(102); q.enqueue(103);
        q.enqueue(104); // full
        System.out.println("Serving token: " + q.dequeue());
        q.enqueue(104); // ab jagah hai (circular)
        while (q.count > 0) System.out.println("Serving token: " + q.dequeue());
        q.dequeue();
    }
}
