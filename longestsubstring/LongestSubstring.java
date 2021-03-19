package com.leetcode.longestsubstring;

//author: Derek Mandl
//3/18/2020
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {
    //bruteforce technique, my first attempt
    public int lengthOfLongestSubstring(String s) {
        int result = 0, temp = 1;
        if(s.length() == 1) return 1;
        for(int i = 1; i < s.length(); i++){
            if(s.substring(i - temp, i).contains(Character.toString(s.charAt(i)))){i = (i - temp) + 1; temp = 1;}
            else{temp++;}
            if(temp > result) result = temp;
        }
        return result;
    }
    //sliding window technique, my second attempt
    public int lengthOfLongestSubstring2(String s){
        int i = 0, j = 1, temp = 1, result = 0;
        if(s.equals("")) return 0;
        if(s.length() == 1) return 1;
        do{
            if(s.substring(i, j).contains(Character.toString(s.charAt(j)))) { i++; }
            else { temp = j - i + 1; j++;}
            if (temp > result) result = temp;
        }while(j < s.length());
        return result;
    }
    public static void main(String[] args){
        String myString = "enter test string here";
        LongestSubstring solution = new LongestSubstring();
        System.out.println(solution.lengthOfLongestSubstring2(myString));
    }
}
