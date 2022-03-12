// Problem Statement: 
/*
Given an unsorted array Arr of N positive and negative numbers. Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
Note: Array should start with positive number.
 

Example 1:

Input: 
N = 9
Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
Output:
9 -2 4 -1 5 -5 0 -3 2
*/

package DSA450Restart.Arrays;
import java.util.*;
public class AltNegPos {
    
    // We first write the function for rotating by one position
    public static void altnegpos(int arr[], int n) {
        // code here
       ArrayList<Integer> posNums = new ArrayList<>();
       ArrayList<Integer> negNums = new ArrayList<>();
       
       for(int i = 0; i < n; i++){
           if(arr[i] >= 0){
               posNums.add(arr[i]);
           }else{
               negNums.add(arr[i]);
           }
       }
       
       int posIndex = 0, negIndex = 0, i = 0;
       
       while(posIndex < posNums.size() && negIndex < negNums.size()){
           
           if(i%2 == 0){ // Since we have the first position as always positive we check for the positive places and add positive numbers in those indices
               arr[i] = posNums.get(posIndex);
               posIndex++;
               i++;
           }else{
               // In all other places we place the negative numbers
               arr[i] = negNums.get(negIndex);
               negIndex++;
               i++;
           }
           
       }
       
      // For differing sizes of the negative and positive elements we add the remaining elements that we have left in our
      // positive and negative arrays. If our positive and negative arrays have the same sizes these loops won't execute.
      while(posIndex < posNums.size()){
          arr[i] = posNums.get(posIndex);
            posIndex++;
          i++;
      }
       
      while(negIndex < negNums.size()){
          arr[i] = negNums.get(negIndex);
          negIndex++;
          i++;
      }
    }
    

    

    public static void main(String[] args) {
        int arr[] = {-1,-2,-3,4,5,6}; // Output: {4,-1,5,-2,6,-3}
        altnegpos(arr, arr.length);

    }

}
