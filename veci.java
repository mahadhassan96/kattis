import java.util.*;
import java.util.Scanner;

/*
 * Your program will be given an integer X. Find the smallest number larger than X consisting of the same digits as X.
 * The first line of input contains the integer X (1≤X≤999999). The first digit in X will not be a zero.
*/

public class veci{
	/*Converts int array into an integer*/
	private static int int_from_arr(int[] arr){
		int ret = 0;
		int t = 1;
		for(int i = arr.length-1; i >= 0; i--){
			ret = (arr[i]*t) + ret;
			t *= 10;
		}
	
		return ret;
	}
	
	/*Returns order of magnitude of a numeric value*/
	public static int order_of_mag(int num){
		int t = 1;
		while(num/10 != 0){
			num = num / 10;
			t++;
		}
		return t;
	}
	
	/*exchanges elements in an array*/
	public static void exch(int[] arr, int a, int b){
		int swap = arr[a];
		arr[a] = arr[b];
		arr[b] = swap;
	}
	
	/*insertion sort*/
	private static void sort(int[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i+1; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
	
	/*Finds the smallest number larger than X consisting of the same digits as X*/
	public static int veci(int[] arr){
		int k = arr.length-1;
		int l = k;
		int j = arr.length-1;
		
		while(k > 0){
			--k;
			if(arr[k] < arr[j]){
				exch(arr,k,j);	
				sort(arr,k+1,arr.length-1);
				break;
			}
			if(k == 0){
				j--;
				k = l-1;
				l--;
			}
		}
		
		return int_from_arr(arr);
	}
	
	public static boolean less(int a, int b){
		return a < b;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Type number: ");
		int X = in.nextInt();
		
		int t = order_of_mag(X);

		//fill array with individual numbers
		int[] arr = new int[t];
		int ten = 10;
		for(int i = t-1; i >= 0; i--){
			arr[i] = X % ten;
			X /= ten;
		}
		
		//sorting 
		int res = veci(arr);
		System.out.print(res);
	}
}