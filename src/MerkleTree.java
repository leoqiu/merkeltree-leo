import java.util.ArrayList;
import java.util.List;


class MNode {
	
	MNode left;
	MNode right;
	int hashVal;
	
	MNode (int hashVal, MNode left, MNode right) {
		this.hashVal = hashVal;
		this.left = left;
		this.right = right;
	}
	
}



public class MerkleTree {
	
	public MerkleTree () {
		
	}
	
	
	private int hashFunc (int val) {
		return val % 3 + 1;
	}
	
	
	private List<MNode> getNextLevel (List<MNode> list) {
		
		List<MNode> res = new ArrayList<MNode>();
		
		if(list.size() >= 2) {
			for (int i = 1; i < list.size(); i += 2) {
				MNode left = list.get(i-1);
				MNode right = list.get(i);
				
				MNode parent = new MNode(hashFunc(left.hashVal + right.hashVal), left, right);
				res.add(parent);
			}
		}
		
		return res;
		
	}
	
	public MNode make (int[] data) {
		
		//level 0
		List<MNode> list = new ArrayList<MNode>();
		for (int d : data) {
			list.add(new MNode(hashFunc(d), null, null));
		}
		
		while (list.size() > 1) {
			list = this.getNextLevel(list);
		}
		
		return list.get(0);
		
	}
	

}

























