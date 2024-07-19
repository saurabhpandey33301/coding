#include<bits/stdc++.h>

using namespace std;

void print(int arr[],int n){
    for (int i = 0; i < n; i++)
    {
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

void selectionSort(int arr[],int n){

    //selecting minimum and swaping it to front index.
    int mini=0;
    for (int i = 0; i <= n-2; i++)
    {
        mini=i;
        for(int j=i;j<=n-1;j++){
            if(arr[j]<arr[mini])  mini=j;
        }
        int temp = arr[i];
        arr[i]= arr[mini];
        arr[mini] = temp;
    }

    print(arr,n);
    
}

void BubbleSort(int arr[],int n){
    int didswap=0;
    //swap two adjacent element by taking minimum element to front.
    for (int i = 0; i < n; i++)
    {
        for(int j=0;j<n-1-i;j++){
            if(arr[j+1]<arr[j]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            didswap=1;
        }
        if(didswap==0){
            break;
        }
    }
    print(arr,n);

    //best case time complexity O(n)......if array is already sorted.
    
}



int main(){

    int arr[] = {1,5,9,23,45,4};
    selectionSort(arr,6);
    BubbleSort(arr,6);

}