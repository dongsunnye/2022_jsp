package dto;

public class EmployeeDTO {
	private String eno;
	private String name;
	private String department;
	private int positionNo;
	public EmployeeDTO(String eno, String name, String department, int positionNo) {
		super();
		this.eno = eno;
		this.name = name;
		this.department = department;
		this.positionNo = positionNo;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getPositionNo() {
		return positionNo;
	}
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", name=" + name + ", department=" + department + ", positionNo="
				+ positionNo + "]";
	}
	
	
}
