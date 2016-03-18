/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.addtwonumbers;

import leetcode.utils.PrintUtils;

/**
 *
 * @author DQ
 */
public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        ListNode ll1 = new ListNode(9);
        ll1.next = new ListNode(8);
        ListNode ll2 = new ListNode(1);

        PrintUtils.printListNode(addTwoNumbersBySigLoop(l1, l2));
        PrintUtils.printListNode(addTwoNumbersBySigLoop(ll1, ll2));
        PrintUtils.printListNode(addTwoNumbersByShortLoop(l1, l2));
        PrintUtils.printListNode(addTwoNumbersByShortLoop(ll1, ll2));
    }

    /**
     * 循环链表，位数相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersBySigLoop(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode list = null;
        ListNode next = null;
        int sum = 0;
        int b = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += b;
            if (sum > 9) {
                sum -= 10;
                b = 1;
            } else {
                b = 0;
            }
            if (list == null) {
                list = new ListNode(sum);
                next = list;
            } else {
                next.next = new ListNode(sum);
                next = next.next;
            }
            sum = 0;
        }
        if (b == 1) {
            next.next = new ListNode(b);
        }
        return list;
    }

    /**
     * 只循环较短链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersByShortLoop(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode list = null;
        ListNode next = null;
        ListNode cl1 = l1.next;
        ListNode cl2 = l2.next;
        while (true) {
            if (cl1 == null) {
                cl1 = l1;
                cl2 = l2;
                break;
            } else if (cl2 == null) {
                cl1 = l2;
                cl2 = l1;
                break;
            } else {
                cl1 = cl1.next;
                cl2 = cl2.next;
            }
        }

        int sum = 0;
        int b = 0;
        while (cl1 != null) {
            sum = cl1.val + cl2.val + b;
            cl1 = cl1.next;
            cl2 = cl2.next;

            if (sum > 9) {
                sum -= 10;
                b = 1;
            } else {
                b = 0;
            }

            if (list == null) {
                list = new ListNode(sum);
                next = list;
            } else {
                next.next = new ListNode(sum);
                next = next.next;
            }

            sum = 0;
        }

        next.next = cl2;
        while (b == 1) {
            if (cl2 == null) {
                next.next = new ListNode(b);
                break;
            }
            sum = cl2.val + b;
            if (sum > 9) {
                sum -= 10;
                b = 1;
            } else {
                b = 0;
            }
            cl2.val = sum;
            cl2 = cl2.next;
            next = next.next;
        }
        return list;
    }
}
