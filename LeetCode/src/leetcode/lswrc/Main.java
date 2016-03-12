/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.lswrc;

import leetcode.PrintUtils;

/**
 *
 * @author DQ
 */
public class Main {

    public static void main(String[] args) {
        String s = "sas";
        String ss = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(ss));

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] sChars = s.toCharArray();
        int sIndex = 0;
        int eIndex = 0;
        int lenght = 0;
        while (eIndex < sChars.length) {
            for (int i = sIndex; i < eIndex; i++) {
                if (sChars[i] == sChars[eIndex]) {
                    lenght = eIndex - sIndex > lenght ? eIndex - sIndex : lenght;
                    sIndex = i + 1;
                    break;
                }
            }
            eIndex++;
        }
        lenght = eIndex - sIndex > lenght ? eIndex - sIndex : lenght;
        return lenght;
    }
}
