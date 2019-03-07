// https://leetcode.com/problems/zigzag-conversion/

import "bytes"

func convert(s string, numRows int) string {
    if numRows == 1 || s == "" {
        return s
    }
    
    buffers := make([]bytes.Buffer, numRows)
    
    inc := 1
    for row, i := 0, 0; i < len(s); i++ {
        buffers[row].WriteString(string(s[i]))
        row += inc
        if row >= numRows {
            row = numRows - 2
            inc *= -1
        } else if row < 0 {
            row = 1
            inc *= -1
        }
    }
    
    masterBuffer := bytes.Buffer{}
    for _, buf := range buffers {
        masterBuffer.WriteString(buf.String())
    }
    
    return masterBuffer.String()
}