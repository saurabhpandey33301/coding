#include<bits/stdc++.h>
using namespace std;

int longestSubarray(vector<int> nums) {

        int maxi = *max_element(nums.begin(), nums.end());
        int max_len = 0, curr_len = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == maxi) {
                curr_len++;
                max_len = max(max_len, curr_len);
            } else {
                curr_len = 0;
            }
        }

        return max_len; 
}
int main(){
    // concept is a subarray containing maximum bitwise AND must have subarray 
    //which have larget element of that subarray.

    vector<int> v = {1,2,3,3,2,2};
    cout<<longestSubarray(v);

}