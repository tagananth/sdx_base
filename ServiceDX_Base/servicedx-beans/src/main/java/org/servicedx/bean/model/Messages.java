package org.servicedx.bean.model;

import java.io.Serializable;

public class Messages implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5159164784139310335L;
	
	public String apiMessageId;
	public boolean accepted;
	public String to;
	public String errorCode;
	public String error;
	public String errorDescription;
	//Need to  check Extra param
	public String status;
	public String getApiMessageId()
	{
		return apiMessageId;
	}
	public void setApiMessageId(String apiMessageId)
	{
		this.apiMessageId = apiMessageId;
	}
	public boolean isAccepted()
	{
		return accepted;
	}
	public void setAccepted(boolean accepted)
	{
		this.accepted = accepted;
	}
	public String getTo()
	{
		return to;
	}
	public void setTo(String to)
	{
		this.to = to;
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
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	

}
