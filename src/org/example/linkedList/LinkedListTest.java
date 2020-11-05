package org.example.linkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        // 첫 번째 데이터 삭제 가능
        ll.delete(1);
        ll.retrieve();

        // 중복된 요소 추가 및 제거
        ll.append(3);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();
    }
}
