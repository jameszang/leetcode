// https://leetcode.com/problems/longest-palindromic-substring/

func longestPalindrome(s string) string {
	if s == "" {
		return ""
	}

	// set n = size of s
	n := len(s)

	// initialize 2D array for dp
	dp := make([][]bool, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]bool, n)
	}

	// every letter is a palindrome of length 1, and every two
	// same, adjacent letters are palindromes of length 2
	maxLen, left, right := 1, 0, 0
	for i := 0; i < n; i++ {
		dp[i][i] = true
		if (i < n-1) && (s[i] == s[i+1]) {
			dp[i][i+1] = true
			maxLen, left, right = 2, i, i+1
		}
	}

	// fill out dp table by checking all the substrings of len 3,
	// then len 4, ... up to len n
	for len := 3; len <= n; len++ {
		for i := 0; i < n; i++ {
			if j := i + len - 1; j < n {
				if s[i] == s[j] && dp[i+1][j-1] {
					dp[i][j] = true
					if j-i+1 > maxLen {
						maxLen, left, right = j-i+1, i, j
					}
				}
			}
		}
	}

	runes := []rune(s)
	ans := string(runes[left : right+1])

	return ans
}