// https://leetcode.com/problems/fibonacci-number/

/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
    let fib = [0, 1];
    
    for (let i = 2; i <= 30; i++) {
        fib.push(fib[i-1] + fib[i-2]);
    }
    
    return fib[n];
};