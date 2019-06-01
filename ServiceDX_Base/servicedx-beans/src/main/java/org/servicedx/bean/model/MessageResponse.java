package org.servicedx.bean.model;

import java.io.Serializable;

public class MessageResponse implements Serializable
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3365731233035235636L;

	public Messages[]			messages;
	public String				errorCode;
	public String				error;
	public String				errorDescription;
	public Messages[] getMessages()
	{
		return messages;
	}
	public void setMessages(Messages[] messages)
	{
		this.messages = messages;
	}
	public String getErrorCode()
	{
		return errorCode;
	}
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}
	public String getError()
	{
		return error;
	}
	public void setError(String error)
	{
		this.error = error;
	}
	public String getErrorDescription()
	{
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription)
	{
		this.errorDescription = errorDescription;
	}
	
}
