package edu.maor;

public class HeapSort {
    void heapify(int[] arr, int len, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // Get left child
        int r = 2 * i + 2; // Get right child

        if (l < len && arr[l] > arr[largest]) largest = l;
        if (r < len && arr[r] > arr[largest]) largest = r;
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected subtree
            heapify(arr, len, largest);
        }
    }

    public void sort(int[] nums){
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) heapify(nums, len, i);

        for (int i = len - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 12, 11, 13, 5, 6, 7, 20, 12, 10, 16, 8 };
        // Function call
        HeapSort ob = new HeapSort();
        ob.sort(nums);

        System.out.println("Sorted array is");
        for(int n: nums) System.out.printf("%d ", n);
    }
}
