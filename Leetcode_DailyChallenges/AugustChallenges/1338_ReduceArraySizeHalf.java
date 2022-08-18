class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i: arr){
            countMap.put(i, countMap.getOrDefault(i,0)+1);
        }
        /* 
        After counting the frequencies we need to
        traverse the map such that we are traversing the largest occuring element first
        So is there any need to use a minHeap? or is there a way to sort the elements in the map based 
        on the values of the entries? 
        */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer i: countMap.keySet()){
            maxHeap.add(countMap.get(i));
        }
        int n = arr.length;
        int currLen = n;
        int ans = 0;
        while(!maxHeap.isEmpty()){
            currLen-=maxHeap.poll();
            ans++;
            if(currLen<=n/2){
                break;
            }
        }
        return ans;
    }
}