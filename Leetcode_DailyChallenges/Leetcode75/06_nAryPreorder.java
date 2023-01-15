class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;

    }
    void helper(Node root, List<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        for(int i=0; i<root.children.size(); i++){
            helper(root.children.get(i), ans);
        }
    }
}