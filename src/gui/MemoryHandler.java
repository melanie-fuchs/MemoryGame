/**
 * 
 */
package gui;

import java.util.Vector;


/**
 * @author yume
 *
 */
public class MemoryHandler {
	
	public static int attempts;
	private static Vector<Integer> tempCardArray; 	
	private static Vector<Integer> flippedPairs;
	
	private void checkPairs() {
		if(tempCardArray.size() == 2) {
			if(tempCardArray.elementAt(0) == tempCardArray.elementAt(1)) {
				System.out.println("They match");
				flippedPairs.add(tempCardArray.elementAt(0));
				tempCardArray.removeAllElements();
			} else {
				System.out.println("They do not match");
				tempCardArray.removeAllElements();
			}
		} else {
			System.out.println("Can't compare due to wrong number of items.");
		}
	}

	public MemoryHandler() {
		tempCardArray = new Vector<Integer>();
		flippedPairs = new Vector<Integer>();
		tempCardArray.add(1);
		tempCardArray.add(1);;
		checkPairs();
	}
	
	public static void main(String[] args) {
		new MemoryHandler();
		
	}
}
