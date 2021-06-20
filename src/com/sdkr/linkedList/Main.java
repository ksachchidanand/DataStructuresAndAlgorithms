import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        System.out.println(list.getKthFromTheEnd(3));

        System.out.println(Arrays.toString(list.toArray()));

        // var newList = list.createWithLoop();
        // System.out.println(newList.hasLoop());

        // list.printMiddle();

    }
}
