package domted;

import org.w3c.dom.Node;

public interface NodeDistance {
	public int rename(Node n1,Node n2);
	public int delete(Node n1,Node n2);
	public int insert(Node n1,Node n2);
}
