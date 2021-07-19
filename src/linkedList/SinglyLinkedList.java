package linkedList;

public class SinglyLinkedList {
    private Node head;

    private class Node {
        int item;
        Node next;

        private Node(int item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node=" + item;
        }
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if (head == null)
            head = node;
        else {
            node.next = head;
            head = node;
        }
    }

    public void addLast(int item) {
        var node = new Node(item);
        var curr = head;
        if (head == null)
            head = node;
        else {
            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = node;
        }
    }

    public int deleteFirst() {
        if (head == null)
            throw new IllegalArgumentException();

        var iterator = head;
        head = head.next;
        iterator.next = null;
        return iterator.item;
    }

    public int deleteLast() {
        if (head == null)
            throw new IllegalArgumentException();

        var current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
        return current.item;
    }

    public void add(int index) {

    }

    public int indexOf(int item) {
        int index = 0;
        var current = head;

        while (current != null) {
            if (current.item == item)
                return index;
            index++;
            current = current.next;
        }

        return -1;
    }

    public String printRecursive() {
        var list = new StringBuilder();
        list.append("[ ");
        printRecursive(head, list);
        return list.toString();
    }

    private void printRecursive(Node head, StringBuilder list) {
        if (head == null)
            return;

        if (head.next != null)
            list.append(head.item).append(", ");
        else
            list.append(head.item).append(" ]");

        printRecursive(head.next, list);
    }

    @Override
    public String toString() {
        var iterator = head;
        var list = new StringBuilder();
        list.append("[ ");
        while (iterator != null) {
            if (iterator.next != null)
                list.append(iterator.item).append(", ");
            else
                list.append(iterator.item).append(" ");
            iterator = iterator.next;
        }

        list.append("]");

        return list.toString();
    }

    public static void main(String[] args) {
        var list = new SinglyLinkedList();
        // list.add(3);
        // list.add(2);
        // list.add(1);
        list.addLast(4);
        // list.addLast(5);
        System.out.println(list.printRecursive());
    }
}
