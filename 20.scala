// https://leetcode.com/problems/valid-parentheses/

object Solution {
    val closeToOpen: Map[Char, Char] = Map(
        ')' -> '(',
        '}' -> '{',
        ']' -> '['
    );

    def isValid(s: String): Boolean = {
        var stack: List[Char] = List[Char](); // scala's Stack class is deprecated...
        
        for (i <- s) {
            if (i == '(' || i == '{' || i == '[') {
                stack = i +: stack;
            } else {
                if (stack.isEmpty || stack.head != closeToOpen.get(i).get) {
                    return false;
                }
                stack = stack.tail;
            }
        }
        return stack.isEmpty;
    }
}