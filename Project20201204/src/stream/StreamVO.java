package stream;

public class StreamVO {
	private String firstName;
	private int id;
	private String email;
	private int salary;

	public StreamVO(String firstName, int id, String email, int salary) {
		super();
		this.firstName = firstName;
		this.id = id;
		this.email = email;
		this.salary = salary;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void showEmpInfo() {
		System.out.println("사원번호: " + id + "사원이름: " + firstName + "이메일: " + email + "급여" + salary);
	}

}
