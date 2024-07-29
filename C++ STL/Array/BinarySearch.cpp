#include<bits/stdc++.h>

using namespace std;

void BinarySearchIterative(int arr[],int size,int k){
        int low = 0 ;
        int high = size-1;
        while(low<=high){
            int mid= (low+high)/2;
            if(arr[mid]>k){
                high = mid-1;
            }else if(arr[mid]<k){
                low = mid+1;
            }else{
                cout<<mid<<endl;
                return;
            }
        }
        cout<<"-1"<<endl;
        return;
}

void BinarySearchRecursive(int arr[],int left,int right, int k){
                if(left>right){
                    cout<<"-1"<<endl;
                    return;
                }
                int mid = (left+right)/2;
                if(k==arr[mid]){
                    cout<<mid<<endl;
                    return;
                }
                if(arr[mid]<k){
                    BinarySearchRecursive(arr,mid+1,right,k);
                }else if(arr[mid]>k){
                    BinarySearchRecursive(arr,left,mid-1,k);
                }
}

void lowerBound(int arr[],int size,int k){
    
    for (int i = 0; i < size; i++)
    {
        if(arr[i]>=k){
            cout<<i<<endl;
            return;
        }
    }
    
}

void lastAndFirstOccurence(int arr[],int size,int k){
        
        //brute force approach.....(linear search)
        // int j=-1;
        // for (int i = 0; i < size; i++)
        // {
        //     if(k==arr[i]){
        //         j=i;
        //         cnt++;   
        //     }
        // }
        // cout<<j<<endl;

        //optimal approach(using binary search).....
        int low=0;
        int high= size-1;
        int last=-1;
        int first=-1;
        while (low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]==k){
                first = mid;
                high = mid-1;

            }else if(k<arr[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        cout<<first<<endl;
        
}

void findMinimumInRotatedArray(int arr[],int size){
    int low = 0;
    int high = size-1;
    int ans = INT_MAX;
    while(low<=high){
        int mid = low + (high-low)/2;
        if(arr[low]<=arr[mid]){
            ans = min(ans,arr[low]);
            low = mid+1;
        }else{
            ans = min(arr[mid],ans);
            high = mid-1;
        }

    }
    cout<<ans<<endl;
}

void timesArrayRotated(int arr[],int size){

    int low = 0;
    int high = size-1;
    int ans = INT_MAX;
    int index = -1;
    while (low<=high)
    {
        int mid = low + (high-low)/2;
        if(arr[low]<=arr[mid]){
            if(arr[low]<=ans){
                index = low;
            }
            ans = min(ans,arr[low]);
            low = mid+1;
        }else{
            if(arr[mid]<=ans){
                index = mid;
            }
            ans = min(arr[mid],ans);
            high = mid-1;
        }
    }
    cout<<index<<endl;
}

int SingleOccurenceOfElement(int nums[],int size){
        int n = size;
        if(n==1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }

        int low = 1;
        int high = n-2;
        while(low<=high){
            
            int mid = low + (high-low)/2;
            if(nums[mid-1]!=nums[mid] && nums[mid]!= nums[mid+1]){
                return nums[mid];
            }

            if((mid%2==1 && nums[mid-1]==nums[mid]) || (mid%2==0 && nums[mid]==nums[mid+1])){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    
}

int main(){
        int arr[] = {1,1,2,2,3,3,4,5,5,6,6};
        int size = sizeof(arr)/sizeof(arr[0]);

        //BinarySearchIterative(arr,size,17);
        //BinarySearchRecursive(arr,0,size,22);
        //lowerBound(arr,size,9);
        //lastAndFirstOccurence(arr,7,13);
        //findMinimumInRotatedArray(arr,size);
        //timesArrayRotated(arr,size);
        cout<<SingleOccurenceOfElement(arr,size)<<endl;
}