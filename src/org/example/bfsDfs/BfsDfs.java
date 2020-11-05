package org.example.bfsDfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked; // 스택에 추가가 되었는지에 대한 여부

        public Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    // 노드를 저장할 배열
    private Node[] nodes;

    // 노드 개수 고정으로 배열방 생성
    public Graph(int size) {
        nodes = new Node[size];
        for(int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    // 두 노드의 관계를 저장하는 메서드
    public void addEdge(int i1, int i2) {
        Node n1 = nodes[i1]; // 파라미터의 값이 인덱스의 값과 동일
        Node n2 = nodes[i2];

        if(!n1.adjacent.contains(n2)) n1.adjacent.add(n2);
        if(!n2.adjacent.contains(n1)) n2.adjacent.add(n1);
    }

    // dfs가 인자값 없이 호출되면 0번 부터 호출
    public void dfs() {
        dfs(0);
    }

    public void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for(Node n : r.adjacent) { // 가져온 노드의 자식을 스택에 추가
                if(n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    // bfs가 인자값 없이 호출되면 0번 부터 호출
    public void bfs() {
        bfs(0);
    }

    public void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.marked = true;

        while(!queue.isEmpty()) {
            Node r = queue.poll();
            for(Node n : r.adjacent) {
                if(n.marked == false) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r);
        }
    }

    public void dfsR() {
        dfsR(0);
    }

    // 재귀 호출을 이용한 dfs
    public void dfsR(Node r) {
        if(r == null) return;
        r.marked = true;
        visit(r);
        for(Node n : r.adjacent) {
            if(n.marked == false) dfsR(n);
        }
    }

    // 시작 노드를 다양하게 테스트하기 위해 배열 방의 인덱스를 받는 메서드
    public void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    public void visit(Node n) {
        System.out.print(n.data + " - ");
    }
}
/*
0
|
1 -- 3 - 5 -- 7
|  / |   |
2 -- 4   6 -- 8
*/
public class BfsDfs {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

//        g.dfs();
        g.dfsR();
//        g.bfs();
    }
}
