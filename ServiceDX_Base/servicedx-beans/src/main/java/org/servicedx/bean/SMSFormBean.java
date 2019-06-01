package org.servicedx.bean;

import java.io.Serializable;

import org.servicedx.bean.model.Configuration;
import org.servicedx.bean.model.MessageContent;

public class SMSFormBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3863538897425589523L;

	public Configuration configuration;
	
	public MessageContent  messageContent;
	
	public String status;
	
	public String sendId;

	public Configuration getConfiguration()
	{
		return configuration;
	}

	public void setConfiguration(Configuration configuration)
	{
		this.configuration = configuration;
	}

	public MessageContent getMessageContent()
	{
		return messageContent;
	}

	public void setMessageContent(MessageContent messageContent)
	{
		this.messageContent = messageContent;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getSendId()
	{
		return sendId;
	}

	public void setSendId(String sendId)
	{
		this.sendId = sendId;
	}
	
	
	
}
