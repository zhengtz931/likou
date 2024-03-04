import org.junit.Test;

import java.util.*;

/**
 * @author zhengtianze
 * @version 1.0
 * @description: TODO
 * @date 2024/2/27 2:28 下午
 */
public class TreeNodeTest {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode() {};
    }




    // 初始化一棵树
    public TreeNode initTreeNode(int nums[]) {

        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode tmp = null;
            if (nums[i] != -1) {
                tmp = new TreeNode(nums[i]);
            }
            map.put(i, tmp);
        }


        for (int i = 0; i < nums.length / 2; i++) {
            TreeNode tmp = map.get(i);
            if (tmp != null) {
                if (2 * i + 1 < nums.length) {
                    tmp.left = map.get(2 * i + 1);
                }
                if (2 * i + 2 < nums.length) {
                    tmp.right = map.get(2 * i + 2);
                }
            }
        }

        return map.get(0);


    }

    // 层次遍历
    public List<List<Integer>> cengcibianli(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        List<List<Integer>> lists = new ArrayList<>();

        while (!queue.isEmpty()) {
            System.out.println("queue size is " +  queue.size());
            List<Integer> list = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }

            lists.add(new ArrayList<>(list));

            for (TreeNode tmp : nodes) {
                System.out.println(tmp.val);
                queue.add(tmp);
            }

        }

        return lists;
    }

    // 前序遍历， 直接右左 开始
    public List<Integer> preVisit(TreeNode root) {


        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return res;

    }
    // 中序遍历 先不断往下找到最左边，然后 pop add right
    public List<Integer> orderVisit(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }

        }

        return res;
    }

    // 后序遍历 前序遍历的 根左右 变为 根右左
    public List<Integer> houxuVisit(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            res.add(list.get(i));
        }

        return res;
    }

    // 遍历树的每一条路径
    public void getPath(TreeNode root) {

    }


    @Test
    public void testCengci() {
        int nums[] = new int[]{1, 2, 3, -1, 4};
        TreeNode root = new TreeNode();
        root =  initTreeNode(nums);
        List<List<Integer>> lists = cengcibianli(root);

        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println(" ");
        }
    }

    @Test
    public void testPreVisit() {
        int nums[] = new int[]{1, 2, 3, -1, 4};
        TreeNode root = new TreeNode();
        root =  initTreeNode(nums);

        List<Integer> res = preVisit(root);

        System.out.println("前序遍历为： ");
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    @Test
    public void testOrderVisit() {
        int nums[] = new int[]{1, 2, 3, -1, 4};
        TreeNode root = new TreeNode();

        root =  initTreeNode(nums);


        List<Integer> res = orderVisit(root);

        System.out.println("中序遍历为： ");
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }

    }

    @Test
    public void testHouxuVisit() {
        int nums[] = new int[]{1, 2, 3, -1, 4};
        TreeNode root = new TreeNode();

        root =  initTreeNode(nums);


        List<Integer> res = houxuVisit(root);

        System.out.println("后序遍历为： ");
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }

    }



}
