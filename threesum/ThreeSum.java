package com.leetcode.threesum;
import java.util.*;


//author: Derek Mandl
// Date: 3/17/2020
//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        int[] sorted = nums; Arrays.sort(sorted);
        List<List<Integer>> result = new ArrayList<>();
        boolean repeat;
        for(int i = 0; i < sorted.length - 2; i++){
            for(int j = i + 1; j < sorted.length - 1; j++){
                for(int c = j + 1; c < sorted.length; c++){
                    //if the nums = 0 then check for dupicates and add the nums if no duplicate
                    if (sorted[i] + sorted[j] + sorted[c] == 0) {
                        repeat = false;
                        ArrayList<Integer> resultSet = new ArrayList<>(Arrays.asList(sorted[i], sorted[j], sorted[c]));
                        if(result.isEmpty()) result.add(resultSet);
                        else{
                            //since everything is sorted, we just check 1 by 1 each of the 3 elements for each arrayList already in the result list
                            for(int k = 0; k < result.size(); k++) {
                                if (result.get(k).get(0).equals(resultSet.get(0)) &&
                                        result.get(k).get(1).equals(resultSet.get(1)) &&
                                        result.get(k).get(2).equals(resultSet.get(2))) {
                                    repeat = true;
                                    break;
                                }
                            }
                            //if a repeat was found then don't add it to result set and continue looking
                            if(!repeat) result.add(resultSet);
                        }
                    }
                }
            }
        }
        return result;
    }
    //Aurhor of this solution: annibelli28 @ leetcode.com
    //Found here: https://leetcode.com/problems/3sum/discuss/1113198/Java-solution-O(N2)-with-detailed-explanation
    public List<List<Integer>> threeSum2(int[] nums){
        int[] sorted = nums; Arrays.sort(sorted);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < sorted.length; i++){
            while(i > 0 && sorted[i] == sorted[i - 1]) i++;
            int j = i + 1, k = sorted.length - 1;
            while(j < k){
                if(sorted[i] + sorted[j] + sorted[k] == 0) {
                    result.add(Arrays.asList(sorted[i], sorted[j], sorted[k]));
                    j++;
                    k--;
                    while (sorted[j] == sorted[j - 1]) j++;
                    while (sorted[k] == sorted[k - 1]) k++;
                }
                else if(sorted[i] + sorted[j] + sorted[k] > 0) k--;
                else j++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] myArray = {-1, 0, 2, 1, -3, -4, 4};
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> myList = solution.threeSum2(myArray);

        for(int i = 0; i < myList.size(); i++){
            System.out.print("Set " + i + ": \n");
            for(int j = 0; j < myList.get(i).size(); j++){
                System.out.print(myList.get(i).get(j) + "  ");
            }
            System.out.println();
        }
        return;
    }
}
