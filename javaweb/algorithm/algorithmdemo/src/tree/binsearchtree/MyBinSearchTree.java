package tree.binsearchtree;


public class MyBinSearchTree<E extends Comparable<E>> {
	
	//根
	private TreeNode<E> root;
	
	// 默认构造函数
	public MyBinSearchTree(TreeNode treeNode) {
		this.root = treeNode;
	}
	
	public boolean search(E element) {
		
		TreeNode<E> current = root;
		while (current != null) {
			
			if(element.compareTo(current.element) < 0) {
				current = current.left;
			} else if (element.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				
				return true;
			}
		}
		
		return false;
	}
	
	// 二叉查找树的插入
    public boolean insert(E element) {
    	
    	// 如果之前是空二叉树 插入的元素就作为根节点
    	if(root == null) {
    		root = createNewNode(element);
    	} else {
    		// 否则就从根节点开始遍历 直到找到合适的父节点
    		TreeNode<E> parent = null;
    		TreeNode<E> current = root;
    		
    		while (current != null) {
    			if(element.compareTo(current.element) < 0) {
    				parent = current;
    				current = current.left;//要插入的元素(5)比父节点(20)小，将其与该父节点的左节点(10)比较 ;发现比10还要小，继续想与10的左节点比较
    				//而10没有左节点，跳出循环  将该元素与10比较，小——创建节点
    				
    			} else if(element.compareTo(current.element) > 0) {
    				parent = current;
    				current = current.right;
    			} else {
    				return false;
    			}
    		}
    		
    		//插入
    		if(element.compareTo(parent.element) < 0) {
    			parent.left = createNewNode(element);    			
    		} else {
    			parent.right = createNewNode(element);
    		}
    		
    		System.out.println(parent.toString());
    	}
    	
    	return true;
    }
    
    // 创建新的节点
    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode(e);
    }
}
