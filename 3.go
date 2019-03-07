// https://leetcode.com/problems/longest-substring-without-repeating-characters/

func lengthOfLongestSubstring(s string) int {
	charToLastIndex := make(map[rune]int)
	// curr := 0
	begin := 0
	max := 0

	for i, c := range s {
		lastIdx, prs := charToLastIndex[c]

		if prs && lastIdx+1 > begin {
			begin = lastIdx + 1
		}

		charToLastIndex[c] = i
		if curr := i - begin + 1; curr > max {
			max = curr
		}
	}

	if max == 0 {
		max = len(s)
	}

	return max
}