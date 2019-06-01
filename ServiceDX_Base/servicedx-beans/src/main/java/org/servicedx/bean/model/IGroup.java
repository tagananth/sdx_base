package org.servicedx.bean.model;

public interface IGroup extends ICommonCustomerBean
{
	public long getGroupId();

	public String getGroupName();

	public String getType();

	public void setGroupId(long groupId);

	public void setGroupName(String groupName);

	public void setType(String type);

}