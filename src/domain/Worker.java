package domain;

public class Worker {

	private String employeeID;
	private String name;
	
	public Worker(String employeeID, String name){
		this.employeeID = employeeID;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeID() {
		return employeeID;
	}
	
	
}
