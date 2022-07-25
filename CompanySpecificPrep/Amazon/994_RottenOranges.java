class Solution {
    public int orangesRotting(int[][] grid) {
        
        int[] xdir = {0,0,1,-1};
        int[] ydir = {1,-1,0,0};
        Deque<int[]> q = new LinkedList<>();
        
        // Total oranges we need to rot
        int oranges = 0;
        int n = grid.length;
        int m = grid[0].length;
        int rottenOranges = 0;
        int mins = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != 0){
                    oranges++;
                }
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            rottenOranges += size;
            while(size-->0){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                
                for(int i=0; i<4; i++){
                    // We get the current direction
                    int newx = x + xdir[i];
                    int newy = y + ydir[i];

                    // Then we check for the boundary conditions and if the current orange in that direction is rotten
                    // if it is, then we simply, add it into the queue and rot the current orange we are traversing from
                    if(newx>=0 && newx<n && newy>=0 && newy<m && grid[newx][newy] == 1){
                        grid[newx][newy] = 2;
                        q.add(new int[]{newx, newy});
                    }
                }
                
            }
            if(q.size()!=0) { mins++;};
        }
        return rottenOranges == oranges? mins: -1;
    }
}