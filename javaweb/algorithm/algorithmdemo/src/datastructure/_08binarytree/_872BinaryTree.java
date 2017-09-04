package datastructure._08binarytree;

public class _872BinaryTree {
	private Node root;
	
	public _872BinaryTree() {
		root = null;
	}

	//��data���뵽�����������
	public void insert(int data) {
		Node newNode = new Node(data);
		//��ʼ�����ڵ�
		if(root == null) {
			root = newNode;
		} else {
			//�Ӹ��ڵ㿪ʼ����
			Node current = root;
			Node parent;//current��Ӧ�Ľڵ�ĸ��ڵ�
			while(true) {
				parent = current;
				if(data < current.data) {//����������ڵ�
					current = current.left;
					if(current == null) {//�ҵ����õĽڵ�
						parent.left = newNode;
						return;//������������һ���ڵ�
					}
				} else {
					current = current.right;
					if(current ==null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	//����ֵ���빹�����������
	public void buildTree(int[] data) {
		for(int i=0;i<data.length;i++) {
			insert(data[i]);
		}
	}
	
	//������������ݹ�ʵ��
	
	public void inOrder(Node localRoot) {
		if(localRoot!=null) {
			inOrder(localRoot.left);
			System.out.println(localRoot.data + "");
			inOrder(localRoot.right);
		}
	}
	
	public void inOrder() {
		inOrder(this.root);
	}
	
	//������������ĵݹ�ʵ��
	public void preOrder(Node localRoot) {
		if(localRoot!=null) {
			System.out.println(localRoot.data+"");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	
	public void preOrder() {
		preOrder(this.root);
	}
	
	//��������ĵݹ鷨
	public void postOrder(Node localRoot) {
		if(localRoot!=null) {
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.println(localRoot.data+"");
		}
	}
	
	public void postOrder() {
		postOrder(this.root);
	}
	
	public static void main(String[] args) {
		_872BinaryTree biTree = new _872BinaryTree();
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		biTree.buildTree(data);
		
		System.out.println("����������:");
		biTree.inOrder();
		System.out.println("����������:");
		biTree.preOrder();
		System.out.println("����������:");
		biTree.postOrder();
	}

}
