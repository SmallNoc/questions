package com.example.questions;

/***
 * 链表的实现及增删查改
 * @param <T>
 */
public class Mylink<T> {
    ListNode head = null; //节点头

    public class ListNode {
        T val; //节点对象，既内容
        ListNode next; // 节点的引用，指向下一个节点

        public ListNode(T val,ListNode next){
            this.val = val;
            this.next = next;
        }

        public ListNode(T val){
            this(val,null);
        }

    }

    /**
     * 向列表中插入节点(头部插入)
     * 比尾部插入效率高
     * @return
     */
    public ListNode addNodeFirst(T var){
        ListNode node = new ListNode(var);
        node.next = head;
        head = node;
        //this.head = new ListNode(var,head) 等同于上述代码
        return head;
    }

    /**
     * 向列表中插入节点(尾部插入)
     */
    public void addNodeLast(T val) {
        ListNode newListNode = new ListNode(val);//实例化一个节点
        if(head == null){
            head = newListNode;
            return;
        }
        ListNode tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newListNode;
    }

    /**
     * 插入节点 （插入位置后进行插入）
     *
     * @param t 插入位置
     * @param val 插入的元素
     */
    public void insertNode(T t , T val){
        //构造虚拟头节点
        ListNode node = new ListNode(t,this.head);
        //插入的节点
        ListNode newNode = new ListNode(val);
        ListNode curNode = node;
        while (curNode.next != null){
            if (curNode.next.val.equals(t)){
                //节点替换
                newNode.next = curNode.next.next;
                curNode.next.next = newNode;
                break;
            }else {
                curNode = curNode.next;
            }
        }
        //去除虚构节点头
        head = node.next;
    }

    /**
     *
     * @param index :删除第index节点
     * @return
     */
    public boolean deleteNode(int index){
        if (index < 1 || index > length()){
            return false;
        }
        if(index == 1){
            head = head.next; //如果是头部 替换节点
            return true;
        }
        int i = 2;
        ListNode preNode = head;//上级节点
        ListNode curNode = head.next;//下级节点
        while (curNode != null){
            if(i == index){
                preNode.next = curNode.next;//替换当前节点
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    /**
     * 在不知道头指针的情况下删除指定节点
     * @param  node
     * @retrun
     */
    public boolean deleteNodeIsNodeHead(ListNode node){
        if (node == null || node.next == null) {

            return  false;
        }
        T tmp = node.val;//当前节点对象内容
        node.val = node.next.val;//将下一个节点对象内容赋值给当前节点
        node.next.val = tmp;//将当前对象原有内容赋值给下一节点（该步骤我觉得可以省略）
        node.next = node.next.next;//把下下节点赋值给下一节点
        System.out.println("删除成功！");
        return true;
    }

    /**
     * 使用对象内容进行节点删除
     * 使用虚拟头 进行节点删除
     * @param t 对象内容
     */
    public void removeElt(T t){
        //构造一个虚拟头节点，下一节点指定head
        ListNode Node = new ListNode(t,this.head);
        //声明节点指向虚拟头节点
        ListNode cur = Node;
        while (cur.next != null){
            if (cur.next.val.equals(t)){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        this.head = Node.next;
    }

    /**
     * 删除最后一个元素
     */
    public void removeLast(){
        if(this.head == null){
            System.out.println("无元素可删除");
        }
        if(length() == 1){
            removeFirst();
            return;
        }
        ListNode preNode = head;//记录倒数第二个节点
        ListNode curNode = head;//记录当前节点
        while (curNode.next != null){
                preNode = curNode;
                curNode = curNode.next;
        }
        preNode.next = curNode.next;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public void removeFirst() {
        if(head == null){
            System.out.println("无元素可删除");
        }
        ListNode listNode = head.next;
        this.head = listNode;
    }



    /**
     * 输出链表
     */
    public void printList(){
        ListNode node = head;
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    /***
     *
     * @return 返回节点长度
     */
    public int length() {
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /***
     * 判断链表是否包含某元素
     * @param t 元素val
     * @return
     */
    public boolean contains(T t){
        ListNode tmp = head;
        while (tmp != null){
            if (tmp.val.equals(t)){
                return true;
            }else {
                tmp = tmp.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Mylink mylink = new Mylink();
        mylink.addNodeLast(1);
        mylink.addNodeLast(21);
        mylink.addNodeLast(3);
        mylink.addNodeLast(72);
        mylink.addNodeLast(5);
//        System.out.println("链表长度：" + mylink.length());
//        System.out.println("head.val：" + mylink.head.val);
        mylink.addNodeFirst(110);
//        mylink.addNodeLast(6);
//        mylink.printList();
//        mylink.deleteNode(2);
//        mylink.printList();
//        mylink.deleteNodeIsNodeHead(mylink.head.next.next);
        mylink.printList();
//        mylink.removeLast();
//        mylink.removeElt(72);
//        mylink.insertNode(1,4);
        System.out.println(mylink.contains(712));
        mylink.printList();

    }
}

