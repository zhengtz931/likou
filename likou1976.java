import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhengtianze
 * @version 1.0
 * @description: TODO
 * @date 2024/3/5 10:05 上午
 */
public class likou1976 {
    public static void main(String[] args) {

    }
    /*
    你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两个路口之间最多有一条路。

给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费 timei 时间才能通过的道路。你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。

请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 109 + 7 取余 后返回。
     */

    // 先用 dijietesila 算出最短的路径
    public int countPaths(int n, int[][] roads) {


        return 0;

    }

    public int getMinDis1(int n, int roads[][]) {


        return 0;

    }


    // 到目的地的最小的距离
    public int getMinDis(int n, int [][] roads) {
//        List<int[]>[] list = new List[n];
//
//        Arrays.fill(list, new ArrayList<>());
//
//        for (int i = 0; i < roads.length; i++) {
//            list[roads[i][0]].add(new int[]{roads[i][1], roads[i][2]});
//            list[roads[i][0]].add(new int[]{roads[i][1], roads[i][2]});
//        }

        int grid[][] = new int[n][n];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }


        for (int i = 0; i < roads.length; i++) {
            for (int j = 0; j < roads[0].length; j++) {
                grid[roads[i][0]][roads[i][1]] = roads[i][2];
                grid[roads[i][1]][roads[i][0]] = roads[i][2];
            }
        }


        // Floyd 算法
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != Integer.MAX_VALUE) {
                    for (int k = 0; k < grid[0].length; k++) {
                        if (grid[j][k] != Integer.MAX_VALUE && grid[j][k] + grid[i][j] < grid[i][k]) {
                            grid[i][k] = grid[j][k] + grid[i][j];
                        }

                    }
                }
            }
        }

        // 第一中，暴力优化， 先找到距离最小的结点，然后拓展距离最小的

        List<int[]>[] edges = new List[n];
        Arrays.fill(edges, new ArrayList<>());

        for (int i = 0; i < roads.length; i++) {
            System.out.println(roads[i][0] +  "edges is " + roads[i][1] + " " + roads[i][2] );
            edges[roads[i][0]].add(new int[]{roads[i][1], roads[i][2]});
            edges[roads[i][1]].add(new int[]{roads[i][0], roads[i][2]});

        }

        // 暴力版本迪杰特斯拉 n 方时间复杂度
        boolean isVisit[] = new boolean[grid.length];
        int dis[] = new int[grid.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int count[] = new int[n];
        dis[0] = 0;
        for (int i = 0; i < n; i++) {
            int u = -1, mind = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                // dis 0 本身为 0
                if (!isVisit[j] && (u == -1 || dis[j] < mind)) {
                    u = j;
                    mind = dis[j];
                    System.out.println(j + " " + mind);
                }
            }

            isVisit[u] = true;

            for (int[] nums : edges[u]) {
                /*
                此处输出异常
                0 0
                input 6 7
                0 6 7
                input 0 7
                0 0 0
                input 1 2
                0 1 2
                 */
                System.out.println("input " + nums[0] + " " + nums[1]);
                if (dis[nums[0]] == nums[1] + dis[u]) {
                    count[nums[0]] = count[u] + 1;
                }
                if (dis[nums[0]] > nums[1] + dis[u]) {
                    dis[nums[0]] = nums[1] + dis[u];
                }
                System.out.println( u + " " + nums[0] + " " + dis[nums[0]]);
            }
        }

        for (int tmp : count) {
            System.out.print(tmp + "");
        }
        System.out.println(" ");

        System.out.println(dis[n - 1]);

        System.out.println("min dis count is " + count[n - 1]);

        return grid[0][n - 1];

    }


    @Test
    public void test() {
        int roads[][] = new int[][]{ {0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
         System.out.println(getMinDis(7, roads));
    }
}
