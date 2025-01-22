#include<bits/stdc++.h>

using namespace std;


class node{
    public:
    int data;
    node* next;

    //constructor
    public:
    node(int data1,node* next1){
        data = data1;
        next = next1;
    }
    public:
    node(int data1){
        data = data1;
        next = nullptr;
    }
};

node* InsertAthead(vector<int>& arr){
    node* head = new node(arr[0]);
    node* mover = head;
    for (int i = 1; i < arr.size(); i++)
    {
        node* temp = new node(arr[i]);
        mover->next = temp;
        mover = temp;
    }
    return head;
}


node* MergeSort(Node* head){
     
}


void PrintLL(node* head){
    node* temp = head;
    while(temp){
        cout<<temp->data<<" ";
        temp = temp->next;
    }
    cout<<endl;
}

int main(){
    
    vector<int> arr ={2,3,4,5};
    
    
    //making linked list by inserting at head....
    node* head = InsertAthead(arr);
    PrintLL(head);
    //sorting linked list by merge sort for nlog(n) time complexity.....

   


    return 0;
}