package com.SpringCRUD2.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="dept")
public class department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer deptId;
	@Column
	private String deptName;
	
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("department")
	private List<employee>employees;
	
	public department() {
		
	}

	public department(Integer deptId, String deptName, List<employee> employees) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.employees = employees;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
	    return "department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}

}
