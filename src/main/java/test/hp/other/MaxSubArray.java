package test.hp.other;

import java.util.Arrays;

/**
 * 找和最大的子数组
 */
public class MaxSubArray {

    public static int[] getMaxSubArray(int[] nums){
        int max = nums[0];
        int indexEnd = 0;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            res[i] = Math.max(res[i-1] + nums[i], nums[i]);
            if(res[i] > max){
                max = res[i];
                indexEnd = i;
            }
        }
        System.out.println(Arrays.toString(res));
        System.out.println(indexEnd);
        int indexStart = 0;
        for(int i=indexEnd; i >= 0; i--){
            if(res[i] < 0){
                indexStart = i+1;
                break;
            }
        }
        System.out.println(indexStart);
        int[] result = new int[indexEnd - indexStart + 1];
        for(int i = 0; i < (indexEnd - indexStart + 1); i ++){
            result[i] = nums[indexStart + i];
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,-4,-1,2,1,-5,4};
        System.out.println(Arrays.toString(getMaxSubArray(nums)));
    }
}
