package datastructure.linkedlist;

import java.util.Hashtable;


public class MyLinkedList {
	Node head = null;
	
	/**
	 * �������в�������
	 */
	public void addNode(int d){
		Node newNode = new Node(d);
		if(head == null) {//������
			head = newNode;
			return;
		}
		
		Node tmp = head;
		while(tmp.next != null) {//�����һ���ڵ�
			tmp = tmp.next;
		}
		
		//add node to the end
		tmp.next = newNode;
	}
	
	/**
	 * ɾ����index���ڵ�
	 * �ɹ�����true,ʧ�ܷ���false
	 */
	public Boolean deleteNode(int index) {
		if(index < 1 || index > length()) {//ɾ��Ԫ�ص�λ�ò�����
			return false;
		}
		
		//ɾ�������һ��Ԫ��
		if(index == 1) {
			head = head.next;
			return true;
		}
		
		//����λ��
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
	 * ���ؽڵ㳤��
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
	 * �������������
	 * ����������ͷ���
	 * �Լ����:ð�ݷ�
	 * ��:��������???
	 */
	public Node orderList() {
		Node nextNode = null;
		int tmp=0;
		Node curNode = head;
		while (curNode.next != null) {//�����һ���ڵ�
			nextNode = curNode.next;
			while(nextNode != null) {//��1��
				if(curNode.data > nextNode.data) {//����߽ڵ����ݴ����ұߣ���Ļ����ұ�
					tmp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = tmp;
				}
				nextNode = nextNode.next;//�����Ƚ��¸��ڵ������¸��ڵ��С��
			}
			
			curNode = curNode.next;//��2��ָ��ָ�����¸��ڵ㣬�������ɣ������Ƚϣ�������
		}
		
		return head;
	}
	
	/**
	 * 8.1.2 ����ȥ�ء�Hashtable
	 * @param head
	 */
	public void deleteDuplecate1(Node head) {
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		Node tmp = head;
		Node pre = null;
		
		while(tmp != null) {
			if(table.containsKey(tmp.data)) {
				pre.next = tmp.next;//ɾ���ظ����Ǹ�tmp
			}else {
				table.put(tmp.data, 1);
				pre = tmp;
			}
			tmp = tmp.next;
		}
	}
	
	/**
	 * 8.1.2 ����ȥ��
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
	 * 8.1.4 ����ת
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
	 * 8.1.5 ���������
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
		
		//����
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
		
		
		//����ת
		/*System.out.println("before reverse:");
		list.printList();
		list.ReverseTteratively(list.head);
		System.out.println("after reverse:");
		list.printList();*/
		
		//���������
		/*System.out.println("before reverse:");
		list.printList();
		list.printListReverse(list.head);
		System.out.println("after reverse:");
		list.printList();*/
	}
	
}
