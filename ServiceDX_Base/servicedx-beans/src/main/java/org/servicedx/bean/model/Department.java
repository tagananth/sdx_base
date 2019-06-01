package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department extends CommonCustomerBean implements IDepartment
{

	private static final long serialVersionUID = -6901157598979563566L;

	protected long				departmentId;

	protected String			departmentName;

	@Column(name="departmentid")
	public long getDepartmentId()
	{
		return departmentId;
	}

	public void setDepartmentId(long departmentId)
	{
		this.departmentId = departmentId;
	}
	
	@Column(name="departmentname")
	public String getDepartmentName()
	{
		return departmentName;
	}

	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}


}
