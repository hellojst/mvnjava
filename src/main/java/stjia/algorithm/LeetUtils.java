package stjia.algorithm;

public class LeetUtils {

    public static boolean canJump(int[] nums) {
        int lenth = nums.length;
        boolean[] isCanJumps = new boolean[lenth];
        isCanJumps[lenth - 1] = true;
        //从后往前计算每个点是否可以跳到最后一步，以前面所得到的boolean可最终得到第一个位置是否可以跳到最后一个位置
        for(int i = lenth - 2; i >= 0; i--) {
            if (nums[i] >= lenth - 1 - i) {
                isCanJumps[i] = true;
                continue;
            }
            boolean isCanjump = false;
            for (int j = 1; j <= nums[i]; j++) {
                if (isCanJumps[i + j]) {
                    isCanjump = true;
                    break;
                }
            }
            isCanJumps[i] = isCanjump;
        }
        return isCanJumps[0];
    }
}
