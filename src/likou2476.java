import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengtianze
 * @version 1.0
 * @description: TODO
 * @date 2024/2/26 2:43 下午
 */
public class likou2476 {


     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    static public int[] getNum(TreeNode root, int num, int[] tmp) {
        if (root == null) {
            return tmp;
        }
        if (root.val == num) {
            return new int[]{num, num};
        } else if(root.val > num) {
            if (tmp[1] == -1 || root.val < tmp[1]) {
                tmp[1] = root.val;
            }
            return getNum(root.left, num, tmp);
        } else if (root.val < num) {
            if (tmp[0] == -1 || root.val > tmp[0]) {
                tmp[0] = root.val;
            }
            return getNum(root.right, num, tmp);
        }
        return tmp;
    }

    static List<Integer> target;
    // 用二叉搜索树处理
    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> lists = new ArrayList<>();
        target = new ArrayList<>();

        // 先将 root 放入到数组中，然后二分来处理
        getTarget(root);

//        for (int i : target) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println(" ");

        for(int i = 0; i < queries.size(); i++) {
            int num = queries.get(i);
            List<Integer> list = new ArrayList<>();
            int position = getPosition(num, 0, target.size() - 1);
            if (position >=0 && position <= target.size() - 1 && target.get(position) == num) {
                // System.out.println();
                list.add(target.get(position));
                list.add(target.get(position));
            } else if (position == -1 || position == 0) {
                list.add(-1);
                list.add(target.get(0));
            } else if(position == target.size() || position == target.size() - 1) {
                list.add(target.get(target.size() - 1));
                list.add(-1);
            } else {
                list.add(target.get(position - 1));
                list.add(target.get(position));
            }
            lists.add(new ArrayList<>(list));
        }


        return lists;
    }
    // 找到第一个等于/大于他的元素
    public static int getPosition(int num, int start, int end) {


        //System.out.println(num + "  " + start + " " + end);

        while (start <= end && start >= 0 && end <= target.size() -1 ) {
            int mid = (end - start) / 2 + start;
            // System.out.println(start + " " + end + "num is " + num + " " + target.get(mid));
            if (target.get(mid) == num) {
                return mid;
            } else if (num > target.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // System.out.println(num + "  " + start);
        return start;
    }

    public static  void getTarget(TreeNode root) {
        if (root == null) {
            return;
        }
        getTarget(root.left);
        target.add(root.val);
        getTarget(root.right);

        return;
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(16);
        List<List<Integer>> res = closestNodes(root, list);

        for (List<Integer> list1 : res) {
            for (Integer i : list1) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }


    }
}
