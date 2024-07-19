#include<bits/stdc++.h>   //includes all library...
//#include<string>


using namespace std;

int main(){
    string s = "hello";
    int len = s.length();
    int sum=0;
    int dif = 0;
    for(int i=0;i<len-1;i++){
        if(int(s[i])>int(s[i+1])){
            dif = int(s[i])-int(s[i+1]);
        }else{
            dif =int(s[i+1])-int(s[i]);
        }
        sum = sum +  dif ;
    }
    
    cout<<sum<<endl;
}