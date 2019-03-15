// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

object Solution {
    def removeDuplicates(nums: Array[Int]): Int = {
        if (nums.isEmpty) {
            return 0;
        }
        
        var prevUnique: Int = nums(0);
        var numUnique: Int = 1;
        for (i <- 1 until nums.length) {
            if (nums(i) != prevUnique) {
                prevUnique = nums(i);
                var temp: Int = nums(numUnique);
                nums(numUnique) = nums(i);
                nums(i) = temp;
                numUnique += 1;
            }
        }
        return numUnique;
    }
}