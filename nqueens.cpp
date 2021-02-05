#include <iostream>
#include <cmath>
using namespace std;

bool ok(int q[], int c) {// Reuse the ok function from your 1D 8 queens program.

    for( int i=0; i<c; i++){
        if (q[i]==q[c] || c-i==abs(q[i]-q[c]))return false;
    }

    return true;
}

// This function should return the number of solutions for the given board size (you don't need to print the solutions).
int nqueens(int n) {
    int * q;// Dynamically declare an array of size n and initialize the first element to 0.
    q = new int [n];
    int c=0, solutions=0;
    q[0]=0;


    while(c>=0){
        c++;
        if(c==n){
            solutions++;
            c--;
        }

        while (c>=0){
            q[c]++;
            if(q[c]==n){
                q[c]=-1;
                c--;
            }
            else
                if(ok(q,c)==true)break;
        }
    }


    delete [] q;
    return solutions;

    // Reuse the code from your 1D 8 queens program to find the solutions (you may have to make changes).
    // Delete the array.
    // Return the number of solutions.
}

int main() {
    int n = 12;
    for (int i = 1; i <= n; ++i)
        cout << "There are " << nqueens(i) << " solutions to the " << i << " queens problem.\n";
    return 0;
}
