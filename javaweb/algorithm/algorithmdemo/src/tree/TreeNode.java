package tree;

public class TreeNode<E> {
	
	public E element;
	public TreeNode<E> left;
	public TreeNode<E> right;
	
	public TreeNode(E element) {
		this.element = element;
	}
	
	//先序遍历
	public void preorder(TreeNode<E> root) {
		if(root == null) {
			return;
		}
		
		System.out.println(root.element + "");
		
		preorder(root.left);
		preorder(root.right);
		
	}
	
	//中序遍历
	public void inorder(TreeNode<E> root) {
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		
		System.out.println(root.element + "");
		
		inorder(root.right);
	}
	
	//代码14 后序遍历
	public void postorder(TreeNode<E> root) {

	    if (root == null) {
	    	return;
	    }

	    postorder(root.left);

	    postorder(root.right);

	    System.out.println(root.element + " ");
	}
}
