// https://leetcode.com/problems/roman-to-integer/

func romanToInt(s string) int {
	n := len(s)
	ans, index := 0, 0
	for index < n {
		switch {
		case s[index] == 'M':
			ans += 1000
			index++

		case s[index] == 'D':
			ans += 500
			index++

		case s[index] == 'C':
			if index+1 < n {
				if s[index+1] == 'M' {
					ans += 900
					index += 2
				} else if s[index+1] == 'D' {
					ans += 400
					index += 2
				} else {
					ans += 100
					index++
				}
			} else {
				ans += 100
				index++
			}

		case s[index] == 'L':
			ans += 50
			index++

		case s[index] == 'X':
			if index+1 < n {
				if s[index+1] == 'C' {
					ans += 90
					index += 2
				} else if s[index+1] == 'L' {
					ans += 40
					index += 2
				} else {
					ans += 10
					index++
				}
			} else {
				ans += 10
				index++
			}

		case s[index] == 'V':
			ans += 5
			index++

		case s[index] == 'I':
			if index+1 < n {
				if s[index+1] == 'X' {
					ans += 9
					index += 2
				} else if s[index+1] == 'V' {
					ans += 4
					index += 2
				} else {
					ans += 1
					index++
				}
			} else {
				ans += 1
				index++
			}
		}
	}
	return ans
}