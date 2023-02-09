package util;

public class Program {

	public static void main(String[] args) {
		String s = "my java Program";
		String[] s2 = s.split(" ");
		for (int i = 0; i < s2.length; i++) {

			String s3 = s2[i].substring(0, 1).toUpperCase() + s2[i].substring(1);

			System.out.print(s3 + " ");

		}
	}
}
