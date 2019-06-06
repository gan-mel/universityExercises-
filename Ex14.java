/**
 * Maman - 14 - Ex14.java
 *
 * This class contains all the solutions for the exercises
 * provided in Maman 14.
 *
 * Question 1 - efficiency - water volume tool
 * Question 2 - efficiency - find the purpose of the method and write it efficiently
 * Question 3 - recursion - print all possible solutions and return how many are possible
 * Question 4 - recursion - find a possible path to the sum given in a matrix by adding up numbers
 *
 *  @author Gan Melamoud
 *  @version 2019, semester a
 */



public class Ex14 {

// Question 1:
// This method receives an array which represents a water collection tool
// water can be collected in a way that it is not "spilled outside"
// of the tool, each rain collected is represented by a single block.
//
// @param heights - array of positive heights of the water tool
// @return totalRain - the total amount of rain that can be collected in the given water tool
//
// Space Complexity: O(1)
// Time Complexity: O(n)

    public static int waterVolume(int[] heights) {

        int

                highestWallPosition = 0,
                highestLeft = heights[0],
                highestRight = heights[heights.length - 1],
                entireArr = heights.length - 1,
                totalRain = 0;


        // Find the highest wall if there is
        // more than one, the first one will be selected

        for (int i = 0; i < entireArr; i++) {

            if (heights[i] > heights[highestWallPosition]) {

                highestWallPosition = i;

            }

        }


        // Collect rain, each loops starts from one end
        // of the tool and collects rain until it reaches the
        // position of the highest wall, if there is more than
        // a single highest wall the first one that was selected will
        // serve as the highest.

        for (int j = 0; j < highestWallPosition; j++) {


            if (highestLeft >= heights[j]) {

                totalRain += highestLeft - heights[j];

            } else {

                highestLeft = heights[j];

            } // Left side accumulating

        }

        for (int k = entireArr; k > highestWallPosition; k--) {

            if (highestRight >= heights[k]) {

                totalRain += highestRight - heights[k];

            } else {

                highestRight = heights[k];

            }

        } // Right side accumulating


        return totalRain;

    }


// Question 2:

// Question A - This method takes in an array of numbers and calculates the maximum amount of cells that their sum can be added together as an even number.

// Question B -
// Time complexity: n^3
// Space complexity: O(1)

// Question C -
// This method takes in an array of numbers and calculates the maximum amount of cells that their sum can be added together as an even number.
//
// @param a - array of whole numbers (negative or positive)
// @return maxEvenCells - the maximum amount of cells that can be added together while their value's sum is even
// Question D -
// Time complexity: O(n) - as there is only one loop dependent on the input of the user array size it is 1*N time complexity
// Space complexity: O(1) - The amount of data used is not dependent on user input and is a constant amount of data (4)

    public static int what(int[] a) {

        int entireArr = a.length;
        int sumOfArr = 0;
        int i;
        int maxEvenCells = 0;
        boolean flag = false;
        for (i = 0; i <= entireArr-1; i++) {

            sumOfArr += a[i];

        } // add all the numbers

        if (sumOfArr % 2 == 0) {

            maxEvenCells = i;

        } // if the sum of all the cells is already even the solution is the length of the entire array

        else if(sumOfArr % 2 != 0) {

            for (int j = 0; (j <= entireArr-1) && (sumOfArr % 2 != 0); j++) {

                if ((sumOfArr - a[j]) % 2 == 0) {

                    sumOfArr -= a[j];

                    maxEvenCells = entireArr-1;

                    flag = true;
                }
            } // first side of the array check if there is an odd number to deduct

            for (int k = entireArr-1 ; (k < 0) && (sumOfArr % 2 != 0) && (!flag) ; k--) {

                if ((sumOfArr - a[k]) % 2 == 0) {

                    sumOfArr -= a[k];

                    maxEvenCells = entireArr-1;
                }
            }  // second side of the array check if first unable to locate an odd number


        }

        return maxEvenCells;

    }


// Question 3:
// This is a recursive method which takes in a positive integer and returns
// the amount of possible equations in order to reach to this number (x1 + x2 + x3 = num) - while x is a number between 1-10
// the method also prints each of the possible equations.
//
// @param num - a positive integer
// @return counting - the amount of possible equations to reach to the given number


    public static int solutions(int num) {

        int x1 = 1, x2 = 1, x3 = 1;

        return solutions(num, x1, x2, x3);

    }


    private static int solutions(int num, int x1, int x2, int x3) {

        int counting = 0;

        if (num < 3 || num > 30) {
            return 0;
        }


        if (x1 + x2 + x3 == num) {
            System.out.println(x1 + " + " + x2 + " + " + x3);
            counting++;
        } // every time the equation equals the given num, print that equation and add to the counting.


        if (x1 < 10) {

            return counting + solutions(num, x1 + 1, x2, x3);

        }// run the recursion adding to x1 and return the counting amount

        if (x2 < 10) {
            x1 = 1; // reset the x1 to 1 and run the recursion adding to x2 and return the counting amount
            return counting + solutions(num, x1, x2 + 1, x3);

        }

        if (x3 < 10) {
            x1 = 1;
            x2 = 1;// reset x1 and x2 to 1 and run the recursion adding to x3 and return the counting amount
            return counting + solutions(num, x1, x2, x3 + 1);


        }

        return counting;
    }



// Question 4:
// This is a recursive method which find weather there is path to a given sum number within a given matrix with
// positive integers. the method will return weather at least one path is possible or not and will modify the path
// matrix which is filled with 0's to have 1's where such a path is possible to add up numbers and reach the sum.
//
// @param mat - a matrix of positive integers
// @param sum - the sum of which a path needs to be found within the matrix to reach that sum by adding numbers
// @param path - a matrix of 0's, to be filled with 1's from the beginning of the path to the sum until the end of path to the sum
// @return boolean - if there is at least one path the method will return true if there is not - false

    public static boolean findSum(int mat[][], int sum, int path[][]) {

        return findSum(mat, sum, path, 0, 0);

    }

    private static boolean findSum(int[][] mat, int sum, int[][] path, int row, int col) {
        if (row >= mat.length || row < 0)
            return false; // if iterated over all of the rows and couldn't find a path return false

        if (findPath(mat, sum, path, row, col))
            return true; // if it could find a path return true

        // above are the two stop conditions for the below recursive calls (otherwise continue to go through the matrix)

        if (col < mat[0].length - 1) // there are still columns to go through in this row, move to the next column
            return findSum(mat, sum, path, row, col + 1);

               else
                 return findSum(mat, sum, path, row + 1, 0); // no more columns to go to - move to the next row

    } // This method goes through the matrix recursively

    private static boolean findPath(int mat[][], int sum, int path[][], int row, int col) {

        if (sum == 0)
            return true; // a path is sound to get to the sum (by reducing the sum for each square on the path

        if (row >= mat.length || row < 0 || col >= mat[0].length || col < 0 || path[row][col] == 1)
            return false; // check if it's a valid path, not out of bounds and has not been visited already


        sum -= mat[row][col]; // for each path it tries to take, remove the amount in the current sum to try and get to 0
        path[row][col] = 1; // mark path as visited


        if (findPath(mat, sum, path, row + 1, col))
            return true;

        if (findPath(mat, sum, path, row - 1, col))
            return true;

        if (findPath(mat, sum, path, row, col + 1))
            return true;

        if (findPath(mat, sum, path, row, col - 1))
            return true;

        path[row][col] = 0;
           return false; // if a path was not found for that specific square in all directions mark it with 0 as it is not a valid path


    } // This method looks through all possible paths to the sum from right,left,up or down for each of the squares in the matrix
}
