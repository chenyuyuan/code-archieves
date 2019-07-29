package spto;

import spto.datastructure.TreeNode;

public class question07 {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    public static BinaryTreeNode construct(int[] preorder, int[] inorder, int length) {
        if(preorder == null || inorder == null || length <= 0 || preorder.length != inorder.length){
            return null;
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private static BinaryTreeNode construct(int[] preorder, int sp, int ep,int[] inorder, int si, int ei) {
        if(sp >= ep || si >= ei) {
            return null;
        }
        int value = preorder[sp];
        int index = si;
        while (index <= ei && inorder[index] != value) {
            index++;
        }
        if (index > ei) {
            throw new RuntimeException("Invalid input");
        }
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;
        // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
        node.left = construct(preorder, sp + 1, sp + index - si, inorder, si, index - 1);
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
        node.right = construct(preorder, sp + index - si + 1, ep, inorder, index + 1, ei);

        // 返回创建的根结点
        return node;
    }
}
