package com.example.demo.likou;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/6 15:25
 */
public class Question94 {


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

    List<Integer> list = new ArrayList<>();
    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,null,new TreeNode(2,new TreeNode(3,null,null),null));
        Question94 question94 = new Question94();
        List<Integer> integers = question94.inorderTraversal(treeNode);
        System.out.println(integers);
    }
}
