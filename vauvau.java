import java.util.*;
import java.util.Scanner;

/*
 * In a nearby village, the postman, milkman and garbage man face the same problem morning after morning: house 18. 
 * House 18 is guarded by two dogs that often cause problems. What they don’t know is that the dogs’ behaviour is completely predictable.
 * When the day starts, one dog is aggressive for A minutes and is then calm for B minutes. Similarly, the other dog is aggressive for C minutes, 
 * then calm for D minutes. Both dogs repeat their behaviours indefinitely, starting a new aggressive period after the calm period, then another calm period etc.
 * Given the arrival times of the postman, milkman and garbage man, determine how many dogs (none, one or both) attack each of them.
*/

public class vauvau{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] dogs = new int[4];
		int[] heroes = new int[3];
		char[] names = {'A', 'B', 'C', 'D', 'P', 'M', 'G'};
		boolean[] aggr = new boolean[6];
		
		//type in input
		for(int i = 0; i < 7; i++){
			System.out.print(" " + names[i] + ": ");
			if(i < 4){
				dogs[i] = in.nextInt();
			}
			else{
				heroes[i-4] = in.nextInt();
			}
		}

		//find max of heroes
		int max = heroes[0];
		for(int i = 0; i < heroes.length; i++)
			if(max < heroes[i])
				max = heroes[i];
			
		//check if dogs and heroes meet
		int j = 1;
		int h = 0;
		int l = 1;
		int m = 0;
		int i = 1;
		
		//find intersection of arrival time for men and dog attacks
		while(m < heroes.length){
			if(j <= dogs[l-1]){	//1-2 & 5-6
				aggr[h] = true;
			}
			else if(j > 1 && j <= dogs[l] + dogs[l-1]){	//3-4
				aggr[h] = false;
				if(j > dogs[l] + dogs[l-1]){ j = 1; }
			}
			j++; i++;
			if(i == heroes[m]+1){ 
				h++; l = l+2;  j = i = 1; 
				if(h % 2 == 0 && h != 0){
					m++;
					l = 1;
				}
			} 
		}

		//print none, one, both
		j = 4;
		for(i = 1; i < aggr.length; i=i+2){
			if(aggr[i-1] == true && aggr[i] == true) System.out.println(names[j] + ": both");
			else if((aggr[i-1] == true && aggr[i] == false) || (aggr[i-1] == false && aggr[i] == true)) System.out.println(names[j] + ": one");
			else System.out.println(names[j] + ": none");
			j++;
		}  
	}
}