public class HouseRobber {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];               // max money robbing first house
        dp[1] = Math.max(nums[0], nums[1]);  // max money robbing first two houses

        for (int i = 2; i < n; i++) {
            // Either skip current house or rob it and add dp[i-2]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];  // max money robbing all houses
    }

    public static void main(String[] args) {
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println("Maximum amount that can be robbed: " + rob(houses));
    }
}
