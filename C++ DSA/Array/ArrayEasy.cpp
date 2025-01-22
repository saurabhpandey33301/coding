#include<bits/stdc++.h>

using namespace std;


class Solutions{
       
   public : int findMax(int arr[],int size){
        int max=INT_MIN;

        for (int i = 0; i < size; i++)
        {
            /* code */
            if(arr[i]>max){
                max= arr[i];

            }
        }
        return max;
        
   }

   public : void secondLargest(int arr[],int size){
          int max = INT_MIN;
          int sec = INT_MIN;
          for (int i = 0; i < size; i++)
          {
            /* code */
            if(arr[i]>max){
                sec=max;
                max=arr[i];
            }
            else if( arr[i]>sec && arr[i] != max){
                sec = arr[i];
            }
          }
          cout<<sec<<endl;     
   }

   public : void secondSmallest(int arr[],int size){
        int min = INT_MAX;
        int sec = INT_MAX;
        for (int i = 0; i < size; i++)
        {
            /* code */
            if(arr[i]<min){
                sec= min;
                min = arr[i];
            }
            else if(arr[i]<sec && arr[i] != min ){
                sec = arr[i];
            }
        }
        cout<<sec<<endl;
   }

   public : bool IsSorted(int arr[], int size){
    //optimal approach..
    for (int i = 1; i < size; i++)
    { 
        if(arr[i]<arr[i-1]){
            return false;
        }
    }
    return true;
     
}

   public : void RemoveDuplicate(int arr[], int size){
        //brute for appraoch.....
        set<int> st;
        for (int i = 0; i < size; i++)
        {
            st.insert(arr[i]);
        }
        for(auto it:st){
            cout<<it<<endl;
        }
        //optimal approach....(two pointer approach i.e; i & j)
        int i=0;
        for (int j = 0; j < size; j++)
        {
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        for( int k = 0; k < i+1 ; k++)
        {
            cout<<arr[k]<<" ";
        }
        cout<<endl;
   
   }

   public : void RotateLeft(int arr[],int size){
        int temp=arr[0];
        for (int i = 0; i < size; i++)
        {
            if(i==size-1){
                arr[i] = temp;
                continue;
            } 
            arr[i] = arr[i+1];

        }
       for (int i = 0; i < size; i++)
       {
          cout<<arr[i]<<" ";
       }
       
        cout<<endl;
        
   }

   public : void RotateLeftByNumber(int arr[], int size){
        //brute force approach...
        int temp[size];
        int x;
        cin>>x;
        for (int i = 0; i < size; i++)
        {
            if((i+x)>(size-1)){
                 temp[i] = arr[abs(size-i-x)];
            }else{
                temp[i] = arr[i+x];
            }
        }
        for (int i = 0; i < size; i++)
        {
            cout<<temp[i]<<" ";
        }
        cout<<endl;
        //optimal approach.....(by recursive calling)    
   }
   
   public : void AllZerosToEnd(int arr[],int size){
        //brute force approach (space complexcity -> O(n))
        // int temp[size] = {0};
        // int j=0;
        // for (int i = 0; i < size ; i++)
        // {
        //     if(arr[i]==0){
        //         continue;
        //     }else{
        //         temp[j] = arr[i];
        //         j++;
        //     }
        // }
        // for (int i = 0; i < size; i++)
        // {
        //     cout<<temp[i]<<" ";
        // }
        // cout<<endl;

        //optimal approach ......(space complexity -> O(1))   (Two-pointer approach)
        int j=-1;
        for (int i = 0; i < size; i++)
        {
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1) {
            cout<<"No zeroes"<<endl;
            return;
        }
        
        for (int i = j+1; i < size; i++)
        {
            if(arr[i]!=0){
                 int temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
                 j++;
            }
        }
        
        for (int i = 0; i < size; i++)
        {
            cout<<arr[i]<<" "; 
        }
        cout<<endl;
    }

   public : void LinearSeach(int arr[],int size,int key){
        for (int i = 0; i < size; i++)
        {
            if(arr[i] == key){
                cout<<i<<endl;
                break;
            }
        }
        
   }

   public: void UnionOfArray(int arr[],int ary[],int n , int m){
           map<int,int> freq;
           vector<int> Union;

           for (int i = 0; i < n ; i++)
           {
             freq[arr[i]]++;
           }
           for (int i = 0; i < m; i++)
           {
             freq[ary[i]]++;
           }
           for(auto it:freq){
             cout<<it.first<<" ";
             Union.push_back(it.first);
           }
           cout<<endl;
           
           

   }

   public : void MissingNum(int arr[],int n,int k){
        //you can use hashing also....

        //my approach.....(good approach)
        int m=1;
        sort(arr,arr+n);
        for (int i = 0; i < n; i++)
        {
            if(arr[i]!=m){
                cout<<m<<endl;
                break;
            }
            m++;
        }
        //optimal approach -> 1
        int s1 = (k*(k+1))/2;
        int s2 = 0 ;
        for (int i = 0; i < n; i++)
        {
            s2 += arr[i];
        }
        cout<<s1-s2<<endl;
        //optimal approach -> 2
        // using XOR see from sheet -> taking out exclusively or element from arr and from 1 to K using two dummy variable.

        

   }

   public : void ConscutiveOne(int arr[],int n){
        //optimal approach......
        int cnt=0;
        int maxi=0;

        for (int i = 0; i < n; i++)
        {
            if(arr[i]==0){
                cnt = 0;
            }else{
                cnt++;
            }
            maxi = max(maxi,cnt);
        }
        cout<<maxi<<endl;  
   }

   public : void FindSingleElement(int arr[],int n){
        //better approach....
        map<int,int> mpp;
        for (int i = 0; i < n; i++)
        {
            mpp[arr[i]]++;
        }
        for(auto it:mpp){
            if(it.second==1){
                cout<<it.first<<endl;
            }
        }
        //you can also use hasing method using vector by intialising all element by zero.
        
        //optimal approach -> using XOR operator (see striver sheet)
        
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ arr[i];
        }
        cout<<xorr<<endl;
   
   }

   public : void LargestSubArrayLen(int arr[],int n,int k){
         
         
   }




};

int main(){
    int arr[] = {2,2,1};
    int size = sizeof(arr)/sizeof(arr[0]);
    int ary[] = {1,2,34,5,5,6};
    int size1 = sizeof(ary)/sizeof(ary[0]);
    Solutions solution;
    //cout<<solution.findMax(arr,size)<<endl;
    //solution.secondLargest(arr,size);
    //solution.secondSmallest(arr,size);
    //cout<<solution.IsSorted(arr,size)<<endl;
    //cout<<"from here"<<endl;
    //solution.RemoveDuplicate(arr,size);
    //solution.RotateLeft(arr,size);
    //solution.RotateLeftByNumber(arr,size);
    //solution.AllZerosToEnd(arr,size);
    //solution.LinearSeach(arr,size,3);
    //solution.UnionOfArray(arr,ary,size,size1);
    //solution.MissingNum(arr,size,5);
    //solution.ConscutiveOne(arr,size);
    //solution.FindSingleElement(arr,size);


}