//author: Derek Mandl
//Date: 3/15/2021
//https://leetcode.com/problems/add-two-numbers/
package com.leetcode.addtwonumbers;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i1 = l1, i2 = l2; //iterators
        ListNode result = new ListNode();
        ListNode ri = result; //iterator for result list

        //perform addition
        int sum = 0, carry = 0, val = 0;
        while(i1 != null && i2 != null){
            sum = i1.val + i2.val + ri.val;
            val = sum % 10;
            carry = sum / 10;
            ri.val = val;
            //determines whether a new list item is needed
            if((i1.next!= null || i2.next != null) || carry != 0) {
                ri.next = new ListNode();
                ri = ri.next;
                if(carry != 0) {
                    ri.val = carry;
                }
            }
            i1= i1.next; i2 = i2.next;
        }

        if(i1 != null){
            //if i1 is not finished, copy it to the new list
            while(i1 != null){
                sum = i1.val + ri.val;
                val = sum % 10;
                carry = sum / 10;
                ri.val = val;
                if(i1.next != null || carry != 0) {
                    ri.next = new ListNode();
                    ri = ri.next;
                    if(carry != 0) ri.val = carry;
                }
                i1 = i1.next;
            }
        }else if (i2 != null){
            //if i2 is not finished, copy it to the new list
            while(i2 != null){
                sum = i2.val + ri.val;
                val = sum % 10;
                carry = sum / 10;
                ri.val = val;
                if(i2.next != null || carry != 0) {
                    ri.next = new ListNode();
                    ri = ri.next;
                    if(carry != 0) ri.val = carry;
                }
                i2 = i2.next;
            }
        }

        return result;
    }
    public static void main(String[] args){
        //ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l3 = new ListNode(3, new ListNode(7));
        ListNode l4 = new ListNode(9, new ListNode(2));
        AddTwoNumbers mySolution = new AddTwoNumbers();
        ListNode answer = mySolution.addTwoNumbers(l3, l4);
        ListNode p1 = answer;
        while(p1 != null) {
            System.out.print(p1.val);
            p1 = p1.next;
        }
        return;
    }
}
