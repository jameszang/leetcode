// https://leetcode.com/problems/integer-to-roman/

import "bytes"

func intToRoman(num int) string {
	var buffer bytes.Buffer

	remaining := num
	for remaining > 0 {
		switch {
		case remaining >= 1000:
			buffer.WriteString("M")
			remaining -= 1000

		case remaining >= 900:
			buffer.WriteString("CM")
			remaining -= 900

		case remaining >= 500:
			buffer.WriteString("D")
			remaining -= 500

		case remaining >= 400:
			buffer.WriteString("CD")
			remaining -= 400

		case remaining >= 100:
			buffer.WriteString("C")
			remaining -= 100

		case remaining >= 90:
			buffer.WriteString("XC")
			remaining -= 90

		case remaining >= 50:
			buffer.WriteString("L")
			remaining -= 50

		case remaining >= 40:
			buffer.WriteString("XL")
			remaining -= 40

		case remaining >= 10:
			buffer.WriteString("X")
			remaining -= 10

		case remaining >= 9:
			buffer.WriteString("IX")
			remaining -= 9

		case remaining >= 5:
			buffer.WriteString("V")
			remaining -= 5

		case remaining >= 4:
			buffer.WriteString("IV")
			remaining -= 4

		default:
			buffer.WriteString("I")
			remaining--
		}
	}

	return buffer.String()
}