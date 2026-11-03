package com.SpringCRUD2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="emp")
public class employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer eid;
	@Column
	private String firstName;
	@Column
	private String lastNmae;
	@Column
	private String email;
	
	@ManyToOne
	@JoinColumn(name="deptId")
	@JsonIgnoreProperties("employees")
	private department department;
	
	public employee() {
		
	}

	public employee(Integer eid, String firstName, String lastNmae, String email,
			com.SpringCRUD2.entities.department department) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.lastNmae = lastNmae;
		this.email = email;
		this.department = department;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNmae() {
		return lastNmae;
	}

	public void setLastNmae(String lastNmae) {
		this.lastNmae = lastNmae;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public department getDepartment() {
		return department;
	}

	public void setDepartment(department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "employee [eid=" + eid + ", firstName=" + firstName + ", lastNmae=" + lastNmae + ", email=" + email
				+ ", department=" + department + "]";
	}

	

}
