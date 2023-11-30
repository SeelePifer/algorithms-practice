package org.example;

import java.util.Arrays;

public class GreedySolutions {

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] permutation = new int[ n + 1];

        int start = 0;
        int end = n;

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'I'){
                permutation[i] = start++;
            }else{
                permutation[i] = end--;
            }
        }
        permutation[n] = start;

        return  permutation;
    }
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, ( a,b ) -> a[1]-b[1]);
        int end = intervals[0][1];
        int count = intervals.length - 1;
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] >= end){
                end = intervals[i][1];
                count--;
            }
        }
        return count;
    }
    public boolean canJump(int[] nums) {

        int reachable = 0; //2
        for (int i = 0; i < nums.length; i++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static int longestPalindrome(String s) {
        int[] charCount = new int[128];

        for (char c: s.toCharArray()){
            charCount[c]++;
        }

        int length = 0;
        boolean oddCountFound = false;

        for (int count : charCount){
            length += (count / 2) * 2;
            if(count % 2 == 0){
                oddCountFound = true;
            }
        }
        if(oddCountFound){
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
}
