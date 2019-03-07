// https://leetcode.com/problems/longest-common-prefix/

import "bytes"

func longestCommonPrefix(strs []string) string {
    if len(strs) == 0 {
        return ""
    }
    
    var buffer bytes.Buffer

    idx := 0
    for {
        good := true
        if idx >= len(strs[0]) {
            break
        }
        curr := strs[0][idx]
        for i := 1; i < len(strs); i++ {
            if idx >= len(strs[i]) || strs[i][idx] != curr {
                good = false
                break
            }
        }
        if good {
            buffer.WriteString(string(curr))
        } else {
            break
        }
        idx++
    }
    
    return buffer.String()
}