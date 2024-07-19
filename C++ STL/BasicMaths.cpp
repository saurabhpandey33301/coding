#include<bits/stdc++.h>

using namespace std;


int main(){

    // int n = 5854652;
    // int cnt = 0;
    // while(n>0){            //time complexity O(log_10 N + 1)
    //     n = n/10;
    //     cnt++;
    // }
    //int cnt1 = (int)(log10(n)+1);      // this way time complexity will be O(1) 
    // cout<<cnt<<endl;
    // cout<<cnt<<endl;


    //reverse a digit....
    
    // int num1 = 555;
    // int num3 = num1;
    // int num2 = 0;
    // int cnt2 = (int)(log10(num1)+1); 
    // //cout<<(num1%10)*pow(10,cnt2-1)<<endl; 

    // while(num1>0){
    //     int ad = (num1%10)*pow(10,(cnt2-1));
    //     num2 = num2 + ad;
    //     num1 = num1/10;
    //     cnt2--;

    // }
    // cout<<num2+1<<endl;    //some glitch here
    
    // to check number is palindrome...

    // if(num3 == (num2+1)){
    //     cout<<"the number is Palindrome"<<endl;
    // }else{
    //     cout<<"the number is not Palindrome"<<endl;
    // }

    // to check number is armstong or not....
    // int no = 153;
    // int dummy = no;
    // int count  = (int)(log10(no)+1);
    // //int count = to_string(num).length();     //you can also use this to check the no. of digits
    // int arm=0;
    // while(no>0){
    //     int di = (no%10);
    //     arm += pow(di,count);
    //     no = no/10;
    // }
    // if(dummy = arm){
    //     cout<<"number is armstrong"<<endl;
    // }else{
    //     cout<<"number is not armstrong"<<endl;
    // }

    //to find all the divisor

    //brute force approach...
    // int num5 = 36;
    // int i = 1;
    // while(num5>0){
    //     if(num5%i==0){
    //         cout<<i<<" "<<endl;
    //     }
    //     i++;
    // }
    // cout<<endl;

    // optimal approach....
    // O(sqrt(N)) time complexity....
    // int n = 36;
    // vector<int> divisor;
    // int sqrtN = sqrt(n);
    // for(int j=1;j<=sqrtN;j++){
    //     if(n%j==0){
    //         divisor.push_back(j);
    //         if(j!= n/j){
    //             divisor.push_back(n/j);
    //         }
    //     }
    // }
    // for(auto it:divisor){
    //     cout<<it<<endl;
    // }



    //to find if a number is prime or not........

    int n1 = 7;
    int srt = (sqrt(n1));
    int cnt=0;
    for(int k = 1 ; k<= srt ; k++){
        if(n1%k==0){
            cnt++;
        }
    }
    if(cnt>2){
        cout<<"the number is not prime";
    }else{
        cout<<"the numbwer is prime ";
    }



}