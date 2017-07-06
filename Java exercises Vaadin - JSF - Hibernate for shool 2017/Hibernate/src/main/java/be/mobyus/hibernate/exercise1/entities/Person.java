package be.mobyus.hibernate.exercise1.entities;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private Long id;
	private String name;
	private String firstName;

	private List<Address> address = new ArrayList();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(final List<Address> address) {
		this.address = address;
	}
}
