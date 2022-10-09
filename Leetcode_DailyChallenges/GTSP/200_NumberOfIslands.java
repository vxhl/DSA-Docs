class NumberOfIslands {
     
    /*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
    Example 1:
    Input: grid = [["1","1","1","1","0"],
                   ["1","1","0","1","0"],
                   ["1","1","0","0","0"],
                   ["0","0","0","0","0"]]
    Output: 1 
     */

    // BFS Approach.
    public int numIslands(char[][] grid) {
        // we can move in 4 directions
        int[] xDir = {1,0,-1,0};
        int[] yDir = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        int islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                // We can only make an island when our coordinate is '1' so this is when we start our BFS
                if(grid[i][j]=='1'){
                    // We increment our islands
                    islands++;
                    q.offer(new int[]{i,j});
                    // We set the current one as 'X' so we mark a trail of visited islands on the map.
                    grid[i][j]='X';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();    
                        int x = curr[0];
                        int y = curr[1];
                        for(int k=0; k<4; k++){
                            int newx = x+xDir[k];
                            int newy = y+yDir[k];
                            if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length && grid[newx][newy]=='1'){
                                q.offer(new int[]{newx,newy});
                                grid[newx][newy]='X';
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
    
    // DFS Approach
    public int numIslands2(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid, int i, int j, int n, int m){
        if(i>=0 && j>=0 && i<n && j<m && grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i+1, j, n,m);
            dfs(grid, i-1, j,n,m);
            dfs(grid, i, j-1,n,m);
            dfs(grid, i, j+1,n,m);
        }
    }

    // Union Find Approach

}
