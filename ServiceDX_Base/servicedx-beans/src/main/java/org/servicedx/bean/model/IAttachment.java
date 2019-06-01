package org.servicedx.bean.model;

public interface IAttachment
{

	public long getAttachmentId();

	public long getMessageId();

	public String getAttachmentURL();

	public void setAttachmentId(long attachmentId);
	

	public void setMessageId(long messageId);


	public void setAttachmentURL(String attachmentURL);


}