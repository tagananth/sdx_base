package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attachment")
public class Attachment implements IAttachment
{
	private static final long	serialVersionUID	= -8117066273433451132L;

	private long				attachmentId;

	private long				messageId;

	private String				attachmentURL;

	@Id
	@Column(name = "attachmentid")
	public long getAttachmentId()
	{
		return attachmentId;
	}

	@Column(name = "messageid")
	public long getMessageId()
	{
		return messageId;
	}

	@Column(name = "attachmenturl")
	public String getAttachmentURL()
	{
		return attachmentURL;
	}

	public void setAttachmentId(long attachmentId)
	{
		this.attachmentId = attachmentId;
	}

	public void setMessageId(long messageId)
	{
		this.messageId = messageId;
	}

	public void setAttachmentURL(String attachmentURL)
	{
		this.attachmentURL = attachmentURL;
	}

}
