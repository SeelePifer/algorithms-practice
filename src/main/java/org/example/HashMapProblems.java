package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapProblems {

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if(hashMap.containsKey(magazine.charAt(i))){
                hashMap.put(magazine.charAt(i), hashMap.get(magazine.charAt(1))+1); // If exist count+1
            }else{
                hashMap.put(magazine.charAt(i), 1); //If not exist put 1
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(hashMap.containsKey(ransomNote.charAt(i)) && hashMap.get(ransomNote.charAt(i))>0){
                hashMap.put(ransomNote.charAt(i), hashMap.get(ransomNote.charAt(i)) - 1);
            }else{
                return false;
            }
        }
        return true;
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char charAt = pattern.charAt(i);
            String word = words[i];

            if(!charToWord.containsKey(charAt)){
                charToWord.put(charAt, word);
            }

            if(!wordToChar.containsKey(word)){
                wordToChar.put(word, charAt);
            }

            if(!charToWord.get(charAt).equals(word) || !wordToChar.get(word).equals(charAt)){
                return false;
            }
        }
        return true;
    }
    public List<String> letterCombinations(String digits) {
        HashMap<String, String> number = new HashMap<>();

        number.put("2","abc");
        number.put("3","def");
        number.put("4","ghi");
        number.put("5","jkl");
        number.put("6","mno");
        number.put("7","pqrs");
        number.put("8","tuv");
        number.put("9","wxyz");
        
        return null;
    }
    public int romanToInt(String s) {
        HashMap<Character, Integer> number = new HashMap<>();

        number.put('I',1);
        number.put('V',5);
        number.put('X',10);
        number.put('L',50);
        number.put('C',100);
        number.put('D',500);
        number.put('M',1000);


        int result = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            int currValue = number.get(s.charAt(i));

            if(currValue < prevValue){
                result -= currValue;
            }else{
                result += currValue;
            }
            prevValue = currValue;
        }
        return result;
    }

    public String addStrings(String num1, String num2) {
        BigInteger i = new BigInteger(num1);
        BigInteger j = new BigInteger(num2);

        return String.valueOf(i.add(j));
    }
    public int numIslands(char[][] grid) {
        int count = 0;

        for( int i = 0; i < grid.length; i++){
            for( int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    callBFS(grid,i,j);
                }
            }
        }
        return count;
    }
    public void callBFS(char[][] grid, int i, int j){
        if(i < 0 || i>= grid.length || j<0 || j>= grid[i].length || grid[i][j]=='0')return;
        grid[i][j] = '0';
        callBFS(grid,i+1,j); //up
        callBFS(grid,i-1,j); //down
        callBFS(grid,i,j); //right
        callBFS(grid,i,j); //left
    }
    public LinkedListExercises.ListNode reverseList(LinkedListExercises.ListNode head) {

        LinkedListExercises.ListNode prev = null;
        LinkedListExercises.ListNode current = head;

        while (current != null){
            LinkedListExercises.ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }



    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(canConstruct("aa","aab"));
    }
}
