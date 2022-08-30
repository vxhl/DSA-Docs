// N = 6673, K = 6
class InsertK{

    public int insertK(int N, int K){
        String s = Integer.toString(N);
        String k = Integer.toString(K);
        // So now we position k at different places in S to determine whether the string is maximum
        
        
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(i=0; i<s.length(); i++){
            if(s.charAt(i)>k.charAt(0)){
                sb.append(s.charAt(i));
            }else{
                sb.append(k.charAt(0));
                break;
            }

        }
        while(i<s.length()){
            sb.append(s.charAt(i));
            i++;
        }
        return Integer.parseInt(sb.toString());

    }

    public static void main(String[] args) {
        int n = 76521;
        int k = 3;
        InsertK obj1 = new InsertK();
        System.out.println(obj1.insertK(n, k));
    }
    /*
         * 
         * 1 2 3 4 5 and insert 6 then
         * -> 6 1 2 3 4 5
         * 7 6 5 4 3 and insert 1 then
         * -> 7 6 5 4 3 1 would be the optimal answer
         * So let's say we traverse the string as long as we find elements larger,
         * we append into the StringBuilder, as soon as we find smaller elements before appending we
         * push the K into the stringbuilder
         * 7 6 5 2 1 and inserting 3
         * 7 
         * 7 6
         * 7 6 5
         * 7 6 5 |3| 2 1
         */

}