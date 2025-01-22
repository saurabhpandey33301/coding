#include<bits/stdc++.h>

using namespace std;


void print(int arr[],int size){
    for (int i = 0; i < size; i++)
    {
        cout<<arr[i]<<" ";
    }
    cout<<endl;
    
}

void SortArrayMethod(int arr[],int size){

    //Better approach ..... ( time complexity  -> O(N)+O(N)=> O(N)  space complexity => O(1) )
    // int cnt0=0,cnt1=0,cnt2=0;
    // for (int i = 0; i < size; i++)
    // {
    //     if(arr[i]==0){
    //         cnt0++;
    //     }else if(arr[i]==1){
    //         cnt1++;
    //     }else{
    //         cnt2++;
    //     }
    // }
    // for (int i = 0; i < cnt0; i++)
    // {
    //     arr[i]=0;
    // }
    // for (int i = cnt0; i < cnt0+cnt1; i++)
    // {
    //     arr[i]=1;
    // }
    // for (int i = cnt1+cnt0; i < size; i++)
    // {
    //     arr[i]=2;
    // }


    //two pointer method.... (time -> O(N) space -> O(1))
    // int i = 0;
    // int j=1;
    // while (i<j && j<size)
    // {
    //     if(arr[i]==0){
    //         i++;
    //         j++;
    //     }else{
    //         if(arr[j]==0){
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //             i++; 
    //             j++;
    //         }else{
    //             j++;
    //         }       
    //     }
    // }
    // j=i+1;
    // while (i<j && j<size)
    // {
    //     if(arr[i]==1){
    //         i++;
    //         j++;    
    //     }else{
    //         if(arr[j]==1){
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //             i++; 
    //             j++;
    //         }else{
    //             j++;
    //         }       
    //     }  
    // }


    //three pointer appraoch...(optimal appraoch)
    int low = 0, mid = 0, high = size - 1; // 3 pointers

    while (mid <= high) {
        if (arr[mid] == 0) {
            swap(arr[low], arr[mid]);
            low++;
            mid++;
        }
        else if (arr[mid] == 1) {
            mid++;
        }
        else {
            swap(arr[mid], arr[high]);
            high--;
        }
    }
    print(arr,size);
}

void MajorityElement(int arr[],int size){

    //better appraoch (time-> O(NlogN)+O(N)  space-> O(N)).....
    // map<int,int> mpp;
    // for (int i = 0; i < size; i++)
    // {
    //     mpp[arr[i]]++;

    // }
    // for(auto it:mpp){
    //     if(it.second>(size/2)){
    //         cout<<it.first;
    //         break;
    //     }
    // }

    //optimal appraoch (Moore’s Voting Algorithm)
   int el=arr[0];
   int cnt=0;
   for (int  i = 0; i < size ; i++)
   { 
       if(arr[i]==el){
         //cout<<"P"<<endl;
         cnt++;
       }
       if(arr[i]!=el){
         //cout<<"M"<<endl;
         cnt--;
       }
       if(cnt==0){
            //cout<<el<<endl;
            el = arr[i+1];
            continue;
        }
       
   }
   cnt=0;
   for (int i = 0; i < size; i++)
   {
      if(arr[i]==el){
        cnt++;
      }
   }
   if(cnt>size/2){
     cout<<el<<" is majority element"<<endl;
   }else{
     cout<<"there is no majority element"<<endl;
   }
    
}


void KadanesAlgo(int arr[], int size){
        
        //largest sum contiguous subarray.....
        for (int i = 0; i < size; i++)
        {
           
        }
         

}


int main(){
    int arr[] = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5} ;
    int size = sizeof(arr)/sizeof(arr[0]);
    
    //SortArrayMethod(arr,size);
    //MajorityElement(arr, size);
    
    
    
    
    
}