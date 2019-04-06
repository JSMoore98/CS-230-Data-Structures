import java.util.Random;

public class MergingLists {

	public static void main(String[] args) {
		int[] A = new int[25];
		int[] B = new int[25];
		ABList<Integer> C = new ABList<Integer>();
		Random random = new Random();
		int i,j;
		
		for(i=0; i<A.length; i++)
			A[i] = random.nextInt(100);
		for(j=0; j<B.length; j++)
			B[j] = random.nextInt(100);
		
		A = bubbleSort(A);
		B = bubbleSort(B);
		
		//Test Output
		/*for(i=0; i < A.length; i++)
			System.out.print(A[i] + ", ");
		System.out.println();
		for(i=0; i < B.length; i++)
			System.out.print(B[i] + ", ");
		System.out.println();
		*/
			
		//Merges the two lists
		i = j = 0;
		while(i < A.length && j < B.length) {
			if (A[i] <= B[j])
				C.insert(A[i++]);
			else
				C.insert(B[j++]);
		}
		
		while (i < A.length)
			C.insert(A[i++]);
		
		while (i < B.length)
			C.insert(B[j++]);
		
		System.out.println(C);
	
	}

	/**
	 * Performs bubble sorting on the passed array
	 */
	public static int[] bubbleSort(int[] X) {
		int pass, i, temp;

		for (pass = 1; pass <= X.length; pass++) {
			for (i = 0; i < X.length - 1; i++)
				if (X[i] > X[i + 1]) {
					temp = X[i];
					X[i] = X[i + 1];
					X[i + 1] = temp;
				}
		}
		return X;
	}
}