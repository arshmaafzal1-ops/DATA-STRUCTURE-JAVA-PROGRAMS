// SCENARIO: Music playlist. Songs add, delete aur display karne hain.
public class LinkedListDemo {
    static class Node {
        String song; Node next;
        Node(String s) { song = s; }
    }
    Node head;

    void addSong(String s) {            // end me add
        Node n = new Node(s);
        if (head == null) { head = n; return; }
        Node t = head;
        while (t.next != null) t = t.next;
        t.next = n;
    }
    void deleteSong(String s) {
        if (head == null) return;
        if (head.song.equals(s)) { head = head.next; return; }
        Node t = head;
        while (t.next != null && !t.next.song.equals(s)) t = t.next;
        if (t.next != null) t.next = t.next.next;
        else System.out.println(s + " playlist me nahi hai");
    }
    void display() {
        for (Node t = head; t != null; t = t.next) System.out.print(t.song + " -> ");
        System.out.println("END");
    }

    public static void main(String[] args) {
        LinkedListDemo playlist = new LinkedListDemo();
        playlist.addSong("Kesariya");
        playlist.addSong("Apna Bana Le");
        playlist.addSong("Tum Hi Ho");
        playlist.display();
        playlist.deleteSong("Apna Bana Le");
        playlist.display();
        playlist.deleteSong("Unknown");
    }
}
