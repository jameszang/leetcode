// https://leetcode.com/problems/string-to-integer-atoi/

import "math"

func myAtoi(str string) int {    
    var firstChar rune
    var firstIdx int
    for i, c := range str {
        if c != ' ' {
            firstChar, firstIdx = c, i
            break
        }
    }
    
    var positive bool
    ans := 0
    if !(firstChar >= '0' && firstChar <= '9') && firstChar != '-' && firstChar != '+' {
        return 0
    } else {
        if firstChar == '-' {
            positive = false
            firstIdx++
        } else if firstChar == '+' {
            positive = true
            firstIdx++
        } else {
            positive = true
        }
        
        // remove leading 0's
        for firstIdx < len(str) && str[firstIdx] == '0' {
            firstIdx++
        }
        
        digits := make([]int, 0)
        for firstIdx < len(str) && str[firstIdx] >= '0' && str[firstIdx] <= '9' {
            digits = append(digits, int(str[firstIdx] - '0'))
            firstIdx++
        }
        
        power := 0
        for i := len(digits) - 1; i >= 0; i-- {
            if power > 9 || float64(ans) > float64(math.MaxInt32 % 1000000000) {
                if positive {
                    if power <= 9 && digits[i] == 1 && i == 0 {
                        return (ans + digits[i] * int(math.Pow10(power)))
                    } else {
                        return math.MaxInt32
                    }
                } else {
                    if power <= 9 && digits[i] == 1 && i == 0 {
                        return (-1 * (ans + digits[i] * int(math.Pow10(power))))
                    } else {
                        return math.MinInt32
                    }
                }
            }
            ans += digits[i] * int(math.Pow10(power))
            power++
        }
        if positive {
            return ans
        } else {
            return ans * -1
        }
    }
}