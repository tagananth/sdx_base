package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message extends CommonCustomerBean implements IMessage
{
	private static final long	serialVersionUID	= -8117066273433451132L;

	private long				messageId;

	private String				sendId;

	private String				instanceId;

	private long				userId;

	private String				userName;

	private long				groupId;

	private String				groupName;

	private long				configurationId;

	private String				configurationName;

	private String				type;

	private String				source;

	private String				emailId;

	private String				mobileNumber;

	private long				templateId;

	private String				message;
	
	private String				subject;

	private String				messageStatus;

	@Id
	@Column(name = "messageid")
	public long getMessageId()
	{
		return messageId;
	}

	@Column(name = "sendid")
	public String getSendId()
	{
		return sendId;
	}

	@Column(name = "instanceid")
	public String getInstanceId()
	{
		return instanceId;
	}

	@Column(name = "userid")
	public long getUserId()
	{
		return userId;
	}

	@Column(name = "username")
	public String getUserName()
	{
		return userName;
	}

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

	@Column(name = "configurationid")
	public long getConfigurationId()
	{
		return configurationId;
	}

	@Column(name = "configurationname")
	public String getConfigurationName()
	{
		return configurationName;
	}

	@Column(name = "type")
	public String getType()
	{
		return type;
	}

	@Column(name = "source")
	public String getSource()
	{
		return source;
	}

	@Column(name = "emailid")
	public String getEmailId()
	{
		return emailId;
	}

	@Column(name = "mobileno")
	public String getMobileNumber()
	{
		return mobileNumber;
	}

	@Column(name = "templateid")
	public long getTemplateId()
	{
		return templateId;
	}

	@Column(name = "message")
	public String getMessage()
	{
		return message;
	}
	
	@Column(name = "subject")
	public String getSubject()
	{
		return subject;
	}

	@Column(name = "messagestatus")
	public String getMessageStatus()
	{
		return messageStatus;
	}

	public void setMessageId(long messageId)
	{
		this.messageId = messageId;
	}

	public void setSendId(String sendId)
	{
		this.sendId = sendId;
	}

	public void setInstanceId(String instanceId)
	{
		this.instanceId = instanceId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public void setGroupId(long groupId)
	{
		this.groupId = groupId;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	public void setConfigurationId(long configurationId)
	{
		this.configurationId = configurationId;
	}

	public void setConfigurationName(String configurationName)
	{
		this.configurationName = configurationName;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}

	public void setTemplateId(long templateId)
	{
		this.templateId = templateId;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public void setMessageStatus(String messageStatus)
	{
		this.messageStatus = messageStatus;
	}


}
