package org.servicedx.bean;

import java.util.List;

import org.servicedx.bean.model.Department;
import org.servicedx.bean.model.Users;
import org.springframework.security.core.Authentication;

public class DepartmentFormBean extends APIStatus
{

	private static final long	serialVersionUID	= -1597093081533091318L;

	public Department			department			= new Department();
	public Department			repodepartment;
	public List<Users>			userList;

	public void updateRepoDepartment(Authentication auth)
	{
		repodepartment.setActive(department.isActive());
		repodepartment.setComments(department.getComments());
		repodepartment.setDepartmentName(department.getDepartmentName());
		repodepartment.modifiedUserInfo(auth);
	}
}
