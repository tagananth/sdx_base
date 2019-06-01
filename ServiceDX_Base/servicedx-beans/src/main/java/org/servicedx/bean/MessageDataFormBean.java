package org.servicedx.bean;

import org.servicedx.bean.model.Message;

public class MessageDataFormBean extends APIStatus{
	
	private static final long serialVersionUID = 1452795795821759203L;

	public Message 				message;
	public String 				searchParam;
	public String				userId;
	public String				groupId;
	public String				customerId;
	public long					fromDate;
	public long					toDate;
	public int					year;

}

	