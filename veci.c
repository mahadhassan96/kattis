#include <stdio.h>
#include <math.h> 

int main(){
	int arr[6];
	int x;
	int f = 1;
	int size;
	printf("Input number \n");
	scanf("%d", &x);
	
	//breakdown integer to elements
	for(int i = 0; i < 6; i++){
		arr[i] = x%10;
		x = x%10;
	}
	
	//find size of element and number of permutations
	for(int j = 5; j >= 0; j--){
		if((arr[j] == 0) && (arr[j-1] != 0)){
			size = j;
			for(int k = 1; k <= j; k++){
				f = f*k;
			}
		}
	}
	
	
}

//  {0,0,0,1,4,1}

https://open.kattis.com/problems/veci