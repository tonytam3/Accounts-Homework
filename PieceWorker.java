
public class PieceWorker extends Employee {
	
	private double wage;
	private int pieces;
	
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces, int month, int day, int year){
		super(firstName, lastName, socialSecurityNumber, month, day, year);
		
		if (wage< 0.0)
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		
		if (pieces< 0)
			throw new IllegalArgumentException("Pieces must be >= 0.0");
		
		this.wage = wage;
		this.pieces = pieces;
	}
	
	

	public double getWage() {
		return wage;
	}



	public int getPieces() {
		return pieces;
	}
	
	
	public void setWage(double wage) {
		if (wage <0.0)
			throw new IllegalArgumentException("hourly Wage must be >= 0.0");
		
		this.wage = wage;
	}



	public void setPieces(int pieces) {
		if (pieces< 0)
			throw new IllegalArgumentException("Pieces must be >= 0.0");
		
		this.pieces = pieces;
	}



	@Override
	public double earnings() {
		return getWage()*getPieces();
	}
	
	@Override
	public String toString() {
		return String.format("Piece employee: %s%n%s: $%,.2f; %s: %d", super.toString(), "Piece wage", getWage(),"Pieces worked", getPieces());
	}
}
