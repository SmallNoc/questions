package com.example.questions;

// 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
// 来源：力扣（LeetCode）

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并序列链表
 */
public class MergeSequence {

    /**
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * @param args
     */

    public static void main(String[] args) {
        Mylink mylink1 = new Mylink();
        Mylink mylink2 = new Mylink();
        Mylink mylink3 = new Mylink();
        Mylink mylink4= new Mylink();
        mylink1.addNodeFirst(-1);
        mylink1.addNodeFirst(12);
        mylink1.addNodeFirst(3);
        mylink2.addNodeFirst(11);
        mylink2.addNodeFirst(4);
        mylink2.addNodeFirst(7);
        mylink3.addNodeFirst(1);
        mylink3.addNodeFirst(2);
        mylink3.addNodeFirst(4);
        Mylink.ListNode[] nodes = new Mylink.ListNode[3];
        nodes[0] = mylink1.head;
        nodes[1] = mylink2.head;
        nodes[2] = mylink3.head;
        MergeSequence ms = new MergeSequence();
        mylink4= ms.mergeKLists(nodes);
        mylink4.printList();

    }


    public Mylink mergeKLists(Mylink.ListNode[] listNodes){
        Mylink mylink = new Mylink();

        if (listNodes == null || listNodes.length == 0){
            return null;
        }
        //创建一个堆，并设置元素排序方法；
        PriorityQueue queue = new PriorityQueue(new Comparator<Mylink.ListNode>() {
            @Override
            public int compare(Mylink.ListNode o1, Mylink.ListNode o2) {
                return ((int)o1.val - (int)o2.val);
            }
        });

        //遍历链表数组，然后将每个链表的每个节点都放入堆中
        for(int i=0 ;i<listNodes.length;i++){
            while (listNodes[i] != null){
                queue.add(listNodes[i]);
                listNodes[i] = listNodes[i].next;
            }
        }

        Mylink.ListNode dummy = mylink.addNodeFirst(-1);
        Mylink.ListNode head = dummy;
        //从堆中不断取出元素，并且串联起来
        while (!queue.isEmpty()){
            dummy.next = (Mylink.ListNode)queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        mylink.head = head.next;
        return  mylink;
    }




}
