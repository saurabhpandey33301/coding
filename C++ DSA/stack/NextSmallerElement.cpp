#include<bits/stdc++.h>

using namespace std;

vector<int> NextSmallerElement(vector<int> &arr){
    stack<int> st;
    vector<int> ans;
    for (int i = 0; i < arr.size(); i++)
    {
        while (!st.empty()&& st.top()>= arr[i])
        {
            st.pop();
        }
        if(st.empty()==true){
            ans.push_back(-1);
        }else{
            ans.push_back(st.top());
        }
        st.push(arr[i]);
        
    }
    return ans;
    
    
}

int main(){
    vector<int> arr = {1,3,4,2};
    vector<int> ans;
    ans = NextSmallerElement(arr);
    for(auto it:ans){
        cout<<it<<" ";
    }


    return 0;
}