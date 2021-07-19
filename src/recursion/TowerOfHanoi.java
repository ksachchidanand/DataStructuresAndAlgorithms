package recursion;

public class TowerOfHanoi {
    public void recursive(int n) {
        String start = "START";
        String temp = "TEMP";
        String end = "END";

        recursive(n, start, temp, end);
    }

    private void recursive(int n, String start, String temp, String end) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + start + " to " + end);
            return;
        }

        recursive(n - 1, start, end, temp);
        System.out.println("Move disk " + n + " from " + start + " to " + end);
        recursive(n - 1, temp, start, end);
    }
}
