package org.ytheohar.salary;

public class Employee {
	private int id;
	private String user;
	private float salary;

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(final String user) {
		this.user = user;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(final float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=").append(id).append(", user=").append(user).append(", salary=").append(salary).append("]");
		return builder.toString();
	}
}
