package huffman;

//Basic node in a Huffman coding tree.
public class HuffNode implements Comparable<HuffNode>
{
	public int value;
	public int weight;
	HuffNode left;
	HuffNode right;
	HuffNode parent;

	HuffNode( int v, int w, HuffNode lt, HuffNode rt, HuffNode pt )
	{
		value = v; 
		weight = w; 
		left = lt; 
		right = rt; 
		parent = pt;
	}
	public int compareTo(HuffNode rhs)
	{
		HuffNode other = rhs;
		return weight - other.weight;
	}

	@Override
	public String toString() {
		return toString(0,"");
	}

	public String toString(int indent,String extra) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < indent; i++) {
			b.append("\t");
		}
		b.append(extra);
		b.append(""+value +":" + weight+ ":"+"\n");
		if(left!=null)b.append(left.toString(indent+1,"left"));
		if(right!=null)b.append(right.toString(indent+1,"right"));
		return b.toString();
	}
}