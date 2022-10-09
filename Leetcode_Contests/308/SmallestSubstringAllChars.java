import java.io.*;
import java.util.*;

class Solution {

  static String getShortestUniqueSubstring(char[] arr, String str) {
    // For the sliding windows 
    int left = 0;
    int right = 0;
    // For getting the count of unique elements in substring at present
    int count = 0;
    String res = "";
    Map<Character,Integer> mp = new HashMap<>();
    // We first put all elements into the map and set a counter as 0
    for(char c: arr){
      mp.put(c,0);
    }
    for(;right<str.length(); right++){
      // The element is not in the map, we simply increment our right pointer
      if(!mp.containsKey(str.charAt(right))){
        continue;
      }
      // Otherwise get the current count of right, if 0 we increment unique counter

      if(mp.get(str.charAt(right))==0){
        count += 1;
      }
      mp.put(str.charAt(right),mp.get(str.charAt(right))+1);
      // If we find the correct number of elements in our window
      while(count==arr.length){
        // We first get the size of the window
        int temp = right-left+1;
        // If the window is already of the required size, we simply return
        if(temp==arr.length){
          return str.substring(left,right+1);
        }
        // Otherwise, if our window size is smaller than our intial answer we set a new answer
        if(res=="" || temp<res.length()){
          res = str.substring(left,right+1);
        }
        // Then after setting a new answer, we move our left pointer ahead
        if(mp.containsKey(str.charAt(left))){
          // we reduce the count of the element at left pointer if it is in the array,
          int curr = mp.get(str.charAt(left))-1;
          // If the curr reaches 0, that measn we no longer have the required count inside the map
          if(curr==0){
            // So we decrement our count
            count -=1;
          }
          mp.put(str.charAt(left), curr);
        }
        // Either way we increment our left pointer.
        left = left+1;
      }
    }
    return res;
  }
  public static void main(String[] args) {

  }

}