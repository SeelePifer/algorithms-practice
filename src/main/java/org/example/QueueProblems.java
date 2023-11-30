package org.example;


import java.util.ArrayDeque;
import java.util.Queue;

public class QueueProblems {

    public void rotate(int[] nums, int k) {
        int length = nums.length;

        if (length <= 1) {
            return;
        }
        k = k % length;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = length - k; i < length ; i++) {
            queue.add(nums[i]);
        }

        for (int i = length - 1; i >= k ; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = queue.poll();
        }

    }

    public static void main(String[] args) {


    }
}
