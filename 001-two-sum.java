class Solution {
    private int[] nums;
    private int target;
    private Map<Integer, Integer> seen;
    
    public int[] twoSum(int[] nums, int target) {
        initialize(nums, target);
        
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int thisNumber = nums[currentIndex];
            if (weHaveSeen(complementOf(thisNumber))) {
                return new int[] {indexOf(complementOf(thisNumber)), currentIndex};
            }
            markSeenAtIndex(thisNumber, currentIndex);
        }
        return null;
    }
    
    private void initialize(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        seen = new HashMap<>();
    }
    
    private void markSeenAtIndex(int n, int index) {
        seen.put(n, index);
    }
    
    private boolean weHaveSeen(int n) {
        return seen.containsKey(n);
    }
    
    private int indexOf(int c) {
        return seen.get(c);
    }
    
    private int complementOf(int n) {
        return target - n;
    }
}
