
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// args[0] is the tree data
		// args[1] is the key.txt
		 try {
			
			 String key = ""; // used to store the key
			 List<Integer> data = new LinkedList<Integer>(); // used to store the data
			 FileReader input1 = new FileReader(args[0]); // used to read input from args(the tree data)
			 FileReader input2 = new FileReader(args[1]); // used to read input from the second args (the key)
			 BufferedReader bufRead1 = new BufferedReader(input1);
			 String line = "";
			 
			 line = bufRead1.readLine();
			 data.add(Integer.parseInt(line));
			 
			 
			 while(line != null){
				 line = bufRead1.readLine();
				 
				 if(line != null)
					 data.add(Integer.parseInt(line));
				
				
			 }
			 for (Iterator<Integer> i = data.iterator(); i.hasNext(); ){
				 System.out.println(i.next());
				 
			 }
			 @SuppressWarnings("resource")
			 BufferedReader bufRead2 = new BufferedReader(input2);
			 key = bufRead2.readLine();
			 System.out.println(key);
			 bufRead1.close();
			 bufRead2.close();
			 
			 BTree Tree = new BTree(data,key);
			 System.out.println(Tree.search(Tree.getRoot(), 10000).value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
