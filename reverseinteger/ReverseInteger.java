package com.leetcode.reverseinteger;

//author: Derek Mandl
//Date: 3/17/2021
//https://leetcode.com/problems/reverse-integer/
//This solution uses precondition testing, and does not make use of 64-bit integers or any other data type such as BigInteger or ArrayList
public class ReverseInteger {
    public int reverse(int x){
        boolean negative;
        boolean overflowDanger = true;
        int num = x;

        if(x == Integer.MIN_VALUE) return 0;
        else if(x== Integer.MAX_VALUE) return 0;
        if (num < 0){
            negative = true;
            num = x * -1;
        }else if(num == 0) return 0;
        else negative = false;
        //if the number is less than 10 digits, then it is guaranteed to not overflow
        if(num < 1000000002) overflowDanger = false;

        //find out length of the number
        int temp = num, length = 0;
        while(temp >0){
            length++;
            temp /= 10;
        }

        //reverse the integer while precondition checking for overflow//
        //factor is the factor of the digit from the parameter to check for the precondition check
        //reverseFactor will control which digit to check against
        //maxComparison is the digit to check, and MAX is the maximum value allowed.
        //numComparison is the digit from the parameter to check
        //result is the integer to be returned
        int reverseFactor = 1;
        for(int i = 1; i < length; i++) reverseFactor *= 10; //same as (int)Math.pow(10, length -1)
        int factor = 10;
        //technically, a negative number should be compared to Integer.MAX_VALUE + 1, but this causes overflow and it won't actually matter
        int maxComparison = 0, MAX =Integer.MAX_VALUE;
        int numComparison = 0;
        int result = 0;
        for(int i = 0; i < length; i++){
            maxComparison = MAX / reverseFactor;
            numComparison = (num % factor) / (factor / 10);
            num -= num % factor;
            MAX -= maxComparison * reverseFactor;
            //overflow can only happen if the first numComparison >= first maxComparison digit. if it is greater, then overflow.
            //If it is lesser then it automatically passes no matter what the next digits are (so we don't need to check anymore)
            //If it is equal then the same condition trickles to the next digits.
            if(overflowDanger){
                if(numComparison > maxComparison){ return 0;}
                else if(numComparison < maxComparison){overflowDanger = false;}
                //and if numComparison = maxComparison, keep overflowDanger true but continue the loop;
            }
            //reverse the comparison digit onto the new integer
            result += numComparison * reverseFactor;
            //factor *= 10; this causes overflow for 10 digit numbers, reduce num instead
            num /= 10;
            reverseFactor /= 10;
        }//end for
        return (negative?result * -1 : result);
    }

    public static void main(String[] args){
        ReverseInteger solution = new ReverseInteger();
        int myInt = 12345932;
        int overflow = 1234567899;
        System.out.print(solution.reverse(myInt) + "\n" + solution.reverse(overflow));
        return;
    }
}
