public class Solution {
    public int coverPoints(int[] A, int[] B) {
        int steps = 0;
        int currX = A[0];
        int currY = B[0];
        for(int i=1; i<A.length; i++){
            int distX = A[i];
            int distY = B[i];
            while(currX!=distX || currY!=distY){
                if(currX<distX) currX++;
                else if(currX>distX) currX--;
                
                if(currY<distX) currY++;
                else if(currY>distY) currY--;
                
                steps++;
            }
        }
        return steps;
    }

    public int coverPoints2(int[] A, int[] B) {
        int steps = 0;
        int currX = A[0];
        int currY = B[0];
        for(int i=1; i<A.length; i++){
            int distX = A[i];
            int distY = B[i];
            steps+= Math.max(
                Math.abs(distX-currX),
                Math.abs(distY-currY)
            );
            currX = distX;
            currY = distY;
        }
        return steps;
    }

}
