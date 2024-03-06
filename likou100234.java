import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengtianze
 * @version 1.0
 * @description: TODO
 * @date 2024/3/4 9:56 上午
 */
public class likou100234 {
    /**
     * 给你一个下标从 1 开始、包含 不同 整数的数组 nums ，数组长度为 n 。
     *
     * 你需要通过 n 次操作，将 nums 中的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
     *
     * 如果 arr1 的最后一个元素 大于 arr2 的最后一个元素，就将 nums[i] 追加到 arr1 。否则，将 nums[i] 追加到 arr2 。
     * 通过连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
     *
     * 返回数组 result 。
     * @param args
     */
    public static void main(String[] args) {

    }


    public int[] resultArray(int[] nums) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();


        list1.add(nums[0]);
        list2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (list1.get(list1.size() - 1) < list2.get(list2.size() - 1)) {
                list2.add(nums[i]);
            } else {
                list1.add(nums[i]);
            }
        }


        int res[] = new int[nums.length];
        for (int i = 0; i < list1.size(); i++) {
            res[i] = list1.get(i);
        }

        for (int i = 0; i < list2.size(); i++) {
            res[i + list1.size()] = list2.get(i);
        }

        return  res;



    }
}
