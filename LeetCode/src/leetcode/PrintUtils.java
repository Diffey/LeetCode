/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import leetcode.addtwonumbers.ListNode;

/**
 *
 * @author DQ
 */
public class PrintUtils {

    /**
     * 打印数组
     *
     * @param <T>
     * @param arr
     */
    public static <T> void printArray(T[] arr) {
        for (T t : arr) {
            System.out.print(t);
        }
        System.out.println();
    }

    /**
     * 打印int数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    /**
     * 打印char数组
     * @param arr 
     */
    public static void printArray(char[] arr) {
        for (int t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    /**
     * 打印链表
     *
     * @param ls
     */
    public static void printListNode(ListNode ls) {
        while (ls != null) {
            System.out.print(ls.val + " ");
            ls = ls.next;
        }
        System.out.println();
    }

}
