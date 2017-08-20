package datastructure.linkedlist;

import java.util.Hashtable;


public class MyLinkedList {
	Node head = null;
	
	/**
	 * 向链表中插入数据
	 */
	public void addNode(int d){
		Node newNode = new Node(d);
		if(head == null) {//空链表
			head = newNode;
			return;
		}
		
		Node tmp = head;
		while(tmp.next != null) {//非最后一个节点
			tmp = tmp.next;
		}
		
		//add node to the end
		tmp.next = newNode;
	}
	
	/**
	 * 删除第index个节点
	 * 成功返回true,失败返回false
	 */
	public Boolean deleteNode(int index) {
		if(index < 1 || index > length()) {//删除元素的位置不合理
			return false;
		}
		
		//删除链表第一个元素
		if(index == 1) {
			head = head.next;
			return true;
		}
		
		//其它位置
		int i = 1;
		Node preNode = head;
		Node curNode = preNode.next;
		while(curNode != null) {
			if(i == index) {
				preNode.next = curNode.next;
				return true;
			}
			
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return true;
	}
	
	/**
	 * 返回节点长度
	 */
	public int length() {
		int length = 0;
		Node tmp = head;
		while(tmp != null) {
			length++;
			tmp= tmp.next;
		}
		return length;
	}
	
	/**
	 * 对链表进行排序
	 * 返回排序后的头结点
	 * 自己理解:冒泡法
	 * 书:插入排序???
	 */
	public Node orderList() {
		Node nextNode = null;
		int tmp=0;
		Node curNode = head;
		while (curNode.next != null) {//非最后一个节点
			nextNode = curNode.next;
			while(nextNode != null) {//【1】
				if(curNode.data > nextNode.data) {//若左边节点数据大于右边，大的换到右边
					tmp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = tmp;
				}
				nextNode = nextNode.next;//继续比较下个节点与下下个节点大小。
			}
			
			curNode = curNode.next;//【2】指针指向下下个节点，依次往由，两两比较，交换。
		}
		
		return head;
	}
	
	/**
	 * 8.1.2 链表去重—Hashtable
	 * @param head
	 */
	public void deleteDuplecate1(Node head) {
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		Node tmp = head;
		Node pre = null;
		
		while(tmp != null) {
			if(table.containsKey(tmp.data)) {
				pre.next = tmp.next;//删除重复的那个tmp
			}else {
				table.put(tmp.data, 1);
				pre = tmp;
			}
			tmp = tmp.next;
		}
	}
	
	/**
	 * 8.1.2 链表去重
	 * @param head
	 */
	public void deleteDuplecate(Node head) {
		Node p = head;
		while(p.next != null) {
			Node q = p;
			
			while (q.next != null) {
				if(p.data == q.next.data) {
					q.next = q.next.next;
				} else {
					q = q.next;
				}
			}
			p = p.next;
		}
	}
	
	
	
	
	
	
	/**
	 * 8.1.4 链表反转
	 * @param head
	 */
	public void ReverseTteratively(Node head) {
		Node pReversedHeadNode = head;
		Node pNode = head;
		Node pPrev = null;
		while (pNode != null) {
			Node pNext = pNode.next;
			if(pNext == null) {
				pReversedHeadNode = pNode;
			}
			
			pNode.next = pPrev;
			
			pPrev = pNode;
			pNode = pNext;
		}
		this.head = pReversedHeadNode;
	}
	
	/**
	 * 8.1.5 链表倒序输出
	 * @param heaNode
	 */
	public void printListReverse(Node heaNode) {
		if(heaNode!=null) {
			printListReverse(heaNode.next);
			System.out.println(heaNode.data);
		}
	}
	
	
	
	public void printList(){
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(5);
		list.addNode(3);
		list.addNode(1);
		list.addNode(3);
		System.out.println("list length:" + list.length());
		
		//排序
		/*System.out.println("before order:");
		list.printList();
		
		list.orderList();
		
		System.out.println("after order:");
		list.printList();*/
		
		System.out.println("before:");
		list.printList();
		
		list.deleteDuplecate1(list.head);
		
		System.out.println("after:");
		list.printList();
		
		
		//链表反转
		/*System.out.println("before reverse:");
		list.printList();
		list.ReverseTteratively(list.head);
		System.out.println("after reverse:");
		list.printList();*/
		
		//链表倒序输出
		/*System.out.println("before reverse:");
		list.printList();
		list.printListReverse(list.head);
		System.out.println("after reverse:");
		list.printList();*/
	}
	
}
