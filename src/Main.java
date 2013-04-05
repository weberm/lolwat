
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;
public class Main {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException, InvalidKeyException {
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
		 SecretKeySpec keySpec = new SecretKeySpec(
			        "qnscAdgRlkIhAUPY44oiexBKtQbGY0orf7OV1I50".getBytes(),
			        "HmacSHA1");

			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(keySpec);
			byte[] result = mac.doFinal("foo".getBytes());

			BASE64Encoder encoder = new BASE64Encoder();
			System.out.println(encoder.encode(result));
		 
	}

}
