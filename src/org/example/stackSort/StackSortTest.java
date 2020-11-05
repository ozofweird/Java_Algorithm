package org.example.stackSort;

import org.example.stack.Stack;

public class StackSortTest {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(5);
        s1.push(1);
        s1.push(6);

        StackSort.sort(s1);
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
    }
}
