#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <utility>
using namespace std;

const int TotalUsers = 4;

void allocateBandwidth(const string users[], const int userBandwidth[], const int userValues[], const int totalBandwidth) {
    double VBRatio[TotalUsers];

    // Calculate value-to-bandwidth ratios
    for (int i = 0; i < TotalUsers; ++i) {
        VBRatio[i] = static_cast<double>(userValues[i]) / userBandwidth[i];
    }

    // Sort users by value-to-bandwidth ratio
    for (int i = 0; i < TotalUsers - 1; ++i) {
        for (int j = 0; j < TotalUsers - i - 1; ++j) {
            if (VBRatio[j] < VBRatio[j + 1]) {
                swap(VBRatio[j], VBRatio[j + 1]);
                swap(users[j], users[j + 1]);
                swap(userBandwidth[j], userBandwidth[j + 1]);
                swap(userValues[j], userValues[j + 1]);
            }
        }
    }

    int remainingBandwidth = totalBandwidth;
    double totalValue = 0.0;
    double allocation[TotalUsers] = {0};

    // Allocate bandwidth
    for (int i = 0; i < TotalUsers; ++i) {
        if (remainingBandwidth > 0) {
            double allocated = min(static_cast<double>(userBandwidth[i]), static_cast<double>(remainingBandwidth));
            totalValue += (allocated / userBandwidth[i]) * userValues[i];
            allocation[i] = allocated;
            remainingBandwidth -= allocated;
        }
    }

    // Print the results
    cout << "Maximum Value Achieved: " << totalValue << endl;
    cout << "Bandwidth Allocation:" << endl;
    for (int i = 0; i < TotalUsers; ++i) {
        cout << "User " << users[i] << ": " << allocation[i] << " MB" << endl;
    }
}

int main() {
    vector<tuple<string[TotalUsers], int[TotalUsers], int[TotalUsers], int, double, vector<double>>> testCases = {
        {
            {"U1", "U2", "U3", "U4"},
            {40, 70, 30, 50},
            {50, 90, 45, 60},
            100,
            96.4286,
            {40, 60, 0, 0} // Expected allocations
        },
        {
            {"U1", "U2", "U3", "U4"},
            {40, 70, 30, 50},
            {50, 90, 45, 60},
            50,
            49.2857,
            {40, 10, 0, 0} // Expected allocations
        },
        {
            {"U1", "U2", "U3", "U4"},
            {40, 70, 30, 50},
            {50, 90, 45, 60},
            70,
            70.0,
            {40, 30, 0, 0} // Expected allocations
        },
        {
            {"U1", "U2", "U3", "U4"},
            {40, 70, 30, 50},
            {50, 90, 45, 60},
            30,
            30.0,
            {30, 0, 0, 0} // Expected allocations
        },
        {
            {"U1", "U2", "U3", "U4"},
            {40, 70, 30, 50},
            {50, 90, 45, 60},
            0,
            0.0,
            {0, 0, 0, 0} // Expected allocations
        }
    };

    for (size_t i = 0; i < testCases.size(); ++i) {
        string users[TotalUsers];
        int userBandwidth[TotalUsers];
        int userValues[TotalUsers];
        int totalBandwidth;
        double expectedValue;
        vector<double> expectedAllocations;

        tie(users, userBandwidth, userValues, totalBandwidth, expectedValue, expectedAllocations) = testCases[i];

        cout << "Test Case " << i + 1 << ":\n";

        // Print input
        cout << "Input:\n";
        cout << "Users: ";
        for (const auto& user : users) {
            cout << user << " ";
        }
        cout << "\nUser Bandwidth: ";
        for (const auto& bw : userBandwidth) {
            cout << bw << " ";
        }
        cout << "\nUser Values: ";
        for (const auto& value : userValues) {
            cout << value << " ";
        }
        cout << "\nTotal Bandwidth: " << totalBandwidth << endl;

        // Perform bandwidth allocation
        allocateBandwidth(users, userBandwidth, userValues, totalBandwidth);

        cout << "Expected Output: Maximum Value Achieved: " << expectedValue << endl;
        cout << "Expected Bandwidth Allocation: ";
        for (const auto& alloc : expectedAllocations) {
            cout << alloc << " MB ";
        }
        cout << endl;

        cout << endl;
    }

    return 0;
}
