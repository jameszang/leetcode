// https://leetcode.com/problems/reverse-integer/

import "math"
import "strconv"

func reverse(x int) int {
    flag := x < 0
    
    var y int
    if flag {
        y = int(math.Abs(float64(x)))
    } else {
        y = x
    }
    
    ans := 0
    power := len(strconv.Itoa(y)) - 1
    
    for y > 0 {
        temp := y % 10
        y /= 10
        ans += temp * int(math.Pow10(power))
        
        if ans > math.MaxInt32 {
            return 0
        }
        
        power--
    }
    
    if flag {
        ans *= -1
    }
    
    return ans
}