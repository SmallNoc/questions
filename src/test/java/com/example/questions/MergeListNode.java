package com.example.questions;

import java.util.HashMap;
import java.util.Map;

/***
 * 将两个升序链表合并为一个新的升序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 *  链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
 */
public class MergeListNode {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
           this( val, null);
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        Mylink mylink1 = new Mylink();
        Mylink mylink2 = new Mylink();
        mylink1.addNodeLast(1);
        mylink1.addNodeLast(3);
        mylink1.addNodeLast(5);
        mylink1.addNodeLast(7);
        mylink1.addNodeLast(9);

        mylink2.addNodeLast(2);
        mylink2.addNodeLast(4);
        mylink2.addNodeLast(6);
        mylink2.addNodeLast(8);
        mylink2.addNodeLast(10);


        MergeListNode mergeListNode = new MergeListNode();
        Mylink mylink = mergeListNode.mergeTwoLists(mylink1,mylink2);
//        mylink.printList();

    }
    private Mylink  mergeTwoLists(Mylink mylink1, Mylink mylink2) {
        if (mylink1.head == null){
            return null;
        }
        if (mylink2.head == null){
            return null;
        }

        Mylink newListNode = new Mylink();
        newListNode.addNodeLast(-1);
        newListNode.addNodeLast(2);
        newListNode.addNodeLast(3);
        Mylink tmp = newListNode;


        Mylink newListNode2 = new Mylink();
        newListNode2.addNodeLast(-1);
        Mylink tmp2 = newListNode2;
        tmp2.head = tmp.head;


        while (mylink1.head != null && mylink2.head != null){

            if((int)mylink1.head.val <= (int)mylink2.head.val){
                tmp.head.next = mylink1.head;
                mylink1.head = mylink1.head.next;
            }else {
                tmp.head.next = mylink2.head;
                mylink2.head = mylink2.head.next;
            }

            tmp.head = tmp.head.next;
        }

        tmp.head.next = mylink1.head == null ? mylink2.head : mylink1.head;
        System.out.println("最终结果");
        tmp.printList();
        tmp2.printList();

        tmp.removeLast();
        tmp.removeLast();

        tmp.printList();
        tmp2.printList();
        return newListNode;
    }
}
