package com.example.questions;

/**
 * 一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GracefuArray {
    public static void main(String[] args) {
        int nums[] = {1,3,2,5,2,2,2,6,3,2,1,2,2,2,1,2,8};
//        int nums[] = {1,0,1,1,0,0};
        int k = 5;
        GracefuArray gracefuArray = new GracefuArray();
        int GA= gracefuArray.numberOfSubarrays(nums,k);
        System.out.println("有" + GA + "组");
    }

    private int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int arr[] = new int[len + 2];//+2是为了设置左右边界
        int res = 0;
        int feed = 0;//奇数个数
        //遍历数组 记录奇数位于nums数组中的下标位置
        for (int i = 0;i < len;i++){
            //判断是否为奇数
            if(isOdd(nums[i])){
                arr[++feed] = i;
            }
        }
        //左边边界
        arr[0] = -1;
        //右边边界
        arr[feed + 1] = len;
//        当奇数个数大于循环中未被使用奇数个数时执行
        for(int i = 1; i + k < feed + 2; i ++) {
//          对于每种子情形，其可能数为：
//            (arr[i]−arr[i−1])∗(arr[i+k]−arr[i+k−1])
//            例如{1,0,1,1,0,0}中
//            存入arr数组中的值为
//            {-1,0,2,3,6,0,0,0}
//            其中向左边界延伸的可能有(arr[1]−arr[0])∗(arr[3]−arr[2])
//            (0-(-1))*(3-2) = 1
//            向右边界延伸的可能有(arr[2]−arr[1])∗(arr[5]−arr[4])；
//            (2-0)*(6-3) = 6
//            1*6=6 有6种可能 综合以上得公式
//            (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
//            其中K为数组中所需包含的奇数个数
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }


    private boolean isOdd(int num) {
        return (num&1) == 1 ;
    }
}
