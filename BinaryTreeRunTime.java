import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int j=1; j<100; j++) {

            for (int i = 0; i < j*100000; i++) {
                arr1.add(i);
            }

            BinaryTree tree = new BinaryTree();

            while(arr1.size() != 0) {
                int num=arr1.remove(rand.nextInt(arr1.size()));
                tree.root = tree.add_iterative(tree.root, num);
            }

            long startTime = System.nanoTime();
            tree.root = tree.deleteIterative(tree.root, 1);
            long endTime = System.nanoTime();

            long runtime=endTime-startTime;


            writer.println(runtime);
            System.out.println("Runtime: "+ (endTime - startTime)+" ite: "+j);

        }
        writer.close();
    }
}
