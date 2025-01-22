#include<bits/stdc++.h>

using namespace std;

int m=0;
int n=0;

int gcd(int a,int b){

    if (a==0){
        return b;
    }
    if(a>b){
        m = a-b;
    }else{
        m = b-a;
    }
    n = min(a,b);

    gcd(m,n);
}

int main(){
    int a,b;
    cin>>a>>b;

    //brute force approach.....

    int c=0;
    // int len = min(a,b);
    // for(int i=2;i<3;i++){
    //         if(a%i==0 && b%i==0){
    //             c = i; 
    //         }else{
    //             c=1;
    //         }
    // }


    //optimal approach....
    
    c = gcd(a,b);
    cout<<c<<endl;
}