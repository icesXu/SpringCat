/**
 * 
 */
package tree;

import java.util.Stack;

/**
 * @author yuzhao.yang
 * @description:实现了二叉树的各种操作
 * @time:2017年8月15日 下午3:50:47
 */
public class BinaryTree {
	private TreeNode root = null;

	public BinaryTree() {
		root = new TreeNode(1, "rootNode(A)");
	}

	public void createBinTree() {
		TreeNode newNodeB = new TreeNode(2, "B");
		TreeNode newNodeC = new TreeNode(3, "C");
		TreeNode newNodeD = new TreeNode(4, "D");
		TreeNode newNodeE = new TreeNode(5, "E");
		TreeNode newNodeF = new TreeNode(6, "F");

		root.leftChild = newNodeB;
		root.rightChild = newNodeC;

		root.leftChild.leftChild = newNodeD;
		root.leftChild.rightChild = newNodeE;
		root.rightChild.rightChild = newNodeF;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int height() {
		return height(root);
	}

	public int size() {
		return size(root);
	}

	/**
	 * 
	 * @description:计算高度的实现方法,递归式实现方式
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:08:57
	 */
	public int height(TreeNode root) {
		// 树为空，高度为0
		if (root == null) {
			return 0;
		} else {
			int i = height(root.leftChild);
			int j = height(root.rightChild);
			return i < j ? j + 1 : i + 1;
		}
	}

	/**
	 * 
	 * @description:
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:09:37
	 */
	public int size(TreeNode root) {
		if (null == root) {
			return 0;
		} else {
			return 1 + size(root.rightChild) + size(root.leftChild);
		}
	}

	/**
	 * 
	 * @description:返回双亲节点
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:13:11
	 */
	public TreeNode parent(TreeNode node) {
		return (root == null || root == node) ? null : parent(root, node);
	}

	/**
	 * 
	 * @description:获取双亲节点
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:14:39
	 */
	public TreeNode parent(TreeNode root, TreeNode node) {
		if (root == null) {
			return null;
		}
		if (root.leftChild == node || root.rightChild == node) {
			return root;
		}
		TreeNode p;
		if ((p = parent(root.leftChild, node)) != null) {
			return p;
		} else
			// 递归在右子树中搜索{
			return parent(root.rightChild, node);
	}

	public TreeNode getLeftChildNode(TreeNode node) {
		return node.leftChild;
	}

	public TreeNode getRightChildNode(TreeNode node) {
		return node.rightChild;
	}

	/**
	 * 
	 * @description:移除一个节点
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:20:00
	 */
	public void remove(TreeNode node) {
		if (null != root) {
			remove(node.leftChild);
			remove(node.rightChild);
			node = null;
		}
	}

	/**
	 * 
	 * @description:前序遍历（中左右）
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:23:13
	 */
	public void preOrder(TreeNode node) {
		visit(node);
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}

	/**
	 * 
	 * @description:中序遍历（左中右）
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:25:13
	 */
	public void inOrder(TreeNode node) {
		inOrder(node.leftChild);
		visit(node);
		inOrder(node.rightChild);
	}

	/**
	 * 
	 * @description:后续遍历（左右中）
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:27:32
	 */
	public void postOrder(TreeNode node) {
		postOrder(node.leftChild);
		postOrder(node.rightChild);
		visit(node);
	}

	/**
	 * 
	 * @description:非递归的前序遍历
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:32:16
	 */
	public void nonRecPreOrder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = node;
		while (root != null || stack.size() > 0) {
			while (root != null) {
				visit(root);
				stack.push(root);
				root = root.leftChild;
			}
			while (stack.size() > 0) {
				root = stack.pop();
				root = root.rightChild;
			}
		}
	}

	// 中序遍历的非递归实现
	public void nonRecInOrder(TreeNode p) {
		Stack<TreeNode> stack = new Stack<BinaryTree.TreeNode>();
		TreeNode node = p;
		while (node != null || stack.size() > 0) {
			// 存在左子树
			while (node != null) {
				stack.push(node);
				node = node.leftChild;
			}
			// 栈非空
			if (stack.size() > 0) {
				node = stack.pop();
				visit(node);
				node = node.rightChild;
			}
		}
	}

	// 后序遍历的非递归实现
	public void noRecPostOrder(TreeNode p) {
		Stack<TreeNode> stack = new Stack<BinaryTree.TreeNode>();
		TreeNode node = p;
		while (p != null) {
			// 左子树入栈
			for (; p.leftChild != null; p = p.leftChild) {
				stack.push(p);
			}
			// 当前结点无右子树或右子树已经输出
			while (p != null && (p.rightChild == null || p.rightChild == node)) {
				visit(p);
				// 纪录上一个已输出结点
				node = p;
				if (stack.empty())
					return;
				p = stack.pop();
			}
			// 处理右子树
			stack.push(p);
			p = p.rightChild;
		}
	}

	/**
	 * 
	 * @description:
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午4:24:45
	 */

	public void visit(TreeNode node) {
		node.isVisited = true;
		System.out.println("key:" + node.key + "--name:" + node.data);
	}

	class TreeNode {
		public int key = 0;
		public String data = null;
		public boolean isVisited = false;
		public TreeNode leftChild = null;
		public TreeNode rightChild = null;

		public TreeNode() {

		}

		public TreeNode(int key, String data) {
			this.key = key;
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
}
