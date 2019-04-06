
public class PayrollSystemTest {
	public static void main(String[] args) {
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith","111-11-1111",800.00, 1, 2, 2011);
		
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen","Price","222-22-2222",16.75, 40, 2, 3, 2012);
		
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue","Jones","333-33-3333",10000,.06, 3, 4, 2013);
		
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob","Lewis","444-44-4444",5000,.04,300, 4, 5, 2014);
		
		PieceWorker pieceWorker = new PieceWorker("TEST", "SUBJECT", "555-55-5555", 20.00, 5, 5, 6, 2015);
		
		
		System.out.println("Employees precessed individually:");
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee,"earned",salariedEmployee.earnings());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", hourlyEmployee,"earned",hourlyEmployee.earnings());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", commissionEmployee,"earned",commissionEmployee.earnings());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee,"earned",basePlusCommissionEmployee.earnings());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", pieceWorker,"earned",pieceWorker.earnings());
		
		Employee[] employees = new Employee[5];
		
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		employees[4] = pieceWorker;
		
		double[][] monthlyPay = new double[5][12]; 
		
		for (int j = 0; j<monthlyPay.length; j++) {
			for(int i = 0; i<12; i++) {
				monthlyPay[j][i]= employees[j].earnings()*4;
				if(employees[j].getMonth()==i) {
					monthlyPay[j][i] = monthlyPay[j][i]+100;
				}
			}
		}
		
		System.out.println("Employee processed polymorphically:\n");
		
		for (Employee currentEmployee : employees) {
			System.out.println(currentEmployee);
			
			if (currentEmployee instanceof BasePlusCommissionEmployee) {
				BasePlusCommissionEmployee employee =(BasePlusCommissionEmployee) currentEmployee;
				
				employee.setBaseSalary(1.10 *employee.getBaseSalary());
				
				System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			}
			
			System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
		}
		
		for(int j = 0; j<employees.length; j++) {
			System.out.printf("Employee %d is a %s%n", j,employees[j].getClass().getName());
			
			for(int i = 0; i<12; i++) {
				System.out.printf("\tMonth %02d: $%.2f%n", i+1, monthlyPay[j][i]);
			}
		}
	}
}
