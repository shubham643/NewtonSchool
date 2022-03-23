// https://1drv.ms/u/s!ApNLaUHTgtzbkHUcZGXl_OrBMG33?e=oyrLdm

// Heap - min heap, max heap
// Properties
// 1. complete
// 2. left aligned
// 3. min/max heap (parent > child for max, parent < child for min)
// represent it in array form, left child = 2i+1, right = 2i+2, parent = (i-1)/2

// main operation is heapify
public class MaxHeap {

    private static void heapify(int[] a, int i, int heap_size) { // O(logn)

        int left_child = 2*i+1;
        int right_child = 2*i+2;

        int largest_index = i;
        // compare parent with left child
        if (left_child < heap_size && a[left_child] > a[i]) { // in min heap, change condition here
            largest_index = left_child;
        }
        if (right_child < heap_size && a[right_child] > a[largest_index]) { // in min heap, change condition here
            largest_index = right_child;
        }
        if (largest_index != i) {
            // do the swapping
            int temp = a[i];
            a[i] = a[largest_index];
            a[largest_index] = temp;
            // call recursively
            heapify(a, largest_index, heap_size);
        }
    }

    public static void buildHeap(int[] a) { // looks like O(nlogn), actually it is O(n)
        int n = a.length;

        for(int i = n-1; i >=0; i--) {
            heapify(a, i, n);
        }
    }

    public static void printHeap(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    public static void heapSort(int[] a) {
        // 1. build heap
        // 2. swap first and last element of heap
        // 3. remove last element from heap
        // 4. heapify for 0th index
        // 5. repeat 2-4th step till all elements are processed
        buildHeap(a); // O(n)
        int n = a.length;
        for(int heap_size = n; heap_size>0; heap_size--) { // O(nlogn)
            // swap
            int temp = a[0];
            a[0] = a[heap_size-1];
            a[heap_size-1] = temp;
            // swapping between first and last element done
            heapify(a, 0, heap_size-1);
        }
    }

    public static void main(String[] args) {
        int[] a = {5,8,1,0,2,3,9,6};
//        buildHeap(a);
//        printHeap(a);
        heapSort(a); // O(nlogn) same as merge sort
        printHeap(a);
    }
}
