package com.example.questions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
 * 如果当前遍历到的区间的左端点 > 结果集中最后一个区间的右端点，说明它们没有交集，此时把区间添加到结果集；
 * 如果当前遍历到的区间的左端点 <= 结果集中最后一个区间的右端点，说明它们有交集，此时产生合并操作
 * 即：对结果集中最后一个区间的右端点更新（取两个区间的最大值）。
 */
public class IntervalMerging {

    public int[][] merge(int[][] ints){
        //判断是否大于两个元素
        if (ints.length < 2){
            return ints;
        }
        //java8函数式变成，起点排序，Comparator.comparingInt(o -> o[0]) 根据数组中的每个元素的第一个下标进行排序
        Arrays.sort(ints, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        //作为起点
        res.add(ints[0]);

        for(int i = 1; i < ints.length; i++){
            //拿出每个元素
            int[] curInterval  = ints[i];
            //每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
            int[] peek = res.get(res.size()-1);
            if (curInterval[0] > peek[1] && curInterval[0] < curInterval[1]){
                res.add(curInterval);
            }else {
                //比较最大值放入 最右端
                if(curInterval[0] > curInterval[1]){
                    peek[1] = Math.max(curInterval[0],peek[1]);
                }else {
                    peek[1] = Math.max(curInterval[1], peek[1]);
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        IntervalMerging  IM = new IntervalMerging();

        int [][] ints= {{6,9},{1,3},{2,4},{77,22},{16,20},{0,4},{13,67},{55,76},{99,101},{30,35}};

        int[][] newInts = IM.merge(ints);

        for(int i = 0;i<newInts.length;i++){
            System.out.println("区间为 ="+ Arrays.toString(newInts[i]));
        }

    }
    
}

