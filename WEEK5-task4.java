class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];

        for (int i = 0; i < nums.length; i++) {

            totalSum += nums[i];

            if (i > 0) {
                // Maximum subarray
                currentMax = Math.max(nums[i], currentMax + nums[i]);
                maxSum = Math.max(maxSum, currentMax);

                // Minimum subarray
                currentMin = Math.min(nums[i], currentMin + nums[i]);
                minSum = Math.min(minSum, currentMin);
            }
        }

        // If all numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Normal maximum vs circular maximum
        return Math.max(maxSum, totalSum - minSum);
    }
}
Output:Accepted
Runtime: 0 ms
Case 1
Case 2
Case 3
Input
nums =
[1,-2,3,-2]
Output
3
Expected
3