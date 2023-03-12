import java.util.Arrays;

//code was sourced from https://www.geeksforgeeks.org/heap-sort/
public class HeapSort {
    /*
     * Sorts the given array using the HeapSort algorithm.
     *
     * Loop invariant: At the start of each iteration of the outer for loop, the subarray A[1..i]
     * is a maxheap containing the i smallest elements of A[1..i] and the subarray A[i+1..n] contains
     * the n-i largest elements of A[1..n], sorted in decreasing order.
     */
    public void Heapsort(int arr[]) {

        int N = arr.length;

        // Build a max heap of the ith smallest elements in the subarray A[1..i]
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
        }

        // Extract the i largest elements in the subarray A[i+1..n] and place them in their correct position
        for (int i = N - 1; i > 0; i--) {
            // Swap the root node with the last element in the heap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Maintain the maxheap property on the remaining elements in the subarray A[1..i-1]
            heapify(arr, i, 0);
        }
    }

    /*
     * Heapify the subtree rooted at index i in the given array
     *
     * arr: the array containing the subtree to be heapified
     * N: the size of the heap
     * i: the root index of the subtree
     */
    void heapify(int arr[], int N, int i) {

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // If the left child is larger than the root
        if (l < N && arr[l] > arr[largest]) {
            largest = l;
        }

        // If the right child is larger than the largest so far
        if (r < N && arr[r] > arr[largest]) {
            largest = r;
        }

        // If the largest is not the root
        if (largest != i) {
            // Swap the root node with the largest child
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, N, largest);
        }
    }

    public static void main(String args[])
    {
        int[] arr = {};
        int N = arr.length;

        // Function call
        HeapSort ob = new HeapSort();
        ob.Heapsort(arr);
        System.out.println(Arrays.toString(arr
        ));

    }
}
