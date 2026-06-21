#include <bits/stdc++.h>
using namespace std;

int main()
{
    set<int> s;
    //Insertion
    s.insert(10);
    s.insert(5);
    s.insert(20);
    s.insert(10); // Duplicate, won't be inserted
    //Iteration
    for (int x : s)
    {
        cout << x << " ";
    } // out: 5 10 20
    //Deletion
    s.erase(10); // Removes 10 if present
    cout << s.size();
    cout << *s.begin();  // First (smallest) element
    cout << *s.rbegin(); // Last (largest) element

    set<int> s1 = {10, 20, 30, 40};
    //cout << s[2]; // Error
}
