

/*
Key计算Hash值后随机存储，Value在每个桶中是链式存储，因此containsKey可在O(1)时间复杂度中寻找
Map中是否包含该Key值。
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(target - nums[i])) {
                hashMap.put(nums[i], i);
            } else {
                return new int[] {hashMap.get(target - nums[i]), i};
            }
        }
        return new int[] {0};
    }
}
