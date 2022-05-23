package com.shen.easy;

/**
 * 
 * @author Cometstrike
 * 
 * 
 *         Given an integer x, return true if x is palindrome integer.
 * 
 *         An integer is a palindrome when it reads the same backward as
 *         forward.
 * 
 *         For example, 121 is a palindrome while 123 is not.
 * 
 *         Example 1:
 * 
 *         Input: x = 121 Output: true Explanation: 121 reads as 121 from left
 *         to right and from right to left. Example 2:
 * 
 *         Input: x = -121 Output: false Explanation: From left to right, it
 *         reads -121. From right to left, it becomes 121-. Therefore it is not
 *         a palindrome. Example 3:
 * 
 *         Input: x = 10 Output: false Explanation: Reads 01 from right to left.
 *         Therefore it is not a palindrome.
 * 
 * 
 *         Constraints:
 * 
 *         -231 <= x <= 231 - 1
 * 
 * 
 *         Follow up: Could you solve it without converting the integer to a
 *         string?
 *
 */

public class PalindromeNumber {

	// this is probably the intuitive solution by converting it into a string then
	// comparing end values to beginning values, but you only need to go up until
	// the mid point
	public boolean isPalindromeIntuitiveSolution(int x) {
		// take care of easiest cases first
		if (x < 0) {
			return false;
		}
		if (x == 0 || x == 1) {
			return true;
		}
		char[] xCharArray = String.valueOf(x).toCharArray();

		for (int i = 0; i < xCharArray.length / 2; i++) {
			if (xCharArray[i] != xCharArray[xCharArray.length - i - 1]) {
				return false;
			}
		}

		return true;
	}

	// we still take care of easiest cases first, the findReversedX private method
	// basically says everytime I iterate, if x divide by 10 is not 0, then that
	// means the previous digit I got I need to times it by 10 in order to reflect
	// the reverted numeric value
	// for example, if 12 divide by 10 is not 0, then 12 mod 10 reminder 2 should
	// actually be 20, therefore times by 10 then we add the 1 mod by 10 1 to make
	// it 21 which is a reverse of 12
	public boolean isPalindromeChallenge(int x) {
		// take care of easiest cases first
		if (x < 0) {
			return false;
		}
		if (x == 0 || x == 1) {
			return true;
		}
		int revertedX = findReversedX(x);

		return x == revertedX ? true : false;
	}

	private int findReversedX(int x) {
		int reversedX = 0;
		int remainder = 0;
		for (; x != 0; x /= 10) {
			remainder = x % 10;
			reversedX = reversedX * 10 + remainder;
		}
		return reversedX;
	}

}
