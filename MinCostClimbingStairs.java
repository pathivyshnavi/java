public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];  // dp[i] = min cost to reach step i

        dp[0] = 0;  // starting point before step 0
        dp[1] = 0;  // can also start before step 1 with no cost

        for (int i = 2; i <= n; i++) {
            // min cost to get to step i is min cost to get to i-1 or i-2 plus cost of that step
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],  // step from i-1
                             dp[i - 2] + cost[i - 2]); // step from i-2
        }

        return dp[n];  // min cost to get beyond last step
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("Minimum cost to climb stairs: " + minCostClimbingStairs(cost));
    }
}
