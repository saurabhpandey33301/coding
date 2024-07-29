#include<bits/stdc++.h>

using namespace std;

int SqrtUsingBS(int n,int k){
     
    int low = 0;
    int high = n;
    int fl=0;
    while (low<=high)
    {
        int mid = low + (high-low)/2;
        int m = pow(mid,k);
        if((m)==n){
            return mid;
        }
        else if((m)<n){
            low = mid+1;
        }else{
            high = mid-1;
        }
        fl = floor((low+high)/2);
    }
    cout<<"here"<<endl;
    return fl;
     
}

int main(){
    
    int n = 101;
    cout<<SqrtUsingBS(1000,3)<<endl;
    return 0;
    
}
