// https://leetcode.com/problems/subsets/

#include <bits/stdc++.h>

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        ans.push_back(vector<int>());
        
        for (int i = 0; i < nums.size(); i++) {
            int currIterationSize = ans.size();
            for (int j = 0; j < currIterationSize; j++) {
                vector<int> temp = ans[j];
                temp.push_back(nums[i]);
                ans.push_back(temp);
            }
        }
        return ans;
    }
};