package org.servicedx.bean.model;

import org.servicedx.util.ICRUDBean;

public interface IMessage extends ICRUDBean
{

	public long getMessageId();

	public String getSendId();

	public String getInstanceId();

	public long getUserId();

	public String getUserName();

	public long getGroupId();

	public String getGroupName();

	public long getConfigurationId();

	public String getConfigurationName();

	public String getType();

	public String getSource();

	public String getEmailId();

	public String getMobileNumber();

	public long getTemplateId();

	public String getMessage();

	public String getSubject();
	
	public String getMessageStatus();

	public void setMessageId(long messageId);

	public void setSendId(String sendId);

	public void setInstanceId(String instanceId);

	public void setUserId(long userId);

	public void setUserName(String userName);

	public void setGroupId(long groupId);

	public void setGroupName(String groupName);

	public void setConfigurationId(long configurationId);

	public void setConfigurationName(String configurationName);

	public void setType(String type);

	public void setSource(String source);

	public void setEmailId(String emailId);

	public void setMobileNumber(String mobileNumber);

	public void setTemplateId(long templateId);

	public void setMessage(String message);
	
	public void setSubject(String subject);

	public void setMessageStatus(String messageStatus);

}