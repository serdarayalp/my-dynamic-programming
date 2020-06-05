package de.dynamic.programming.geeksforgeeks;

// Java program to find out maximum
// value from a given sequence of coins

class GFG {

    // https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
    // Returns optimal value possible
    // that a player can collect from
    // an array of coins of size n.
    // Note than n must be even
    static int optimalStrategyOfGame(int arr[], int n) {

        // Create a table to store
        // solutions of subproblems
        int table[][] = new int[n][n];
        int w, i, j, x, y, z;

        // Fill table using above recursive formula.
        // Note that the tableis filled in diagonal
        // fashion (similar to http:// goo.gl/PQqoS),
        // from diagonal elements to table[0][n-1]
        // which is the result.


        /*
            F(i, j) represents the maximum value the user
            can collect from i'th coin to j'th coin.

            F(i, j) = Max(Vi + min(F(i+2, j), F(i+1, j-1) ),
                          Vj + min(F(i+1, j-1), F(i, j-2) ))
            As user wants to maximise the number of coins.

            Base Cases
                F(i, j) = Vi           If j == i
                F(i, j) = max(Vi, Vj)  If j == i + 1
         */
        for (w = 0; w < n; ++w) {
            for (i = 0, j = w; j < n; ++i, ++j) {

                // x = F(i+2, j),
                // y = F(i+1, j-1) and
                // z = F(i, j-2)
                x = ((i + 2) <= j)
                        ? table[i + 2][j]
                        : 0;

                y = ((i + 1) <= (j - 1))
                        ? table[i + 1][j - 1]
                        : 0;

                z = (i <= (j - 2))
                        ? table[i][j - 2]
                        : 0;

                table[i][j] = Math.max(
                        arr[i] + Math.min(x, y),
                        arr[j] + Math.min(y, z));
            }
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                System.out.printf("%3d", table[a][b]);
            }
            System.out.println();
        }

        System.out.println();

        return table[0][n - 1];
    }

    public static void main(String[] args) {

        int arr0[] = {8, 5};
        int n = arr0.length;
        System.out.println("{8, 5}");
        System.out.println(optimalStrategyOfGame(arr0, n));

        int arr1[] = {8, 15, 3, 7};
        n = arr1.length;
        System.out.println("{8, 15, 3, 7}");
        System.out.println(optimalStrategyOfGame(arr1, n));

        int arr2[] = {2, 2, 2, 2};
        n = arr2.length;
        System.out.println("{2, 2, 2, 2}");
        System.out.println(optimalStrategyOfGame(arr2, n));

        int arr3[] = {20, 30, 2, 2, 2, 10};
        n = arr3.length;
        System.out.println("{20, 30, 2, 2, 2, 10}");
        System.out.println(optimalStrategyOfGame(arr3, n));

        int arr4[] = {4, 7, 2, 3};
        ;
        n = arr4.length;
        System.out.println("{4,7,2,3}");
        System.out.println(optimalStrategyOfGame(arr4, n));

        int arr5[] = {3, 4, 1, 2, 8, 5};
        n = arr5.length;
        System.out.println("{3,4,1,2,8,5}");
        System.out.println(optimalStrategyOfGame(arr5, n));

    }

}
