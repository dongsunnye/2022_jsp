package dto;

public class EmployeeDTO {
	private String eno;
	private String name;
	private String dept;
	private int position;
	private int salary;
	public EmployeeDTO(String eno, String name, String dept, int position, int salary) {
		super();
		this.eno = eno;
		this.name = name;
		this.dept = dept;
		this.position = position;
		this.salary = salary;
	}
	public EmployeeDTO() {
		super();
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", name=" + name + ", dept=" + dept + ", position=" + position + ", salary="
				+ salary + "]";
	}

	
	
}
