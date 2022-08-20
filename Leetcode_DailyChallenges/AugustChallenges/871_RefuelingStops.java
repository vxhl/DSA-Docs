class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // We first add all the elements into the priority queue which have
        // a distance smaller than or equal to the places we can reach
        int stationCount = 0;
        int i = 0;
        for(stationCount = 0; startFuel<target; stationCount++){
            while(i<stations.length && stations[i][0]<=startFuel){
                // Into the queue we are adding the possible
                // fuel quantities we can add into our currentFuel so as to
                // reach the station as fast as possible
                pq.offer(-stations[i++][1]);
            }
            // if there are no stations we can reach with the current
            // fuel we have we just return -1
            if(pq.isEmpty()) return -1;
            startFuel = startFuel - (pq.poll());
        }
        
        return stationCount;
        
        
    }
}