// SCENARIO: Text editor ka UNDO feature. Har change stack me push hota hai,
// Undo dabane par last change pop hota hai (LIFO).
public class StackArray {
    private String[] data;
    private int top = -1;

    StackArray(int size) { data = new String[size]; }

    void push(String s) {
        if (top == data.length - 1) { System.out.println("Stack full!"); return; }
        data[++top] = s;
    }
    String pop() {
        if (top == -1) { System.out.println("Kuch undo karne ko nahi hai"); return null; }
        return data[top--];
    }
    String peek() { return top == -1 ? null : data[top]; }

    public static void main(String[] args) {
        StackArray undo = new StackArray(5);
        undo.push("Type: Hello");
        undo.push("Type: World");
        undo.push("Bold: World");
        System.out.println("Current action: " + undo.peek());
        System.out.println("Undo -> " + undo.pop());
        System.out.println("Undo -> " + undo.pop());
        System.out.println("Undo -> " + undo.pop());
        undo.pop(); // empty
    }
}
