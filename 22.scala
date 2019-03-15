// https://leetcode.com/problems/generate-parentheses/

import scala.collection.mutable.MutableList

object Solution {
    val OpenParen: Char = '(';
    val CloseParen: Char = ')';
    def generateParenthesis(n: Int): List[String] = {
        var ans: MutableList[String] = MutableList();
        recursiveAddParenthesis(n, 0, 0, "", ans);
        return ans.toList;
    }
    
    def recursiveAddParenthesis(n: Int, open: Int, close: Int, acc: String, ans: MutableList[String]): Unit = {
        if (open == n && close == n) {
            ans += acc;
        } else {
            if (open < n) {
                recursiveAddParenthesis(n, open + 1, close, acc + OpenParen, ans);
            }
            if (close < open) {
                recursiveAddParenthesis(n, open, close + 1, acc + CloseParen, ans);
            }
        }
    }
}