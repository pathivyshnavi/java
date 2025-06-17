public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;  // The farthest index we can reach so far
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                // If current position is beyond the farthest reachable, can't move forward
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= n - 1) {
                return true;  // We can reach or go beyond last index
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Can jump to the end: " + canJump(nums));
    }
}
