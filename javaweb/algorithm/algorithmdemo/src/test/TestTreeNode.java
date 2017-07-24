package test;
import org.junit.Test;
import tree.TreeNode;
public class TestTreeNode {
	@Test
	public void test() {
		TreeNode treeNode = new TreeNode("rootdata1");
		treeNode.left = new TreeNode("leftdata1");
		treeNode.right = new TreeNode("rightdata1");
		
		treeNode.preorder(treeNode);
		//treeNode.inorder(treeNode);
		//treeNode.postorder(treeNode);
	}
}
