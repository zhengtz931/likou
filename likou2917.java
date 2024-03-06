import org.junit.Test;

/**
 * @author zhengtianze
 * @version 1.0
 * @description: TODO
 * @date 2024/3/6 10:14 上午
 */
public class likou2917 {
    public static void main(String[] args) {

    }

    /*
   给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。

nums 中的 K-or 是一个满足以下条件的非负整数：

只有在 nums 中，至少存在 k 个元素的第 i 位值为 1 ，那么 K-or 中的第 i 位的值才是 1 。
返回 nums 的 K-or 值。

注意 ：对于整数 x ，如果 (2i AND x) == 2i ，则 x 中的第 i 位值为 1 ，其中 AND 为按位与运算符。
     */
    public int findKOr(int[] nums, int k) {
        int res = 0;

        for (int i = 0; i < 31; i++) {
            int num = (int) Math.pow(2, i);
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & num) == num) {
                    count++;
                }
            }
            if (count >= k) {
                res += num;
            }
        }
        return  res;
    }

    @Test
    public void test() {
        System.out.println(2 & 1);
        int nums[] = new int[]{7,12,9,8,9,15};
        System.out.println(findKOr(nums, 4));;
    }
}
