package com.example.demo.likou.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/7/27 17:20
 */
public class Question7 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    Map<Integer,Integer> map = new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int length = preorder.length;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return generateTreeNode(preorder,inorder,0,length-1,0,length-1);
    }

    private TreeNode generateTreeNode(int[] preorder, int[] inorder,
        int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft > preRight){
            return null;
        }
        // 返回中心节点
        int preRoot = preLeft;
        int inRoot = map.get(preorder[preRoot]);
        // 获取左子树的节点数
        int leftSize = inRoot - inLeft;
        // 构建
        TreeNode treeNode = new TreeNode(preorder[preRoot]);
        // 递归查询
        treeNode.left = generateTreeNode(preorder,inorder,preLeft+1,preLeft+leftSize,inLeft,inRoot-1);
        treeNode.right = generateTreeNode(preorder,inorder, preLeft + leftSize + 1,preRight,inRoot+1,inRight);
        return treeNode;
    }

    public static void main(String[] args) {
        Question7 question7 = new Question7();
        int[] preorder = {3,9,20,15,7};
         int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = question7.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }


}
