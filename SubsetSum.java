public class SubsetSum {
    public static boolean isSubsetSum(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum 0 can always be achieved with empty subset
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {
                if (nums[i - 1] <= sum) {
                    // Either exclude or include the current element
                    dp[i][sum] = dp[i - 1][sum] || dp[i - 1][sum - nums[i - 1]];
                } else {
                    // Cannot include the current element as it exceeds the sum
                    dp[i][sum] = dp[i - 1][sum];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        System.out.println("Is there a subset with sum " + target + "? " + isSubsetSum(nums, target));
    }
}
