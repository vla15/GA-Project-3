package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isPalindrome("abcba"));
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(binarySearch(numbers, 7));
    }

    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int size = chars.length;
        String reverseString = "";
        for (int i = size - 1; i >= 0; i--) {
            reverseString += chars[i];
        }
        return str.equals(reverseString);
    }

    public static boolean binarySearch(ArrayList<Integer> nums, int target) {
        int start = 0;
        int end = nums.size();
        int mid = (start +  end) / 2;
        while (start < end) {
            if (target == nums.get(mid)) {
                return true;
            }
            if (target > nums.get(mid)) {
                start = mid + 1;
                mid = (start +  end) / 2;
            } else {
                end = mid - 1;
                mid = (start +  end) / 2;
            }
        }
        return false;
    }
}
