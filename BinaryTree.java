
// Binary Tree in Java

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// Node creation
//source:https://www.programiz.com/dsa/binary-tree
class Node {
    Integer key; // data store in Node
    Node left, right; // pointers to children

    //constructor for Node Object
    public Node(int item) {
        key = item;
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree(int key) {
        root = new Node(key);
    }

    public BinaryTree() {
        root = null;
    }

    //will always return the current root of the BST
    public Node remove(Node root, int key) {
        if(root == null) {
            return null;
        } else if(key < root.key) {
            root.left = remove(root.left, key);
        } else if (key > root.key) {
            root.right = remove(root.right, key);
        } else if (root.left == null) {
            root = root.right;
        } else if (root.right == null) {
            root = root.left;
        } else {
            root.key = FindMin(root.right);
        }

        return root;
    }
    /*
        This function will return the minimum element of the BST.
        Essentially this function recursively iterate down every left child
        until it finds a node that does not have a left child, it will then return that Node.
     */
    public Integer FindMin(Node root) {
        //edge case if the tree is empty
        if(root == null) return null;
        //Base Case
        if(root.left == null) return root.key;
        //recusive call
        return FindMin(root.left);
    }
    /*
       This function will return the new root of the BST.
       Essentially this function recursively iterate down the Binary Search Tree, comparing keys in order to know which child to go down.
       It will continue this process until it finds an empty child, in which case will create a new Node object and insert it the Binary Search Tree.
    */
    public Node add(Node root, int key) {
        //Base Case;
        if(root == null) {
            root = new Node(key);
        } else if(root.key < key) { // key must be inserted in right SubTree
            add(root.right, key);
        } else if (root.key > key) { // key must be inserted in left SubTree
            add(root.left, key);
        }
        return root;
    }

    public static void BST(ArrayList<Integer> arr, Node root) {
        if(root == null) {
            return;
        }

        BST(arr,root.left);
        arr.add(root.key);
        System.out.print(root.key+" ");
        BST(arr, root.right);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i =0; i < 10; i++) arr.add(i);
        Collections.shuffle(arr);
        System.out.println(arr.toString());

        BinaryTree tree = new BinaryTree();
        for(Integer i: arr) {
            tree.add(tree.root, i);
        }
        ArrayList<Integer> arr1 = new ArrayList<>();
        BST(arr1, tree.root);
        System.out.println(arr1.toString());


    }


}