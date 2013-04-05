
import java.util.Iterator;
import java.util.List;
 

public class BTree {
	private  String items = "";
	private BNode theBTRootNode;
	public BTree(List<Integer> data, String key){
		theBTRootNode = null;
		 for (Iterator<Integer> i = data.iterator(); i.hasNext(); ){
			 	insertBST(i.next());
			 
		 }
		
		
	}
	public String getitems(){
		return this.items;
	}
	public BNode getRoot(){
		return this.theBTRootNode;
	}
	public void setItems(String items){
		this.items = items;
	}
	protected BNode insertAB(BNode theRootNode, BNode myNewNode) {
        if (theRootNode == null) {
            theRootNode = myNewNode;
          
        } else if (myNewNode.value < theRootNode.value) {
            theRootNode.leftBNode = insertAB(theRootNode.leftBNode, myNewNode);
        } else {
            // else if bigger appends to the right
            theRootNode.rightBNode = 
               insertAB(theRootNode.rightBNode, myNewNode);
        }
        return theRootNode;
    }
	 public void insertBST(int value) {
	        BNode anyClassBTNode = new BNode(value);
	        //calls insert above
	        theBTRootNode = insertAB(theBTRootNode, anyClassBTNode);
	    }
	 protected BNode search(BNode theRootNode, int keyName) {
	        //if the root is null returns null
	        if (theRootNode == null) {
	            return null;
	        } else {
	            //checks if they are equal
	            if (keyName == theRootNode.value){
	                return theRootNode;
	            //checks id the key is smaller than the current
	            //record  if smaller traverses to the left
	            } else if (keyName < theRootNode.value) {
	                return search(theRootNode.leftBNode, keyName);
	            } else {
	                // if bigger traverses to the right
	                return search(theRootNode.rightBNode, keyName);
	            }
	        }
	    }
	  protected void inorder(BNode theRootNode) {
		
	        if (theRootNode != null) {
	            inorder(theRootNode.leftBNode);
	            items = items.concat(Integer.toString(theRootNode.value));
	           // System.out.println(items.length());
	            setItems(items);
	            //System.out.println(items);
	            inorder(theRootNode.rightBNode);
	        }
	    }
}


