/**
 * 
 */
package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuzhao.yang
 * @description:二叉查找树
 * @time:2017年8月15日 下午4:42:29
 */
public class BinarySearchTree {
	// 树的根结点
	private TreeNode root = null;

	// 遍历结点列表
	private List<TreeNode> nodelist = new ArrayList<TreeNode>();

	private class TreeNode {

		private int key;
		private TreeNode leftChild;
		private TreeNode rightChild;
		private TreeNode parent;

		public TreeNode(int key, TreeNode leftChild, TreeNode rightChild,
				TreeNode parent) {
			this.key = key;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.parent = parent;
		}

		public int getKey() {
			return key;
		}

		public String toString() {
			String leftkey = (leftChild == null ? "" : String
					.valueOf(leftChild.key));
			String rightkey = (rightChild == null ? "" : String
					.valueOf(rightChild.key));
			return "(" + leftkey + " , " + key + " , " + rightkey + ")";
		}
	}

	/**
	 * 
	 * @description:查找key满足的节点
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:44:02
	 */
	public TreeNode search(int key) {
		TreeNode begin = root;
		while (null != begin && begin.key != key) {
			if (key < begin.key) {
				begin = begin.leftChild;
			} else {
				begin = begin.rightChild;
			}
		}
		return begin;
	}

	/**
	 * 
	 * @description:寻找最小节点
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @throws Exception
	 * @time:2017年8月15日 下午4:47:11
	 */
	public TreeNode minElemNode(TreeNode root) throws Exception {
		if (null == root) {
			throw new Exception("树为空!");
		}
		while (root.leftChild != null) {
			root = root.leftChild;
		}
		return root;
	}

	/**
	 * 
	 * @description:寻找最大节点
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @throws Exception
	 * @time:2017年8月15日 下午4:47:40
	 */
	public TreeNode maxElemNode(TreeNode root) throws Exception {
		if (root == null) {
			throw new Exception("树为空!");
		}
		while (root.rightChild != null) {
			root = root.rightChild;
		}
		return root;
	}

	/**
	 * 
	 * @description:插入指定节点，必须要保证还是一个二叉查找树
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:51:54
	 */
	public void insert(int key) {
		TreeNode parentNode = null;
		TreeNode newNode = new TreeNode(key, null, null, parentNode);
		TreeNode pNode = root;

		// 如果根节点是空
		if (root == null) {
			root = newNode;
			return;
		}
		while (null != pNode) {
			parentNode = pNode;
			if (key < pNode.key) {
				pNode = pNode.leftChild;
			} else if (key > pNode.key) {
				pNode = pNode.rightChild;
			} else {
				return;
			}
		}
		if (key < parentNode.key) {
			parentNode.leftChild = newNode;
			newNode.parent = parentNode;
		} else {
			parentNode.rightChild = newNode;
			newNode.parent = parentNode;
		}
	}
}
