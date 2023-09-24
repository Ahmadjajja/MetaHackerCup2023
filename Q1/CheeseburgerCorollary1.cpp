#include<iostream>
#include <unordered_map>
#include<fstream>
#include<vector>
using namespace std;
ofstream file("D:/Git Hub Repos/Meta hacker cup/2023/Qualification Round/Problem 1/output.txt");
void calculate(int test_case){
    int S, D, K;
    cin >> S >> D >> K;

    int bunsWeHave, pAndc;
    bunsWeHave = 2 * (S + D);
    pAndc = (S * 1) + (D * 2);

    cout << "Case #" << test_case << ": ";
    file << "Case #" << test_case << ": ";
    if(bunsWeHave >= K+1){
        if(pAndc >= K){
            cout << "YES" << '\n';
            file << "YES" << '\n';
            return;
        }
    }
    cout << "NO" << '\n';
    file << "NO" << '\n';  
}

int main(){ 

    int test_cases;
    cin >> test_cases;


    for(int tc = 1; tc <=test_cases; tc++){ 
        calculate(tc);
        cout << flush;
    }
    file.close();
    return 0;

}

