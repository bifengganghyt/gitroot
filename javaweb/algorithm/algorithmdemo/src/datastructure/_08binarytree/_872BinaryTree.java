package datastructure._08binarytree;

public class _872BinaryTree {
	private Node root;
	
	public _872BinaryTree() {
		root = null;
	}

	//将data插入到排序二叉树中
	public void insert(int data) {
		Node newNode = new Node(data);
		//初始化根节点
		if(root == null) {
			root = newNode;
		} else {
			//从根节点开始遍历
			Node current = root;
			Node parent;//current对应的节点的父节点
			while(true) {
				parent = current;
				if(data < current.data) {//继续遍历左节点
					current = current.left;
					if(current == null) {//找到放置的节点
						parent.left = newNode;
						return;//结束。安置下一个节点
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
	
	//将数值输入构建二叉查找树
	public void buildTree(int[] data) {
		for(int i=0;i<data.length;i++) {
			insert(data[i]);
		}
	}
	
	//中序遍历方法递归实现
	
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
	
	//先序遍历方法的递归实现
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
	
	//后序遍历的递归法
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
		
		System.out.println("中序遍历结果:");
		biTree.inOrder();
		System.out.println("先序遍历结果:");
		biTree.preOrder();
		System.out.println("后序遍历结果:");
		biTree.postOrder();
	}

}
