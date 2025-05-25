import java.util.Arrays;

public class JumpGame {

        public static boolean canJump(int[] nums) {
            int finalPosition = nums.length -1;
            for( int i = nums.length -2 ; i>=0 ; i--){
                if( i + nums[i] >= finalPosition   )
                    finalPosition  = i;
            }
            return finalPosition == 0;

        }


        public static  boolean canJumpDP(int[] nums) {
            int [] dp = new int[nums.length+1];
            Arrays.fill(dp, -1);
            return helper(nums, 0, nums.length, dp);


        }

        public static  boolean helper(int [] nums, int i, int n, int[] dp){
            if( i == n-1 ) return true;
            if(dp[i] != -1) return dp[i] == 1;

            for (int j = 1; j < n; j++) {
                if(helper(nums, i+j, n, dp)) {
                     dp[i] = 1;
                     return  true;
                }

            }
            dp[i] = 0;
            return false;

    }

    static int jump( int [] nums){
            int jumps = 0, end =0, farthest =0;

        for (int i = 0; i < nums.length -1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if( i == end){
                jumps++;
                end = farthest;

            }

            
        }return jumps;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Minimum Jumps: " + canJump(nums)); // Output: 2
    }
}
