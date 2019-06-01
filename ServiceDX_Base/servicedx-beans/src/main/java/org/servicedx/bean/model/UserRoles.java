package org.servicedx.bean.model;

public class UserRoles
{
	protected long		autoId;
	protected IUsers	user;
	protected Roles		role;
	protected String	employeeId;
	protected String	roleId;

	public UserRoles()
	{
		super();
	}

	public UserRoles(long autoId, String employeeId, String roleId)
	{
		super();
		this.autoId = autoId;
		this.employeeId = employeeId;
		this.roleId = roleId;
		this.user = new Users(this.employeeId);
		this.role = new Roles(this.roleId);
	}

	public long getAutoId()
	{
		return autoId;
	}

	public void setAutoId(long autoId)
	{
		this.autoId = autoId;
	}

	public IUsers getUser()
	{
		return user;
	}

	public void setUser(IUsers user)
	{
		this.user = user;
	}

	public Roles getRole()
	{
		return role;
	}

	public void setRole(Roles role)
	{
		this.role = role;
	}

	public String getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId(String employeeId)
	{
		this.employeeId = employeeId;
	}

	public String getRoleId()
	{
		return roleId;
	}

	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}

}
