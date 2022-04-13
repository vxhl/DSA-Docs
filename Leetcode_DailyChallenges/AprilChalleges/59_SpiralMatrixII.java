package Leetcode_DailyChallenges.AprilChalleges;

class SpiralMatrixII
{
    public static int[][] generateMatrix(int n)
    {
        // The range of elements to be put into our matrix
        int range = n*n;
        int[][] res = new int[n][n];

        // Ok now for the traversal 
        // We first define our start and end cols and rows

        int startRow = 0;
        int startCol = 0;
        int endCol = n-1;
        int endRow = n-1;
        int k = 1;
        while(startRow<=endRow && startCol <=endCol && k<=range)
        {
            /*
            recalling how we did in spiral matrix 1
            We first filled our first row and then moved our row and col
            accordingly inward when we were done with it right
            */

            // First we traverse for our firstRow and once we are done with it we increment our row
            for(int i=startCol; i<=endCol; i++)
            {
                res[startRow][i] = k;
                k++; 
            }
            startRow++;

            // Now we print our last column;
            for(int i=startRow; i<=endRow; i++)
            {
                res[i][endCol] = k;
                k++;
            }
            endCol--;

            if(startRow<=endRow)
            {
                for(int i=endCol; i>=startCol; i--)
                {
                    res[endRow][i] = k;
                    k++;
                }
                endRow--;

            }
            if(startCol<=endCol)
            {
                for(int i=endRow; i>=startRow; i--)
                {
                    res[i][startCol] = k;
                    k++;
                }
                startCol++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;

        for(int i=0; i<generateMatrix(n).length; i++)
        {
            for(int j=0; j<generateMatrix(n)[0].length; j++)
            {
                System.out.print(generateMatrix(n)[i][j] + " ");
            }
            System.out.println();
        }
    
    
    }
}
