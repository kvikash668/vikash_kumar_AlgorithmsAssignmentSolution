package utilities;



import java.util.ArrayList;

import stocks.Stock;

public class BinarySearch {
	
	public boolean containsStockPrice(ArrayList<Stock> sortedStocks, double value) 
	{
		return containsValue( sortedStocks, value, 0, sortedStocks.size() - 1 );
	}
	
	private boolean containsValue(ArrayList<Stock> sortedStocks, double value, int start, int end) {
		if(start > end)
			return false;
		
		int pos = (start + end) / 2;
		Stock stock = sortedStocks.get(pos);
		
		if(stock.getPrice() == value) {
			return true;
		}	
		else if(stock.getPrice() > value) {
			return containsValue( sortedStocks, value, start, pos-1);
		}
		else {
			return containsValue( sortedStocks, value, pos+1, end);
		}
	}
}