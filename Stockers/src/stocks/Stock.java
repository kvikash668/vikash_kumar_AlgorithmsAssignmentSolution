package stocks;

public class Stock {
	private double price;
	private String risingState;
	
	public String getRisingState() {
		return risingState;
	}
	
	public boolean setRisingState(String risingState) {
		if(risingState.trim().equalsIgnoreCase("true") || risingState.trim().equalsIgnoreCase("false") ) {
			this.risingState = risingState.trim();
			return true;
		}
		return false;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean isRisingStock() {
		if(risingState.equalsIgnoreCase("true")) {
			return true;
		}
		else if(risingState.equalsIgnoreCase("false")) {
			return false;
		}
		
		return false;
	}
}
