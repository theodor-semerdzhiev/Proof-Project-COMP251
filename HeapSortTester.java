import java.util.Arrays;
import java.util.Random;

public class HeapSortTester {
    public static void main(String[] args) {
        Random rand = new Random();
        HeapSort sort = new HeapSort();

        int[] arr1 = new int[25];
        for (int i = arr1.length - 1; i > 0; i--) {
            arr1[arr1.length-i-1]=i;
        }
        System.out.println("CASE 1");
        System.out.println("BEFORE HEAPSORT: "+ Arrays.toString(arr1));
        sort.Heapsort(arr1);
        System.out.println("Passed: "+ isSorted(arr1));
        System.out.println("AFTER HEAPSORT: "+Arrays.toString(arr1));

        System.out.println("-------------------------------------------------------------------------------------------");

        int[] arr2 = new int[25];
        for (int i = 0; i < arr2.length; i++) {

            arr2[i]= rand.nextInt(arr2.length);
        }
        System.out.println("CASE 2");
        System.out.println("BEFORE HEAPSORT: "+Arrays.toString(arr2));
        sort.Heapsort(arr2);
        System.out.println("Passed: "+ isSorted(arr2));
        System.out.println("AFTER HEAPSORT: "+Arrays.toString(arr2));


        System.out.println("-------------------------------------------------------------------------------------------");


        int[] arr3 = new int[25];
        for (int i = 0; i < arr3.length; i++) {

            arr3[i]= rand.nextInt(arr3.length);
        }

        System.out.println("CASE 3");
        System.out.println("BEFORE HEAPSORT: "+Arrays.toString(arr3));
        sort.Heapsort(arr3);
        System.out.println("Passed: "+ isSorted(arr3));
        System.out.println("AFTER HEAPSORT: "+Arrays.toString(arr3));

        System.out.println("-------------------------------------------------------------------------------------------");

        int[] arr4 = new int[25];
        for(int i = 0; i < arr4.length; i++) {
            arr4[i]=0;
        }

        System.out.println("CASE 4");
        System.out.println("BEFORE HEAPSORT: "+Arrays.toString(arr4));
        sort.Heapsort(arr4);
        System.out.println("Passed: "+ isSorted(arr4));
        System.out.println("AFTER HEAPSORT: "+Arrays.toString(arr4));

        System.out.println("-------------------------------------------------------------------------------------------");


        int[] arr5 = new int[25];
        for(int i = 0; i < arr5.length; i++) {
            arr5[i]=i;
        }

        System.out.println("CASE 5");
        System.out.println("BEFORE HEAPSORT: "+Arrays.toString(arr5));
        sort.Heapsort(arr5);
        System.out.println("Passed: "+ isSorted(arr5));
        System.out.println("AFTER HEAPSORT: "+Arrays.toString(arr5));
    }
    static public boolean isSorted(int[] arr){
        for(int i=0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) return false;
        }
        return true;
    }
}
