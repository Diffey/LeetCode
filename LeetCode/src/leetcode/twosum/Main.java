/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import leetcode.PrintUtils;

/**
 *
 * @author DQ
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 7};
        int target = 8;
        int[] oNums = new int[]{-10, -5, -7};
        int oTarget = -12;
        int[] ooNums = new int[]{0, 4, 3, 0};
        int ooTarget = 0;

        PrintUtils.printArray(twoSumByExhaustive(nums, target));
        PrintUtils.printArray(twoSumByHashMap(nums, target));
        PrintUtils.printArray(twoSumBySort(nums, target));

        PrintUtils.printArray(twoSumByExhaustive(oNums, oTarget));
        PrintUtils.printArray(twoSumByHashMap(oNums, oTarget));
        PrintUtils.printArray(twoSumBySort(oNums, oTarget));

        PrintUtils.printArray(twoSumByExhaustive(ooNums, ooTarget));
        PrintUtils.printArray(twoSumByHashMap(ooNums, ooTarget));
        PrintUtils.printArray(twoSumBySort(ooNums, ooTarget));

    }

    /**
     * 穷举法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByExhaustive(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 以空间换时间 通过hash表存储数据
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByHashMap(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }

//    public static int[] twoSumBySort(int[] nums, int target) {
//        int[] result = new int[2];
//        Map<Integer, Integer> map = new HashMap();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        //可以自己写排序算法
//        Arrays.sort(nums);
//        int sIndex = 0;
//        int eIndex = nums.length - 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[sIndex] + nums[eIndex] == target) {
//                result[0] = map.get(nums[sIndex]);
//                result[1] = map.get(nums[eIndex]);
//            } else if (nums[sIndex] + nums[eIndex] > target) {
//                eIndex--;
//            } else {
//                sIndex++;
//            }
//
//        }
//
//        if (result[0] > result[1]) {
//            sIndex = result[0];
//            result[0] = result[1];
//            result[1] = sIndex;
//        }
//        return result;
//    }
    public static int[] twoSumBySort(int[] nums, int target) {
        int[] result = new int[2];
        int[] copyNums = nums.clone();
        //可以自己写排序算法
        Arrays.sort(nums);
        int sIndex = 0;
        int eIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[sIndex] + nums[eIndex] == target) {
                result[0] = nums[sIndex];
                result[1] = nums[eIndex];
                break;
            } else if (nums[sIndex] + nums[eIndex] > target) {
                eIndex--;
            } else {
                sIndex++;
            }

        }

        boolean f = false;
        for (int i = 0; i < copyNums.length; i++) {
            if (!f && copyNums[i] == result[0]) {
                sIndex = i;
                f = true;
            } else if (copyNums[i] == result[1]) {
                eIndex = i;
            }
        }

        result[0] = sIndex > eIndex ? eIndex : sIndex;
        result[1] = sIndex > eIndex ? sIndex : eIndex;
        return result;
    }

}
