package Leetcode_DailyChallenges.AprilChalleges;
import java.util.*;
class TopKFrequent
{
    /*
        I know the approach, what I don't know is how to implement it so let's do that in the next session
    */

    public static int[] TopK(int[] arr, int k)
    {
        HashMap<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());

        for(int i=0; i<arr.length; i++)
        {
            if(!mp.containsKey(arr[i]))
            {
                mp.put(arr[i], 1);
            }
           else {  mp.put(arr[i], mp.get(arr[i])+1); }
        }
        ArrayList<Integer> res = new ArrayList<>();

        for(Map.Entry mapElement:  mp.entrySet())
        {
            pq.add(mapElement);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }

        while(!pq.isEmpty())
        {
            res.add(pq.poll().getKey());
        }

        int[] ans = new int[res.size()];

        for(int i=0; i<res.size(); i++)
        {
            ans[i] = res.get(i);
        }
        return ans;
    }



    // Bucket Sort O(N) approach


    public static int[] KFreq(int[] arr, int k)
    {
        HashMap<Integer, Integer> mp = new HashMap<>();
        // This array holds the max number of occurences that any element
        // in our given array cam have
        ArrayList [] freq = new ArrayList[arr.length+1];
        for(int i=0; i<freq.length; i++)
        {
            freq[i] = new ArrayList<>();
        }

        // Now just get the count of th elements in our HashMap
        for(int i=0; i<arr.length; i++)
        {
            if(!mp.containsKey(arr[i]))
            {
                mp.put(arr[i], 1);
            }
            else
            {
                mp.put(arr[i], mp.get(arr[i])+1);
            }
        }

        for(Map.Entry<Integer, Integer> mapElement: mp.entrySet())
        {
            freq[(int) mapElement.getValue()].add((int)mapElement.getKey());
        }

        // Now we traverse our frequency array
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        for(int i=freq.length-1; i>=0; i--)
        {
                for(int q=0; q<freq[i].size(); q++)
                {
                    if(count<k)
                    {
                    res.add((int)freq[i].get(q));
                    count++;
                }
                }
              
        }

        int[] ans = new int[res.size()];

        for(int i=0; i<res.size(); i++)
        {
            ans[i] = res.get(i);
        }

        return ans;


    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};

        for(int i=0; i<KFreq(arr, 2).length; i++)
        {
            System.out.print(KFreq(arr, 2)[i] + " ");
        }

    }

}