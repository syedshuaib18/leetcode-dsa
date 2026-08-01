class Solution {

    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1, 0, 0, true);
    }

    private boolean solve(int[] nums, int left, int right, int p1, int p2, boolean turn) {

        // No elements left
        if (left > right) {
            return p1 >= p2;
        }

        if (turn) {
            // Player 1's turn
            return solve(nums, left + 1, right, p1 + nums[left], p2, false)
                    || solve(nums, left, right - 1, p1 + nums[right], p2, false);
        } else {
            // Player 2's turn
            return solve(nums, left + 1, right, p1, p2 + nums[left], true)
                    && solve(nums, left, right - 1, p1, p2 + nums[right], true);
        }
    }
}