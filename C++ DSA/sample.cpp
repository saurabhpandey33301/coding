#include<bits/stdc++.h>

using namespace std;

int main(){
//    string s = "";
//    cin>>s;
//    map<char,int> mp;
   
//    int l = s.length();
//    for(int i=0;i<l;i++){
//        mp[s[i]]++;
//    }
//    cout<<"our required frequency is:"<<endl;
//    for(auto it:mp){
//        cout<<it.first<<" "<<it.second;
//        cout<<endl;
//    }
     int arr[6] = {1,2,2,8,5,9};
     set <int> s;
     for(auto it:arr){
         s.insert(it);
     }
    for(auto it:s){
        cout<<it<<" ";
    }
    return 0;

}