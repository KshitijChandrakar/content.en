#include <iostream>
#include <vector>
int pass = 1;
void merge(std::vector<int>& arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    std::vector<int> L(n1), R(n2);

    for (int i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[mid + 1 + j];

    int i = 0;
    int j = 0;
    int k = left;

    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }

    std::cout << "Array after merging at " << pass << "th pass: ";
    pass++;
    for (int m = 0; m < arr.size(); m++) {
        std::cout << arr[m] << " ";
    }
    std::cout << std::endl;
}

void mergeSort(std::vector<int>& arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}
int testcases( std::vector<int> arr){
  std::cout << "Initial array: ";
  for (const int& num : arr) {
      std::cout << num << " ";
  }
  std::cout << std::endl;

  mergeSort(arr, 0, arr.size() - 1);

  std::cout << "Sorted array: ";
  for (const int& num : arr) {
      std::cout << num << " ";
  }
  std::cout << std::endl;

  return 0;
}
int main() {
  std::vector<std::pair<std::vector<int>, std::vector<int>>> testCases = {
      {{1, 2, 3, 4, 5, 6, 7}, {1, 2, 3, 4, 5, 6, 7}},
      {{9, 8, 7, 6, 5, 4, 3, 2, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9}},
      {{4, 1, 3, 9, 7}, {1, 3, 4, 7, 9}},
      {{5, 3, 8, 5, 2, 8, 1}, {1, 2, 3, 5, 5, 8, 8}},
      {{42}, {42}},
      {{}, {}}
  };
    int count = 6;
    for (size_t i = 0; i < count; i++) {
      pass = 0;
      testcases(testCases[i].second);
      std::cout << "Expected Output:" << '\n';
      for (const int& num : testCases[i].first) {
          std::cout << num << " ";
      }
      std::cout << "\n-----------------\n";
    }

}
