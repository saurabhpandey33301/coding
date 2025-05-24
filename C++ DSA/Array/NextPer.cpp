#include<bits/stdc++.h>

using namespace std;

void nextPermutation(vector<int>& nums) {
        int idx=-1;
        int n = nums.size();
        // finding the breaking point
        // where the next number is greater than the current number
        for(int i=n-2;i>=0;i--){
               if(nums[i]<nums[i+1]){
                  idx = i;
                  break;
               }
        }
        // if no such point is found, it means the array is in descending order
        // so we reverse the entire array to get the smallest permutation
        if(idx==-1){
            sort(nums.begin(),nums.end());
            return;
        }
        // finding the next greater element to swap with
        // the element at the breaking point
        for(int i=n-1;i>idx;i--){
            if(nums[i]>nums[idx]){
                int t = nums[idx];
                nums[idx] = nums[i];
                nums[i] = t;
                break;
            }
        }
        // sorting the elements after the breaking point
        // to get the next permutation in ascending order
        sort(nums.begin()+idx+1,nums.end());
}

int main(){
    vector<int> nums = {1,2,3};
    nextPermutation(nums);
    for(int i=0;i<nums.size();i++){
        cout<<nums[i]<<" ";
    }
    cout<<endl;

    //or using STL
    next_permutation(nums.begin(), nums.end());
    for(int i=0;i<nums.size();i++){
        cout<<nums[i]<<" ";
    }
    cout<<endl;
   
    return 0;
}