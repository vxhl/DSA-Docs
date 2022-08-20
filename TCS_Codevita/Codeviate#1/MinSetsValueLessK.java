class UniqueSets{
    // Very greedy
    public int countUniqueSets(String s, int k){
        // We need a boolean visited array to mark the already used elements
        boolean[] vis = new boolean[s.length()];
        int count = 0;
        for(int i=0; i<s.length(); i++){
            
            // If not already used the number
            if(!vis[i]){
                // We first mark it as visited
                StringBuilder sb = new StringBuilder();
                vis[i] = true;
                int j=i+1;
                // We append the current number into the string
                if(!vis[i]) sb.append(s.charAt(i));
                // As long as we don't reach the end
                while(j<s.length()){
                    // If on appending we find the number to still be lesser than or equal
                    // to k, then we add it and mark it as visited      
                    if(!vis[j] && Integer.parseInt(sb.append(s.charAt(j)).toString())<=k ){
                        vis[j] = true;
                        System.out.print(sb.toString()+ " ");
                    }else{
                        // As soon as we find the number exceed we increment the count of sets we have and break for the
                        // current loop
                        count++;
                        // And set i as the current index where we broke at
                        // vis[j] = false;
                        i = j;
                        break;
                    }
                j++;
            }
            }
        }
        return count;
    }


    // better greedy
    // Instead of the visited array we use a boolean flag to mark the traversed stuff
    // The previous approach would work but takes space and polynomial time
    public int countUniqueSets2(String s, int k){
        int curr = 0;
        boolean flag = false;
        int uniqueSets = 0;

        for(int i=0; i<s.length(); i++){
            // Ok so we get the number till the current index since consecutive allowed
            curr = curr*10 + (s.charAt(i)-'0');
            // If the current number is still lesser than k, we just keep iterating and mark flag as true
            if(curr<=k){
                flag = true;
            }
            // If we find the current number to be greater than k, then
            else{
                // If at any point our flag was true before this number we increment our count of unique sets
                if(flag)uniqueSets++;
                // Then we set the curr back to the current index we are at and set flag to false
                // If the current index we are at number is smaller than or equal to k then we again mark the flag
                // as true, otherwise we set the current back to 0 for the next index we will be iterating from.
                flag = false;
                curr = s.charAt(i)-'0'; // s[i]-'0'
                if(curr<=k){
                    flag = true;
                }else{
                    curr=0; 
                }
                
            }
        }
        // finally if we run out of the loop and the answer was true for the latest index then increment
        // unique sets by 1 again.
        if(flag) uniqueSets++;
        return uniqueSets;
    }   

    public static void main(String[] args) {
        UniqueSets obj1 = new UniqueSets();
        String s = "30";
        int k = 4;
        System.out.println(obj1.countUniqueSets2(s, k)+ " ");
    }
}