// SCENARIO: Compiler/Calculator me brackets balanced hain ya nahi check karna.
// "{[()]}" sahi hai, "{[(])}" galat. Stack linked list se bana hai.
public class StackLinkedList {
    static class Node {
        char ch; Node next;
        Node(char c) { ch = c; }
    }
    private Node top;

    void push(char c) { Node n = new Node(c); n.next = top; top = n; }
    char pop() { char c = top.ch; top = top.next; return c; }
    boolean isEmpty() { return top == null; }

    static boolean isBalanced(String s) {
        StackLinkedList st = new StackLinkedList();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') st.push(c);
            else if (c == ')' || c == ']' || c == '}') {
                if (st.isEmpty()) return false;
                char o = st.pop();
                if ((c == ')' && o != '(') || (c == ']' && o != '[') || (c == '}' && o != '{')) return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = {"{[()]}", "{[(])}", "((a+b)*c", "[(a+b)*{c-d}]"};
        for (String t : tests)
            System.out.println(t + " -> " + (isBalanced(t) ? "Balanced" : "Not Balanced"));
    }
}
