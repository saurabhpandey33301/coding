#include<bits/stdc++.h>

using namespace std;

string TwoSum(vector<int> &arr,int k,int size){
    map<int,int> mpp;

    int moreNedded;

    for (int i = 0; i < size; i++)
    {
        moreNedded = k-arr[i];
        if(mpp.find(moreNedded)!= mpp.end() && mpp[moreNedded]!=i){
            cout<<mpp[moreNedded]<<" "<<i<<endl;
            return "yes";
        }
        mpp[arr[i]] = i;
    }
    return "no";
}

string twoSumUsingTwoPointer(int n, vector<int> &arr, int target) {
    
    sort(arr.begin(), arr.end());
    int left = 0, right = n - 1;
    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) {
            return "YES";
        }
        else if (sum < target) left++;
        else right--;
    }
    return "NO";
}

int main(){
    vector<int> arr = {3,2,4};
    int n = arr.size();
    int k=5;
    int cnt=0;

    // time complexity => O(n^2) space complexity => O(1)...............(brute force approach)
    // for (int i = 0; i < size; i++)
    // {
    //     for (int j = 0; j < size; j++)
    //     {
    //         if(arr[i]+arr[j]==k && i!=j){
    //             cout<<"Yes"<<endl;
    //             cout<<i<<" "<<j<<endl;
    //             cnt++;
    //             break;
    //         }
    //     }
    //     if(cnt==1){
    //         break;
    //     }
        
    // }

    // better approach .........( time complexity -> O(N) & space complexity -> O(N))  using hashMap ....
     
    cout<<TwoSum(arr,k,n)<<endl;
    
    // optimal approach .......(  time complexity -> O(N) & space complexity -> O(1) )  using Two Pointer.....

    //cout<<twoSumUsingTwoPointer(n,arr,k)<<endl;


}