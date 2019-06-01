package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "template")
public class Template extends CommonCustomerBean implements ITemplate
{
	private static final long	serialVersionUID	= -8117066273433451132L;

	private long				templateId;

	private String				messageName;

	private String				messageSubject;

	private String				messageText;

	private String				messageType;

	@Id
	@Column(name = "templateid")
	public long getTemplateId()
	{
		return templateId;
	}

	@Column(name = "message")
	public String getMessageText()
	{
		return messageText;
	}

	@Column(name = "messagetype")
	public String getMessageType()
	{
		return messageType;
	}

	@Column(name = "messagename")
	public String getMessageName()
	{
		return messageName;
	}

	@Column(name = "messagesubject")
	public String getMessageSubject()
	{
		return messageSubject;
	}

	public void setTemplateId(long templateId)
	{
		this.templateId = templateId;
	}

	public void setMessageText(String messageText)
	{
		this.messageText = messageText;
	}

	public void setMessageType(String messageType)
	{
		this.messageType = messageType;
	}

	public void setMessageName(String messageName)
	{
		this.messageName = messageName;
	}

	public void setMessageSubject(String messageSubject)
	{
		this.messageSubject = messageSubject;
	}

}
