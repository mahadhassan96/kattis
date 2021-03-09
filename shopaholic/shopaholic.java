import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class shopaholic{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Long[] arr = new Long[N];
		for(int i = 0; i < N; i++){
			arr[i] = in.nextLong();
		}
		in.close();
		
		Arrays.sort(arr,Collections.reverseOrder());

		long sum = 0;
		if(N % 3 != 0){ N--; }
		for(int i = 2; i < N; i+=3){
			sum = arr[i] + sum;
		}
		
		System.out.println(sum);
	}
}