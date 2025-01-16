#include <iostream>
#include <vector>
using namespace std;
void insertionSort(vector<int>& arr) {
    for (size_t i = 1; i < arr.size(); ++i) {
        int key = arr[i];
        size_t j = i - 1;

        while (j < arr.size() && j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
// Function to print an array
void printArray(const vector<int>& arr) {
    for (const int& num : arr) {
        cout << num << " ";
    }
    cout << endl;
}

int main() {
    vector<pair<vector<int>, vector<int>>> testCases = {
        {{25, 14, 16, 13, 10, 8, 12}, {8, 10, 12, 13, 14, 16, 25}},  // Random unsorted array
        {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}},                        // Already sorted array
        {{5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}},                        // Reverse sorted array
        {{42}, {42}},                                               // Single element array
        {{}, {}}                                                    // Empty array
    };

    for (size_t i = 0; i < testCases.size(); ++i) {
        vector<int> inputArray = testCases[i].first;
        vector<int> expectedOutput = testCases[i].second;   
        cout << "Test Case " << i + 1 << ":\n";
        cout << "Input: ";
        printArray(inputArray);
        insertionSort(inputArray);
        cout << "Expected Output: ";
        printArray(expectedOutput);
        cout << "Output: ";
        printArray(inputArray);

        cout << endl;
    }

    return 0;
}
