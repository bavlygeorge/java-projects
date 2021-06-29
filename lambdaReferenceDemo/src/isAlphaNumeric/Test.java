package isAlphaNumeric;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter a string: ");
		String str = sc.nextLine();
		sc.close();
		boolean state = t.checkString(str);
		state = str.chars().allMatch(Character::isLetter);
		System.out.println(state);

	}

	
	public boolean checkString(String s) {
		if(s.isEmpty() || s==null) {
			return false;
		}else {
			return true;
		}
	}
}
