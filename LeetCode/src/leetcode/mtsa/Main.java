/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.mtsa;

import leetcode.PrintUtils;

/**
 *
 * @author diff
 */
public class Main {

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 6};
        int[] nums2 = {2, 4};

        int[] nums11 = {100000};
        int[] nums22 = {100001};

        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums11, nums22));

    }

    public static double findMedianSortedArraysBySort(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        double median;
        int nums1Index = 0;
        int nums2Index = 0;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (nums1Index < nums1.length) {
                a = nums1[nums1Index];
            }
            if (nums2Index < nums2.length) {
                b = nums2[nums2Index];
            }
            if (a < b) {
                num[i] = a;
                a = Integer.MAX_VALUE;
                nums1Index++;
            } else {
                num[i] = b;
                b = Integer.MAX_VALUE;
                nums2Index++;
            }

        }
        if (num.length % 2 == 0) {
            median = (double) (num[num.length / 2 - 1] + num[num.length / 2]) / 2;
        } else {
            median = num[(num.length + 1) / 2 - 1];

        }
        return median;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isEven = false;
        if ((nums1.length + nums2.length) % 2 == 0) {
            isEven = true;
        }
        double median;
        int start = 0;
        int end = 2;
        int nums1Index = 0;
        int nums1EndIndex = nums1.length - 1;
        int nums2Index = 0;
        int nums2EndIndex = nums2.length - 1;
        if (isEven) {
            while (start == end - 1) {
                if(nums1Index < nums1.length)
            }
        } else {
        }

        if (num.length % 2 == 0) {
            median = (double) (num[num.length / 2 - 1] + num[num.length / 2]) / 2;
        } else {
            median = num[(num.length + 1) / 2 - 1];

        }
        return median;
    }
}
