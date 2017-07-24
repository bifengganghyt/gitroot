package tree.binsearchtree;


public class MyBinSearchTree<E extends Comparable<E>> {
	
	//��
	private TreeNode<E> root;
	
	// Ĭ�Ϲ��캯��
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
	
	// ����������Ĳ���
    public boolean insert(E element) {
    	
    	// ���֮ǰ�ǿն����� �����Ԫ�ؾ���Ϊ���ڵ�
    	if(root == null) {
    		root = createNewNode(element);
    	} else {
    		// ����ʹӸ��ڵ㿪ʼ���� ֱ���ҵ����ʵĸ��ڵ�
    		TreeNode<E> parent = null;
    		TreeNode<E> current = root;
    		
    		while (current != null) {
    			if(element.compareTo(current.element) < 0) {
    				parent = current;
    				current = current.left;//Ҫ�����Ԫ��(5)�ȸ��ڵ�(20)С��������ø��ڵ����ڵ�(10)�Ƚ� ;���ֱ�10��ҪС����������10����ڵ�Ƚ�
    				//��10û����ڵ㣬����ѭ��  ����Ԫ����10�Ƚϣ�С���������ڵ�
    				
    			} else if(element.compareTo(current.element) > 0) {
    				parent = current;
    				current = current.right;
    			} else {
    				return false;
    			}
    		}
    		
    		//����
    		if(element.compareTo(parent.element) < 0) {
    			parent.left = createNewNode(element);    			
    		} else {
    			parent.right = createNewNode(element);
    		}
    		
    		System.out.println(parent.toString());
    	}
    	
    	return true;
    }
    
    // �����µĽڵ�
    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode(e);
    }
}
