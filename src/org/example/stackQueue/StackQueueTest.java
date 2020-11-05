package org.example.stackQueue;

public class StackQueueTest {
    public static void main(String[] args) {
        StackQueue<Integer> q = new StackQueue<>();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
