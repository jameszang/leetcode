// https://leetcode.com/problems/3sum/

import scala.collection.immutable.HashSet;

object Solution {
    def threeSum(nums: Array[Int]): List[List[Int]] = {
        // sort the array of nums
        scala.util.Sorting.quickSort(nums);
        
        // initialize answer matrix and a set for checking duplicates
        var ans: List[List[Int]] = List();
        var visited: Set[List[Int]] = HashSet();
        
        // for each i in nums, perform 2sum for -i from index(i) + 1 to nums.length - 1
        for (i <- 0 to nums.length - 1) {
            var twoSumAns = twoSumSorted(nums, i + 1, nums.length, nums(i) * -1);
            for (pair <- twoSumAns) {
                var triplet = (nums(i) :: pair).sorted;
                if (!visited.contains(triplet)) {
                    visited = visited + triplet;
                    ans = triplet :: ans;
                }
            }
        }
        return ans;
    }
    
    // implementation of twoSum for a sorted array, starting at index start (inclusive) and ending at index end (exclusive)
    def twoSumSorted(nums: Array[Int], start: Int, end: Int, value: Int): List[List[Int]] = {
        var ans: List[List[Int]] = List();
        var i = start;
        var j = end - 1;
        while (i < j) {
            var curr = nums(i) + nums(j);
            if (curr < value) {
                i += 1;
            } else if (curr > value) {
                j -= 1;
            } else {
                ans = List(nums(i), nums(j)) :: ans;
                i += 1;
            }
        }
        return ans;
    }
}