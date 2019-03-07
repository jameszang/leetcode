// https://leetcode.com/problems/two-sum/

func twoSum(nums []int, target int) []int {
	david := make(map[int]int)
	for i, v := range nums {
		if _, prs := david[v]; prs {
			return []int{david[v], i}
		} else {
			david[target-v] = i
		}
	}
	return []int{-1, -1}
}