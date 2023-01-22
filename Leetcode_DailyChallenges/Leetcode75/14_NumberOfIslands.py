class Solution:

    def numIslands(self, grid: List[List[str]]) -> int:
        islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    islands+=1
                    self.dfs(grid, i, j, len(grid), len(grid[0]))
        return islands

    
    def dfs(self, grid: List[List[str]], i, j, n, m):
        if(i>=0 and j>=0 and i<n and j<m and grid[i][j]=='1'):
            grid[i][j] = "0"
            self.dfs(grid, i-1, j, n, m)
            self.dfs(grid, i+1, j, n, m)
            self.dfs(grid, i, j-1, n, m)
            self.dfs(grid, i, j+1, n, m)