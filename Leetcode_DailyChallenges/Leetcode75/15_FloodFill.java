class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int[] xdir = {0,0,1,-1};
        int[] ydir = {1,-1,0,0};
        int x = image[sr][sc];
        if(image[sr][sc]==color) return image;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            image[curr[0]][curr[1]] = color;
            for(int i=0; i<4; i++){
                int newx = curr[0]+xdir[i];
                int newy = curr[1]+ydir[i];
                if(newx>=0 && newx<image.length && newy>=0 && newy<image[0].length && image[newx][newy] == x){
                    image[newx][newy] = color;
                    q.add(new int[]{newx, newy});
                }
            }
        }
        return image;
    }
}