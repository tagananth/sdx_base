package org.servicedx.bean;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class MessageFormBean extends APIStatus
{

	private static final long			serialVersionUID	= 2490152380120347818L;

	public String						messageType;

	public String						bodyText;

	public String						subjectText;

	public MultipartFile[]				file;

	public Map<String, SendMessageBean>	dataMap;

	public long							customerId;

}
