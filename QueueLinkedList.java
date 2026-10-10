// SCENARIO: Customer care call center. Calls aati hain, line me wait karti hain
// aur agent jo call pehle aayi use pehle attend karta hai. Size limit nahi (dynamic).
public class QueueLinkedList {
    static class Node {
        String caller; Node next;
        Node(String c) { caller = c; }
    }
    private Node front, rear;

    void enqueue(String caller) {
        Node n = new Node(caller);
        if (rear == null) front = rear = n;
        else { rear.next = n; rear = n; }
        System.out.println(caller + " line me wait kar raha hai");
    }
    String dequeue() {
        if (front == null) { System.out.println("Koi call waiting nahi"); return null; }
        String c = front.caller;
        front = front.next;
        if (front == null) rear = null;
        return c;
    }

    public static void main(String[] args) {
        QueueLinkedList calls = new QueueLinkedList();
        calls.enqueue("Rahul");
        calls.enqueue("Priya");
        calls.enqueue("Imran");
        System.out.println("Agent attend kar raha: " + calls.dequeue());
        calls.enqueue("Neha");
        System.out.println("Agent attend kar raha: " + calls.dequeue());
        System.out.println("Agent attend kar raha: " + calls.dequeue());
        System.out.println("Agent attend kar raha: " + calls.dequeue());
        calls.dequeue();
    }
}
