#include<iostream>
using namespace std;

bool ok(int q[], int col) { // Finish this code
    static int mp[3][3] = { { 0,2,1 },       // Man#0's preferences
        { 0,2,1 },        // Man#1's preferences
        { 1,2,0 } };    // Man#2's preferences

    static int wp[3][3] = { { 2,1,0 },        // Woman#0's preferences
        { 0,1,2 },        // Woman#1's preferences
        { 2,0,1 } };     // Woman#2's preferences

    //Similar to 1D Queens, use a loop to check the array.
    //Inside the loop we chould check for 3 conditions
    for(int i=0; i<col; i++){
        if(q[col]==q[i])return false;//first condition

        if(mp[i][q[col]] < mp[i][q[i]] && wp[q[col]][i]< wp[q[col]][col])return false;//second condition

        if(mp[col][q[i]] < mp[col][q[col]] && wp[q[i]][col] < wp[q[i]][i])return false;//third condition

    }

    return true;
    //First condition checks is the same women is married to two different man *hint we need to check if two things are equal*
    //Second condition checks if (Man#i) and (Man#c's wife) both like each other more than their own spouse
    //Third condition checks if (Man#c) and (Man#i's wife) both like each other more than their own spouse

    //mp[i][j] tells you how much Man#i likes Woman#j. (0 = favorite; 2 = least favorite)
    //wp[i][j] tells you how much Woman#i likes Man#j.

    //mp[i][q[i]] tells you how much Man#i likes his own wife.
    //mp[i][q[c]] tells you how much Man#i likes Man#c's wife.
    //wp[q[i]][i] tells you how much Man#i's wife likes Man#i.
    //wp[q[i]][c] tells you how much Man#i's wife likes Man#c.
    //If mp[i][q[c]] < mp[i][q[i]], it means that Man#i likes Man#c's wife more than his own wife


    //if we pass the loop, what do we return?
}

void print(int q[]) {
    static int solution = 0;
    cout << "Solution #" << ++solution << ":\nMan\tWoman\n";

    for(int i=0; i<3; i++){
        cout<<i;
        cout<<"    "<<q[i]<<endl;
    }
    //Finish this print function
}

void backtrack(int &col){
    col--;
    if(col==-1)exit(1);
}


int main() {//Write the main function.//The main function is exactly the same as 1D Queens. EXCEPT the array size is different.
    int q[3]={}, col=0;
    q[0]=0;

    while (col>=0){
        col++;
        if(col==3){
            print(q);
            backtrack(col);
        }

        while(col>=0){
            q[col]++;
            if(q[col]==3){
                q[col]=-1;
                backtrack(col);
            }
            else
                if(ok (q,col)==true) break;

        }
    }

    return 0;
}
