package edu.maor;

public class HeapSort {
    void heapifyMax(int[] arr, int len, int i) {
        int largest = i;
        int lc = 2 * i + 1; // Get left child
        int rc = 2 * i + 2; // Get right child

        if (lc < len && arr[lc] > arr[largest]) largest = lc;
        if (rc < len && arr[rc] > arr[largest]) largest = rc;
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected subtree
            heapifyMax(arr, len, largest);
        }
    }

    public void sortMinMax(int[] nums){
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) heapifyMax(nums, len, i);

        for (int i = len - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // call heapifyMax on the reduced heap
            heapifyMax(nums, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 12, 11, 13, 5, 6, 7, 20, 12, 10, 16, 8 };
        HeapSort ob = new HeapSort();
        ob.sortMinMax(nums);

        System.out.println("Sorted array is");
        for(int n: nums) System.out.printf("%d ", n);
    }
}
