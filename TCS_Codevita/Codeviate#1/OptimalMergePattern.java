import java.util.*;

public class OptimalMergePattern {
    // OK this is very similar to the Merge K sorted lists isn't it
    // yeah it is, extremly similar, actually this is the easy version
    public int minCostMerge(int[] arr){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: arr){
            minHeap.add(i);
        }

        int comps = 0;

        while(minHeap.size()>1){
            int weight = minHeap.poll() + minHeap.poll();
            comps+=weight;
            minHeap.offer(weight);
        }

        return comps;
    }

    public static void main(String[] args) {
        int[] arr = {5,10,20,30,30};
        OptimalMergePattern obj1 = new OptimalMergePattern();
        System.out.println("The most optimal merge cost: "+ obj1.minCostMerge(arr));
    }

}
