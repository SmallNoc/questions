package com.example.questions;

import java.util.Arrays;

public class CanJump {
    int[] ints = {3,4,5,0,7,2};

    public CanJump(int[] ints) {
        System.out.println(IsCanJump(ints));
        System.out.println(IsCanJump2(ints));
    }


    /**
     *
     * {2, 3, 1, 1, 4}
     * 我们一开始在位置 0，可以跳跃的最大长度为 2，因此最远可以到达的位置被更新为 2；
     * 我们遍历到位置1，由于 1≤2，因此位置 1 可达。我们用 1 加上它可以跳跃的最大长度 3，
     * 将最远可以到达的位置更新为 4。由于 4大于等于最后一个位置 4，因此我们直接返回 True。
     */
    boolean IsCanJump(int[] ints){
        int len = ints.length;
        int x = 0;//x为最远可跳距离
        for (int i = 0 ; i < len; i++) {
            if (i <= x){//当最远可跳距离大于下标位置时不进判断
                x = Math.max(x,i+ints[i]);
                if(x >= len -1){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
     * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
     * 如果可以一直跳到最后，就成功了
     * @param ints
     * @return
     */
    boolean IsCanJump2(int[] ints){
        int x = 0;
        for (int i = 0 ; i < ints.length;i++){
            if (i > x){//i为下标，x为所能到的最远下标
                return false;
            }else {
                x = Math.max(x,i+ints[i]);
                if(x > ints.length-1) return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] ints = {1, 3, 4, 0, 0, 7, 9};
//        int[] ints = {2, 3, 1, 1, 4};
//        int[] ints = {1, 2, 1, 0, 4};
        int[] ints = {4, 3, 2, 0, 1, 5};
        CanJump canJump = new CanJump(ints);

    }

}
