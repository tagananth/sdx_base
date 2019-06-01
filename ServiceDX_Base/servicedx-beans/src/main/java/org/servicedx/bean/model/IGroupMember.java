package org.servicedx.bean.model;

public interface IGroupMember extends ICommonCustomerBean
{

	public long getGroupMemberId();

	public long getGroupId();

	public String getGroupName();

	public long getUserId();

	public String getUserName();

	public String getUserContact();
	
	public String getType();

	public void setGroupMemberId(long groupMemberId);

	public void setGroupId(long groupId);

	public void setGroupName(String groupName);

	public void setUserId(long userId);

	public void setUserName(String userName);

	public void setUserContact(String userContact);

	public void setType(String type);

}