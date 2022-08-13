class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int windowSize = (words[0].length())*words.length;
        int left = 0;
        int right = 0;
        Map<String,Integer> mainMap = new HashMap<>();
        for(String s1: words){
            mainMap.put(s1,mainMap.getOrDefault(s1,0)+1);
        }
        while(right<s.length()){
            if(right-left+1==windowSize){
                int wordSize = words[0].length();
                int left1 = left;
                int right1 = left;
                Map<String, Integer> subMap = new HashMap<>();
                while(right1<=right){
                    if(right1-left1+1 == wordSize){
                        if(!mainMap.containsKey(s.substring(left1,right1+1))){break; }
                        subMap.put(s.substring(left1, right1+1),subMap.getOrDefault(s.substring(left1, right1+1),0)+1);
                        left1=right1+1;
                        right1=right1+wordSize;
                    }else{
                        right1++;
                    }
                }
                if(subMap.equals(mainMap)){
                    ans.add(left);   
                }
                left++;
                right++;
            }else{
                right++;
                
            }
        }
        return ans;
    }
}


/*
"wordgoodgoodgoodbestword"
*/