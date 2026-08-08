package entities;

public class Bill {
	public char gender;
	public int beer;
	public int barbecue;
	public int softDrink;
	
	public double cover() {
		return feeding() > 30 ? 0.00 : 4.00;
	}
	
	public double feeding() {
		return beer * 5 + barbecue * 7 + softDrink * 3;
	}
	
	public double ticket() {
		return gender == 'M' ? 10.00 : 8.00;
	}
	
	public double total() {
		return feeding() + ticket() + cover();
	}
}
