class Solution {

    /*
        "0110101"
        
    */
    // nOt working
    public int secondsToRemoveOccurrences(String s) {
        int time = 0;
        boolean flag = false;
        while(true){
            time++;
            Map<String, Integer> mp = new HashMap<>();
            for(int k=0; k<s.length()-1; k++){
                if(!mp.containsKey(s.substring(k,k+2))){
                    mp.put(s.substring(k,k+2),1);
                }else{
                    mp.put(s.substring(k,k+2),mp.get(s.substring(k,k+2))+1);
                }
            }
            System.out.print(mp);
            
            if(!mp.containsKey("01")){
                break;
            }else{
                flag = true;
            }
            int i=0;
            int j=0;
            while(j<s.length()){
                if(j-i+1==2){
                    if(s.charAt(i)=='0' && s.charAt(j)=='1'){
                        char[] arr = s.toCharArray();
                        arr[i]='1';
                        arr[j]='0';
                        s = String.valueOf(arr);
                    }
                    i++;
                    j++;
                }else{
                    j++;
                }   
            }   
        }
        return flag?time:0;
        
    }
}
//WOrking but TLE
class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int time = 0;
        
        while(s.contains("01")){
            int i=0;
            int j=1;
            time++;
            
            while(j<s.length() && i<s.length()-1){
                char[] arr = s.toCharArray();
                if(arr[i]=='0' && arr[j]=='1'){
                    arr[i]='1';
                    arr[j]='0';
                    s = String.valueOf(arr);
                    i++;
                    j++;
                }
                i++;
                j++;
            }
        }
        return time;
    }
}
// Working and Accepted
/*
 * 
 * 
 * First off, the final string will be of the form 1111....000....

One observation is that since a '1' has to be swapped with every occurence of '0' to its left, the time taken for that '1' to reach its final position is atleast the number of zeroes to its left.

Why is it not equal to number of '0's to its left ?
In a testcase like '011' -> '101' -> '110', the second '1' had to wait for the first '1' in the first turn.

The total number of time taken for a '1' to reach its final position is number of '0's to its left + number of turns it waits.

Every time we come across two consequetive ones, the waiting time increases by one.

And everytime we come acress two consequetive zeroes, the waiting time decreases by one.
( consider 0 1 1 0 0 1 The waiting time for the first '1' is 0, for the second '1' is 1 , but for the third '1' is again 0, because while the second '1' was waiting, the third '1' would not waste a turn by moving through the zeroes before it.)

Also, it is obvious that the last occurence of a '1' is the one that will reach its destination the last.
So we just have to find the number of zeroes to the left of it + its waiting time
 */

class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int waitingTime = 0;
        int zeroCount=0;
        int lastOcc = s.lastIndexOf('1');
        char[] arr = s.toCharArray();
        for(int i=0; i<lastOcc+1; i++){
            if(i>0 && arr[i]=='1' && arr[i-1]=='1' && zeroCount>0){
                waitingTime+=1;
            }
            
            if(i>0 && arr[i]=='0' && arr[i-1]=='0' && waitingTime>0){
                waitingTime-=1;
            }
            if(arr[i]=='0'){
                zeroCount+=1;
            }
        }
        return zeroCount+waitingTime;
    }
}