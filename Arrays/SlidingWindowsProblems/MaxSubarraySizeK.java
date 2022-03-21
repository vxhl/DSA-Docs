package Arrays.SlidingWindowsProblems;

public class MaxSubarraySizeK {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
         int i=0;
        int j=0;
        ArrayList<Integer> list=new ArrayList<>();
        Deque<Integer> q=new LinkedList<>();
        while(j<arr.length){
            if(q.isEmpty()==false && q.peekLast()<arr[j]){
                while(q.peekLast()!=null && q.peekLast()<arr[j]){
                    q.removeLast();
                }
            }
            q.addLast(arr[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(q.isEmpty()==false) list.add(q.peekFirst());
                if(q.isEmpty()==false && q.peekFirst()==arr[i]){
                    q.removeFirst();
                }
                i++;
                j++;
            }
        }
        return list;
    }
}
