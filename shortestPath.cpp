#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

const int NUM_ROWS = 5, NUM_COLS = 6;
string path[NUM_ROWS][NUM_COLS];

// Calculates the cost of every square and fills in the cost matrix.
void calculateCosts() {
   static int weight[NUM_ROWS][NUM_COLS] = {{3,4,1,2,8,6},
                                            {6,1,8,2,7,4},
                                            {5,9,3,9,9,5},
                                            {8,4,1,3,2,6},
                                            {3,7,2,8,6,4}};
   // Declare the cost matrix.
   static int cost[NUM_ROWS][NUM_COLS];
   // Copy the leftmost column of the weight matrix to the cost matrix, and initialize the leftmost column of the path matrix.
   for(int i=0; i<NUM_ROWS; i++){
   cost[i][0]= weight[i][0];
   path[i][0]= to_string(i);
   }
   // For each remaining column,
   int up, left, down, min;

   for(int j=1; j<NUM_COLS; j++){// Calculate the cost of each square in the column (non-recursively),
     for(int i=0; i<NUM_ROWS; i++){
     left =  cost[i][j-1];
     up = cost [(i-1+NUM_ROWS)%NUM_ROWS][j-1];
     down = cost [(i+1)%NUM_ROWS][j-1];


     if (left < up && left < down) min= left;
     else if( up< left && up<down ) min= up;
     else min= down;

    cost[i][j] = min + weight[i][j];
   if (min == left )path[i][j]= path [i][j-1]+ to_string(i);
   else if (min== up)path [i][j]= path [(i-1+NUM_ROWS)%NUM_ROWS][j-1]+ to_string(i);
   else path[i][j]= path [(i+1)%NUM_ROWS][j-1]+ to_string(i);
      // Calculate the cost of each square in the column (non-recursively),
      // and store the correct number in the cost matrix and the correct string in the path matrix.
    }
  }
   int minRow=0;
   int minCost = cost[0][NUM_COLS-1];
   // Check which square in the rightmost column has the lowest cost.  Store the row number of that square in minRow.
   for(int i=1; i<NUM_COLS-1; i++){
     int temp = cost[i][NUM_COLS-1];
     if(temp < minCost) {
       minCost = temp;
       minRow = i;
     }
   }

   cout << "The length of the shortest path is " << minCost;
   cout << ".\nThe rows of the path from left to right are " << path[minRow][NUM_COLS-1] << ".";
}

int main() {
   calculateCosts();

   return 0;
}
