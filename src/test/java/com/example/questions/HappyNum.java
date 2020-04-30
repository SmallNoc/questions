package com.example.questions;

import java.util.HashSet;

/****
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *   输入：19
 *   输出：true
 *   解释：
 *   1² + 9² = 82
 *   8² + 2² = 68
 *   6² + 8² = 100
 *   1² + 0² + 0² = 1
 *
 *   来源：力扣（LeetCode）
 *   链接：https://leetcode-cn.com/problems/happy-number
 *   著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 我们可以先举几个例子。我们从 7 开始。则下一个数字是 49（因为 7²=49）
 * ，然后下一个数字是 97（因为 4²+9²=97）。
 * 我们可以不断重复该的过程，直到我们得到 1。
 * 因为我们得到了 1，我们知道 7 是一个快乐数，函数应该返回 true。
 *
 *
 * 再举一个例子，让我们从 116 开始。通过反复通过平方和计算下一个数字，
 * 我们最终得到 58，再继续计算之后，我们又回到 58。
 * 由于我们回到了一个已经计算过的数字，可以知道有一个循环，
 * 因此不可能达到 111。所以对于 116函数应该返回 false。
 */
public class HappyNum {
    public static void main(String[] args) {
        int num = 19;
        HappyNum happyNum = new HappyNum();
//        happyNum.isHappyNum(num);
        System.out.println(happyNum.isHappyNum(14));
        System.out.println(happyNum.isHappyNum1(14));
    }


    /***
     * 通过链表的 快慢指针原理进判断
     */
    public boolean isHappyNum1(int num){
//        把转换过程的每一个结果看做是链表的下一个节点，1看做是链表的最后一个元素，
//        如果不能转化为1，则说明链表中存在
        int slow = num;//慢指针
        int fast = getNext(num);//快指针
        while (fast != 1 && slow != fast){
//          快指针会优先进入循环，当慢指针也进入循环后，快指针会追上慢指针，并且相遇
//          相遇时会出现两种情况
//          1.快指针先进入列表尾部1 （一直在1中循环 慢指针紧随其后进入尾部节点） 为1时说明是快乐数，则跳出循环
//          2.如同赛跑 跑圆圈，快指针追上慢指针相遇时 说明该循环不为快乐数
            slow = getNext(slow);//
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }


    /***
     * 通过利用 Set 集合值不可重复特性进行判断 set集合add()方法添加时，如果该值存在则返回false
     * @param num
     * @return
     */
    private boolean isHappyNum(int num) {
        if (num == 0){
            return false;
        }
        // isHappy 用来储存出现过的数字（HashSet 集合不可储存重复的值）
        HashSet isHappy = new HashSet();
        //当数字不等于1时 && 集合中没有该数字（如果已经有重复的数字则说明是死循环 或者为1）
        while (num != 1 && !isHappy.contains(num)){
            isHappy.add(num);
            num = getNext(num);
        }
        return num == 1;//跳出的数字如果不等于1 则不是快乐数
    }

    /***
     * 取数字每个位置的数的平方之和 例：19的结果为82 过程 1² + 9² = 82
     * @param num
     * @return
     */
    private int getNext(int num) {
        int sum = 0;
        while (num > 0){
            int d = num%10; //取最右数字
            num = num / 10;//取最左数字 进行循环
            sum += d * d;
        }
        return sum;
    }


}
