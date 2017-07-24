package link;

class Node<E> {
	E item;
	Node<E> next;
	
	public Node(E item) {
		this.item = item;
		this.next = null;
	}
	
	
	
	@Override
	public String toString() {
		return "Node [item=" + item + ", next=" + next + "]";
	}



	public static void main(String[] args) {
		//空链表
		Node head = new Node("nodedata1");
		Node tail = head;
		
		//1.2.4	代码6 链表追加一个节点
		tail.next = new Node("node1data2");
		
		tail = tail.next;
		
		//1.2.5	代码7 顺序遍历链表
		/*Node<String> current = head;
		while (current != null) {
			System.out.println("current.item:" + current.item);//1:nodedata1  2:node1data2
			current = current.next;
			//System.out.println("current.item new:" + current.item);
			
		}*/
		//printList(head);
		revList(head);
	}
	
	//1.2.6	代码8 倒序遍历链表
	static void printList(Node<String> head) {
		//递归思想
		if(head != null) {
			printList(head.next);
			System.out.println(head.item); //1:node1data2 2:nodedata1
		}
	}
	
	//1.2.7	代码 单链表反转
	static Node<String> revList(Node<String> head) {
		if(head == null) {
			return null;
		}
		
		Node<String> nodeResult = null;
		Node<String> nodePre = null;
		Node<String> current = head;
		
		while (current != null) {
			Node<String> nodeNext = current.next;
			if(nodeNext == null) {
				nodeResult = current;
			}
			
			current.next = nodePre;
			nodePre = current;
			current = nodeNext;
		}
		System.out.println(nodeResult.toString());
		//Node [item=node1data2, next=Node [item=nodedata1, next=null]]
		return nodeResult;
	}
}
