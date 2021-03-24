package com.leetcode.longestpalindromicsubstring;

//Author: Derek Mandl
//Date: 3/24/2021
//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPanindrome {
    /* My first attempt, this method is bugged.  However, it also fails on a conceptual level.  It will miss even palindromes
    such as "abba" while only catching odd palindromes such as "aba".  Therefore it is not worth debugging, but I still wanted
    to keep it here for archival purposes.
    public String longestPalindrome(String s) {
        int index1= 0, index2 = 0, currentIndex1 = 0, currentIndex2 = 0;
        for(int i = 0; i < s.length(); i++){
            currentIndex1 = i; currentIndex2 = i;
            while((currentIndex1 >= 0 && currentIndex2 < s.length()) && s.charAt(currentIndex1) == s.charAt(currentIndex2)){
                if(currentIndex2 - currentIndex1 > index2 - index1) index1 = currentIndex1; index2 = currentIndex2;
                currentIndex1--; currentIndex2++;
            }
        }
        return s.substring(index1, index2 + 1);
    }*/

    //Attempt 2: This one is called the pincer technique.  It identifies pairs of matching chars,
    //and because we tackle the largest-gap pairs first, we can just return the palindrome as substring right away.
    public String longestPalindrome(String s){
        int p1 = 0, p2 = 1, difference = s.length() -1;
        while(p1 < p2){
            p1 = 0; p2 = difference;
            while(p2 < s.length()){
                if(isPalindrome(s.substring(p1, p2 + 1))) return s.substring(p1, p2 + 1);
                p1++; p2++;
            }
            difference--;
        }
        return "error";
    }
    //precondition: string s is a string of size n; n > 0
    //postcondition: if s is a palindrome, then true is returned.  Otherwise false.
    //this is O(n) since we execute n/2 statements in the worst case
    public boolean isPalindrome(String s){
        int p1 = 0, p2 = s.length() - 1;
        while(p1 < p2){
            if(s.charAt(p1) != s.charAt(p2)) return false;
            p1++; p2--;
        }
        return true;
    }
    public static void main (String[] args){
        LongestPanindrome solution = new LongestPanindrome();
        String myString = "Some of the longest known palindromes include: " +
                "1. rotovator: A machine with rotating blades that tills soil, " +
                "2. malayalam: A dravidian language, " +
                "3. detartrated: Having removed tartrates, " +
                "4. sattarrattat: The sound made by knocking on a door, " +
                "5. saippuakivikauppias: Soapstone vendor, " +
                "6, a man a plan a canal panama, " +
                "7. sir i demand i am a maid named iris, " +
                "8. dammit im mad, " +
                "9. satire veritas, " +
                "10, dr awkward, " +
                "11. olson in olso, ";

        //if you want the program to be able to match sentences like the above, you must strip whitespace, or curtail the palindrome matching algo
        //to ignore it.  The latter is better so that you can still print the substring and get the sentence with whitespace.
        //The problem states that the string shall not contain whitespace, but if you wanted to use this for such a purpose, the modification would be easy.
        System.out.print(solution.longestPalindrome(myString));
    }
}
