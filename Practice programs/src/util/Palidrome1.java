package util;

import java.util.Scanner;

public class Palidrome1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = scanner.nextInt();
		int r, sum = 0, temp;
		temp=num;
		for(int i=0;i<num;i++)
		{
			r=num%10;
			System.out.println("r value:"+ r);
			sum=(sum*10)+r;
			System.out.println("sum value:"+sum);
			num=num/10;
			System.out.println("num value:"+num);
			
		}
		if(temp==sum)
		{
			System.out.println("palidrome");
			
		}
		else
		{
			System.out.println("not palindrome");
		}


	}

}
