// https://leetcode.com/problems/container-with-most-water/

import scala.math;

object Solution {
    def maxArea(height: Array[Int]): Int = {
        // Initialize maxArea as the container formed by the first and last lines. This is the widest possible container so it is a good starting point.
        var left = 0;
        var right = height.length - 1;
        var maxArea = math.min(height(left), height(right)) * (right - left);
        
        var currArea = 0;

        // Iterate through array with left and right pointers, keeping the taller side for each iteration.
        //    We keep the taller side because the container width is shrinking as we iterate. Thus, in order to 
        //    be better than the maxArea, the container must increase in height. Keeping the shorter side would 
        //    not increase the height, so it cannot possibly be the solution.
        while (left <= right) {
            if (height(left) > height(right)) {
                currArea = height(right) * (right - left);
                right -= 1;
            } else {
                currArea = height(left) * (right - left);
                left += 1;
            }
            
            if (currArea > maxArea) {
                maxArea = currArea;
            }
        }
        return maxArea;
    }
}