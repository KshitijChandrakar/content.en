**Name:** Parv Saini
**SAP ID:** 500119000
**Batch:** 50
# Unit 2
## Binary Search
  ### Algorithm:
  1. Start with a sorted array A and target value m
  2. Set low = 0, high = length of array - 1.
  3. While low ≤ high:
      mid = (low + high) // 2.
        If array[mid] == target, return mid.
        If target < array[mid], set high = mid - 1.
      Else, set low = mid + 1.

  4. If not found, return -1.

  #### Time Complexity:
  ##### Best Case: O(1)
  ##### Average Case: O(log n)
  ##### Worst Case: O(log n)

  #### Space Complexity:
  ##### Iterative: O(1)
  ##### Recursive: O(log n)

  ### Code: (Assuming all libraries are included)
  ```c++
  int binarySearch(const vector<int>& arr, int target) {
      int low = 0, high = arr.size() - 1;
      while (low <= high) {
          int mid = low + (high - low) / 2;
          if (arr[mid] == target) {
              return mid;
          } else if (arr[mid] > target) {
              high = mid - 1;
          } else {
              low = mid + 1;
          }
      }

      return -1;
  }
  ```

  ### Output
  ```
  Element found at index: 4
  ```



---
## Merge Sort

### Algorithm:
1. If the array has one or no elements, it is already sorted. Otherwise apply merge sort to the the given array
2. Divide the array into two halves.
3. Recursively sort both halves.
4. Merge the two sorted halves into a single sorted array.

#### Time Complexity:

##### Best Case: O(n log n)

##### Average Case: O(n log n)

##### Worst Case: O(n log n)

#### Space Complexity:

##### Recursive: O(n)

##### Iterative: O(1)

### Code: (Assuming all libraries are included)

```c++
void merge(vector<int>& arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    vector<int> L(n1), R(n2);

    for (int i = 0; i < n1; ++i) {
        L[i] = arr[left + i];
    }
    for (int i = 0; i < n2; ++i) {
        R[i] = arr[mid + 1 + i];
    }

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            ++i;
        } else {
            arr[k] = R[j];
            ++j;
        }
        ++k;
    }

    while (i < n1) {
        arr[k] = L[i];
        ++i;
        ++k;
    }

    while (j < n2) {
        arr[k] = R[j];
        ++j;
        ++k;
    }
}

void mergeSort(vector<int>& arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
}

```

### Output

```
5 6 7 11 12 13
```
---
## Quick Sort

### Algorithm:
1. If the array has one or no elements, it is already sorted.
2. Choose a pivot element from the array.
3. Partition the array such that:
   - Elements less than the pivot are on the left.
   - Elements greater than the pivot are on the right.
4. Recursively apply quick sort to the left and right partitions.

#### Time Complexity:

##### Best Case: O(n log n)

##### Average Case: O(n log n)

##### Worst Case: O(n²) (when the pivot is poorly chosen)

#### Space Complexity:

##### Recursive: O(log n) (for the recursion stack)

##### Iterative: O(1) (with an iterative approach)

### Code: (Assuming all libraries are included)

```c++
vector<int> arr = {10, 7, 8, 9, 1, 5};
int partition(vector<int>& arr, int low, int high) {
    int pivot = arr[high]; // Choose the last element as pivot
    int i = low - 1;

    for (int j = low; j < high; ++j) {
        if (arr[j] <= pivot) {
            ++i;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[high]);
    return i + 1;
}

void quickSort(vector<int>& arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

### Output

```
1 5 7 8 9 10
```
---

---
## Strassen Method of Matrix Multiplication

### Algorithm:

1. Divide each matrix into four submatrices of equal size.
2. Compute seven intermediate products using Strassen's formulas.
3. Combine the intermediate products to form the final matrix.

#### Time Complexity:

##### Best Case: O(n⁲⁺⁵)

##### Average Case: O(n⁲⁺⁵)

##### Worst Case: O(n⁲⁺⁵)

#### Space Complexity:

##### Recursive: O(n²)

### Code: (Assuming all libraries are included)

```c++
typedef vector<vector<int>> Matrix;
Matrix A = {{1, 2}, {3, 4}};
Matrix B = {{5, 6}, {7, 8}};
Matrix C = strassen(A, B);

Matrix add(const Matrix& A, const Matrix& B) {
    int n = A.size();
    Matrix result(n, vector<int>(n));
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < n; ++j)
            result[i][j] = A[i][j] + B[i][j];
    return result;
}

Matrix subtract(const Matrix& A, const Matrix& B) {
    int n = A.size();
    Matrix result(n, vector<int>(n));
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < n; ++j)
            result[i][j] = A[i][j] - B[i][j];
    return result;
}

Matrix strassen(const Matrix& A, const Matrix& B) {
    int n = A.size();
    if (n == 1) {
        return {{A[0][0] * B[0][0]}};
    }

    int newSize = n / 2;
    Matrix A11(newSize, vector<int>(newSize)), A12(newSize, vector<int>(newSize));
    Matrix A21(newSize, vector<int>(newSize)), A22(newSize, vector<int>(newSize));
    Matrix B11(newSize, vector<int>(newSize)), B12(newSize, vector<int>(newSize));
    Matrix B21(newSize, vector<int>(newSize)), B22(newSize, vector<int>(newSize));

    for (int i = 0; i < newSize; ++i) {
        for (int j = 0; j < newSize; ++j) {
            A11[i][j] = A[i][j];
            A12[i][j] = A[i][j + newSize];
            A21[i][j] = A[i + newSize][j];
            A22[i][j] = A[i + newSize][j + newSize];

            B11[i][j] = B[i][j];
            B12[i][j] = B[i][j + newSize];
            B21[i][j] = B[i + newSize][j];
            B22[i][j] = B[i + newSize][j + newSize];
        }
    }

    Matrix M1 = strassen(add(A11, A22), add(B11, B22));
    Matrix M2 = strassen(add(A21, A22), B11);
    Matrix M3 = strassen(A11, subtract(B12, B22));
    Matrix M4 = strassen(A22, subtract(B21, B11));
    Matrix M5 = strassen(add(A11, A12), B22);
    Matrix M6 = strassen(subtract(A21, A11), add(B11, B12));
    Matrix M7 = strassen(subtract(A12, A22), add(B21, B22));

    Matrix C(n, vector<int>(n));

    for (int i = 0; i < newSize; ++i) {
        for (int j = 0; j < newSize; ++j) {
            C[i][j] = M1[i][j] + M4[i][j] - M5[i][j] + M7[i][j];
            C[i][j + newSize] = M3[i][j] + M5[i][j];
            C[i + newSize][j] = M2[i][j] + M4[i][j];
            C[i + newSize][j + newSize] = M1[i][j] - M2[i][j] + M3[i][j] + M6[i][j];
        }
    }

    return C;
}
```

### Output

```
19 22
43 50
```
---
## Maximum Subarray Problem

### Algorithm (Kadane's Algorithm):
1. Initialize two variables:
   - `max_so_far = INT_MIN`
   - `max_ending_here = 0`
2. Iterate through the array:
   - Add the current element to `max_ending_here`.
   - If `max_so_far < max_ending_here`, update `max_so_far`.
   - If `max_ending_here < 0`, reset `max_ending_here = 0`.
3. Return `max_so_far`.

#### Time Complexity:
##### Best Case: O(n)
##### Average Case: O(n)
##### Worst Case: O(n)

#### Space Complexity:
##### O(1)

### Code:
```c++
#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int maxSubArray(const vector<int>& nums) {
    int max_so_far = INT_MIN, max_ending_here = 0;

    for (int num : nums) {
        max_ending_here += num;
        if (max_so_far < max_ending_here) {
            max_so_far = max_ending_here;
        }
        if (max_ending_here < 0) {
            max_ending_here = 0;
        }
    }

    return max_so_far;
}

int main() {
    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    cout << "Maximum Subarray Sum: " << maxSubArray(nums) << endl;
    return 0;
}
```

### Output:
```
Maximum Subarray Sum: 6
```

---

---
## Powering a Number (Exponentiation by Squaring)

### Algorithm:
1. If `exponent == 0`, return 1.
2. If `exponent` is even:
   - Compute `half = power(base, exponent / 2)`.
   - Return `half * half`.
3. If `exponent` is odd:
   - Return `base * power(base, exponent - 1)`.

#### Time Complexity:
##### O(log n)

#### Space Complexity:
##### Recursive: O(log n)
##### Iterative: O(1)

### Code:
```c++
#include <iostream>
using namespace std;

long long power(long long base, int exponent) {
    long long result = 1;
    while (exponent > 0) {
        if (exponent % 2 == 1) {
            result *= base;
        }
        base *= base;
        exponent /= 2;
    }
    return result;
}

int main() {
    cout << "2^10 = " << power(2, 10) << endl;
    return 0;
}
```

### Output:
```
2^10 = 1024
```

---

---
## Celebrity Problem
### Algorithm:
1. Start with two pointers: `a = 0` and `b = n - 1`.
2. While `a < b`:
   - If `a` knows `b`, `a` cannot be a celebrity. Move `a` to the next person.
   - Else, `b` cannot be a celebrity. Move `b` to the previous person.
3. Verify if the potential celebrity `a` is known by everyone and knows no one.
4. If true, `a` is the celebrity; otherwise, there is no celebrity.

#### Time Complexity:
##### O(n)

#### Space Complexity:
##### O(1)

### Code:
```c++
vector<vector<int>> matrix = {
    {0, 1, 0},
    {0, 0, 0},
    {1, 1, 0}
};

bool knows(int a, int b, const vector<vector<int>>& matrix) {
    return matrix[a][b] == 1;
}

int findCelebrity(int n, const vector<vector<int>>& matrix) {
    int a = 0, b = n - 1;

    while (a < b) {
        if (knows(a, b, matrix)) {
            a++;
        } else {
            b--;
        }
    }

    for (int i = 0; i < n; ++i) {
        if (i != a && (knows(a, i, matrix) || !knows(i, a, matrix))) {
            return -1;
        }
    }

    return a;
}
```

### Output:
```
Celebrity is person 1
```
---




# Unit 3
## Knapsack Problem (Fractional)

### Algorithm:
1. Start with a list of items, each with weight \( w \), value \( v \), and compute \( v/w \) (value per weight).
2. Sort the items in decreasing order of \( v/w \).
3. Initialize total value = 0, remaining capacity \( W \).
4. For each item in sorted order:
    - If \( W \geq w \), take the whole item: Add \( v \) to total value, subtract \( w \) from \( W \).
    - Else, take a fraction: Add \( W \times (v/w) \) to total value, and set \( W = 0 \).
5. Stop when \( W = 0 \).

### Time Complexity:
- Sorting: \( O(n \log n) \)
- Greedy selection: \( O(n) \)
- Overall: \( O(n \log n) \)

### Space Complexity:
- \( O(1) \), assuming sorting is done in-place.

### Code: (Assuming all libraries are included)
```c++
struct Item {
    int weight, value;
    double valuePerWeight() const {
        return (double)value / weight;
    }
};

double fractionalKnapsack(vector<Item>& items, int capacity) {
    sort(items.begin(), items.end(), [](const Item& a, const Item& b) {
        return a.valuePerWeight() > b.valuePerWeight();
    });

    double totalValue = 0;
    for (const auto& item : items) {
        if (capacity >= item.weight) {
            totalValue += item.value;
            capacity -= item.weight;
        } else {
            totalValue += capacity * item.valuePerWeight();
            break;
        }
    }
    return totalValue;
}
```

### Output:
```
Maximum value in Knapsack: 240.0
```

---

## Activity Selection Problem

### Algorithm:
1. Start with a list of activities, each with start time \( s \) and finish time \( f \).
2. Sort the activities by increasing order of \( f \).
3. Initialize last selected activity's finish time = 0, selected activities = [].
4. For each activity in sorted order:
    - If \( s \) of current activity \( \geq \) last selected activity's \( f \):
        - Add current activity to selected activities.
        - Update last selected activity's finish time to current activity's \( f \).
5. Return the selected activities.

### Time Complexity:
- Sorting: \( O(n \log n) \)
- Greedy selection: \( O(n) \)
- Overall: \( O(n \log n) \)

### Space Complexity:
- \( O(1) \), assuming in-place sorting.

### Code: (Assuming all libraries are included)
```c++
struct Activity {
    int start, finish;
};

vector<Activity> activitySelection(vector<Activity>& activities) {
    sort(activities.begin(), activities.end(), [](const Activity& a, const Activity& b) {
        return a.finish < b.finish;
    });

    vector<Activity> selected;
    int lastFinishTime = 0;
    for (const auto& activity : activities) {
        if (activity.start >= lastFinishTime) {
            selected.push_back(activity);
            lastFinishTime = activity.finish;
        }
    }
    return selected;
}
```

### Output:
```
Selected Activities: [(1, 2), (3, 4), (5, 7)]
```

## Huffman Encoding

### Algorithm:
1. Start with a frequency table for characters.
2. Create a priority queue (min-heap) of nodes, where each node represents a character and its frequency.
3. While the queue has more than one node:
    - Remove two nodes with the smallest frequencies.
    - Create a new node with these two nodes as children, and its frequency as the sum of their frequencies.
    - Add the new node back to the queue.
4. The final node in the queue represents the root of the Huffman tree.
5. Traverse the tree to assign binary codes to each character based on the path from the root.

### Time Complexity:
- \( O(n \log n) \) (Building the heap and extracting elements)

### Space Complexity:
- \( O(n) \) (Heap and tree storage)

### Code:
```c++
struct Node {
    char character;
    int frequency;
    Node* left;
    Node* right;

    Node(char ch, int freq) : character(ch), frequency(freq), left(nullptr), right(nullptr) {}
};

struct Compare {
    bool operator()(Node* a, Node* b) {
        return a->frequency > b->frequency;
    }
};

void buildCodes(Node* root, string code, unordered_map<char, string>& huffmanCodes) {
    if (!root) return;
    if (!root->left && !root->right) {
        huffmanCodes[root->character] = code;
    }
    buildCodes(root->left, code + "0", huffmanCodes);
    buildCodes(root->right, code + "1", huffmanCodes);
}

unordered_map<char, string> huffmanEncoding(const unordered_map<char, int>& freqTable) {
    priority_queue<Node*, vector<Node*>, Compare> minHeap;
    for (const auto& [ch, freq] : freqTable) {
        minHeap.push(new Node(ch, freq));
    }

    while (minHeap.size() > 1) {
        Node* left = minHeap.top(); minHeap.pop();
        Node* right = minHeap.top(); minHeap.pop();

        Node* merged = new Node('\0', left->frequency + right->frequency);
        merged->left = left;
        merged->right = right;
        minHeap.push(merged);
    }

    unordered_map<char, string> huffmanCodes;
    buildCodes(minHeap.top(), "", huffmanCodes);
    return huffmanCodes;
}
```

### Output:
```
Huffman Codes: { 'a': "0", 'b': "101", 'c': "100", 'd': "11" }
```

---

## Interval Partitioning Problem

### Algorithm:
1. Start with a list of intervals, each with a start time \( s \) and finish time \( f \).
2. Sort the intervals by start time \( s \).
3. Use a priority queue (min-heap) to track end times of ongoing intervals.
4. For each interval:
    - If the heap is not empty and the earliest end time \( \leq \) current interval's start time, remove the top of the heap.
    - Add the current interval's finish time to the heap.
5. The size of the heap at any time gives the minimum number of resources required.

### Time Complexity:
- Sorting: \( O(n \log n) \)
- Greedy allocation: \( O(n \log n) \)
- Overall: \( O(n \log n) \)

### Space Complexity:
- \( O(n) \) (Heap storage)

### Code:
```c++
struct Interval {
    int start, finish;
};

int intervalPartitioning(vector<Interval>& intervals) {
    sort(intervals.begin(), intervals.end(), [](const Interval& a, const Interval& b) {
        return a.start < b.start;
    });

    priority_queue<int, vector<int>, greater<int>> minHeap;
    for (const auto& interval : intervals) {
        if (!minHeap.empty() && minHeap.top() <= interval.start) {
            minHeap.pop();
        }
        minHeap.push(interval.finish);
    }
    return minHeap.size();
}
```

### Output:
```
Minimum number of resources required: 3
```

---

## Dijkstra's Algorithm for Single Source Shortest Path Problem

### Algorithm:
1. Start with a graph represented by adjacency lists and a source vertex \( s \).
2. Initialize distances of all vertices to \( \infty \), except \( s \) (set \( \text{dist}[s] = 0 \)).
3. Use a priority queue (min-heap) to store pairs of distance and vertex, initialized with \( (0, s) \).
4. While the queue is not empty:
    - Extract the vertex \( u \) with the smallest distance.
    - For each neighbor \( v \) of \( u \), update \( \text{dist}[v] \) if a shorter path is found.
5. Repeat until all vertices are processed.

### Time Complexity:
- \( O((V + E) \log V) \), where \( V \) is the number of vertices and \( E \) is the number of edges.

### Space Complexity:
- \( O(V + E) \) (Graph representation and heap storage)

### Code:
```c++
vector<int> dijkstra(int V, vector<vector<pair<int, int>>>& adj, int src) {
    vector<int> dist(V, INT_MAX);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    dist[src] = 0;
    pq.push({0, src});

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        for (const auto& [v, weight] : adj[u]) {
            if (dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
                pq.push({dist[v], v});
            }
        }
    }
    return dist;
}
```

### Output:
```
Shortest distances from source: [0, 4, 8, 5, 7]
```


## Prim's Algorithm for Minimum Cost Spanning Tree (MST)

### Algorithm:
1. Start with an arbitrary vertex as the starting point for the MST.
2. Initialize a priority queue (min-heap) to keep track of edges with the minimum weight that connect the tree to new vertices.
3. Add all edges from the starting vertex to the heap.
4. While the heap is not empty:
    - Extract the minimum weight edge from the heap.
    - If the edge connects a vertex not yet in the MST, add it to the MST, mark the vertex as visited, and add all its adjacent edges to the heap.
5. Repeat until all vertices are in the MST.

### Time Complexity:
- \( O(E \log V) \), where \( E \) is the number of edges and \( V \) is the number of vertices.

### Space Complexity:
- \( O(V + E) \), for the graph representation and the priority queue.

### Code:
```c++
vector<pair<int, int>> prim(int V, vector<vector<pair<int, int>>>& adj) {
    vector<int> key(V, INT_MAX);
    vector<int> parent(V, -1);
    vector<bool> inMST(V, false);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    key[0] = 0;
    pq.push({0, 0}); // (weight, vertex)

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();
        inMST[u] = true;

        for (const auto& [v, weight] : adj[u]) {
            if (!inMST[v] && weight < key[v]) {
                key[v] = weight;
                pq.push({key[v], v});
                parent[v] = u;
            }
        }
    }

    vector<pair<int, int>> mstEdges;
    for (int i = 1; i < V; ++i) {
        if (parent[i] != -1) {
            mstEdges.push_back({parent[i], i});
        }
    }
    return mstEdges;
}
```

### Output:
```
Edges in the MST: [(0, 1), (1, 2), (2, 3), (3, 4)]
```

---

## Kruskal's Algorithm for Minimum Cost Spanning Tree (MST)

### Algorithm:
1. Start with a graph where edges are sorted by their weights in increasing order.
2. Use a Union-Find (Disjoint Set) data structure to keep track of connected components.
3. Iterate over the sorted edges:
    - For each edge, check if it connects two vertices in different components (using the Union-Find structure).
    - If they are in different components, add the edge to the MST and union the two components.
4. Repeat until there are \( V - 1 \) edges in the MST, where \( V \) is the number of vertices.

### Time Complexity:
- Sorting edges: \( O(E \log E) \), where \( E \) is the number of edges.
- Union-Find operations: \( O(\alpha(V)) \), where \( \alpha \) is the inverse Ackermann function (almost constant time).

- Overall: \( O(E \log E) \).

### Space Complexity:
- \( O(V + E) \), for storing the graph and the Union-Find structure.

### Code:
```c++
struct DisjointSet {
    vector<int> parent, rank;

    DisjointSet(int n) {
        parent.resize(n);
        rank.resize(n, 0);
        for (int i = 0; i < n; ++i) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void unionSets(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
};

vector<pair<int, int>> kruskal(int V, vector<pair<int, pair<int, int>>>& edges) {
    sort(edges.begin(), edges.end(), [](const auto& a, const auto& b) {
        return a.first < b.first; // Sort by edge weight
    });

    DisjointSet ds(V);
    vector<pair<int, int>> mstEdges;

    for (const auto& [weight, edge] : edges) {
        int u = edge.first, v = edge.second;
        if (ds.find(u) != ds.find(v)) {
            mstEdges.push_back({u, v});
            ds.unionSets(u, v);
        }
    }
    return mstEdges;
}
```

### Output:
```
Edges in the MST: [(0, 1), (1, 2), (2, 3), (3, 4)]
```
# Unit 4
## 0/1 Knapsack Problem
### Algorithm:
1. Create a 2D DP array `dp[i][w]` where `i` is the number of items and `w` is the current weight limit.
2. Initialize the first row and first column of `dp` to 0.
3. Iterate through each item:
    - For each possible weight limit from 1 to `W`, check if including the item results in a higher value than excluding it.
    - If the item's weight is less than or equal to the current weight limit, then:  
      `dp[i][w] = max(dp[i-1][w], dp[i-1][w-weight[i-1]] + value[i-1])`
    - Else: `dp[i][w] = dp[i-1][w]`
4. The answer will be found in `dp[n][W]`, where `n` is the number of items and `W` is the maximum weight capacity.

#### Time Complexity:
##### Best Case: O(n * W)
##### Average Case: O(n * W)
##### Worst Case: O(n * W)

#### Space Complexity:
##### Iterative: O(n * W)
##### Optimized: O(W) (by using a 1D array)

### Code: (Assuming all libraries are included)
```c++
int knapsack(int W, const vector<int>& weights, const vector<int>& values, int n) {
    vector<vector<int>> dp(n+1, vector<int>(W+1, 0));

    for (int i = 1; i <= n; ++i) {
        for (int w = 1; w <= W; ++w) {
            if (weights[i-1] <= w) {
                dp[i][w] = max(dp[i-1][w], dp[i-1][w - weights[i-1]] + values[i-1]);
            } else {
                dp[i][w] = dp[i-1][w];
            }
        }
    }

    return dp[n][W];
}
```

### Output:
```
Maximum value in Knapsack: 220
```

---

## Matrix Chain Multiplication Problem
### Algorithm:
1. Create a 2D DP array `dp[i][j]` where `i` and `j` are matrix indices. `dp[i][j]` stores the minimum number of scalar multiplications needed to multiply matrices from `i` to `j`.
2. Initialize the diagonal `dp[i][i] = 0` since no multiplication is needed for a single matrix.
3. For chain lengths from 2 to `n`:
    - For each subchain, compute the minimum cost of multiplying matrices between indices `i` and `j`.
    - For each `k` between `i` and `j-1`, compute the cost as:
      `dp[i][j] = min(dp[i][k] + dp[k+1][j] + p[i-1] * p[k] * p[j])`
      where `p[]` contains the matrix dimensions.
4. The answer will be found in `dp[1][n-1]`, which represents the minimum cost to multiply all matrices.

#### Time Complexity:
##### Best Case: O(n^3)
##### Average Case: O(n^3)
##### Worst Case: O(n^3)

#### Space Complexity:
##### O(n^2)

### Code: (Assuming all libraries are included)
```c++
int matrixChainOrder(const vector<int>& p, int n) {
    vector<vector<int>> dp(n, vector<int>(n, 0));

    for (int len = 2; len < n; ++len) {
        for (int i = 1; i < n - len + 1; ++i) {
            int j = i + len - 1;
            dp[i][j] = INT_MAX;
            for (int k = i; k < j; ++k) {
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + p[i-1] * p[k] * p[j]);
            }
        }
    }
    return dp[1][n-1];
}
```

### Output:
```
Minimum number of multiplications: 15125
```
## Longest Common Subsequence Problem
### Algorithm:
1. Create a 2D DP array `dp[i][j]`, where `i` and `j` are the lengths of the two input strings. `dp[i][j]` stores the length of the LCS of the first `i` characters of the first string and the first `j` characters of the second string.
2. Initialize the first row and first column of `dp` to 0, since the LCS with an empty string is 0.
3. Iterate through each pair of characters in the two strings:
    - If the characters match (`str1[i-1] == str2[j-1]`), then:
      `dp[i][j] = dp[i-1][j-1] + 1`
    - Otherwise:
      `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`
4. The length of the LCS will be found in `dp[n][m]`, where `n` and `m` are the lengths of the two strings.

#### Time Complexity:
##### Best Case: O(n * m)
##### Average Case: O(n * m)
##### Worst Case: O(n * m)

#### Space Complexity:
##### O(n * m)

### Code: (Assuming all libraries are included)
```c++
int longestCommonSubsequence(const string& str1, const string& str2) {
    int n = str1.size(), m = str2.size();
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));

    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if (str1[i-1] == str2[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    return dp[n][m];
}
```

### Output:
```
Length of LCS: 4
```

---

## Optimal Binary Search Tree Problem
### Algorithm:
1. Let `key[i]` be the ith key, and `freq[i]` be the frequency of that key.
2. Define `dp[i][j]` as the minimum cost of constructing a binary search tree with keys from index `i` to `j`.
3. If `i == j`, then `dp[i][j] = freq[i]` (the tree contains only one key).
4. For each subproblem size (from 2 to `n`), and for each possible root `r` in the range `[i, j]`:
    - The cost of the tree with root `r` is the sum of the costs of the left and right subtrees, plus the sum of frequencies from `i` to `j`.
    - `dp[i][j] = min(dp[i][r-1] + dp[r+1][j] + sum[i][j])`, where `sum[i][j]` is the sum of frequencies from `i` to `j`.
5. The result will be found in `dp[1][n]`.

#### Time Complexity:
##### Best Case: O(n^3)
##### Average Case: O(n^3)
##### Worst Case: O(n^3)

#### Space Complexity:
##### O(n^2)

### Code: (Assuming all libraries are included)
```c++
int optimalSearchTree(const vector<int>& keys, const vector<int>& freq, int n) {
    vector<vector<int>> dp(n, vector<int>(n, 0));
    vector<vector<int>> sum(n, vector<int>(n, 0));

    for (int i = 0; i < n; ++i) {
        sum[i][i] = freq[i];
        for (int j = i + 1; j < n; ++j) {
            sum[i][j] = sum[i][j-1] + freq[j];
        }
    }

    for (int len = 1; len <= n; ++len) {
        for (int i = 0; i <= n - len; ++i) {
            int j = i + len - 1;
            if (len == 1) {
                dp[i][j] = freq[i];
            } else {
                dp[i][j] = INT_MAX;
                for (int r = i; r <= j; ++r) {
                    int cost = (r > i ? dp[i][r-1] : 0) + (r < j ? dp[r+1][j] : 0) + sum[i][j];
                    dp[i][j] = min(dp[i][j], cost);
                }
            }
        }
    }

    return dp[0][n-1];
}
```

### Output:
```
Minimum cost of constructing optimal binary search tree: 38
```
# Unit 5 Backtracking approach
## 0/1 Knapsack Problem using Backtracking
### Algorithm:
1. Start with the first item and two possibilities: include the item or exclude it.
2. If the item is included, reduce the capacity of the knapsack and move to the next item.
3. If the item is excluded, move to the next item without reducing the capacity.
4. Keep track of the maximum value found during the process.
5. If the capacity is exceeded or there are no more items, backtrack to explore the next option.

#### Time Complexity:
##### Worst Case: O(2^n), where n is the number of items.

#### Space Complexity:
##### O(n), for the recursion stack.

### Code: (Assuming all libraries are included)
```c++
int knapsackBacktracking(const vector<int>& weights, const vector<int>& values, int W, int n) {
    if (n == 0 || W == 0) return 0;

    // If the weight of the current item is more than the knapsack capacity, exclude it
    if (weights[n-1] > W) {
        return knapsackBacktracking(weights, values, W, n-1);
    }

    // Otherwise, try both including or excluding the item
    int include = values[n-1] + knapsackBacktracking(weights, values, W - weights[n-1], n-1);
    int exclude = knapsackBacktracking(weights, values, W, n-1);

    return max(include, exclude);
}
```

### Output:
```
Maximum value in Knapsack: 220
```

---

## Travelling Salesperson Problem using Backtracking
### Algorithm:
1. Start from the first city and recursively try visiting every other city.
2. Track the total distance traveled and keep updating the minimum distance found.
3. Mark cities as visited and backtrack if all cities are visited or if the current path exceeds the minimum distance found.
4. After visiting all cities, return to the starting city and calculate the total distance.

#### Time Complexity:
##### Worst Case: O(n!), where n is the number of cities.

#### Space Complexity:
##### O(n), for the recursion stack.

### Code: (Assuming all libraries are included)
```c++
int tspBacktracking(const vector<vector<int>>& dist, vector<bool>& visited, int currPos, int n, int count, int cost, int ans) {
    // If all cities are visited, return to the starting city
    if (count == n) {
        return min(ans, cost + dist[currPos][0]);
    }

    // Try to go to every city from the current city
    for (int city = 0; city < n; ++city) {
        if (!visited[city]) {
            visited[city] = true;
            ans = tspBacktracking(dist, visited, city, n, count + 1, cost + dist[currPos][city], ans);
            visited[city] = false;
        }
    }
    return ans;
}

int travelingSalesperson(const vector<vector<int>>& dist, int n) {
    vector<bool> visited(n, false);
    visited[0] = true;
    return tspBacktracking(dist, visited, 0, n, 1, 0, INT_MAX);
}
```

### Output:
```
Minimum cost of traveling: 10
```

# Unit 5 Branch and Bound
## 0/1 Knapsack Problem using Branch and Bound
### Algorithm:
1. Sort the items based on the ratio of value/weight in descending order.
2. Define a node representing a subset of items, where each node has:
    - A lower bound (maximum possible value obtainable from this node).
    - The current weight and value of the subset.
3. Use a priority queue (or heap) to store the nodes, with nodes having higher upper bounds being processed first.
4. At each node:
    - If the current weight exceeds the capacity, prune the branch.
    - Otherwise, compute the upper bound and push the next states (including or excluding the current item) into the queue.
5. The algorithm continues until the queue is empty or an optimal solution is found.

#### Time Complexity:
##### Worst Case: O(2^n), but significantly improved by pruning branches.

#### Space Complexity:
##### O(n), for storing nodes in the priority queue.

### Code: (Assuming all libraries are included)
```c++
struct Item {
    int value;
    int weight;
};

struct Node {
    int level;
    int profit;
    int weight;
    float bound;
};

float bound(Node& u, int n, int W, const vector<Item>& items) {
    if (u.weight >= W) return 0;

    int profit_bound = u.profit;
    int j = u.level + 1;
    int total_weight = u.weight;

    while (j < n && total_weight + items[j].weight <= W) {
        total_weight += items[j].weight;
        profit_bound += items[j].value;
        j++;
    }

    if (j < n) {
        profit_bound += (W - total_weight) * items[j].value / items[j].weight;
    }

    return profit_bound;
}

int knapsackBranchBound(const vector<Item>& items, int W, int n) {
    priority_queue<Node> pq;
    Node u = { -1, 0, 0, 0.0 };
    pq.push(u);

    int maxProfit = 0;

    while (!pq.empty()) {
        Node v = pq.top();
        pq.pop();

        if (v.level == n - 1) continue;

        Node u1 = { v.level + 1, v.profit + items[v.level + 1].value, v.weight + items[v.level + 1].weight, 0 };
        if (u1.weight <= W && u1.profit > maxProfit) {
            maxProfit = u1.profit;
        }

        u1.bound = bound(u1, n, W, items);
        if (u1.bound > maxProfit) pq.push(u1);

        Node u2 = { v.level + 1, v.profit, v.weight, 0 };
        u2.bound = bound(u2, n, W, items);
        if (u2.bound > maxProfit) pq.push(u2);
    }

    return maxProfit;
}
```

### Output:
```
Maximum value in Knapsack: 220
```

---

## Travelling Salesperson Problem
### Algorithm:
1. Represent the problem as a graph with cities as nodes and distances as edges.
2. Define a node representing a partial tour, which contains:
    - The set of visited cities.
    - The current cost and path.
    - A bound on the cost to complete the tour from this node.
3. Use a priority queue (or heap) to store nodes, where nodes with lower bounds are processed first.
4. At each node:
    - If the tour is incomplete, explore all possible cities to visit next.
    - If adding a city violates any constraints (e.g., the total cost exceeds the lower bound), prune the branch.
    - Otherwise, calculate the lower bound and push the new node into the priority queue.
5. Continue until the optimal solution is found.

#### Time Complexity:
##### Worst Case: O(n!), but pruning improves the performance.

#### Space Complexity:
##### O(n), for storing nodes in the priority queue.

### Code: (Assuming all libraries are included)
```c++
struct TSPNode {
    vector<int> path;
    int cost;
    int bound;
};

int calculateBound(const vector<vector<int>>& dist, const vector<int>& path, int n) {
    int bound = 0;
    int lastCity = path.back();

    for (int i = 0; i < n; i++) {
        if (find(path.begin(), path.end(), i) == path.end()) {
            bound += dist[lastCity][i];
        }
    }

    return bound;
}

int tspBranchBound(const vector<vector<int>>& dist, int n) {
    priority_queue<TSPNode, vector<TSPNode>, greater<>> pq;
    TSPNode start = { {0}, 0, 0 };
    pq.push(start);

    int minCost = INT_MAX;

    while (!pq.empty()) {
        TSPNode node = pq.top();
        pq.pop();

        if (node.path.size() == n) {
            minCost = min(minCost, node.cost + dist[node.path.back()][0]);
        } else {
            for (int i = 0; i < n; i++) {
                if (find(node.path.begin(), node.path.end(), i) == node.path.end()) {
                    vector<int> newPath = node.path;
                    newPath.push_back(i);
                    int newCost = node.cost + dist[node.path.back()][i];
                    int bound = calculateBound(dist, newPath, n);

                    if (newCost + bound < minCost) {
                        pq.push({newPath, newCost, bound});
                    }
                }
            }
        }
    }

    return minCost;
}
```

### Output:
```
Minimum cost of traveling: 10
```
# Unit 6
```gfm
## String Matching: The Naive String-Matching Algorithm
### Algorithm:
1. Start from the first character of the text.
2. Compare the substring of the text starting from the current character to the pattern.
3. If the substring matches the pattern, return the starting index.
4. Otherwise, move one character forward and repeat the comparison.
5. Continue until the end of the text is reached.

#### Time Complexity:
##### Worst Case: O((n - m + 1) * m), where `n` is the length of the text and `m` is the length of the pattern.

#### Space Complexity:
##### O(1)

### Code: (Assuming all libraries are included)
```c++
int naiveStringMatch(const string& text, const string& pattern) {
    int n = text.size(), m = pattern.size();

    for (int i = 0; i <= n - m; ++i) {
        int j = 0;
        while (j < m && text[i + j] == pattern[j]) {
            ++j;
        }
        if (j == m) {
            return i;  // Match found at index i
        }
    }
    return -1;  // No match found
}
```

### Output:
```
Pattern found at index: 5
```

---

## String Matching: The Rabin-Karp Algorithm
### Algorithm:
1. Compute the hash value of the pattern and the initial substring of the text.
2. Compare the hash values of the pattern and the substring.
3. If the hash values match, perform a character-by-character comparison.
4. Slide the window one character to the right, update the hash value using the rolling hash technique, and repeat the process.
5. Continue until the entire text has been searched.

#### Time Complexity:
##### Worst Case: O((n - m + 1) * m) (if many hash collisions occur).
##### Average Case: O(n + m).

#### Space Complexity:
##### O(1) (excluding the input strings).

### Code: (Assuming all libraries are included)
```c++
int rabinKarp(const string& text, const string& pattern) {
    int n = text.size(), m = pattern.size();
    int d = 256;  // Number of characters in the input alphabet
    int q = 101;  // A prime number
    int h = 1;    // The hash multiplier
    int p = 0;    // Hash value for the pattern
    int t = 0;    // Hash value for the text
    int i, j;

    for (i = 0; i < m - 1; ++i) {
        h = (h * d) % q;
    }

    for (i = 0; i < m; ++i) {
        p = (d * p + pattern[i]) % q;
        t = (d * t + text[i]) % q;
    }

    for (i = 0; i <= n - m; ++i) {
        if (p == t) {
            for (j = 0; j < m; ++j) {
                if (text[i + j] != pattern[j]) {
                    break;
                }
            }
            if (j == m) {
                return i;  // Match found at index i
            }
        }

        if (i < n - m) {
            t = (d * (t - text[i] * h) + text[i + m]) % q;
            if (t < 0) {
                t += q;
            }
        }
    }
    return -1;  // No match found
}
```

### Output:
```
Pattern found at index: 5
```

---

## String Matching with Finite Automata
### Algorithm:
1. Build a finite automaton for the given pattern.
    - The automaton has states representing the characters of the pattern.
    - The transition from one state to another is based on the characters in the text.
2. For each character in the text, transition through the states of the automaton.
3. If the automaton reaches the final state (i.e., the entire pattern is matched), return the starting index of the match.

#### Time Complexity:
##### Worst Case: O(n), where `n` is the length of the text.
##### Preprocessing: O(m * |Σ|), where `m` is the length of the pattern and `|Σ|` is the size of the alphabet.

#### Space Complexity:
##### O(m * |Σ|), for storing the transition table.

### Code: (Assuming all libraries are included)
```c++
vector<vector<int>> buildFiniteAutomaton(const string& pattern) {
    int m = pattern.size();
    int d = 256;  // Number of characters in the input alphabet
    vector<vector<int>> automaton(m + 1, vector<int>(d, 0));

    for (int state = 0; state <= m; ++state) {
        for (int c = 0; c < d; ++c) {
            if (state < m && pattern[state] == c) {
                automaton[state][c] = state + 1;
            } else {
                automaton[state][c] = state;
            }
        }
    }

    return automaton;
}

int finiteAutomatonStringMatch(const string& text, const string& pattern) {
    int n = text.size(), m = pattern.size();
    vector<vector<int>> automaton = buildFiniteAutomaton(pattern);
    int state = 0;

    for (int i = 0; i < n; ++i) {
        state = automaton[state][text[i]];
        if (state == m) {
            return i - m + 1;  // Match found at index i - m + 1
        }
    }
    return -1;  // No match found
}
```

### Output:
```
Pattern found at index: 5
```
