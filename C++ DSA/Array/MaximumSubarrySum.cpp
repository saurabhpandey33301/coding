#include<bits/stdc++.h>
using namespace std;

//kadane's algorithm to find the maximum subarray sum

int maxSubArraySum(vector<int>& nums) {
    int maxSum = INT_MIN; // Initialize to the smallest integer
    int currentSum = 0;   // Current subarray sum

    for (int num : nums) {
        currentSum += num; // Add current number to the current sum
        maxSum = max(maxSum, currentSum); // Update maxSum if currentSum is greater

        if (currentSum < 0) {
            currentSum = 0; // Reset current sum if it becomes negative
        }
    }

    return maxSum; // Return the maximum subarray sum found
}

int main() {
    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int result = maxSubArraySum(nums);
    cout << "Maximum Subarray Sum: " << result << endl; // Output: 6
    return 0;
}