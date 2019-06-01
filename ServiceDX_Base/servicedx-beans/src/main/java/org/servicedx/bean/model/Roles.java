package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles extends CommonCustomerBean
{

	private static final long	serialVersionUID	= 5740245114472539999L;

	protected String			roleId;

	protected String			roleName;

	public Roles()
	{
		super();
	}

	public Roles(String roleId)
	{
		super();
		this.roleId = roleId;
	}

	public Roles(String roleId, String roleName)
	{
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	@Id
	@Column(name = "roleid")
	public String getRoleId()
	{
		return roleId;
	}

	@Column(name = "rolename")
	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

}