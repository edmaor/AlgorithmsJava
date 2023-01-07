package edu.maor.sorting;

public class MergeSort {
    private void merge(int[] nums, int left, int mid, int right){
        int[] numsL = new int[mid - left + 1];
        int[] numsR = new int[right - mid];
        for(int i=0; i < numsL.length; i++) numsL[i] = nums[left + i];
        for(int i=0; i < numsR.length; i++) numsR[i] = nums[mid + i + 1];

        int i = 0, j = 0, k =left;
        while (i < numsL.length && j < numsR.length){
            if (numsL[i] <= numsR[j]) {
                nums[k] = numsL[i];
                i++;
            } else {
                nums[k] = numsR[j];
                j++;
            }
            k++;
        }
        while (i < numsL.length) {
            nums[k] = numsL[i];
            i++;
            k++;
        }
        while (j < numsR.length) {
            nums[k] = numsR[j];
            j++;
            k++;
        }
    }
    public void sort(int[] nums, int left, int right){
        if (left < right){
            int mid = (left + right)/2;
            sort(nums, left, mid);
            sort(nums, mid+1, right);
            merge(nums, left, mid, right);
        }

    }

    public static void main(String[] args) {
        int[] nums = { 12, 11, 13, 5, 6, 7, 20, 12, 10, 16, 8 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums, 0, nums.length-1);

        System.out.println("Sorted array is");
        for(int n: nums) System.out.printf("%d ", n);
    }
}
