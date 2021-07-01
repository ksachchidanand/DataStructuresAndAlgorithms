package test.dynamicProgamming;

public class Fibonacci {
    public static void main(String[] args) {
        var fibonnaci = new dynamicProgramming.Fibonacci();

        int n = 10;

        System.out.println(fibonnaci.recursive(n));
        System.out.println(fibonnaci.topDown(n));
        System.out.println(fibonnaci.bottomUp(n));
        System.out.println(fibonnaci.bottomUpSpaceOptimizer(n));
    }
}
