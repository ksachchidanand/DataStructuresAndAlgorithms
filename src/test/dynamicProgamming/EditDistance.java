package test.dynamicProgamming;

import io.FastReader;

public class EditDistance {
    public static void main(String[] args) {
        var reader = new FastReader();
        String s1 = reader.next();
        String s2 = reader.next();

        var editDistance = new dynamicProgramming.EditDistance();
        System.out.println(editDistance.recursive(s1, s2));
        System.out.println(editDistance.topDown(s1, s2));
        System.out.println(editDistance.bottomUp(s1, s2));
    }
}
