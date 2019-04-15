import java.util.*;
public class LinkedBSTree <T extends Comparable<T>>{
	private class Node{
		private T data;
		private Node leftChild;
		private Node rightChild;
		public Node(T aData) {
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;
	public LinkedBSTree() {
		root = null;
	}
	public void insert(T aData) {
		if(root == null)
			root = new Node(aData);
		else
			insert(root,aData);
	}
	private Node insert(Node aNode, T aData) { //Recursive method
		if(aNode == null)//haulting condition
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data) < 0) //Go left
			aNode.leftChild = insert(aNode.leftChild,aData);
	    else if (aData.compareTo(aNode.data)>=0)  //Go right
			aNode.rightChild = insert(aNode.rightChild, aData);	
		return aNode;		
	}
	
	public void printPreOrder() {
		printPreOrder(root);
	}
	private void printPreOrder(Node aNode) {
		if(aNode == null)
			return;
		System.out.println(aNode.data);
		if(aNode.leftChild != null) //Left
			printPreOrder(aNode.leftChild);
		if(aNode.rightChild != null)//Right (Do not do an else if)
			printPreOrder(aNode.rightChild);
	}
	
	public void printInOrder() {
		printInOrder(root);
	}
	private void printInOrder(Node aNode) {
		if(aNode == null)
			return;
		if(aNode.leftChild != null)
			printInOrder(aNode.leftChild);
		System.out.println(aNode.data);
		if(aNode.rightChild != null)
			printInOrder(aNode.rightChild);
	}
	
	public boolean search(T aData) {
		return search(root, aData);
	}
	private boolean search(Node aNode, T aData) {
		if(aNode == null)//Reached a null 
	      return false;
		if(aData.compareTo(aNode.data) == 0)
			return true;
		else if(aData.compareTo(aNode.data)< 0)
			return search(aNode.leftChild,aData);
		else
			return search(aNode.rightChild,aData);
	}
	public int getHeight() {
		return getHeight(root,0);
	}
	private int getHeight(Node aNode, int count) {
		if(aNode == null)
			return count;
		count ++;
		return Math.max(getHeight(aNode.leftChild,count),
				getHeight(aNode.rightChild,count));
		
	}
	
	public void printBreadthOrder() {
		int nodeCount = 1;
		int maxNodeAtDepth = 1;
		int maxNodes = (int)Math.pow(2.0,getHeight());
		int totalNodeCount = 0;
		Queue<Node> nQ = new LinkedList<Node>();
		nQ.add(root);
		while(nQ.isEmpty() && totalNodeCount < maxNodes) {
			//Dequeue
			Node aNode = nQ.remove();
			if(aNode != null) {
				System.out.print(aNode.data + " ");
				nQ.add(aNode.leftChild);
				nQ.add(aNode.rightChild);
			}else {//This is a leaf so it is null
				System.out.print("X ");
				nQ.add(null);
				nQ.add(null);
			}
			if(nodeCount >= maxNodeAtDepth) {
				System.out.println("|\n--------------" +
			(int) (Math.log(maxNodeAtDepth)/
					Math.log(2)));
				totalNodeCount += nodeCount;
				nodeCount = 1;
				maxNodeAtDepth += 2;
				
			}else {
				if(nodeCount != 1 && nodeCount%2 == 0)
					System.out.println("|");
				nodeCount ++;
			}
		}
		System.out.println();
	}
	public void delete(T aData) {
		root = delete(root,aData);
		
	}
	private Node delete(Node aNode, T aData) {
		if(aNode == null)
			return null;
	
	if(aData.compareTo(aNode.data)<0)
		aNode.leftChild = delete(aNode.leftChild,aData);
	else if(aData.compareTo(aNode.data)>0)
		aNode.rightChild = delete(aNode.rightChild, aData);
	else {
		if(aNode.rightChild == null)
			return aNode.leftChild;
		if(aNode.leftChild == null)
			return aNode.rightChild;
		//Two Children
		//TODO find min in tree\
		Node min = findMinInTree(aNode.rightChild);
		aNode.data = min.data;
		delete(aNode.rightChild,min.data);//Deletes the duplicate
	}
	return aNode;
	}
	private Node findMinInTree(Node aNode) {
		if(aNode == null)
			return null;
		if(aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
}
















