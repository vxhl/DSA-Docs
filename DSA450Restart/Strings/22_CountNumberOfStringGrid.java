package DSA450Restart.Strings;

class Solution_CountStrings
{
    /*
    1 0
    -1 0
    0 1
    0 -1

    */
    
    static int[] Xdir = {0, 0, 1, -1};
    static int[] Ydir = {1, -1, 0, 0};
    public static int countStringsGrid(char[][] grid, String s)
    {
        int count = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(s.charAt(0) == grid[i][j])
                {
                count+= search(i,j, grid, s, 0, s.length()-1, vis);
                }
            }
        }

        return count;

    }

    public static int search(int i, int j, char[][] grid, String s, int curr, int slen, boolean[][] vis)
    {
        
        int count = 0;
        if(curr == slen)
        {
            return 1;
        }
        vis[i][j] = true;
        for(int k = 0; k<4; k++)
        {
            int newi = i + Xdir[k];
            int newj = j + Ydir[k];

            if(newi>=0 && newi<grid.length && newj >= 0 && newj<grid[0].length && !vis[newi][newj] && grid[newi][newj] == s.charAt(curr+1))
            {
                count+=search(newi, newj, grid, s, curr+1, slen, vis);
            }
        }
        vis[i][j] = false;
        return count;
    }

    public static void main(String[] args) {
        String needle = "cat";
        char[][] board =  {{'c','a','t'},
                            {'a','t','c'},
                            {'c','t','a'}};

        System.out.println(countStringsGrid(board, needle));
    }
}



/*
            {D,D,D,G,D,D},
            {B,B,D,E,B,S},
            {B,S,K,E,B,K},
            {D,D,D,D,D,E},
            {D,D,D,D,D,E},
            {D,D,D,D,D,G}
*/