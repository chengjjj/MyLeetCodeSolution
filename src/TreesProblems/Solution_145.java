package TreesProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 * */
public class Solution_145 {
    /*
    * 解决方法1,采用递归的方法
    * */
    //public List<Integer> postorderTraversal(TreeNode root) {
    //    List<Integer> res = new ArrayList<>();
    //    if (root ==  null)
    //        return res;
    //    if (root.left != null) {
    //        res.addAll(postorderTraversal(root.left));
    //    }
    //    if (root.right != null) {
    //        res.addAll(postorderTraversal(root.right));
    //    }
    //    res.add(root.val);
    //    return res;
    //}

    /*
    * 解决方法2
    * 采用栈的数据结构,并且设置一个上次访问节点
    * 向左一直遍历,当遍历到为空的时候
    * 查看栈顶节点,如果右孩子为空或者是上次访问节点是右孩子
    * 则出栈,遍历该节点,并且继续递归
    * 反之,继续遍历右子树
    * */
    //public List<Integer> postorderTraversal(TreeNode root) {
    //    List<Integer> res = new ArrayList<>();
    //    if (root ==  null)
    //        return res;
    //    Stack<TreeNode> stack = new Stack<>();
    //    TreeNode lastVisit = null;
    //    while (!stack.isEmpty() || root != null) {
    //        if (root != null) {
    //            stack.push(root);
    //            root = root.left;
    //        } else {
    //            TreeNode cur = stack.peek();
    //            if (cur.right == null || lastVisit == cur.right) {
    //                lastVisit = stack.pop();
    //                res.add(lastVisit.val);
    //            } else {
    //                root = cur.right;
    //            }
    //        }
    //    }
    //    return res;
    //}

    /*
    * 利用栈,先进根节点
    * 根据后序遍历的相反结果进结果的list中
    * */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root ==  null)
            return res;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
            res.add(0, node.val);
        }
        return res;
    }


}
