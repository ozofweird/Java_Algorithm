package org.example.singlyLinkedList;

public class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }

    /* 데이터 삽입
    - 값을 가진 노드를 생성
    - 포인터 생성
    - 가장 마지막 노드를 찾기 위해 반복
    - 가장 마지막 노드의 링크에 새로운 노드 주소를 추가
    */
    public void append(int data) {
        Node end = new Node(data);
        Node n = this;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    /* 데이터 삭제 (첫 번째 노드 비교하지 않음)
    - 포인터 생성
    - 가장 마지막 노드까지 반복
    - 현재 노드에서 다음 노드의 데이터가 찾고자 하는 데이터일 경우, 현재 노드의 링크에 다음 다음 노드의 주소로 설정
    - 현재 노드에서 다음 노드의 데이터가 찾고자 하는 데이터가 아닐 경우, 다음 노드로 이동
    */
    public void delete(int data) {

        Node n = this;

        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    /* 노드 출력 메서드
    - 포인터 생성
    - 가장 마지막 노드가 되기 전까지 반복하며 출력
    - 마지막 노드 출력
    */
    public void retrieve() {

        Node n = this;
        while (n.next != null) {
            System.out.println("n.data : " + n.data);
            n = n.next;
        }
        System.out.println("n.data : " + n.data);
    }
}