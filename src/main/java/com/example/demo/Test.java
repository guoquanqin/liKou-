package com.example.demo;

import com.example.demo.likou.Question95;
import com.example.demo.likou.Question95.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/24 16:38
 */
public class Test {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;

    }

    public static List<Integer> outorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        // 标记位
        TreeNode lastVisit = null;
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            if(!stk.isEmpty()){
                // 出栈
                root = stk.pop();
                /***
                 * 这块就是判断treeNode是否有右孩子，
                 * 如果没有输出treeNode.data, 让lastVisit指向treeNode, 并让treeNode为空
                 * 如果有右孩子, 将当前节点继续入栈，treeNode指向它的有孩子，继续重复循环
                 */
                // 这里其实是访问到根节点后有两条路径，一个是当没有右孩子或者右孩子被访问过后，
                // 打印根节点，另一个是右孩子没有被访问过，则把该根节点继续压入栈，访问右孩子。
                if(root.right == null || root.right == lastVisit){
                    lastVisit = root;
                    root = null;
                }
                else{
                    stk.push(root);
                    root = root.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {Integer i3 = Integer.valueOf(102); Integer i4 = 102;

        TreeNode treeNode2 = new TreeNode(2,null,null);
        TreeNode treeNode3 = new TreeNode(3,null,null);
        TreeNode treeNode4 = new TreeNode(4,null,null);
        TreeNode treeNode1 = new TreeNode(1,treeNode2,treeNode3);
        TreeNode treeNode = new TreeNode(0,treeNode1,treeNode4);
        System.out.println(outorderTraversal(treeNode));
    }

}
