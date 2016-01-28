import static org.junit.Assert.*;

import org.junit.Test;


public class MerkleTreeTreeTest {

	@Test
	public void testEquality() {
		
		int[] data = {1 ,2, 3, 4};
		MerkleTree mtree = new MerkleTree();
		MNode root1 = mtree.make(data);
		MNode root2 = mtree.make(data);
		assertEquals(root1.hashVal, root2.hashVal);
		
	}
	
	@Test
	public void testUnEquality() {
		
		int[] data1 = {1 ,2, 3, 4};
		int[] data2 = {1 ,2, 3, 5};
		MerkleTree mtree = new MerkleTree();
		MNode root1 = mtree.make(data1);
		MNode root2 = mtree.make(data2);
		assertFalse(root1.hashVal == root2.hashVal);
		
	}

}
