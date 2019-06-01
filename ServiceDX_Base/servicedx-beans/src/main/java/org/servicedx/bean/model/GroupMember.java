package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "groupmember")
public class GroupMember extends CommonCustomerBean implements IGroupMember
{

	private static final long	serialVersionUID	= -5736531759548797968L;

	protected long				groupMemberId;

	protected long				groupId;

	protected String			groupName;

	protected long				userId;

	protected String			userName;

	protected String			userContact;

	protected String			parentGroupId;
	
	protected String 			type;

	@Override
	@Column(name = "groupmemberid")
	public long getGroupMemberId()
	{
		return groupMemberId;
	}

	@Override
	@Column(name = "groupid")
	public long getGroupId()
	{
		return groupId;
	}

	@Override
	@Column(name = "groupname")
	public String getGroupName()
	{
		return groupName;
	}

	@Override
	@Column(name = "userid")
	public long getUserId()
	{
		return userId;
	}

	@Override
	@Column(name = "username")
	public String getUserName()
	{
		return userName;
	}

	@Override
	@Column(name = "usercontact")
	public String getUserContact()
	{
		return userContact;
	}
	
	@Override
	@Column(name = "type")
	public String getType()
	{
		return type;
	}

	@Column(name = "parentgroupid")
	public String getParentGroupId()
	{
		return parentGroupId;
	}

	public void setParentGroupId(String parentGroupId)
	{
		this.parentGroupId = parentGroupId;
	}

	@Override
	public void setGroupMemberId(long groupMemberId)
	{
		this.groupMemberId = groupMemberId;
	}

	@Override
	public void setGroupId(long groupId)
	{
		this.groupId = groupId;
	}

	@Override
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	@Override
	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	@Override
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Override
	public void setUserContact(String userContact)
	{
		this.userContact = userContact;
	}
	
	@Override
	public void setType(String type)
	{
		this.type = type;
	}
}
