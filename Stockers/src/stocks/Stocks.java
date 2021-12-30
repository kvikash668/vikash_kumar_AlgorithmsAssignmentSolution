package stocks;


import java.util.ArrayList;

import utilities.BinarySearch;
import utilities.MergeSort;

public class Stocks {
	private ArrayList<Stock> stocks = new ArrayList<Stock>();
	private int risingStocksCount;
	
	public ArrayList<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(ArrayList<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public void incrementRisingStocksCount(Stock stock) {
		if(stock.getRisingState().equalsIgnoreCase("true"))
			risingStocksCount++;
	}
	
	public int getRisingStocksCount() {
		return risingStocksCount;
	}
	
	public int getDecreasingStocksCount() {
		return stocks.size() - risingStocksCount;
	}

	public boolean isStockPriceAvailable(double stockPrice) {
		BinarySearch binarySearch = new BinarySearch();
		return binarySearch.containsStockPrice(stocks, stockPrice);
	}
	
	public void mergeSort(){
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(stocks, 0, stocks.size()-1);
	}
	
	public void displayStockPricesInAscendingOrder() {
		for(int i = 0; i < stocks.size(); i++) {
			System.out.print(stocks.get(i).getPrice() + " " );
		}
		System.out.println();
	}
	public void displayStockPricesInDescendingOrder() {
		for(int i = stocks.size()-1; i >= 0; i--) {
			System.out.print(stocks.get(i).getPrice() + " " );
		}
		System.out.println();
	}
}
