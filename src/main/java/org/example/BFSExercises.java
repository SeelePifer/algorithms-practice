package org.example;

import com.sun.source.tree.Tree;

import java.util.*;

public class BFSExercises {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    boolean isValid(TreeNode root, Integer max, Integer min){
        if(root == null){
            return true;
        }

        if((max != null && root.val >= max ) || (min != null && root.val <= min)){
            return false;
        }
        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
        q.add(root);
        while(!q.isEmpty()){
            int levels = q.size();
            List<Integer> subLevel = new ArrayList<>();
            for (int i = 0; i < levels; i++) {
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                subLevel.add(q.remove().val);
            }
            answer.add(subLevel);
        }
        return answer;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        Queue<TreeNode> q = new LinkedList<>();
        int size = 0;
        boolean flag = false;

        if(root == null){
            return result;
        }
        q.offer(root);

        while(!q.isEmpty()){
            size = q.size();
            list = new ArrayList<>();
            while(size-- > 0){
                root = q.poll();

                if(root.left != null){
                    q.add(root.left);
                }
                if(root.right != null){
                    q.add(root.right);
                }
                list.add(root.val);
            }
            if(flag == true){
                Collections.reverse(list);
            }
            flag =! flag;
            result.add(list);
        }
        return result;
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> response = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode right = null;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node != null){
                    right = node;
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(right != null){
                response.add(right.val);
            }
        }
        return response;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }
    private TreeNode build(int[] preorder, int[] inorder, int stop){
        int p = 0;
        int i = 0;
        if(p >= preorder.length){
            return null;
        }
        if(inorder[i] == stop){
            ++i;
            return null;
        }
        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        if(left == null){
            return right;
        }else{
            return left;
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, "");
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).substring(2));
        }
        return result;

    }
    public void dfs(TreeNode node, List<String> list, String s){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            list.add(s + "->" +node.val);
        }
        s+= "->"+node.val;
        dfs(node.left, list, s);
        dfs(node.right, list, s);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return  new ArrayList<List<Integer>>();
        }
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);
        l.add(root.val);
        result.add(new ArrayList<>(l));
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> nl = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode r = q.poll();
                if(r.left != null){
                    nl.add(r.left.val);
                    q.add(r.left);
                }
                if(r.right != null){
                    nl.add(r.right.val);
                    q.add(r.right);
                }
            }
            if(nl.size() != 0) result.add(new ArrayList<>(nl));
        }
        Collections.reverse(result);
        return result;
    }
    static int result;
    public int sumOfLeftLeaves(TreeNode root) {
        result = 0;
        task(root.left, true);
        task(root.right, false);

        return result;
    }
    static void task(TreeNode root, boolean flag){
        if(root == null) return;
        if(flag && root.left == null && root.right == null) result+= root.val;

        task(root.left, true);
        task(root.right, false);
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int visited[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = 0;
            }
        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j , visited);
                }
            }
        }
        return count;
    }
    private void dfs(char grid[][], int row, int col, int visited[][]) {

        visited[row][col] = 1; // Mark the current cell as visited

        int n = grid.length;
        int m = grid[0].length;

        int delrow[] = {-1, 0, 1, 0}; // Array to represent possible row moves (up, right, down, left)
        int delcol[] = {0, 1, 0, -1}; // Array to represent possible column moves (up, right, down, left)

        // Explore the adjacent cells (up, right, down, left) in a depth-first manner
        for (int i = 0; i < 4; i++) {

            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            // Check if the adjacent cell is within the grid boundaries, not visited, and contains '1' (part of the island)
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                // Recursively call DFS on the adjacent cell
                dfs(grid, nrow, ncol, visited);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    int area = islandArea(grid,i,j,0);
                    if(area > maxArea) maxArea = area;
                }
            }
        }
        return maxArea;
    }
    public int islandArea(int[][] grid, int row, int col, int area) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return 0;
        grid[row][col] = 0;
        return 1 + islandArea(grid, row + 1, col, area) +
                islandArea(grid, row - 1, col, area) + islandArea(grid, row, col + 1, area) +
                islandArea(grid, row, col - 1, area);
    }
    public int islandPerimeter(int[][] grid) {
        int output = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    output += 4;

                    if ( j-1 >= 0  && grid[i][j-1] == 1)  output -= 1;

                    if ( j+1 != grid[i].length && grid[i][j+1] == 1)  output -=1;

                    if (i-1 >= 0 && grid[i-1][j] == 1)   output -= 1;

                    if (i+1 != grid.length && grid[i+1][j] == 1) output -=1;
                }
            }
        }
        return output;
    }
    int row;
    int col;

    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;

        for(int r =0; r<row; r++)
        {
            if(board[r][0] == 'O')
            {
                dfs(r,0,board);
            }
            if(board[r][col-1] == 'O')
            {
                dfs(r,col-1,board);
            }
        }
        for(int c =0; c<col; c++)
        {
            if(board[0][c] == 'O')
            {
                dfs(0,c,board);
            }
            if(board[row-1][c] == 'O')
            {
                dfs(row-1,c,board);
            }
        }

        for(int i =0; i< row;i++)
        {
            for(int j =0; j<col; j++)
            {
                if(board[i][j] == 'O') board[i][j] = 'X';

                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }

    }
    public void dfs(int r, int c, char[][] board){

        if(r<0 || r >=row || c <0 || c>=col || board[r][c] != 'O') return;

        board[r][c] = '#';

        dfs(r+1,c,board);
        dfs(r-1,c,board);
        dfs(r,c+1,board);
        dfs(r,c-1,board);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null || q == null ) return false;
        else if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        return createBST(nums, start, end);
    }

    public TreeNode createBST(int arr[], int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return targetSum == root.val;
        }
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }

    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        transverse(root);
        return res;
    }
    public void transverse(TreeNode root){
        if(root == null){
            return;
        }
        transverse(root.left);
        res.add(root.val);
        transverse(root.right);
    }

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    int maxDepth(TreeNode root){
        if(root == null) return 0;

        int left = maxDepth(root.left);
        if(left == -1) return -1;
        int right = maxDepth(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        ans.add(1);
        if(rowIndex == 0) return ans;

        long temp = 1;
        for (int i = 1; i < rowIndex; i++) {
            temp = (temp * (rowIndex- (i-1))) /i;
            ans.add((int) temp);
        }
        ans.add(1);
        return ans;
    }

    public int singleNumber(int[] nums) {
        int start = 0;
        int end = nums.length;

        for (int i = 0; i < end; i++) {
            start = start ^ nums[i];
        }
        return end;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    public void preorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    public void postorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }


    public static int height(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);

        if(root.left == null && root.right == null){
            return Math.max(leftDepth, rightDepth);
        }


        return Math.max(leftDepth, rightDepth) + 1;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderTransversal(root, result);
        return result;
    }
    private void postOrderTransversal(Node node, List<Integer> result){
        if(node == null){
            return;
        }
        if (node.children != null) {
            for (Node child : node.children) {
                postOrderTransversal(child, result);
            }
        }

        // Add the current node's value to the result list
        result.add(node.val);
    }

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> uniqueValues = new HashSet<>();

        int min = root.val;
        int secondMin = Integer.MAX_VALUE;

        dfs(root, uniqueValues);

        for (int number: uniqueValues){
            if(number > min && number < secondMin){
                secondMin = number;
            }
        }
        return secondMin == Integer.MAX_VALUE ? -1 : secondMin;

    }
    private void dfs(TreeNode node, Set<Integer> uniqueValues){
        if(node == null){
            return;
        }
        uniqueValues.add(node.val);

        dfs(node.left, uniqueValues);
        dfs(node.right, uniqueValues);
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }

        if(root.val < low){
            return trimBST(root.right, low, high);
        }else if (root.val > high){
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> response = new ArrayList<>();
        largestValueDFS(root, response, 0);
        return response;
    }
    private void largestValueDFS(TreeNode node, List<Integer> result, int level){
        if(node == null){
            return;
        }

        if(level >= result.size()){
            result.add(node.val);
        }else{
            result.set(level, Math.max(result.get(level), node.val ));
        }
        largestValueDFS(node.left, result, level + 1);
        largestValueDFS(node.right, result, level + 1);
    }

    public static void main(String[] args) {
        System.out.println(rightSideView(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }
}

