package edu.maor.sorting;

public class QuickSort {
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private int partition(int[] nums, int left, int right){
        int low = left-1;
        for (int i = left; i <= right-1; i++) {
            if (nums[i] < nums[right]){
                low++;
                swap(nums, low, i);
            }
        }
        swap(nums,low+1, right);
        return low+1;
    }
    public void sort(int[] nums, int leftIndex, int rightIndex){
        if (leftIndex < rightIndex){
            int partitionIndex = partition(nums, leftIndex, rightIndex);
            sort(nums, leftIndex, partitionIndex-1);
            sort(nums,partitionIndex+1, rightIndex);
        }
    }
    public static void main(String[] args) {
        int[] nums = { 12, 11, 13, 5, 6, 7, 20, 12, 10, 16, 8 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums, 0, nums.length-1);

        System.out.println("Sorted array is");
        for(int n: nums) System.out.printf("%d ", n);
    }
}