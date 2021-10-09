package Strings;

class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            this.word = null;
            this.children = new TrieNode[26];
        }
    }
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (validateInput(board, words)) return result;
        
        // Build trie
        TrieNode root = buildTrie(words);
        Set<String> set = new HashSet<>();
        // DFS and populate the result
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(root, board, i, j, set);
            }
        }
        result.addAll(set);
        return result;
    }
    
    private void dfs(TrieNode node, char[][] board, int x, int y, Set<String> set) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        char c = board[x][y];
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];
        
        // Found the match
        if (node.word != null && !set.contains(node.word)) set.add(node.word);

        // Moving forward and backtracking
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            dfs(node, board, x + dx[i], y + dy[i], set);
        }
        board[x][y] = c;
    }
    
    private TrieNode buildTrie(String[] dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) node.children[index] = new TrieNode();
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }

    private boolean validateInput(char[][] board, String[] words) {
        return board == null || board.length == 0 || board[0] == null || board[0].length == 0
           || words == null || words.length == 0;
    }   
}
