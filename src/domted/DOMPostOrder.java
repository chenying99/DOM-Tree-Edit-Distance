package domted;

import java.util.ArrayList;

import org.w3c.dom.Node;

public class DOMPostOrder {
	public Node[] N;
	public Integer[] L;
	public Integer[] kr;
	public DOMPostOrder(Node doc) {
		postOrderNodes(doc);
	}
	private void postOrderNodes(Node doc) {
		ArrayList<Node> postOrderNodes = new ArrayList<Node>();
		postOrderNodes.add(null);
		ArrayList<Integer> leftmostDescendant =new ArrayList<Integer>();
		ArrayList<Integer> krList = new ArrayList<Integer>();
		leftmostDescendant.add(null);
		postOrder(doc,postOrderNodes,leftmostDescendant,krList,true);
		this.N = postOrderNodes.toArray(new Node[postOrderNodes.size()-1]);
		this.L = leftmostDescendant.toArray(new Integer[leftmostDescendant.size()-1]);
		this.kr = krList.toArray(new Integer[krList.size()-1]);
	}
	private static int postOrder(Node n,
			ArrayList<Node> result,
			ArrayList<Integer> leftmostDescendant,
			ArrayList<Integer> krList,
			boolean isKeyRoot){
		Node child = n.getFirstChild();
		int ld;
		if(child!=null) {
			ld = postOrder(child,result,leftmostDescendant,krList,false);
			while((child=child.getNextSibling())!=null) postOrder(child,result,leftmostDescendant,krList,true);
		} else ld = result.size();
		
		if(isKeyRoot) krList.add(result.size());
		result.add(n);
		leftmostDescendant.add(ld);
		
		return ld;
	}
}