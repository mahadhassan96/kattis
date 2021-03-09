import java.util.*;
import java.util.Scanner;

public class twostones{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int stone = in.nextInt();
	
		if(stone % 2 == 0){
			System.out.print("Bob");
		}
		else{
			System.out.print("Alice");
		}
	}
}