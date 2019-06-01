package org.servicedx.bean.model;

public interface ITemplate extends ICommonCustomerBean
{

	public long getTemplateId();

	public String getMessageText();

	public String getMessageType();

	public String getMessageName();

	public String getMessageSubject();

	public void setTemplateId(long templateId);

	public void setMessageText(String messageText);

	public void setMessageType(String messageType);

	public void setMessageName(String messageName);

	public void setMessageSubject(String messageSubject);

}