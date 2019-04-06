
public abstract class Employee extends Date{
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	
	
	public Employee(String firstName, String lastName, String socialSecurityNumber, int month, int day, int year) {
		super (month, day, year);
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s%nsocial security number: %s%nBirthday: %s", getFirstName(), getLastName(), getSocialSecurityNumber(),super.toString());	
	}
	
	public abstract double earnings();
}
