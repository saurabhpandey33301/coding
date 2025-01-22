#include<bits/stdc++.h>

using namespace std;

int main(){
   string s = "";
   cin>>s;
   map<char,int> mp;
   
   int l = s.length();
   for(int i=0;i<l;i++){
       mp[s[i]]++;
   }
   cout<<"our required frequency is:"<<endl;
   for(auto it:mp){
       cout<<it.first<<" "<<it.second;
       cout<<endl;
   }

    return 0;

}