package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "group")
public class Group extends CommonCustomerBean implements IGroup
{

	private static final long	serialVersionUID	= -647097802354872181L;

	protected long				groupId;

	protected String			groupName;

	protected String			type;

	@Column(name = "groupid")
	public long getGroupId()
	{
		return groupId;
	}

	@Column(name = "groupname")
	public String getGroupName()
	{
		return groupName;
	}

	@Column(name = "type")
	public String getType()
	{
		return type;
	}

	public void setGroupId(long groupId)
	{
		this.groupId = groupId;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	public void setType(String type)
	{
		this.type = type;
	}

}
