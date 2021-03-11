// loowater.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Status: Completed

#include <iostream>
#include <algorithm>

bool compare_function(int a, int b) {
	return a > b;
}

int main()
{
	for (int i = 0; i < 5; i++) {
		int n, m;
		std::cin >> n >> m;
		if (n == 0 && m == 0) { return 0; }

		int* n_arr = new int[n];
		int* m_arr = new int[m];
		int* o_arr = new int[n];

		for (int j = 0; j < n; j++) { std::cin >> n_arr[j]; }
		for (int k = 0; k < m; k++) { std::cin >> m_arr[k]; }
		
		if (n <= m) {
			std::sort(n_arr, n_arr + n, compare_function);
			std::sort(m_arr, m_arr + m, compare_function);

			int cntr = 0;
			if (n_arr[0] <= m_arr[0]) {
				for (int i = 0; i < m; i++) {
					if (n_arr[n - 1] <= m_arr[i]) {
						cntr++;
					}
				}
			}
			else {
				goto doomed;
			}

			int a = cntr - 1;
			int b = n - 1;
			int cost = 0;
			for (int i = b; i >= 0; i--) {
				while (m_arr[a] < n_arr[i]) {
					a--;
				}
				if (a < 0) { goto doomed; }
				cost = cost + m_arr[a];
				a--;
			}

			std::cout << cost << std::endl;
		}
		else {
			doomed:
			std::cout << "Loowater is doomed!" << std::endl;
		}
	}
}