/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int ans=INT_MIN;
    int dfs(TreeNode* root) {
        if(!root) return 0;
        int left=max(dfs(root->left), 0);
        int right=max(dfs(root->right), 0);
        ans=max(ans,root->val+left+right);
        return root->val+max(left, right);
    }   
    int maxPathSum(TreeNode* root) {
        dfs(root);
        return ans;
    }
};