/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    return searchHelper(nums, target, 0, nums.length - 1);
};

let searchHelper = function(nums, target, lower, upper) {
    // base case: 2 elements or less
    if (upper - lower < 2) {
        if (target === nums[lower]) {
            return lower;
        } else if (target === nums[upper]) {
            return upper;
        } else {
            return -1;
        }
    }

    // recursive case: at least 3 elements
    let mid = Math.floor((lower + upper) / 2);
        
    if (target === nums[mid]) {
        return mid;
    }
    
    if (target > nums[mid]) {
        if (nums[mid-1] < nums[mid] && nums[mid+1] > nums[mid]) { // we are a normal number
            if (nums[mid] < nums[upper]) { // if mid is smaller than upper, then the pivot is on the left
                if (target <= nums[upper]) {
                    return searchHelper(nums, target, mid + 1, upper);
                } else {
                    return searchHelper(nums, target, lower, mid - 1);
                }
            } else { // nums[mid] > nums[upper]
                return searchHelper(nums, target, mid + 1, upper);
            }
        } else if (nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]) { // we are the largest
            return -1;
        } else { // nums[mid-1] > nums[mid] && nums[mid+1] > nums[mid] // we are the smallest
            if (target <= nums[upper]) {
                return searchHelper(nums, target, mid + 1, upper);
            } else {
                return searchHelper(nums, target, lower, mid - 1);
            }
        }
    } else { // target < nums[mid]
        if (nums[mid-1] < nums[mid] && nums[mid+1] > nums[mid]) { // we are a normal number
            if (nums[mid] > nums[lower]) {
                if (target >= nums[lower]) {
                    return searchHelper(nums, target, lower, mid - 1);
                } else {
                    return searchHelper(nums, target, mid + 1, upper);
                }
            } else { // nums[mid] < nums[lower]
                return searchHelper(nums, target, lower, mid - 1);
            }
        } else if (nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]) { // we are the largest
            if (target >= nums[lower]) {
                return searchHelper(nums, target, lower, mid - 1);
            } else {
                return searchHelper(nums, target, mid + 1, upper);
            }
        } else { // nums[mid-1] > nums[mid] && nums[mid+1] > nums[mid] // we are the smallest
            return -1;
        }
    }
}