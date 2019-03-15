// https://leetcode.com/problems/implement-strstr/

import scala.util.control._

object Solution {
    def strStr(haystack: String, needle: String): Int = {
        if (needle == "") {
            return 0;
        }
        
        for (i <- 0 to (haystack.length - needle.length)) {
            if (haystack(i) == needle(0)) {
                var found: Boolean = true;
                var inner = new Breaks;
                inner.breakable {
                    for (j <- 1 until needle.length) {
                        if (haystack(i + j) != needle(j)) {
                            found = false;
                            inner.break;
                        }
                    }
                }
                if (found) {
                    return i;
                }
            }
        }
        return -1;
    }
}