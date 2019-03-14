// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import scala.collection.mutable.MutableList

object Solution {
    val numToLetters: Map[Char,String] = Map(
        '2' -> "abc",
        '3' -> "def",
        '4' -> "ghi",
        '5' -> "jkl",
        '6' -> "mno",
        '7' -> "pqrs",
        '8' -> "tuv", 
        '9' -> "wxyz"
    );
    
    def letterCombinations(digits: String): List[String] = {
        var ans: MutableList[String] = MutableList();
        recursiveBuildAns(digits, 0, "", ans)
        return ans.toList;
    }
    
    def recursiveBuildAns(digits: String, idx: Int, acc: String, ans: MutableList[String]): Unit = {
        if (idx == digits.length() - 1) {
            var currDigit: Char = digits.charAt(idx);
            var mapping: String = numToLetters.get(currDigit).get;
            for (i <- mapping) {
                ans += (acc + i);
            }
        } else if (idx < digits.length()) {
            var currDigit: Char = digits.charAt(idx);
            var mapping: String = numToLetters.get(currDigit).get;
            for (i <- mapping) {
                recursiveBuildAns(digits, idx + 1, acc + i, ans);
            }
        }
    }
}