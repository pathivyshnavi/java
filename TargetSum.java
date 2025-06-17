public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        // If target + sum is odd or target is out of range, no solutions
        if (target > sum || (target + sum) % 2 != 0) return 0;

        int subsetSum = (target + sum) / 2;
        return countSubsets(nums, subsetSum);
    }

    private static int countSubsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Base case: There's 1 way to get sum=0 (empty subset)
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int s = 0; s <= sum; s++) {
                if (nums[i - 1] <= s) {
                    dp[i][s] = dp[i - 1][s] + dp[i - 1][s - nums[i - 1]];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println("Number of ways to reach target sum: " + findTargetSumWays(nums, target));
    }
}
