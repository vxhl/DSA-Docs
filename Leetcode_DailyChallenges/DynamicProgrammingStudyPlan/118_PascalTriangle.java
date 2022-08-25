class Solution {
    public List<List<Integer>> generate(int numRows) {
        /*
        Hated this one the last time I did it
        
        */
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        List<Integer> second = new LinkedList<>();
        first.add(1);
        ans.add(first); // {1}
        if(numRows==1){
            return ans;
        }
        second.add(1);
        second.add(1);
        ans.add(second); // {1,1}
        for(int i=3; i<=numRows; i++){
            List<Integer> ds = new LinkedList<>();
            ds.add(1);
            int j = i-2;
            for(int k=0; k<ans.get(ans.size()-1).size()-1; k++){
                ds.add(ans.get(ans.size()-1).get(k)+ans.get(ans.size()-1).get(k+1));
            }
            ds.add(1);
            ans.add(ds);
        }
        
        return ans;
    }
}