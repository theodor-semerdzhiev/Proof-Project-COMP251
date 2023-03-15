import javax.management.relation.RelationNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Random;

public class HeapSortRunTime {

    //this program might take a decent while to run depending on your computer
    public static void main(String args[]) {

        File out;
        PrintWriter writer;
        try{
            out = new File("HeapSort_out.csv");
            writer = new PrintWriter("HeapSort_out.csv", "UTF-8");
        } catch(Exception e) {
            System.out.println("Can't Fetch File");
            return;
        }

        HeapSort sort = new HeapSort();
        Random rand = new Random();
        for(int i=1 ; i < 10000; i++) {
            int[] arr = new int[i*100];
            for(int j=0; j < arr.length; j++) arr[j]=rand.nextInt();

            long start = System.nanoTime();
            sort.Heapsort(arr);
            long end = System.nanoTime();

            writer.println(end-start);
            System.out.println("Runtime: "+(end-start)+" ms, Ite: "+ i);
        }

        writer.close();
    }
}
