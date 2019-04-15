import java.util.*;
public class TreeTester {
public static void main (String[] args){

LinkedBSTree<Integer> intTree = new LinkedBSTree<Integer>();
	
  Random r = new Random(100);
	for(int i = 0; i < 10; i++) 
		intTree.insert(r.nextInt(100));
	
	intTree.printPreOrder();
	System.out.println();
	intTree.printInOrder();
	System.out.println(intTree.getHeight());
 }
}
