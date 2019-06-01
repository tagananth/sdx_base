package org.servicedx.bean.model;

public interface IDepartment extends ICommonCustomerBean
{
	public long getDepartmentId();

	public String getDepartmentName();

	public void setDepartmentId(long DepartmentId);

	public void setDepartmentName(String DepartmentName);

}