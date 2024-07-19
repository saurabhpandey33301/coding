#include<bits/stdc++.h>

using namespace std;


//for checking order...
bool sortcol(vector<int>& A , vector<int>& B){

    // '0' denotes the column to be sorted ...
    return A[0]<B[0];
}

int main(){

    //initialising 2D vector ....
    vector<vector <int> > vect{ { 9, 5, 1 },{ 4, 8, 6 },{ 7, 2, 9 }};;

    //for sorting particular row in an 2D vector ......

    sort(vect[1].begin(), vect[1].end());

    //displaying the vector...

    cout<<"row sort\n";

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
                cout<<vect[i][j]<<" ";
        }
        cout<<endl;
        
    }

    //for sorting particular column in an 2D vector ....
    
    sort(vect.begin(), vect.end(),sortcol);

    //displaying the vector...

    cout<<"column sort\n";

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
                cout<<vect[i][j]<<" ";
        }
        cout<<endl;
        
    }
}