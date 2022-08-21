class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> mp = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<cards.length; i++){
            if(mp.containsKey(cards[i])){
                min = Math.min(min, i-mp.get(cards[i])+1);
            }
            mp.put(cards[i],i);
        }
       return min==Integer.MAX_VALUE?-1:min;
    }
}
        
        /* Was initially using sliding windows, and while it might work if I work things around a little more, it is still
        not very optimal now is it. Let's do the same with a hashmap but this time with indices, since we need only one pair anyway, we
        don't need to keep track of the occurences for anything here, just the visited property
        // int i=0; 
        // int j=0;
        // int min = Integer.MAX_VALUE;
        // while(j<cards.length){
        //     // Since the size of window atleast needs to be 2 to have 2 consecutive elements
        //     if(j-i+1>2){
        //         HashMap<Integer, Integer> mp = new HashMap<>();
        //         for(int k=i; k<=j; k++){
        //             System.out.print(mp);
        //             // If at any point we find an occurence
        //             if(mp.containsKey(cards[k])){
        //                 min = Math.min(min, j-i+1);
        //                 i++;
        //             }else{
        //             mp.put(cards[k], 1);
        //             }
        //         }
        //         i++;
        //         j++;
            // }
        //     j++;
        // }
        // return min==Integer.MAX_VALUE?-1:min;
        */
