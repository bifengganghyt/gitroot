package test;

import org.junit.Test;

import tree.binsearchtree.MyBinSearchTree;
import tree.binsearchtree.TreeNode;

public class TestMyBinSearchTree {

	@Test
	public void test() {
		TreeNode treeNode = new TreeNode(20);
		treeNode.left = new TreeNode(10);
		treeNode.right = new TreeNode(30);
		
		MyBinSearchTree myBinSearchTree = new MyBinSearchTree(treeNode);
		//boolean search = myBinSearchTree.search("rootdata1");
		boolean result = myBinSearchTree.insert(5);
		
		
		System.out.println(myBinSearchTree.toString());
		System.out.println("result:" + result);
	}

}
