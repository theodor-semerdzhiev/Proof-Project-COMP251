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


        for(int j=0; j<5000; j++) {

            BinaryTree tree = new BinaryTree();
            ArrayList<Integer> arr1 = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();
            for(int i=1; i < 10*j; i++){
                arr1.add(i);
                arr2.add(i);
            }

            while(arr1.size()!= 0) tree.root = tree.add_iterative(tree.root, arr1.remove(rand.nextInt(arr1.size())));



            long startTime = System.nanoTime();
            for(int i=0; i < arr2.size(); i++) tree.root= tree.deleteIterative(tree.root, arr2.get(i));
            long endTime = System.nanoTime();

            writer.println(endTime-startTime);
            System.out.println("Runtime: "+ (endTime - startTime)+" ite: "+j);
            tree.root=tree.add_iterative(tree.root, 0);



        }
        writer.close();
    }
}
