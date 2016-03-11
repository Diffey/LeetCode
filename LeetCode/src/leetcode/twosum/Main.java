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

    /**
     * 排序后再查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumBySort(int[] nums, int target) {
        int[] result = new int[2];
//        int[] copyNums = nums.clone();
        int[] copyNums = new int[nums.length];
        System.arraycopy(nums, 0, copyNums, 0, nums.length);
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

        boolean fGit = false;
        for (int i = 0; i < copyNums.length; i++) {
            if (!fGit && copyNums[i] == result[0]) {
                sIndex = i;
                fGit = true;
            } else if (copyNums[i] == result[1]) {
                eIndex = i;
            }
        }
        if (sIndex > eIndex) {
            result[0] = eIndex;
            result[1] = sIndex;
        } else {
            result[0] = sIndex;
            result[1] = eIndex;
        }

        return result;
    }

}
