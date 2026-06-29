# 📘 C++ STL Basics Cheat Sheet

> A quick reference for the most commonly used C++ STL containers and utilities.

---

# Table of Contents

1. vector
2. map
3. unordered_map
4. set
5. unordered_set
6. deque
7. queue
8. priority_queue
9. stack
10. list
11. pair
12. tuple
13. algorithm
14. ranges (C++20)
15. string
16. bitset
17. chrono
18. filesystem

---

# 1. vector

A **vector** is a dynamic array that can grow or shrink in size automatically.

### Initialization

```cpp
vector<int> v;
vector<int> v = {1,2,3};
vector<int> v(5);        // 5 elements initialized to 0
vector<int> v(5, 10);    // five 10's
```

### Common Functions

```cpp
v.push_back(10);
v.pop_back();
v.size();
v.empty();
v.clear();
v.front();
v.back();
```

### Uses

- Dynamic arrays
- Random access (`O(1)`)
- Most commonly used STL container

---

# 2. map

Stores **key-value pairs** in **sorted order** (by key).

### Initialization

```cpp
map<int, string> mp;
mp[1] = "Alice";
mp.insert({2, "Bob"});
```

### Common Functions

```cpp
mp.erase(1);
mp.find(2);
mp.count(2);
mp.size();
mp.clear();
```

### Uses

- Sorted data
- Fast searching (`O(log n)`)
- Key-value storage

---

# 3. unordered_map

Stores key-value pairs using a **hash table**.

### Initialization

```cpp
unordered_map<int, string> mp;
mp[1] = "Alice";
mp.insert({2, "Bob"});
```

### Common Functions

```cpp
mp.erase(1);
mp.find(2);
mp.count(2);
mp.size();
```

### Uses

- Fast lookup (`O(1)` average)
- Frequency counting
- Hash-based storage

---

# 4. set

Stores **unique elements** in sorted order.

### Initialization

```cpp
set<int> s;
s.insert(5);
s.insert(3);
```

### Common Functions

```cpp
s.erase(5);
s.find(3);
s.count(3);
s.size();
```

### Uses

- Remove duplicates
- Sorted unique values
- Fast search (`O(log n)`)

---

# 5. unordered_set

Stores unique elements using hashing.

### Initialization

```cpp
unordered_set<int> s;
s.insert(5);
s.insert(10);
```

### Common Functions

```cpp
s.erase(5);
s.find(10);
s.count(10);
```

### Uses

- Fast unique lookup
- Duplicate removal
- Average `O(1)` operations

---

# 6. deque

Double-ended queue. Supports insertion/removal from both ends.

### Initialization

```cpp
deque<int> dq;
dq.push_front(10);
dq.push_back(20);
```

### Common Functions

```cpp
dq.pop_front();
dq.pop_back();
dq.front();
dq.back();
```

### Uses

- Sliding window
- Queue + Stack
- Fast insertion at both ends

---

# 7. queue

Follows **FIFO (First In First Out)**.

### Initialization

```cpp
queue<int> q;
```

### Common Functions

```cpp
q.push(10);
q.pop();
q.front();
q.back();
q.empty();
```

### Uses

- BFS
- Scheduling
- Producer-Consumer problems

---

# 8. priority_queue

Implements a heap.

### Max Heap

```cpp
priority_queue<int> pq;
```

### Min Heap

```cpp
priority_queue<int, vector<int>, greater<int>> pq;
```

### Common Functions

```cpp
pq.push(5);
pq.pop();
pq.top();
pq.size();
```

### Uses

- Dijkstra
- Top K elements
- Heap problems

---

# 9. stack

Follows **LIFO (Last In First Out)**.

### Initialization

```cpp
stack<int> st;
```

### Common Functions

```cpp
st.push(10);
st.pop();
st.top();
st.empty();
```

### Uses

- DFS
- Parentheses matching
- Undo operations

---

# 10. list

Doubly linked list.

### Initialization

```cpp
list<int> l;
l.push_back(10);
l.push_front(5);
```

### Common Functions

```cpp
l.pop_back();
l.pop_front();
l.remove(10);
l.sort();
```

### Uses

- Frequent insertion/deletion
- Doubly linked list operations

---

# 11. pair

Stores two values together.

### Initialization

```cpp
pair<int, string> p = {1, "Alice"};
```

### Access

```cpp
p.first;
p.second;
```

### Uses

- Coordinates
- Key-value pairs
- Returning two values

---

# 12. tuple

Stores multiple values of different types.

### Initialization

```cpp
tuple<int, string, double> t = {1, "Alice", 95.5};
```

### Access

```cpp
get<0>(t);
get<1>(t);
get<2>(t);
```

### Uses

- Returning multiple values
- Structured data

---

# 13. algorithm

Contains useful STL algorithms.

### Examples

```cpp
sort(v.begin(), v.end());

reverse(v.begin(), v.end());

find(v.begin(), v.end(), x);

count(v.begin(), v.end(), x);

binary_search(v.begin(), v.end(), x);

max_element(v.begin(), v.end());

min_element(v.begin(), v.end());
```

### Uses

- Sorting
- Searching
- Counting
- Manipulating containers

---

# 14. ranges (C++20)

Provides cleaner syntax for algorithms.

### Example

```cpp
ranges::sort(v);

ranges::reverse(v);

ranges::find(v, 5);
```

### Uses

- Cleaner code
- Modern C++
- Safer algorithms

---

# 15. string

Represents dynamic strings.

### Initialization

```cpp
string s = "Hello";
```

### Common Functions

```cpp
s.size();
s.length();
s.substr(1,3);
s.find("ll");
s.push_back('!');
s.pop_back();
```

### Uses

- Text manipulation
- Parsing
- Input handling

---

# 16. bitset

Represents fixed-size sequence of bits.

### Initialization

```cpp
bitset<8> b("10101010");
```

### Common Functions

```cpp
b.count();
b.flip();
b.set();
b.reset();
b.test(2);
```

### Uses

- Bit manipulation
- Competitive programming
- Efficient boolean storage

---

# 17. chrono

Library for measuring time.

### Example

```cpp
auto start = chrono::high_resolution_clock::now();

// code

auto end = chrono::high_resolution_clock::now();
```

### Uses

- Benchmarking
- Timers
- Performance measurement

---

# 18. filesystem

Used to work with files and directories.

### Example

```cpp
namespace fs = std::filesystem;

fs::exists("file.txt");

fs::create_directory("Demo");

fs::remove("Demo");
```

### Uses

- File management
- Directory traversal
- File existence checks

---

# Quick Revision

| STL | Primary Use |
|------|-------------|
| vector | Dynamic Array |
| map | Sorted Key-Value |
| unordered_map | Fast Hash Map |
| set | Sorted Unique Elements |
| unordered_set | Fast Unique Elements |
| deque | Double Ended Queue |
| queue | FIFO |
| priority_queue | Heap |
| stack | LIFO |
| list | Doubly Linked List |
| pair | Two Values |
| tuple | Multiple Values |
| algorithm | STL Algorithms |
| ranges | Modern STL Algorithms |
| string | Text Handling |
| bitset | Bit Operations |
| chrono | Time Measurement |
| filesystem | File & Directory Operations |

---
## 💡 Interview Tip

For coding interviews:
- **vector** → Default choice for arrays.
- **unordered_map** → Frequency counting and hashing.
- **set / unordered_set** → Remove duplicates.
- **priority_queue** → Top K, heaps, Dijkstra.
- **queue** → BFS.
- **stack** → DFS, parsing.
- **deque** → Sliding Window.
- **map** → Sorted keys.
- **algorithm** → Always prefer STL algorithms (`sort`, `find`, `binary_search`, etc.) over manual implementations.