package org.example;

import java.util.*;

public class StringExercises {

    boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) { //Already found this char in String
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    boolean permutation(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] sArray = a.toCharArray();
        for (char c : sArray) {
            letters[c]++;
        }
        for (int i = 0; i < b.length(); i++) {
            int c = (int) b.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char charStart = s.charAt(start);
            char charLast = s.charAt(last);

            if (!Character.isLetterOrDigit(charStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(charLast)) {
                last--;
            } else {
                if (Character.toLowerCase(charStart) != Character.toLowerCase(charLast)) {
                    return false;
                }
                start++;
                last--;
            }

        }
        return true;

    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int j = 0;

        for (int i = 0; i < t.length(); i++) {

            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
            if (j == s.length()) return true;
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + "in row " + i) ||
                            !seen.add(number + "in column" + j) ||
                            !seen.add(number + "in block " + i / 3 + " - " + j / 3)) return false;
                }
            }
        }
        return true;
    }

    public static int[] fibonacci(int target) {
        int[] array = new int[target];

        for (int i = 0; i < target; i++) {
            if (i <= 1) {
                array[0] = 1;
                array[1] = 1;
            } else {
                array[i] = array[i - 1] + array[i - 2];
            }
        }
        return array;
    }

    public int solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'x' || s.charAt(i) == 'o') {
                count++;
            }
        }
        return count - 1;
    }

    public int[] solution(int rowIndex) {
        int[] result = new int[rowIndex + 1];
        result[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                result[j] += result[j - 1];
            }
        }

        return result;
    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else {
                String s = String.valueOf(i);
                result.add(s);
            }
        }
        return result;
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);

        for (int i = 0; i < s.length(); i++)
            if (hm.get(s.charAt(i)) == 1) return i;

        return -1;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> array = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (array.contains(nums[i])) {
                return true;
            }
            array.add(nums[i]);
        }
        return false;
    }

    public static int simpleArraySum(List<Integer> ar) {
        int result = 0;
        for (int i = 0; i < ar.size(); i++) {
            result += ar.get(i);
        }
        return result;
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int first = 0;
        int second = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                first += 1;
            } else if (a.get(i) < b.get(i)) {
                second += 1;
            } else {
                first += 0;
                second += 0;
            }
        }
        result.add(first);
        result.add(second);
        return result;
    }

    public static long aVeryBigSum(List<Long> ar) {
        long result = 0;
        for (int i = 0; i < ar.size(); i++) {
            result += ar.get(i);
        }
        return result;

    }

    public boolean isAnagram(String s, String t) {

        s = s.replace("\\s", "").toLowerCase();
        t = t.replace("\\s", "").toLowerCase();

        if (s.length() != t.length()) {
            return false;
        }
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;

        for (int i = 3; i <= n; i++) {
            int next = n1;
            n1 = n2;
            n2 = next + n2;
        }
        return n2;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Arrays.sort(nums1);

        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[i]) {
                i++;
            } else if (nums1[i] > nums2[i]) {
                j++;
            } else {
                arr.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] output = new int[arr.size()];
        int k = 0;
        while (k < arr.size()) {
            output[k] = arr.get(k);
            k++;
        }
        return output;

    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int counter = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] >= target) {
                counter++;
            }
        }
        return counter;
    }

    public static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int[] prefixCount = new int[n];
        Map<Integer, Integer> freqMap = new HashMap<>();

        int totalCount = 0;

        for (int i = 0; i < n; i++) {
            // Increment the frequency of the current number in the frequency map
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

            // Copy the frequency map and initialize unique count for each subarray starting from index i
            Map<Integer, Integer> tempFreqMap = new HashMap<>(freqMap);
            int uniqueCount = 0;

            for (int j = i; j >= 0; j--) {
                // If the count of the number at index j in the temporary frequency map is 1, it is unique
                if (tempFreqMap.get(nums[j]) == 1) {
                    uniqueCount++;
                    tempFreqMap.remove(nums[j]);
                } else {
                    tempFreqMap.put(nums[j], tempFreqMap.get(nums[j]) - 1);
                }

                // If all numbers in the current subarray have the same frequency, increment totalCount
                if (tempFreqMap.size() == 1) {
                    totalCount += uniqueCount;
                }
            }

            // Update the prefix count array for each index
            prefixCount[i] = totalCount;
        }

        // Sum up the counts from the prefix count array to get the total count
        int result = 0;
        for (int count : prefixCount) {
            result += count;
        }

        return result;
    }

    public static String minimumString(String a, String b, String c) {
        int max = Math.max(a.length(), Math.max(b.length(), c.length()));
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < max; i++) {
            if (i < a.length() && c.charAt(i) == a.charAt(i)) {
                result.append(a.charAt(i));
            } else if (i < b.length() && c.charAt(i) == b.charAt(i)) {
                result.append(b.charAt(i));
            } else if (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i)) {
                result.append(a.charAt(i));
            } else {
                result.append(c.charAt(i));
            }
        }

        return result.toString();
    }


    public static int furthestPoint(String moves) {
        int currentPosition = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'L') {
                currentPosition -= 1;
            }
            if (move == 'L' && move + 1 == '_') {
                currentPosition -= 1;
            }
            if (move == 'R') {
                currentPosition += 1;
            }
            if (move == 'R' && move + 1 == '_') {
                currentPosition += 1;
            }
        }

        return Math.abs(currentPosition);
    }

    public static int minBeautifulArraySum(int n, int target) {
        int maxSum = (n * (n + 1)) / 2;
        if (maxSum >= target) {
            int adjustment = target - 1;
            int adjustedSum = maxSum - (adjustment * n);
            return adjustedSum;
        } else {
            return maxSum;
        }
    }


    public int searchInsert(int[] nums, int target) {
        int start = 0, mid;
        int end = nums.length - 1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder st = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            char digit = (char) ('A' + (columnNumber % 26));
            st.append(digit);
            columnNumber /= 26;
        }
        return st.reverse().toString();
    }

    public static boolean canBeEqual(String s1, String s2) {
        if (s1.charAt(0) != s2.charAt(0) && s1.charAt(2) != s2.charAt(2)) {
            if (s1.charAt(0) != s2.charAt(2) || s1.charAt(2) != s2.charAt(0)) {
                return false;
            }
        } else if (s1.charAt(0) != s2.charAt(0) && s1.charAt(2) == s2.charAt(2) || s1.charAt(0) == s2.charAt(0) && s1.charAt(2) != s2.charAt(2)) {
            return false;
        }
        if (s1.charAt(1) != s2.charAt(1) && s1.charAt(3) != s2.charAt(3)) {
            if (s1.charAt(1) != s2.charAt(3) || s1.charAt(3) != s2.charAt(1)) {
                return false;
            }
        } else if (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) != s2.charAt(3) || s1.charAt(1) != s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) {
            return false;
        }
        return true;
    }

    public int hammingWeight(int n) {
        String value = Integer.toBinaryString(n);
        int counter = 0;

        for (int i = 0; i <= value.length(); i++) {
            if (value.charAt(i) == '1') {
                counter += 1;
            }
        }
        return counter;
    }

    public boolean repeatedSubstringPattern(String s) {
        String concat = s + s;
        String response = concat.substring(1, concat.length() - 1);
        return response.contains(s);
    }

    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != nonZeroIndex) {
                    int temp = nums[nonZeroIndex];
                    nums[nonZeroIndex] = nums[i];
                    nums[i] = temp;
                }
                nonZeroIndex++;
            }
        }
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    class NumArray {

        int[] prefix;

        public NumArray(int[] nums) {
            prefix = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                prefix[i] = nums[i];
            }
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += prefix[i];
            }
            return sum;
        }
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return true;
    }

    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    /*public int guessNumber(int n) {
        int low = 0;
        int high = n;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int x = guess(mid);

            if(x == 0){
                return mid;
            }
            else if (x ==-1){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    */

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToTMapping = new HashMap<>();
        Map<Character, Character> tToSMapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToTMapping.containsKey(sChar)) {
                if (sToTMapping.get(sChar) != tChar) {
                    return false;
                }
            } else {
                sToTMapping.put(sChar, tChar);
            }

            if (tToSMapping.containsKey(tChar)) {
                if (tToSMapping.get(tChar) != sChar) {
                    return false;
                }
            } else {
                tToSMapping.put(tChar, sChar);
            }
        }

        return true;
    }

    String[] qwerty = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
    String[] asdf = {"a", "s", "d", "f", "g", "h", "j", "k", "l"};

    String[] zxc = {"z", "x", "c", "v", "b", "n", "m"};

    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start != nums[i]) {
                result.add("" + start + "->" + nums[i]);
            } else {
                result.add("" + start);
            }
        }
        return result;
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int result = 0;

        for (int i = 0; i < nums.size(); i++) {
            int number = nums.get(i);
            int count = 0;
            int index = i;

            while (index > 0) {
                if ((index & 1) == 1) {
                    count++;
                }
                index >>= 1;
            }

            if (count == k) {
                result += number;
            }
        }

        return result;
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = n * (n + 1) / 2;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return totalSum - sum;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numsSet1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            numsSet1.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int value = nums2[i];
            if (numsSet1.contains(value)) {
                list.add(value);
                numsSet1.remove(value);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = square(slow);
            fast = square(square(fast));
        }
        while (slow != fast);
        return slow == 1;
    }

    public int square(int num) {
        int ans = 0;

        while (num > 0) {
            int remain = num % 10;
            ans += remain + remain;
            num /= 10;
        }
        return ans;
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int a = g.length - 1;
        int b = s.length - 1;
        int max = 0;

        while (a >= 0 && b >= 0) {
            if (s[b] >= g[a]) {
                max += 1;
                a -= 1;
                b -= 1;
            } else {
                a -= 1;
            }
        }
        return max;
    }

    public static String reverseWords(String s) {
        String[] stringSeparation = s.split(" ");

        List<String> result = new LinkedList<>();

        for (int i = 0; i < stringSeparation.length; i++) {
            StringBuilder reverseString = new StringBuilder();

            for (int pointer = stringSeparation[i].length() - 1; pointer >= 0; pointer--) {
                reverseString.append(stringSeparation[i].charAt(pointer));
            }
            result.add(reverseString.toString());
        }
        return String.join(" ", result);
    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static int countBinarySubstrings(String s) {
        int current = 1;
        int answer = 0;
        int previous = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current += 1;
            } else {
                answer += Math.min(current, previous);
                previous = current;
                current = 1;
            }
        }
        return answer + Math.min(current, previous);
    }

    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];

        int next = moveFoward(s, c, 0);
        int previous = next;

        for (int i = 0; i < s.length(); i++) {
            if (i > next) {
                previous = next;
                next = moveFoward(s, c, next + 1);
            }

            result[i] = Math.abs(Math.min(next - 1, i - previous));
        }

        return result;

    }

    public int moveFoward(String s, char c, int position) {
        while (position < s.length()) {
            if (s.charAt(position) == c) {
                break;
            }
            position++;
        }
        if (position == s.length()) {
            return Integer.MAX_VALUE;
        }
        return position;
    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String reverseWords2(String s) {
        String[] words = s.trim().split("\\s+");

        String out = "";

        for (int i = words.length - 1; i > 0; i--) {
            out += words[i] + " ";
        }
        return out + words[0];
    }

    public static boolean lemonadeChange(int[] bills) {
        int dollar5 = 0;
        int dollar10 = 0;
        int dollar20 = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                dollar5 += 1;
            } else if (bills[i] == 10) {
                dollar10 += 1;
                if (dollar5 > 0) {
                    dollar5--;
                } else {
                    return false;
                }
            } else {
                dollar20++;
                if (dollar10 >= 1 && dollar5 >= 1) {
                    dollar5--;
                    dollar10--;
                } else if (dollar5 >= 3) {
                    dollar5--;
                    dollar5--;
                    dollar5--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static int thirdMax(int[] nums) {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for (Integer num : nums) {
            if (num.equals(firstMax) || num.equals(secondMax) || num.equals(thirdMax)) {
                continue; // Skip duplicates
            }

            if (firstMax == null || num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (secondMax == null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }
        if (thirdMax == null) {
            return firstMax;
        } else {
            return thirdMax;
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int[] a = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            a[nums[i] - 1]++;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (a[i] == 0) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

    public static int findKthPositive(int[] arr, int k) {
        int actualNumber = 1;
        int index = 0;

        while (k > 0) {
            if (index < arr.length && arr[index] == actualNumber) {
                index++;
            } else {
                k = k - 1;
            }
            actualNumber++;
        }
        return actualNumber - 1;
    }

    public int kthFactor(int n, int k) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                counter++;
                if (counter == k) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int partitionString(String s) {

        Set<Character> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set = new HashSet<>();
                result++;
            }
            set.add(s.charAt(i));
        }
        return result + 1;
    }

    public static int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        int pivotId = 0;
        int pivotCount = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                pivotId = i;
                pivotCount++;
            }
        }
        if (pivotCount > 1) return -1;
        if (pivotId == 0) return 0;
        return (nums.get(n - 1) > nums.get(0)) ? -1 : n - pivotId;
    }

    public int minLengthAfterRemovals(List<Integer> nums) {
        int i = 0;
        int j = nums.size() - 1;
        int counter = 0;
        while (i < j) {

        }
        return 1;
    }

    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        int n = num.length();

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // If there are still some digits to be removed (k > 0), remove them from the end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static int minOperations(List<Integer> nums, int k) {
        int counter = 0;
        int end = nums.size() - 1;

        if (nums.size() > k && nums.get(0) <= k && nums.get(0) <= k) {
            return 2;
        }
        while (k > 0) {
            if (end <= k) {
                counter++;
                k--;
                end--;
            } else {
                counter++;
                end--;
            }
        }
        return counter;
    }

    public static int minOperations(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int count : countMap.values()) {
            int triples = count / 3;
            int pairs = (count % 3) / 2;

            operations += triples + pairs;

            if (count % 3 != 0 && triples == 0 && pairs > 0) {
                operations += 2;
            } else if (count % 3 != 0 && triples == 0) {
                return -1;
            }
        }

        return operations - 1;
    }

    public int[] singleNumber(int[] nums) {
        int xorResult = 0;

        for (int num : nums) {
            xorResult ^= num;
        }

        int k = 0;
        while ((xorResult & (1 << k)) == 0) {
            k++;
        }
        int num1 = 0;
        int num2 = 0;

        for (int num : nums) {
            if ((num & (1 << k)) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        int[] result = {num1, num2};
        return result;
    }

    public static int jump(int[] nums) {
        int response = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            //Case of we didnt need more jumps
            if (farthest >= nums.length - 1) {
                ++response;
                break;
            }
            //Case of we need more jumps
            if (i == end) {
                ++response;
                end = farthest;
            }
        }
        return response;
    }


    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            leftProducts[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            rightProducts[i] = rightProduct;
            rightProduct *= nums[i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }
        return result;
    }

    public List<String> invalidTransactions(String[] transactions) {
        for (int i = 0; i < transactions.length - 1; i++) {

        }
        return null;
    }

    public static int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int sum = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });

        for (int i = 0; i < n / 2; i++) {
            sum += costs[i][0];
        }
        for (int i = n / 2; i < n; i++) {
            sum += costs[i][1];
        }
        return sum;
    }

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + '(', open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ')', open, close + 1, max);
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split(" ", 2);
                String[] split2 = o2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) {
                        return cmp;
                    }
                    return split1[0].compareTo(split2[0]);
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else if (!isDigit1 && isDigit2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return logs;
    }

    public static boolean buddyStrings(String s, String goal) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == goal.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static int[][] diagonalSort(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diagonalKey = i - j;
                diagonalMap.putIfAbsent(diagonalKey, new ArrayList<>());
                diagonalMap.get(diagonalKey).add(mat[i][j]);
            }
        }

        for (List<Integer> diagonal : diagonalMap.values()) {
            Collections.sort(diagonal);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diagonalKey = i - j;
                mat[i][j] = diagonalMap.get(diagonalKey).remove(0);
            }
        }
        return mat;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] ints = new int[2];

        while (right > left) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ints[0] = numbers[left];
                ints[1] = numbers[right];
                return ints;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }

        }
        return ints;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return answer;
        }
        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    answer.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }

        }
        return answer;
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int response = 0;

        while (i < j) {
            int currentArea = Math.min(height[i], height[j]) * (j - i);
            response = Math.max(response, currentArea);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return response;
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int counter = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != ' ') {
                counter++;
            } else {
                counter = 0;
            }
        }
        return counter + 1;
    }

    public static int differenceOfSums(int n, int m) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i <= n; i++) {
            if (i % m != 0) {
                sum1 += i;
            } else {
                sum2 += i;
            }
        }
        return sum1 - sum2;
    }

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public String mergeAlternately(String word1, String word2) {
        int i = 0;

        StringBuilder response = new StringBuilder();

        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                response.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                response.append(word2.charAt(i));
            }
            i++;
        }
        return response.toString();
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!str1.equals(str2)) {
            return "";
        }
        if (str1.length() == str2.length()) {
            return str1;
        } else if (str1.length() > str2.length()) {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        } else {
            return gcdOfStrings(str1, str2.substring(str1.length()));
        }
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxValue = 0;
        List<Boolean> response = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (maxValue < candies[i]) {
                maxValue = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxValue) {
                response.add(true);
            } else {
                response.add(false);
            }
        }
        return response;
    }

    public String reverseVowels(String s) {
        boolean foundVowel = false;
        int i = 0;
        int j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j) {

            if (!isVowel(charArray[i])) {
                i++;
            }
            if (!isVowel(charArray[j])) {
                j--;
            }
            if (isVowel(charArray[i]) && isVowel(charArray[j])) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
                foundVowel = true;
            }
        }
        if (!foundVowel) return s;
        return new String(charArray);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int largestAltitude(int[] gain) {
        int highAltitute = -100;

        for (int i = 1; i < gain.length; i++) {
            if (highAltitute < gain[i - 1] + gain[i]) {
                highAltitute = gain[i - 1] + gain[i];
            }
        }
        if (highAltitute <= 0) {
            return 0;
        } else {
            return highAltitute;
        }
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();

        List<List<Integer>> response = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<Integer> diffList1 = new ArrayList<>();
        List<Integer> diffList2 = new ArrayList<>();
        for (Integer element : set1) {
            if (!set2.contains(element)) {
                diffList1.add(element);
            }
        }
        for (Integer element : set2) {
            if (!set1.contains(element)) {
                diffList2.add(element);
            }
        }
        response.add(diffList1);
        response.add(diffList2);
        return response;
    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
    // indexDifference<=abs( i - j)
    // valueDifference <= (abs(nums[i] - nums[j])

    public static String shortestBeautifulSubstring(String s, int k) {
        for (int l = 1; l <= s.length(); l++) {
            boolean found = false;
            String t = null;
            for (int i = 0; i <= s.length() - l; i++) {
                String ss = s.substring(i, i + l);
                int ct = countOnes(ss);
                if (ct == k) {
                    found = true;
                    if (t == null || t.compareTo(ss) < 0) {
                        t = ss;
                    }
                }
            }
            if (found) {
                return t;
            }
        }
        return "";
    }

    private static int countOnes(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    /*public static int minimumSum(int[] nums) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;

        for (int j = 1; j < n - 1; j++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int i = j - 1; i >= 0; i--) {
                if (nums[i] < nums[j]) {
                    leftMax = Math.max(leftMax, nums[i]);
                }
            }

            for (int k = j + 1; k < n; k++) {
                if (nums[k] < nums[j]) {
                    rightMax = Math.max(rightMax, nums[k]);
                }
            }

            if (leftMax > 0 && rightMax > 0) {
                minSum = Math.min(minSum, leftMax + nums[j] + rightMax);
            }
        }

        return minSum != Integer.MAX_VALUE ? minSum : -1;
    }*/
    /*public static int minimumSum(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return -1;
        }

        int minSum = Integer.MAX_VALUE;

        for (int j = 1; j < n - 1; j++) {
            int minLeft = Integer.MAX_VALUE;
            int minRight = Integer.MAX_VALUE;

            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    minLeft = Math.min(minLeft, nums[i]);
                }
            }

            for (int k = j + 1; k < n; k++) {
                if (nums[k] < nums[j]) {
                    minRight = Math.min(minRight, nums[k]);
                }
            }

            if (minLeft != Integer.MAX_VALUE && minRight != Integer.MAX_VALUE) {
                int sum = minLeft + nums[j] + minRight;
                minSum = Math.min(minSum, sum);
            }
        }

        return minSum != Integer.MAX_VALUE ? minSum : -1;
    }*/
    public static int minimumSum(int[] nums) {
        int n = nums.length;
        int t = Integer.MAX_VALUE;
        int s = Integer.MAX_VALUE;

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (v > t) {
                left.put(i, t);
            }
            t = Math.min(t, v);
        }
        for (int i = n - 1; i >= 0; i--) {
            int v = nums[i];
            if (v > s) {
                right.put(i, s);
            }
            s = Math.min(s, v);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (left.containsKey(i) && right.containsKey(i)) {
                result = Math.min(result, left.get(i) + right.get(i) + nums[i]);
            }
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] response = new int[2];
        response[0] = -1;
        response[1] = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target && nums[i] == nums[i - 1]) {
                if (response[0] == -1) {
                    response[0] = i - 1;
                }
                response[1] = i;
            }
        }
        return response;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int rigth = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > rigth) {
                rigth = piles[i];
            }
        }
        while (left < rigth) {
            int k = left + (rigth - left) / 2;

            if (checkCanEat(piles, k, h)) {
                rigth = k;
            } else {
                left = k + 1;
            }
        }
        return left;
    }

    private boolean checkCanEat(int[] piles, int k, int h) {
        int actualH = 0;
        for (int pile : piles) {
            actualH += (pile + k - 1) / k;
        }
        return actualH <= h;
    }

    public boolean checkPossibility(int[] nums) {
        int counter = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i]) {
                counter++;
            }
        }
        if (counter <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int result = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int j = i; j < n; j++) {
                int num = nums.get(j);
                if (countMap.containsKey(num)) {
                    countMap.put(num, countMap.get(num) + 1);
                    System.out.println(countMap.put(num, countMap.get(num) + 1));
                } else {
                    countMap.put(num, i);
                    System.out.println(countMap.put(num, i));
                }
                result += countMap.size() * countMap.size();
            }
        }

        return result;

    }

    public int minChanges(String s) {
        char[] charArray = s.toCharArray();
        int n = s.length();
        int response = 0;
        for (int i = 0; i < n; i += 2) {
            if (charArray[i] != charArray[i + 1]) {
                response++;
            }
        }
        return response;
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftTmp = new int[n1];
        int[] rightTmp = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftTmp[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightTmp[i] = array[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftTmp[i] <= rightTmp[j]) {
                array[k] = leftTmp[i];
                i++;
            } else {
                array[k] = rightTmp[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftTmp[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightTmp[j];
            j++;
            k++;
        }
    }

    public String nearestPalindromic(String n) {
        long number = Long.parseLong(n);

        if (number <= 1) {
            return String.valueOf(number - 1);
        }
        long greaterPalindrome = findGreaterPalindrome(number);
        long smallerPalindrome = findSmallerPalindrome(number);

        long diffGreater = Math.abs(number - greaterPalindrome);
        long diffSmaller = Math.abs(number - smallerPalindrome);


        if (diffSmaller < diffGreater) {
            return String.valueOf(smallerPalindrome);
        } else {
            return String.valueOf(greaterPalindrome);
        }
    }

    private long findSmallerPalindrome(long num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();


        if (num <= 10) {
            return num - 1;
        }

        long leftPart = Long.parseLong(numStr.substring(0, (n + 1) / 2));

        long smallerPalindrome = generatePalindrome(leftPart);

        return smallerPalindrome;
    }

    private long findGreaterPalindrome(long num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();

        if (num <= 9) {
            return num + 1;
        }

        long leftPart = Long.parseLong(numStr.substring(0, (n + 1) / 2));

        long greaterPalindrome = generatePalindrome(leftPart);

        return greaterPalindrome;
    }

    private long generatePalindrome(long leftPart) {
        String leftStr = String.valueOf(leftPart);
        int n = leftStr.length();

        StringBuilder rightStr = new StringBuilder(leftStr.substring(0, n - 1));
        rightStr.reverse();

        String palindromeStr = leftStr + (n % 2 == 0 ? "" : leftStr.charAt(n - 1)) + rightStr.toString();

        return Long.parseLong(palindromeStr);
    }

    public List<List<String>> solveNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] leftDiagonal = new boolean[2 * n];
        boolean[] rightDiagonal = new boolean[2 * n];
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();


        solveNQUtil(result, n, 0, temp, cols, leftDiagonal, rightDiagonal);

        return result;
    }

    private void solveNQUtil(List<List<String>> result, int n, int row, List<String> board, boolean[] cols, boolean[] leftDiagonal, boolean[] rightDiagonal) {
        if (row == n) {
            // If row == n, it means we have successfully placed all n queens.
            // Hence, add the current arrangement to our answer.
            result.add(new ArrayList<>(board));
            return;
        }

        StringBuilder rowBuilder = new StringBuilder();
        for (int col = 0; col < n; col++) {
            // If we have a queen previously placed in the current column
            // or in the current left or right diagonal, we continue.
            if (cols[col] || leftDiagonal[row + col] || rightDiagonal[row - col + n])
                continue;

            // Otherwise, we place a queen at cell[row][col] and make the current column, left diagonal, and right diagonal true.
            cols[col] = leftDiagonal[row + col] = rightDiagonal[row - col + n] = true;

            // Build the row string with "Q" at the queen's position.
            for (int i = 0; i < n; i++) {
                if (i == col) {
                    rowBuilder.append("Q");
                } else {
                    rowBuilder.append(".");
                }
            }

            board.add(rowBuilder.toString());
            rowBuilder.setLength(0); // Clear the StringBuilder for the next row.

            // Then, we move to the next row.
            solveNQUtil(result, n, row + 1, board, cols, leftDiagonal, rightDiagonal);

            // Backtrack and remove the currently placed queen.
            cols[col] = leftDiagonal[row + col] = rightDiagonal[row - col + n] = false;
            board.remove(board.size() - 1);
        }
    }

    String word;
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        if(word == "") return false;

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
    public int findChampion(int[][] grid) {
        int n = grid.length;

        // Create an array to keep track of the number of teams each team is stronger than
        int[] strongerCount = new int[n];

        // Initialize the strongerCount array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    strongerCount[i]++;
                }
            }
        }

        // Iterate through the teams to find the champion
        for (int i = 0; i < n; i++) {
            if (strongerCount[i] == 0) {
                return i; // Return the index of the team with no teams stronger than it
            }
        }

        return -1; // If no champion is found, return -1 (or any other suitable value)

    }
    public int q1(int n, int limit) {
        int count = 0;

        // Iterate through all possible distributions
        for (int firstChild = 0; firstChild <= Math.min(n, limit); firstChild++) {
            for (int secondChild = 0; secondChild <= Math.min(n - firstChild, limit); secondChild++) {
                int thirdChild = n - firstChild - secondChild;
                if (thirdChild <= limit) {
                    count++;
                }
            }
        }

        return count;
    }
    public long q2(int n, int limit) {
        long count = 0;

        for (int firstChild = 0; firstChild <= Math.min(n, limit); firstChild++) {
            int remainingCandies = n - firstChild;
            int maxForSecondChild = Math.min(remainingCandies, limit);
            // Calculando el rango de caramelos que el segundo niño puede recibir
            // El tercer niño recibirá el resto
            count += Math.max(0, maxForSecondChild - Math.max(0, remainingCandies - limit) + 1);
        }

        return count;
    }

    public static int findMinimumOperations(String s1, String s2, String s3) {
        if(s1.charAt(0) != s2.charAt(0) || s1.charAt(0) != s3.charAt(0)){
            return -1;
        }
        int operations = 0;
        while(!s1.equals(s2) || !s1.equals(s3)) {
            if (s1.length() >= s2.length() && s1.length() >= s3.length()) {
                s1 = s1.substring(0, s1.length() - 1);
            } else if (s2.length() >= s1.length() && s2.length() >= s3.length()) {
                s2 = s2.substring(0, s2.length() - 1);
            } else {
                s3 = s3.substring(0, s3.length() - 1);
            }
            operations++;
        }
        return operations;
    }

    public long minimumSteps(String s) {
        int totalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++; //1
            }
        }
        long steps = 0;
        int finalPosition = s.length() - totalOnes;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                steps += finalPosition - i;
                finalPosition++;
            }
        }

        return steps;
    }
    public static int maximumXorProduct(long a, long b, int n) {
        long mod = 1000000007; // 10^9 + 7
        long maxProduct = 0;

        long upperLimit = 1L << n; // 2^n
        for (long x = 0; x < upperLimit; x++) {
            long product = ((a ^ x) * (b ^ x)) % mod;
            maxProduct = Math.max(maxProduct, product);
        }
        return (int) maxProduct;
    }

    public static int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

       LinkedList<int[]> merged = new LinkedList<>();

       for(int[] interval: intervals){
           if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
               merged.add(interval);
           }else{
               merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
           }
       }
       return merged.toArray(new int[merged.size()][]);
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> response = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if(words[i].indexOf(x) != -1){
                response.add(i);
            }
        }
        return response;
    }
    public static int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = prices[0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + prices[i];

            for (int j = 0; j < i; j++) {
                if (j + prices[j] > i) {
                    dp[i] = Math.min(dp[i], dp[j] + prices[j]);
                }
            }
        }
        return dp[n - 1];
    }



    public static void main(String[] args) {
        System.out.println(minimumCoins(new int[]{3,1,2}));
        System.out.println(findWordsContaining(new String[]{"leet","code"}, 'e'));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6},{8, 10}, {15, 18}})));
        System.out.println(maximumXorProduct(12l, 5l, 4));
        System.out.println(findMinimumOperations("dac", "bac", "cac"));
        System.out.println(sumCounts(List.of(1, 1)));
        /*System.out.println(minimumSum(new int[]{5,4,8,7,10,2}));
        //System.out.println(shortestBeautifulSubstring("001110101101101111", 10));
        System.out.println(Arrays.toString(findIndices(new int[]{5, 1, 4, 1}, 2, 4)));
        System.out.println(differenceOfSums(10, 3));
        System.out.println(StringExercises.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}}));
        System.out.println(buddyStrings(new String("aa"), new String("aa")));
        System.out.println(generateParenthesis(3));
        System.out.println(twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
        System.out.println(minOperations(List.of(3, 1, 5, 4, 2), 2));
        System.out.println(removeKdigits("10", 2));
        System.out.println(minimumRightShifts(List.of(3, 4, 5, 1, 2)));
        System.out.println(findKthPositive(new int[]{1, 3, 4, 7, 8}, 7));
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(reverseWords2("Hola Luis"));
        System.out.println(countBinarySubstrings("00110011"));
        System.out.println(reverseWords("Hello World !"));
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(intersection(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 9, 2}));
        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(StringExercises.nextGreatestLetter(new char[]{'x', 'x', 'y'}, 'z'));
        System.out.println(StringExercises.sumIndicesWithKSetBits(List.of(4, 3, 2, 1), 2));
        System.out.println(Arrays.toString(new List[]{StringExercises.fizzBuzz(20)}));
        System.out.println(StringExercises.simpleArraySum(List.of(1, 2, 3, 4, 10, 11)));
        System.out.println(StringExercises.compareTriplets(List.of(1, 2, 3), List.of(4, 5, 6)));
        System.out.println(StringExercises.aVeryBigSum(List.of(1000000001L, 1000000002L, 1000000003L, 1000000004l, 1000000005l)));

        System.out.println(StringExercises.countCompleteSubarrays(new int[]{1, 3, 1, 2, 2}));

        System.out.println(StringExercises.minimumString("ab", "ba", "aba"));


        System.out.println(StringExercises.furthestPoint("L_RL__R"));

        System.out.println(StringExercises.minBeautifulArraySum(2, 3));


        System.out.println(StringExercises.convertToTitle(1));

        System.out.println(StringExercises.canBeEqual("abcd", "cdab"));

        System.out.println(StringExercises.isIsomorphic("foo", "bar"));

        System.out.println(StringExercises.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));*/

    }


}