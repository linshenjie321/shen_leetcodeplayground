package com.shen.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Cometstrike
 *
 *         Note: I did not come up with this problem, this problem is directly
 *         taken out of https://leetcode.com/problems/two-sum/
 * 
 *         Given an array of integers nums and an integer target, return indices
 *         of the two numbers such that they add up to target.
 * 
 *         You may assume that each input would have exactly one solution, and
 *         you may not use the same element twice.
 * 
 *         You can return the answer in any order.
 * 
 *         Example 1:
 * 
 *         Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation:
 *         Because nums[0] + nums[1] == 9, we return [0, 1]. Example 2:
 * 
 *         Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3:
 * 
 *         Input: nums = [3,3], target = 6 Output: [0,1]
 * 
 * 
 *         Constraints:
 * 
 *         2 <= nums.length <= 104 -109 <= nums[i] <= 109 -109 <= target <= 109
 *         Only one valid answer exists.
 * 
 * 
 *         Follow-up: Can you come up with an algorithm that is less than O(n2)
 *         time complexity?
 *
 */

public class TwoSum {

	public int[] twoSumIntuitiveSolution(int[] nums, int target) {
		int[] answer = new int[2];
		// we can assume this due to the question guaranteeing us that there will
		// definitely be a solution, otherwise we should handle it by throwing an
		// exception at the end indicating there isn't any solution
		if (nums.length == 2) {
			answer[0] = 0;
			answer[1] = 1;
			return answer;
		}
		// by default, the most straight forward way to think about this is to simply
		// loop through the entire array, trying out all possible ways to add two
		// numbers together and simply comparing it to the target sum
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					answer[0] = i;
					answer[1] = j;
					return answer;
				}
			}
		}
		return answer;
	}

	/*
	 * since we want to find within the array what are the two numbers that will add
	 * up to the target, and since we are already looping through the array, each
	 * time we come across an element, we should remember it because one of the
	 * later elements could be its complement that add up to the target. we can
	 * store the current element in a HashMap as the key with its index as the value
	 * so we can search if the next array element's complement is within the HashMap
	 * already if we find it that means the current element index plus the previous
	 * element's index are the indexes that we can return since question guarantees
	 * there is only one unique solution
	 */
	public int[] twoSumOptimalSolution(int[] nums, int target) {
		Map<Integer, Integer> complementMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (complementMap.containsKey(complement)) {
				return new int[] { complementMap.get(complement), i };
			}
			complementMap.put(nums[i], i);
		}
		return new int[] {};
	}

}
