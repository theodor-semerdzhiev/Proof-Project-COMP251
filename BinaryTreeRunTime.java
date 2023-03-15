import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class BinaryTreeRunTime {
    static Random rand = new Random();
    public static void main(String[] args) throws IOException {
        File out;
        PrintWriter writer;
        try{
            out = new File("BinTree_out.csv");
            writer = new PrintWriter("BinTree_out.csv", "UTF-8");
        } catch(Exception e) {
            System.out.println("Can't Fetch File");
            return;
        }

        //This might take a while to run depending on your computer
        for(int j=0; j<10000; j++) {

            BinaryTree tree = new BinaryTree();
            ArrayList<Integer> arr1 = new ArrayList<>();

            for(int i=1; i < 10*j; i++) {
                arr1.add(i);
            }

            //adds the numbers until the arraylist is empty
            while(arr1.size()!= 0) tree.root = tree.add_iterative(tree.root, arr1.remove(rand.nextInt(arr1.size())));
            //add one
            tree.root=tree.add_iterative(tree.root, 0);
            long operations;
            //static int count will count the number of operations performed
            tree.root= tree.deleteIterative(tree.root, 0);
            operations=tree.count;


            //write to cvs file
            writer.println(operations);
            //this is to see the progress of the program but its recommend to remove this line for faster performance
            System.out.println("Operations: "+ operations+" ite: "+j);
            tree.root=tree.add_iterative(tree.root, 0);

            //resets static field
            tree.count=0;

        }
        writer.close();
    }
}
