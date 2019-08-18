package com.banksteel.bean;

public class User {
	private String userName;
	private Integer age;
	private Double salary;
	
	private Address address;

	public User() {
		super();
	}

	public User(String userName, Integer age, Double salary) {
		super();
		this.userName = userName;
		this.age = age;
		this.salary = salary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + ", salary=" + salary + ", address=" + address + "]";
	}

}
