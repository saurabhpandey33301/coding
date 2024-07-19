#include<bits/stdc++.h>

using namespace std;

int main() {
    int arr[] = {2, 0, 2, 1, 1, 0};
    int size = sizeof(arr)/sizeof(arr[0]);

    int low = 0, mid = 0, high = size - 1;

    while (mid <= high) {
        switch (arr[mid]) {
            case 0:
                swap(arr[low++], arr[mid++]);
                break;
            case 1:
                mid++;
                break;
            case 2:
                swap(arr[mid], arr[high--]);
                break;
        }
    }

    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}
