package com.example.questions;

import java.util.Stack;

/***
 * 设计一个栈，使其支持 push、pop、top 操作，并能在常数时间复杂度内完成 getMin 检索栈内最小元素。
 *
 *
 * 链接：https://leetcode-cn.com/problems/min-stack/solution/3-chong-fang-fa-shi-xian-bi-xu-miao-dong-by-sweeti/
 */
public class MinStack {
    private Stack<Integer>  dataStack;//数据栈
    private Stack<Integer>  minStack;//辅助栈 （栈值一直为当前最小值，用以支持常数时间复杂度  getMin 的操作）


    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(-1);
        test.push(-3);
        test.push(5);
        test.push(7);
        System.out.println(test.getMin());
        System.out.println(test.top());
        test.pop();
        System.out.println(test.getMin());
        System.out.println(test.top());


        System.out.println("方法2");

        test.push1(-2);
        test.push1(-4);
        test.push1(6);
        test.push1(8);
        System.out.println(test.getMin1());
        System.out.println(test.top1());
        test.pop1();
        System.out.println(test.getMin1());
        System.out.println(test.top1());

        MinStack test2 = new MinStack("方法三");
        test2.push2(-2);
        test2.push2(-4);
        test2.push2(6);
        test2.push2(8);
        System.out.println(test2.getMin2());
        System.out.println(test2.top2());
        test2.pop2();
        System.out.println(test2.getMin2());
        System.out.println(test2.top2());

    }



    public MinStack(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    /**
     * 存入值到栈中
     * @param x
     */
    public void push(int x) {
        //先把值x压入栈中
        dataStack.push(x);
        //如果x是最小值，把x也压入辅助栈中
        if (minStack.isEmpty() || x < minStack.peek()){
            minStack.push(x);
        }
    }

    /***
     * 删除顶元素
     */
    public void pop(){
//        先删除数据栈的顶元素
        int x = dataStack.pop();
//        如果该元素也是辅助栈中当前的顶元素,则也进行删除
        if(x == minStack.peek()){
            minStack.pop();
        }
    }

    /***
     * 返回当前的顶元素
     * @return
     */
    public int top(){
        return dataStack.peek();
    }

    /**
     * 返回最小元素
     * @return
     */
    public int getMin(){
//        返回辅助栈中当前的最小值
        return minStack.peek();
    }


    //-------------------------------------------方法二-不适用辅助栈，通过链表实现-------------------------------------------------

    public Stack<Node> stack;

    class Node{
        int val;
        int min;
        Node next;

        Node(int val ,int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
        Node(int val,int min){
            this(val,min,null);
        }
    }

    public void push1(int x){
        //判断是否为空
        if(stack.isEmpty()){
            stack.push(new Node(x,x));
        }else {
            stack.push(new Node(x,Math.min(x,stack.peek().min)));
        }
    }

    public void pop1(){
        stack.pop();
    }

    public int top1(){
        return stack.peek().val;
    }

    public int getMin1(){
        return stack.peek().min;
    }

//    --------------------------------------方法三 自定义Stack（链表实现先入后出）------------------------------------------------

    public Node head;
    public MinStack(String str) {
        System.out.println(str);
    }

    public void push2(int x){
        //新建节点插入链表头部，作为新的头节点，储存当前元素值与最小元素值，并指向之前的节点头
        if(head == null){
            head = new Node(x,x);
        }else{
            head = new Node(x,Math.min(x,head.min),head);
        }
    }

    public void pop2(){
        //删除节点头
        head = head.next;
    }

    public int top2(){
        // 返回头节点中存储的元素值
        return head.val;
    }

    public int getMin2(){
        // 返回头节点中存储的最小值
        return head.min;
    }
}
