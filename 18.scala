// https://leetcode.com/problems/4sum/

import scala.collection.immutable.HashSet;

object Solution {
    def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
        // sort the array
        scala.util.Sorting.quickSort(nums);
        
        // initialize answer matrix and a set for checking duplicates
        var ans: List[List[Int]] = List();
        var visited: Set[List[Int]] = HashSet();
        
        // for each i in nums, perform 3sum for value - i from index(i) + 1 to nums.length - 1
        for (i <- 0 to nums.length - 1) {
            var threeSumAns = threeSumSorted(nums, i + 1, nums.length, target - nums(i));
            for (triplet <- threeSumAns) {
                var quadruplet = (nums(i) :: triplet).sorted;
                if (!visited.contains(quadruplet)) {
                    visited = visited + quadruplet;
                    ans = quadruplet :: ans;
                }
            }
        }
        return ans;
    }
    
    // implementation of threeSum for a sorted array, starting at index start (inclusive) and ending at index end (exclusive)
    def threeSumSorted(nums: Array[Int], start: Int, end: Int, value: Int): List[List[Int]] = {
        // initialize answer matrix and a set for checking duplicates
        var ans: List[List[Int]] = List();
        var visited: Set[List[Int]] = HashSet();
        
        // for each i in nums, perform 2sum for value - i from index(i) + 1 to nums.length - 1
        for (i <- start to end - 1) {
            var twoSumAns = twoSumSorted(nums, i + 1, nums.length, value - nums(i));
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