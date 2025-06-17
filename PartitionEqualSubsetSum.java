public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // If total sum is odd, can't partition into two equal subsets
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill dp table
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {
                if (nums[i - 1] <= sum) {
                    dp[i][sum] = dp[i - 1][sum] || dp[i - 1][sum - nums[i - 1]];
                } else {
                    dp[i][sum] = dp[i - 1][sum];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can partition into equal subset sum? " + canPartition(nums));
    }
}
