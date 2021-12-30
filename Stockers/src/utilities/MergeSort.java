package utilities;

import java.util.ArrayList;

import stocks.Stock;

public class MergeSort {
	void merge(ArrayList<Stock> stocks, int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;

		ArrayList<Stock> L= new ArrayList<Stock>(n1);
		ArrayList<Stock> R= new ArrayList<Stock>(n2);

		for (int i = 0; i < n1; ++i)
			L.add(i, stocks.get(l + i));
		for (int j = 0; j < n2; ++j)
			R.add(j, stocks.get(m + 1 + j));

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L.get(i).getPrice() <= R.get(j).getPrice()) {
				stocks.set(k, L.get(i));
				i++;
			}
			else {
				stocks.set(k, R.get(j));
				j++;
			}
			k++;
		}

		while (i < n1) {
			stocks.set(k, L.get(i));
			i++;
			k++;
		}

		while (j < n2) {
			stocks.set(k, R.get(j));
			j++;
			k++;
		}
	}

	public void sort(ArrayList<Stock> stocks, int l, int r)
	{
		if (l < r) {
			int m =l+ (r-l)/2;
  
			sort(stocks, l, m);
			sort(stocks, m + 1, r);
  
			merge(stocks, l, m, r);
		}
	}
}

