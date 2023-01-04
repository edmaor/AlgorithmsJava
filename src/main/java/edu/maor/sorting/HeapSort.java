package edu.maor.sorting;

public class HeapSort {
    void heapifyMax(int[] nums, int len, int i) {
        int largest = i;
        int lc = 2 * i + 1; // Get left child
        int rc = 2 * i + 2; // Get right child
        if (lc < len && nums[lc] > nums[largest]) largest = lc;
        if (rc < len && nums[rc] > nums[largest]) largest = rc;
        // If largest is not root
        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            heapifyMax(nums, len, largest);
        }
    }
    public void sortMinMax(int[] nums){
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) heapifyMax(nums, len, i);
        for (int i = len - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapifyMax(nums, i, 0);
        }
    }
    public static void main(String[] args) {
        int[] nums = { 12, 11, 13, 5, 6, 7, 20, 12, 10, 16, 8 };
        HeapSort heapSort = new HeapSort();
        heapSort.sortMinMax(nums);

        System.out.println("Sorted array is");
        for(int n: nums) System.out.printf("%d ", n);
    }
}