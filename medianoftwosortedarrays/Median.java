package com.leetcode.medianoftwosortedarrays;

public class Median {
    public int[] sortedMerge(int[] num1, int[] num2){
        if(num1 == null) return num2;
        else if(num2 == null) return num1;

        int[] result = new int[num1.length + num2.length];
        int i = 0, j = 0, count = 0;
        while(count < result.length){
                result[count] = ((i >= num1.length || j >= num2.length) ?
                        (i >= num1.length ? num2[j++]: num1[i++]) :
                        (num1[i] < num2[j] ? num1[i++] : num2[j++]));
                count++;
        }
        return result;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = sortedMerge(nums1, nums2);
        if(temp.length % 2 == 1){
            return temp[temp.length / 2];
        } else{
            return ( (double)temp[temp.length / 2] + (double)temp[(temp.length / 2) - 1] ) / 2;
        }
    }
    public static void main(String[] args){
        int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 99, 100};
        int[] array2 = {-12, 0, 1, 2, 10243};
        Median solution = new Median();
        System.out.print(solution.findMedianSortedArrays(array1, array2));
    }
}
