
package stockmanager;

import java.util.ArrayList;
import java.util.Scanner;

import stocks.Stock;
import stocks.Stocks;
public class StockManager {
Stocks stocks;
	
	StockManager() {
		Scanner sc = new Scanner(System.in);
		getStockDetailsFromUser(sc);
		boolean isExitOption = false;
		do {
			printOperationMessages();
			isExitOption = DoOperations(sc, sc.nextInt());
		}while(!isExitOption);
		
	}
	
	private void getStockDetailsFromUser(Scanner sc) {
		System.out.println("enter the no of companies :");
		int totalCompanies = sc.nextInt();
		ArrayList<Stock> theStocks = new ArrayList<Stock>();
		stocks = new Stocks();
		
		for(int i = 1; i <= totalCompanies; i++){
			Stock stock = new Stock();
			System.out.println("Enter current stock price of the company " + i + " :");
			double stockPrice = sc.nextDouble();
			stock.setPrice(stockPrice);
			
			boolean isValidString = true;
			do {
				System.out.println("Whether company's stock price rose today compare to yesterday? ");
				String risingState = sc.next();
				isValidString = stock.setRisingState(risingState);
				if(!isValidString) {
					System.out.println("Invalid String. Enter only \"true\" or \"false\".");
				}
				else {
					theStocks.add(stock);
					stocks.incrementRisingStocksCount(stock);
				}
			}while(!isValidString);
		}
		stocks.setStocks(theStocks);
		stocks.mergeSort();
	}
	
	private void printOperationMessages() {
		System.out.println("Enter the operation that you want to perform\r\n" + 
				"1. Display the companies stock prices in ascending order\r\n" + 
				"2. Display the companies stock prices in descending order\r\n" + 
				"3. Display the total no of companies for which stock prices rose today\r\n" + 
				"4. Display the total no of companies for which stock prices declined today\r\n" + 
				"5. Search a specific stock price\r\n" + 
				"6. press 0 to exit");
	}
	
	private boolean DoOperations(Scanner sc, int ch) {
		switch(ch)
		{
		case 1:
			System.out.println("Stock prices in ascending order are :");
			stocks.displayStockPricesInAscendingOrder();
			break;
		case 2:
			System.out.println("Stock prices in descending order are :");
			stocks.displayStockPricesInDescendingOrder();
			break;
		case 3:
			System.out.println("Total no of companies whose stock price rose today :" + stocks.getRisingStocksCount());
			break;
		case 4:
			System.out.println("Total no of companies whose stock price declined today :" + stocks.getDecreasingStocksCount());
			break;
		case 5:
			System.out.println("Enter the key value :");
			double value = sc.nextDouble();
			if(stocks.isStockPriceAvailable(value))
				System.out.println("Stock of value " + value + "is present");
			else
				System.out.println("Value not found");
			break;
		case 0:
		
				System.out.println("Exited successfully");
		
			return true;
		default:
			System.out.println("Invalid Input. Enter only from 1 to 6.");
			return false;
		}
		
		return false;
	}
}
