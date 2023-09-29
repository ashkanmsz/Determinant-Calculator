import java.util.Scanner;

/**
 * 
 * @author ashkan
 * @since 19/10/2018
 * 
 *        this program is for finding the layer sum
 */
public class Determinan {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int size = sc.nextInt(), index = 0;// size is the size of matrix and index is for finding the point(aeshar)

		String mat[][] = new String[size][size];
		String satr[] = new String[size];// this array is for changing each row of arrival string to row of matrix

		for (int i = 0; i < size; i++) {
			String s = sc2.nextLine();
			satr = s.split(" ");

			for (int j = 0; j < size; j++)
				mat[i][j] = satr[j];
		}
		String s2 = String.valueOf(det(mat, size));// change the doubale value of det to string for its point(aeshar)

		for (int i = 0; i < s2.length(); i++) {// finding the index of point
			
			if (s2.charAt(i) == '.') {
				index = i;
				break;
			}
		}
		System.out.println(s2);

		int m = (s2.length() - 1) - index;
		
		switch (m) {
		case 1: {// this case is for : if we have one digit after point
			s2 += "00";
			break;
		}
		case 2: {
			s2 += "0";// this case is for : if we have two digit after point
			break;
		}

		default: {
			s2 = s2.substring(0, index + 4);//// this is for : if we have more than three digit after point
			break;
		}
		}

		System.out.println("det= " + s2);

		sc.close();
		sc2.close();
	}

	public static double det(String mat[][], int size) {

		double a = 0;
		int b = 0;

		if (mat.length == 1)// it's the finish condition
			return Double.parseDouble(mat[0][0]);

		String temp[][] = new String[size - 1][size - 1];// this is a 2D array for sub matrixs

		for (int j = 0; j < size; j++) {
			
			int x2 = 0, y2 = 0;// these are indexes of our sub matrix

			for (int x = 0; x < size; x++)
				for (int y = 0; y < size; y++)

					if (x != 0 && y != j) {// this condition remove the row and the column of selected section and copy
											// it in new array
						temp[x2][y2] = mat[x][y];
						y2++;
						if (y2 == size - 1) {
							x2++;
							y2 = 0;
						}
					}

			a += Double.parseDouble(mat[0][j]) * Math.pow(-1, j + 2) * det(temp, b = size - 1);// the formula of
																								// claculating the det
		}
		return a;
	}

}
