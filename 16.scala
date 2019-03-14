// https://leetcode.com/problems/3sum-closest/

object Solution {
    def threeSumClosest(nums: Array[Int], target: Int): Int = {
        // sort the array of nums
        scala.util.Sorting.quickSort(nums);
        
        // initialize answer
        var ans = nums(0) + nums(1) + nums(2);
        
        // for each i in nums, perform best effort 2sum for target - nums(i) from index(i) + 1 to nums.length - 3
        for (i <- 0 to nums.length - 3) {
            var twoSumAns = twoSumSortedClosest(nums, i + 1, nums.length, target - nums(i));
            var candidate = twoSumAns + nums(i);
            if (scala.math.abs(target - candidate) < scala.math.abs(target - ans)) {
                ans = candidate;
            }
        }
        return ans;
    }
    
    // implementation of best effort twoSum for a sorted array, starting at index start (inclusive) and ending at index end (exclusive)
    def twoSumSortedClosest(nums: Array[Int], start: Int, end: Int, target: Int): Int = {
        var ans = nums(start) + nums(end - 1);
        var i = start;
        var j = end - 1;
        while (i < j) {
            var curr = nums(i) + nums(j);
            // update ans if curr is closer to target
            if (scala.math.abs(target - curr) < scala.math.abs(target - ans)) {
                ans = curr;
            }
            if (curr < target) {
                i += 1;
            } else if (curr > target) {
                j -= 1;
            } else {
                return curr;       
            }
        }
        println(start, end, target, ans);
        return ans;
    }
}