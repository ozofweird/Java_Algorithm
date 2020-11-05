package org.example.linkedList;

public class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    public LinkedList() {
        header = new Node();
    }

    /* 데이터 삽입
    - 값을 가진 노드를 생성
    - Header를 시작점으로 할당
    - 가장 마지막 노드를 찾기 위해 반복
    - 가장 마지막 노드의 링크에 새로운 노드 주소를 추가
    */
    public void append(int data) {
        Node end = new Node();
        end.data = data;

        Node n = header;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    /* 데이터 삭제
    - Header를 시작점으로 할당
    - 가장 마지막 노드까지 반복
    - 현재 노드에서 다음 노드의 데이터가 찾고자 하는 데이터일 경우, 현재 노드의 링크에 다음 다음 노드의 주소로 설정
    - 현재 노드에서 다음 노드의 데이터가 찾고자 하는 데이터가 아닐 경우, 다음 노드로 이동
    */
    public void delete(int data) {
        Node n = header;

        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    /* 노드 출력 메서드
    - Header 다음 데이터를 할당
    - 가장 마지막 노드가 되기 전까지 반복하며 출력
    - 마지막 노드 출력
    */
    public void retrieve() {
        Node n = header.next;

        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }

    /* 중복 요소 삭제
    - Header를 시작점으로 할당
    - 가장 마지막 노드까지 반복
    - 현재 노드(n)를 r에 할당
    - r이 마지막 노드가 될 때까지 반복하며 현재 노드의 값이 r의 다음 데이터와 동일할 경우 삭제
    */
    public void removeDups() {
        Node n = header;

        while(n.next != null && n != null) {
            Node r = n;
            while(r.next != null) {
                if(n.data == r.next.data) r.next = r.next.next;
                else r = r.next;
            }
            n = n.next;
        }
    }

    /* 중간의 노드 삭제 (삭제할 노드 이전의 노드에 대한 정보가 없을 경우)
    - 삭제할 노드의 다음 노드로 덮어씌운다
    */
    public boolean deleteNode(Node n) {

        if(n == null || n.next == null) {
            return false;
        }

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}