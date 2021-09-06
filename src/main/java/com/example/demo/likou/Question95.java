package com.example.demo.likou;

import com.example.demo.likou.Question94.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/5/6 16:16
 */
public class Question95 {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 每个节点都会成为根节点，左子节点 < 父节点 < 右子节点
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return generateTreeNode(1,n);
    }

    private List<TreeNode> generateTreeNode(int start,int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i =start;i<= end;i++){
            List<TreeNode> left = generateTreeNode(start,i -1);
            List<TreeNode> right = generateTreeNode(i +1,end);
            // 从可行左子树集合中选一棵，再从可行右子树集合中选一棵拼接到根节点上
            for(TreeNode leftNode : left){
                for(TreeNode rightNode : right){
                    TreeNode treeNode = new TreeNode(i,leftNode,rightNode);
                    list.add(treeNode);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Question95 question95 = new Question95();
        List<TreeNode> treeNodes = question95.generateTrees(3);
        System.out.println(treeNodes);
    }
}
