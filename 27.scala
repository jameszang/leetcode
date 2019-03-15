// https://leetcode.com/problems/remove-element/

object Solution {
    def removeElement(nums: Array[Int], `val`: Int): Int = {
        var i: Int = 0;
        var j: Int = 0;
        
        while(i < nums.length) {
            if (nums(i) != `val`) {
                var temp: Int = nums(i);
                nums(i) = nums(j);
                nums(j) = temp;
                j += 1;
            }
            i += 1;
        }
        return j;
    }
}