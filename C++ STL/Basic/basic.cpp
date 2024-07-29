#include<bits/stdc++.h>

using namespace std;

void explainPairs(){
    pair<int, int> p = {1,3};
   // cout<<p.first<<" "<<p.second<<endl;

    pair<int,pair<int,int>> p2 = {1,{2,3}};
   // cout<<p2.first<<" "<<p2.second.second<<" "<<p2.second.first<<endl;
    
    pair<int,int> arr[]={{1,2},{3,4},{5,6}};   //important..

   // cout<<arr[1].second<<endl;
}

void explainVectors(){
    vector<int> v;
    
    v.push_back(5);
    v.push_back(6);
    v.emplace_back(7);

    vector<pair<int,int>> vec;      //vector of pairs...
    vec.push_back({1,2});
    vec.emplace_back(1,2);

    vector<int> v4(5,100);        // 5 size vector with each element 100..
    vector<int> v1(5);
    vector<int> v2(5,20);
    vector<int> v3(v2);      // v3 same as v2..

    // iterator contain memoery address...

    vector<int>::iterator itt = v.begin();   //memory address of first element of vector.
    
    cout<< *(itt) <<" "<<endl;    // '*' used to print the value at that memory address..
    
    vector<int>::iterator itt1 = v.end();   //memory addres of the position after the last element element of vector.

    itt1--; 
    
    cout<<*(itt1)<<" "<<endl;
     
    //iterating method of vector similar to array.....
    cout<<v[0]<<endl;
    
    //print last element present in the vector....
    cout<<v.back()<<endl;

    //auto automatacally define it as vector iterator data type....(uesd for any data type)

    cout<<"iteration using auto..."<<endl;
    for(auto it = v.begin(); it != v.end();it++){
          cout<<*(it)<<endl;
    }

    for(auto it:v){            //automatacally takes as int data type and iterate vector
        cout<<it<<endl;
    }
    
    //.........................................................................................................

    v.erase(v.begin()+1);                        //earse particular element
    // v.erase(v.begin()+2,v.begin()+3);         earse multiple element from starting and end point
   
    v.insert(v.begin()+1,9);                  //single value insertion
    v.insert(v.begin()+2,2,60);            //multiple inserton

    vector<int> copy(2,50);
    v.insert(v.begin(), copy.begin(),copy.end());       //not much needed
    
    cout<<"modified vector"<<endl;
    for(auto it:v){           //printing above modified vector
        cout<<it<<endl;
    }
    
    //..........................................................................................................

    cout<<v.size()<<endl;

    v.pop_back();

    v1.swap(v2);
    v.clear();
    cout<<"bool :- "<< v.empty()<<endl;


}

void Studylist(){
    list<int> ls;
    ls.push_back(2);  //{2}
    ls.emplace_back(3);  //{2,3}
    ls.push_front(5);  //{5,2,3}
    ls.emplace_front(6);  //{6,5,2,3}

    for(auto it:ls){            //automatacally takes as int data type and iterate list
        cout<<it<<endl;
    }
    

    //rest function similar to vector
    //begin,end,clear,insert,size,swap
}

void StudyDeque(){
    deque<int> dq;
    dq.push_back(2);  //{2}
    dq.emplace_back(3);  //{2,3}
    dq.push_front(5);  //{5,2,3}
    dq.emplace_front(6);  //{6,5,2,3}
    
    dq.pop_back();     
    dq.pop_front();
     
    cout<<"back element :-  "<<dq.back()<<endl;
    cout<<"Front element :- "<<dq.front()<<endl;

    for(auto it:dq){            //automatacally takes as int data type and iterate list
        cout<<it<<endl;
    }

    //rest function similar to vector
    //begin,end,clear,insert,size,swap
}

void StudyStack(){
    //LIFO
    stack<int> st;
    st.push(1);          //push element at the top most position of the stack
    st.push(2);
    st.push(3);
    st.push(4);
    st.emplace(5);

    cout<<st.top()<<endl;
    st.pop();              //pop the topmost element in the stack
    cout<<st.top()<<endl;
    cout<<st.size()<<endl;
    cout<<st.empty()<<endl;   //true=1 //false=0

    stack<int> st1,st2;
    st1.swap(st2);            //swap elements of two stack
}

void StudyQueue(){
    //FIFO
    queue<int> q;
    q.push(1);      //{1}
    q.push(2);       //{1,2}
    q.push(3);        //{1,2,3}
    q.emplace(4);      //{1,2,3,4}
    
   // q.back() += 5;

    cout<<q.back()<<endl;
    
    cout<<q.front()<<endl;

    q.pop();

    cout<<q.front()<<endl;

    //size,swap,empty func same as stack
}

void StudyPriorityQueue(){
    //element have largest value stays at the top
    priority_queue<int> pq;
    pq.push(5);
    pq.push(19);
    pq.push(2);
    pq.push(6);

    cout<<pq.top();
    pq.pop();
    cout<<pq.top();

    //size,swap,empty func same as others mentioned above

    //minimum Heap...(minimum element at the top)
    priority_queue<int , vector<int>,greater<int>> pqq;
    pqq.push(5);
    pqq.push(2);
    pqq.push(8);
    pqq.push(10);

    cout<< pqq.top();
}

void Studyset(){
    //store UNIQUE and SORTED element
    set<int> st;
    st.insert(1);   //{1}
    st.insert(2);   //{1,2}
    st.insert(2);   //{1,2}
    st.emplace(4);  //{1,2,4}
    st.insert(3);   //{1,2,3,4}

    //to display element of set..
    for (auto itr : st) 
    {
        cout << itr << " ";
    }
    cout<<endl;

    // begin(), end(), size() , empty() , swap () are same as above mentioned....

    auto it1 = st.find(3);

    auto it2 = st.find(6);

    st.erase(5);  //takes logrithmic time 

    int cnt = st.count(1);  //this func count element, thus set set contain unique element so if that element is present count will be 1 or otherwise 0.
    
    auto it3 = st.find(3);
    st.erase(it3);
    
    auto it4 = st.find(2);
    auto it5 = st.find(4);
    st.erase(it4,it5);
    
    //lower and upper bound function is same as in vector....

    auto it6 = st.lower_bound(2);
    auto it7 = st.upper_bound(3);
    
     for (auto itr : st) 
    {
        cout << itr << " ";
    }
    cout<<endl;

}

void StudyMultiset(){

    //only store elements in sorted order but elements are not unique....
    
    multiset<int> ms;
    ms.insert(1);
    ms.insert(1);
    ms.insert(1);
    ms.insert(2);

    ms.count(1); // count all the occurrence of 1
    ms.erase(1); // earse all 1 present in the multiset
    
    ms.erase(ms.find(1));

   // ms.erase(ms.find(1),ms.find(1)+2);

    // rest all functions are same
}

void StudyUnorderedset(){
    // unqiue element but not in order ...randomise distributioin
    unordered_set<int> unst;
    
    //lower and upper bound func does not work
    //rest all func are same
    // O(1) time complexity bcz it is unordered
}

void StudyMap(){
    //comes in key value pair...
    // map store unique key in sorted order of keys ....
    
    map <int,int> mpp;
    map <pair<int,int>,int> mp;   //key and value can be of any data type ....
    mpp[1]=2;
    mpp.emplace(3,1);

    mp.insert({{2,4},4});

    mpp[2] = 10;

    for (auto it : mpp){
        cout<<it.first<<" "<<it.second<<endl;

    }

    cout << mpp[1]<<endl;      
    cout << mpp[5]<<endl;       //agr wo key nhi hoga toh zero return krega

    auto it = mpp.find(3);
    //pair<const int,int>& pair = *it;
    cout<< it->second<<endl;           //use either of them 
    
    auto it3 = mpp.find(5);
    
    auto it4 = mpp.find(5);   //mp.end()

    auto it1 = mpp.lower_bound(2);
    
    auto it2 = mpp.upper_bound(3);

    //cout<<(it2)<<endl;

    //erase() , swap() , size() , empty() are same as above...

}

void StudyMultimap(){

    multimap<int,int> mp;
    //everything same as map, only it can store multiple keys
    // only mpp[keys] cannot be used here
}

void StudyUnorderedmap(){
    //same as set and unorderd_set difference.
}


bool comp(pair<int,int> p1,pair<int,int> p2){

        if(p1.second<p2.second) return true;
        if(p1.second>p2.second) return false;
        // else they are same

        if(p1.first>p2.first) return true;
        return false;
}

void StudyAlgorithm(){

    int n=3;
    int ar[] = {3,6,1};

    vector<int> v;
    v.push_back(3);
    v.push_back(9);
    v.push_back(2);

    sort(ar,ar+n);            //for array
    sort(v.begin(),v.end());     // for vector

    sort(ar+2,ar+3);
    sort(ar , ar+n , greater<int>()) ;  // sort in decending order..

    pair<int,int> a[] = {{1,2},{2,1},{4,1}};
    //sort it according to second element
    //if second element is same, then sort
    // it according to first element in decending order

    sort(a, a+n, comp);   //comp is self made comprator bool function

    int num = 7;
    int cnt = __builtin_popcount(num);    //return no. of 1's present in its binary form
    long long num1  = 134345364356;
    int cnt1 = __builtin_popcountll(num1);
    
    string s = "123";
    sort(s.begin(),s.end());  // to start from smallest combination possible.
    
    do{
        cout<<s<<endl;
    }while(next_permutation(s.begin(),s.end()));   //return false if their are no other permutaion possible. 
    
    int arr[] = {1,5,7,9};
    int maxi = *max_element(arr,arr+4);    //to find maximum element in array
    cout<<maxi<<endl;
    // similarly there is min_element() 
    
}






int main(){

    cout<<"call start"<<endl;

    //explainPairs();
    //explainVectors();
    //Studylist();
    //StudyDeque();
    //StudyStack();
    //StudyQueue();
    //StudyPriorityQueue();
    //Studyset();
    //StudyMultiset();
    //StudyUnorderedset();
    //StudyMap();
    //StudyMultimap();
    //StudyUnorderedmap();
    //StudyAlgorithm();

    cout<<"call end"<<endl;

}