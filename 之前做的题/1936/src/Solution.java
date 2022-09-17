class Solution {
    private int[] levels;
    private int step;
    int[] minRungs;

    public int addRungs(int[] rungs, int dist) {
        levels = rungs;
        step = dist;
        int finalRungValue = rungs[rungs.length - 1];
        minRungs = new int[finalRungValue + 1];
        for (int i = 1; i <= finalRungValue; i++) {
            minRungs[i] = isIncluded(i) ? getMinRungs(i) : getMinRungs(i) + 1;
        }
        return minRungs[finalRungValue];
    }

    private boolean isIncluded(int n) {
        for (int c : levels) {
            if (c == n) {
                return true;
            }
        }
        return false;
    }

    // 抵达第n阶时需要添加到梯子的最少接数，不考虑当前第n阶是否需要添加梯子
    private int getMinRungs(int n) {
        // 从0阶开始的dist内只需一步就能上去
        if (n <= step) {
            return 0;
        }
        // dist以后的台阶需要从前面的台阶上去
        int curMin = minRungs[n - step];
        for (int i = n - step; i < n; i++) {
            if (minRungs[i] < curMin) {
                curMin = minRungs[i];
            }
        }
        return curMin;
    }
}
