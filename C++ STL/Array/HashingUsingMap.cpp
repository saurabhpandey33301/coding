#include<bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin>>n;
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cin>>arr[i];
    }

    //prerequist......
    map<int,int> mpp;
    for (int i = 0; i < n; i++)
    {
        mpp[arr[i]]++;
    }

    //frequency output based on user input....
    // int q;
    // cin>>q;
    // int key;
    // while(q--){
    //     cin>>key;
    //     cout<<mpp[key]<<endl;
    // }

    // finding the highest and lowest frequency element and their frequency......
    int maxi = 0;
    int max_idx = 0;
    int min = mpp[1];
    int min_idx = 0;

    for(auto it:mpp){
        if(it.second>maxi){
            maxi = it.second;
            max_idx = it.first;
        }
    }
    for(auto it:mpp){
        
        if(it.second<min){
            min = it.second;
            min_idx = it.first;
        }
    }
    cout<<"minimum element "<<min_idx<<" :- "<<min<<" times"<<endl;

    cout<<"maximum element "<<max_idx<<" :- "<<maxi<<" times"<<endl;


    
    
}