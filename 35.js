// https://leetcode.com/problems/search-insert-position/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    return modifiedBinarySearch(nums, target, 0, nums.length - 1);
};

let modifiedBinarySearch = function(nums, target, lower, upper) {
    // base case: 1 element
    if (lower === upper) {
        if (target === nums[lower]) {
            return lower;
        } else if (target > nums[lower]) {
            return lower + 1;
        } else { // target < nums[lower]
            return lower;
        }
    }
    
    // base case: 2 elements
    if (lower === upper - 1) {
        if (target === nums[lower]) {
            return lower;
        } else if (target === nums[upper]) {
            return upper;
        } else if (target < nums[lower]) {
            return lower;
        } else if (target > nums[upper]) {
            return upper + 1;
        } else {
            return upper;
        }
    }
    
    let mid = Math.floor((lower + upper) / 2);
    
    if (target === nums[mid]) {
        return mid;
    } else if (target > nums[mid]) {
        return modifiedBinarySearch(nums, target, mid + 1, upper);
    } else {
        return modifiedBinarySearch(nums, target, lower, mid - 1);
    }
}