#include<bits/stdc++.h>

using namespace std;

int main(){
    vector<int> vec;
    vec.push_back(1);
    vec.push_back(2);
    vec.push_back(3);
    vec.insert(vec.begin()+1,4);
    for(int i=0;i<vec.size();i++){
        cout<<vec[i]<<endl;
    }
}