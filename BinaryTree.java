import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

// source:https://www.programiz.com/dsa/binary-tree

class BinaryTree {

    //the root of the Binary Search Tree
    Node root;
    //creates a Binary Tree object with a  non-null root
    public BinaryTree(int key) {
        root = new Node(key);
    }
    //create a Binary Tree object with an null root
    public BinaryTree() {
        root = null;
    }

    /*
       This function will return the new (or current) root of the Binary Search Tree.
       Essentially this function recursively iterates tree in order to locate the node in question,
       it will then remove that node from the tree by performing the proper operations for the specific case
    */
    public Node remove(Node root, int key) {
        // Check if the root is null (i.e., tree is empty)
        if(root == null) {
            return null;
        }
        // If the key to be removed is less than the root key, go left
        else if(key < root.key) {
            root.left = remove(root.left, key);
        }
        // If the key to be removed is greater than the root key, go right
        else if (key > root.key) {
            root.right = remove(root.right, key);
        }
        // If the node to be removed has no left child, set its right child as the new root
        else if (root.left == null) {
            root = root.right;
        }
        // If the node to be removed has no right child, set its left child as the new root
        else if (root.right == null) {
            root = root.left;
        }
        // If the node to be removed has both left and right children,
        // find the minimum value in the right subtree and use that as the new root
        else {
            root.key = FindMin(root.right);
        }
        // Return the updated root node
        return root;
    }
    /*
        This function will return the minimum element of the BST.
        This function recursively iterates down every left child
        until it finds a node that does not have a left child, it will then return that Node.
     */
    public Integer FindMin(Node root) {
        //edge case if the tree is empty
        if(this.root == null) return root.key;
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
        if(root == null) { // Base Case
            root = new Node(key);
        } else if(root.key < key) { // key must be inserted in right SubTree
            root.right=add(root.right, key);
        } else if (root.key > key) { // key must be inserted in left SubTree
            root.left=add(root.left, key);
        }
        return root;
    }

    /*
    *   Here we have the iterative implementations
    *   The iterative implementations for add() and remove() will be used for runtime Testing to prevent StackOverFlow errors
    * */

    //Code was adapted from https://www.geeksforgeeks.org/binary-search-tree-set-3-iterative-delete/

    /*
      This function will return the new (or current) root of the Binary Search Tree.
      Essentially this function iterates down tree in order to locate the proper position for the node we want to add,
      it will then add that node to tree using the proper operations
   */
    public Node add_iterative(Node root, int key)
    {
        // If the root is null, create a new node with the given key and set it as the root
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Create a new node with the given key
        Node newnode = new Node(key);

        // Traverse the tree to find the correct location to insert the new node
        Node x = root;
        Node y = null;

        while (x != null) {
            y = x;
            if (key < x.key) x = x.left; // If the key is less than the current node's key, move to its left child
            else x = x.right; // If the key is greater than or equal to the current node's key, move to its right child
        }

        // Set the parent of the new node to y
        if (key < y.key) y.left = newnode; // If the key is less than y's key, set the new node as its left child
        else y.right = newnode; // If the key is greater than or equal to y's key, set the new node as its right child

        // Return the updated root node
        return root;
    }


    //this code was adapted from GeeksForGeeks Article: Binary Search Tree | Set 3 (Iterative Delete)
    //https://www.geeksforgeeks.org/binary-search-tree-set-3-iterative-delete/
    /*
   This function will return the new (or current) root of the Binary Search Tree.
   Essentially this function iterates down tree in order to locate the proper position for the node we want to remove,
   it will then remove that node from the tree using the proper operations depending on the case
   */
    public Node deleteIterative(Node root, int key)
    {
        // Initialize current node and its parent
        Node curr = root;
        Node prev = null;
        // Traverse the tree to find the node to be deleted
        while (curr != null && curr.key != key) {
            prev = curr;
            if (key < curr.key) curr = curr.left; // Move to the left subtree if key is less than current node's key
            else curr = curr.right; // Move to the right subtree if key is greater than or equal to current node's key
        }
        // If the node to be deleted is not found, return the original tree
        if (curr == null) return root;

        // If the node has only one child or no children, remove it from the tree
        if (curr.left == null || curr.right == null) {
            Node newCurr;

            if (curr.left == null) newCurr = curr.right; // Set the new current node to the right child if the left child is null
            else newCurr = curr.left; // Set the new current node to the left child if the right child is null

            if (prev == null) return newCurr; // If the node to be deleted is the root, return the new current node

            if (curr == prev.left) prev.left = newCurr; // Update the parent's left child if the current node is the left child
            else prev.right = newCurr; // Update the parent's right child if the current node is the right child
        }
        // If the node has both children, find the minimum value in the right subtree and replace the current node with it
        else {
            Node p = null;
            Node temp;

            temp = curr.right; // Set temp to the right child of the current node
            while (temp.left != null) { // Traverse down the left subtree of the right child to find the minimum value
                p = temp;
                temp = temp.left;
            }
            if (p != null) p.left = temp.right; // Update the parent's left child if the minimum value node has a right child
            else curr.right = temp.right; // Update the current node's right child if the minimum value node has no left child

            curr.key = temp.key; // Replace the current node's key with the minimum value node's key
        }
        // Return the updated root node
        return root;
    }



    //for testing purposes
    public void BST(Node root) {
        if(root == null) return;

        BST(root.left);
        System.out.print(root.key+" ");
        BST(root.right);
    }
}