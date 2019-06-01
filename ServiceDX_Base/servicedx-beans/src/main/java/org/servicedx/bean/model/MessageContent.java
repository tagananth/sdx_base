package org.servicedx.bean.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageContent implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1702955718515965336L;

	public String[] to;
	
	public String content;


	public String[] getTo()
	{
		return to;
	}

	public void setTo(String[] to)
	{
		this.to = to;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	
	
}

