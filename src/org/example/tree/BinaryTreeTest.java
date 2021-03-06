package org.example.tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);

        t.setRoot(n1);
        t.inorder(t.getRoot());
        System.out.println();

        t.preorder(t.getRoot());
        System.out.println();

        t.postorder(t.getRoot());
    }
}
