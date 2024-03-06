import java.util.Map;

/**
 * @author zhengtianze
 * @version 1.0
 * @description: TODO
 * @date 2024/3/4 10:09 上午
 */
public class likou3071 {
    /*
    给你一个下标从 0 开始、大小为 n x n 的矩阵 grid ，其中 n 为奇数，且 grid[r][c] 的值为 0 、1 或 2 。

    如果一个单元格属于以下三条线中的任一一条，我们就认为它是字母 Y 的一部分：

    从左上角单元格开始到矩阵中心单元格结束的对角线。
    从右上角单元格开始到矩阵中心单元格结束的对角线。
    从中心单元格开始到矩阵底部边界结束的垂直线。
    当且仅当满足以下全部条件时，可以判定矩阵上写有字母 Y ：

    属于 Y 的所有单元格的值相等。
    不属于 Y 的所有单元格的值相等。
    属于 Y 的单元格的值与不属于Y的单元格的值不同。
    每次操作你可以将任意单元格的值改变为 0 、1 或 2 。返回在矩阵上写出字母 Y 所需的 最少 操作次数。
     */
    public static int minimumOperationsToWriteY(int[][] grid) {

        // 先统计组成 y 的数据，
        int mid = grid.length / 2;
        int num1[] = new int[3];
        int num2[] = new int[3];


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if ((i == j && i <= grid.length / 2) || (i == grid.length - j - 1  && j > grid.length / 2) || (j == grid.length / 2 && i > grid.length / 2)) {
                    System.out.println(i + " " + j + " " + grid[i][j] );
                    num1[grid[i][j]]++;
                } else {
                    num2[grid[i][j]]++;
                }
            }
        }

        for (int i = 0; i < num1.length; i++) {
            System.out.print(num1[i] + " ");
        }
        System.out.println(" ");

        for (int i = 0; i < num2.length; i++) {
            System.out.print(num2[i] + " ");
        }
        System.out.println(" ");

        int sum1 = grid.length / 2 * 3 + 1;
        int sum2 = grid.length * grid.length - sum1;


        num1[0] = sum1 - num1[0];
        num1[1] = sum1 - num1[1];
        num1[2] = sum1 - num1[2];

        num2[0] = sum2 - num2[0];
        num2[1] = sum2 - num2[1];
        num2[2] = sum2 - num2[2];

        int res1 = Math.min(num1[0] + num2[1], num1[0] + num2[2]);
        int res2 = Math.min(num1[1] + num2[0], num1[1] + num2[2]);
        int res3 = Math.min(num1[2] + num2[0], num1[2] + num2[1]);
        System.out.println(res1 + " " + res2 + " " + res3);

        return Math.min(res3, Math.min(res1, res2));



    }

    public static void main(String[] args) {
        int grid[][] = new int[][]{{1,2,2},{1,1,0},{0,1,0}};
        minimumOperationsToWriteY(grid);
    }
}
