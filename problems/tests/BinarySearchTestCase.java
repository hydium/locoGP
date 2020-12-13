package locoGP.problems.tests;

import java.util.Arrays;

import locoGP.util.Logger;

public class BinarySearchTestCase implements TestCase {
	
	private Object[] test = null; // this should be an array containing an array, its length, and the number to search
	private int oracleAnswer = 0;
	
	public BinarySearchTestCase(Object[] testParameters, int index) {
		this.setTest(testParameters);
		this.oracleAnswer = index;
	}
	
	private void setTest(Object[] test) {
		this.test = test;
	}

	public Object[] getTest() {
		return new Object[]{ ((Integer[])test[0]).clone(), 0, ((Integer) test[1]), ((Integer) test[2])};
	}

	public Object getAnswer() {
		return oracleAnswer;
	}
	
	public int checkAnswer(Object ans){
		return Math.abs((Integer) ans - oracleAnswer) + 1;
	}
	
//	private int checkAnswer(Integer[] returnedAns){
//		Integer[] originalUnsortedTest = (Integer[]) test[0];
//		int errorCount = 0;
//		for (int i = 0; i < oracleAnswer.length; i++) {
//			/*if(returnedAns.length -1 < i)
//				errorCount += 5;
//			else */
//			if (oracleAnswer[i].equals(returnedAns[i])) // 
//				errorCount++; // 1 for correct
//			//else if (!oracleAnswer[i].equals(originalUnsortedTest[i]))
//			else if (!originalUnsortedTest[i].equals(returnedAns[i]))
//				errorCount += 2; // not correct, but has been moved 
//			else
//				errorCount += 10; // highest cost for no change
//		}
//		return errorCount;
//		//}
//	}
	
	/*public int checkAnswer(Integer[] ans){
		boolean same = false;
		if( Arrays.equals((Integer[])test[0],(ans)))
			return -(answer.length*5);// needed in case the array is exactly the same, if so, penalise the result
		else {
			int sameCount = 0;
			for (int i = 0; i < answer.length; i++) { // number goes up, when array is sorted.. wrong!
				if (answer[i].equals(ans[i]))
					sameCount++;
			}
			return sameCount;
		}
	}*/

}