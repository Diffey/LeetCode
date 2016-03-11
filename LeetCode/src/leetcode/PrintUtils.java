/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author DQ
 */
public class PrintUtils {

    public static <T> void printArray(T[] arr) {
        for (T t : arr) {
            System.out.print(t);
        }
        System.out.println();
    }

    /**
     * 打印int数组
     * @param arr 
     */
    public static void printArray(int[] arr) {
        for (int t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

}
