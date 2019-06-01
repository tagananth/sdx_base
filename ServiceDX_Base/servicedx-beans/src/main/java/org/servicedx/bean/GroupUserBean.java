package org.servicedx.bean;

import java.io.Serializable;

import org.servicedx.security.resource.IPath.EMediaType;

public class GroupUserBean implements Serializable, Cloneable
{

	private static final long	serialVersionUID	= 5493821825367197241L;

	private String				emailId				= "";

	private String				emailId1			= "";

	private long				groupId;

	private String				groupName			= "";

	private String				mobileNo			= "";

	private String				mobileNo1			= "";

	private long				userId;
	
	private String				userName			= "";

	private EMediaType			userContact			= EMediaType.Primary;

	private GroupUserBean		groupUserBean		= null;

	public GroupUserBean()
	{
		super();
		this.groupUserBean = null;
	}

	public GroupUserBean(GroupUserBean groupUserBean)
	{
		super();
		this.groupUserBean = groupUserBean;
	}

	public GroupUserBean(long userId,String userName, String emailId, String emailId1, String mobileNo, String mobileNo1)
	{
		super();
		this.emailId = emailId;
		this.emailId1 = emailId1;
		this.mobileNo = mobileNo;
		this.mobileNo1 = mobileNo1;
		this.userId = userId;
		this.userName = userName;
		this.groupUserBean = null;
	}
	
	public GroupUserBean(long groupId,String groupName)
	{
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupUserBean = null;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public String getEmailId1()
	{
		return emailId1;
	}

	public long getGroupId()
	{
		return groupId;
	}

	public String getGroupName()
	{
		return groupName;
	}

	public String getMobileNo()
	{
		return mobileNo;
	}

	public String getMobileNo1()
	{
		return mobileNo1;
	}

	public long getUserId()
	{
		return userId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public void setEmailId1(String emailId1)
	{
		this.emailId1 = emailId1;
	}

	public void setGroupId(long groupId)
	{
		this.groupId = groupId;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}

	public void setMobileNo1(String mobileNo1)
	{
		this.mobileNo1 = mobileNo1;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	
	public EMediaType getUserContact()
	{
		return userContact;
	}

	public void setUserContact(EMediaType userContact)
	{
		this.userContact = userContact;
	}

	public GroupUserBean getGroupUserBean()
	{
		return groupUserBean;
	}

	public void setGroupUserBean(GroupUserBean groupUserBean)
	{
		this.groupUserBean = groupUserBean;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

}
