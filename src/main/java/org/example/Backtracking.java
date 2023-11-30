package org.example;

import java.util.*;

public class Backtracking {


    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        solve(board);
    }
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.'; // backtrack
                            }
                        }
                    }
                    return false; // no valid number found for this cell
                }
            }
        }
        return true; // all cells filled
    }
    private boolean isValid(char[][] board, int row, int col, char num){
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == num || board[i][col] == num || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num){
                return false;
            }
        }
        return true;
    }
    String word;
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        if(word == "") return false;

        this.word = word; //Like a constructor

        for(int i = 0; i <board.length; i++){
            for(int j = 0; j < board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i,j,0,board)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int idx , char[][] board){
        if(idx == word.length()) return true;
        if(i< 0 || j < 0 || i > board.length -1 || j > board[i].length -1 || board[i][j] != word.charAt(idx)) return false;

        char currCharacter = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(i-1, j,idx+1,board)
                || dfs(i, j-1, idx+1, board)
                || dfs(i+1, j, idx+1, board)
                || dfs(i,j+1,idx+1, board);

        board[i][j] = currCharacter;
        return found;
    }
    public List<String> letterCombinations(String digits) {
        List<String> response = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return response;
        }
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        generateCombinations("", digits, 0, phoneMap, response);
        return response;
    }
    private void generateCombinations(String current, String digits, int index, Map<Character, String> phoneMap, List<String> response){
        if(index == digits.length()){
            response.add(current);
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        for (char letter: letters.toCharArray()){
            generateCombinations(current + letter, digits, index + 1, phoneMap, response);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        backtrack(result,"",0,0,n);
        return result;
    }
    private static void backtrack(List<String> result, String current, int open, int close, int max){
        if(current.length() == 2 * max){
            result.add(current);
            return;
        }
        if(open < max){
            backtrack(result,current + '(',open+1,close,max);
        }
        if(close < open){
            backtrack(result,current + ')',open,close+1,max);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,target, new ArrayList<>(),result,0);
        return result;
    }
    private void backtrack(int[] candidates, int target, List<Integer> current,List<List<Integer>> result, int start){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] <= target){
                current.add(candidates[i]);
                backtrack(candidates, target - candidates[i] , current, result, i);
                current.remove(current.size() - 1);
            }
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSets = new ArrayList();
        List<Integer> subSet = new ArrayList();
        backtrack(nums, 0, subSet,subSets);
        return subSets;
    }
    private void backtrack(int[] nums, int start, List<Integer> subSet, List<List<Integer>> subSets){
        subSets.add(new ArrayList(subSet));
        for(int i = start; i < nums.length; i++){
            subSet.add(nums[i]);
            backtrack(nums, i+1, subSet, subSets);
            subSet.remove(subSet.size() - 1);
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> response = new ArrayList();
        generatePalindromeSubSets(s,0, new ArrayList(),response);
        return response;
    }
    private static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() -1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void generatePalindromeSubSets(String s, int start, List<String> subSet, List<List<String>> response){
        if( start == s.length()){
            if(subSet.size() > 0){
                response.add(new ArrayList(subSet));
            }
            return;
        }
        for(int end = start; end < s.length(); end++){
            String currentSubstring = s.substring(start,end+1);
            if (isPalindrome(currentSubstring)) {
                subSet.add(currentSubstring);
                generatePalindromeSubSets(s, end + 1, subSet, response);
                subSet.remove(subSet.size() - 1);
            }
        }

    }
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int[] xorSum = {0};

        backtrack(nums,0,xorSum,0);
        return xorSum[0];
    }

    private void backtrack(int[] nums, int index, int[] xorSum, int currentXOR){
        if(index == nums.length){
            xorSum[0] += currentXOR;
            return;
        }

        backtrack(nums, index+1,xorSum, currentXOR ^ nums[index]);
        backtrack(nums, index+1, xorSum, currentXOR);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subSets = new ArrayList();
        List<Integer> subSet = new ArrayList();
        Arrays.sort(nums);
        backtrack(nums, 0, subSet,subSets);
        return subSets;
    }
    /*private void backtrack(int[] nums, int start, List<Integer> subSet, List<List<Integer>> subSets){
        subSets.add(new ArrayList(subSet));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i -1]){
                continue;
            }
            subSet.add(nums[i]);
            backtrack(nums, i+1, subSet, subSets);
            subSet.remove(subSet.size() - 1);
        }
    }*/

    public static void main(String[] args) {

    }
}
