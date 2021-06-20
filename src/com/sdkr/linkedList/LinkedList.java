import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int value) {
        var newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }

        ++size;
    }

    public void addLast(int value) {
        var newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        
        ++size;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        
        if (first == last) {
            first = last = null;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        --size;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException(); 
        
        if (first == last) {
            first = last = null;
        } else {
            last = getPrevious(last);
            last.next = null;
        }

        --size;
    }

    private Node getPrevious(Node current) {
        Node previous = first;
        while (previous != null){
            if (previous.next == current)
                return previous;
            previous = previous.next;
        }

        return null;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        var current = first;
        int index = 0;
        while (current != null) {
            if (current.value == value)
                return index;
            ++index;
            current = current.next;
        }

        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        var list = "[ ";
        var start = first;
        while (start != null) {
            list += start.value + " ";
            start = start.next;
        }
        return list + "]";
    }

    public int[] toArray() {
        var array = new int[size];
        int index = 0;
        var current = first;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isEmpty())
            return;
        
        var previous = first;
        var current = first.next;
        
        while(current != null) {
            var next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        last = first;
        first = previous;
        last.next = null;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var current = first;
        var end = first;
        
        for (int i=0; i<k-1; i++) {
            end = end.next;
            if (end == null)
                throw new IllegalArgumentException();
        }

        while (end != last) {
            current = current.next;
            end = end.next;
        }

        return current.value;
    }

    public void printMiddle() {
        if (first == null)
            return;

        var slow = first;
        var fast = first;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next == null) {
            System.out.println(slow.value);
        } else {
            System.out.println(slow.value + " " + slow.next.value);
        }
    }

    public LinkedList createWithLoop() {
        var list = new LinkedList();

        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        var cycle = list.last;
        list.addLast(40);
        list.addLast(50);
        last.next = cycle;

        return list;
    }

    public boolean hasLoop() {
        var slow = first;
        var fast = first;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
