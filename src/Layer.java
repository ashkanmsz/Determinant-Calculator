import java.util.Scanner;

/**
 * This is a program for layer sum
 * 
 * @author ashkan
 * @since 19/10/2018
 */

public class Layer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();// the input String
		layerSum(s);
		sc.close();

	}

	public static void layerSum(String s) {

		String arr[] = new String[s.length()];// this is a array for putting numbers of each level
		int c1 = 0, c2 = 0, x = 0, a = 0;
		String s2 = "";// this string is for substring of arrival string

		for (int i = 0; i < arr.length; i++)
			arr[i] = "";

		for (int i = 1; i < s.length() - 1; i++) {

			if (s.charAt(i) == '{')
				c1++;
			else if (s.charAt(i) == '}')
				c2++;
			else if (s.charAt(i) != ',')// if we reach to number exept '{' ',' '}'
				arr[x] += s.charAt(i);
			else
				x++;// update index for next time

			if (c1 != c2)
				s2 += s.charAt(i);// getting the substring

			else if (c1 != 0 && c2 != 0) {// send the substring for minimizing
				s2 += s.charAt(i);
				c1 = 0;
				c2 = 0;
				layerSum(s2);
				s2 = "";
			}
		}

		for (int i = 0; i < arr.length; i++)// add the members of the array list
			if (!arr[i].equals(""))
				a += Integer.parseInt(arr[i]);
		System.out.println(a);
	}
}
