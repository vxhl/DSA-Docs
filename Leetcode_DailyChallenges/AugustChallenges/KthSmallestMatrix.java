class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int R=matrix.length;
        int C=matrix[0].length;
        
        int left=matrix[0][0];
        int right=matrix[R-1][C-1];
        
        int ans=-1;
        while(left<=right){
            int mid = (left+right)/2;
            
            if(countLessEqualsK(mid, matrix)>=k){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    
    private int countLessEqualsK(int mid, int[][] matrix){
        int count=0;
        int c=matrix[0].length-1;
        for(int row=0; row<matrix.length; row++){
            
            while(c>=0 && matrix[row][c]>mid){    
                c--; 
            }
            count+=c+1;
        }
        return count;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        // minHeap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int R = matrix.length;
        int C = matrix[0].length;
        
        for(int r=0; r<R; r++){
            pq.add(new int[]{matrix[r][0],r,0});
        }
        int ans = -1;
        for(int i=0; i<k; i++){
            int[] top = pq.poll();
            int r = top[1];
            int c = top[2];
            ans = top[0];
            if(c+1<C){
                pq.add(new int[]{matrix[r][c+1], r, c+1});
            }
        }
        
        return ans;
    }
}