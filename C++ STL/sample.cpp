#include<bits/stdc++.h>

using namespace std;

int main(){
   int arr[]={7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
   int sz= sizeof(arr)/sizeof(arr[0]);
   int el=arr[0];
   int cnt=0;
   for (int  i = 0; i < 16 ; i++)
   { 
       if(arr[i]==el){
         //cout<<"P"<<endl;
         cnt++;
       }
       if(arr[i]!=el){
         //cout<<"M"<<endl;
         cnt--;
       }
       if(cnt==0 && i!=0){
            //cout<<el<<endl;
            el = arr[i+1];
            continue;
        }
       
   }
   cnt=0;
   for (int i = 0; i < sz; i++)
   {
      if(arr[i]==el){
        cnt++;
      }
   }
   if(cnt>sz/2){
     cout<<el<<" is majority element"<<endl;
   }else{
     cout<<"there is no majority element"<<endl;
   }
   
   
}