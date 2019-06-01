package org.servicedx.bean;

import org.servicedx.bean.model.Group;
import org.servicedx.bean.model.Users;

public class SendMessageBean extends APIStatus
{

	private static final long	serialVersionUID	= 2490152380120347818L;

	public String				type;

	public Group				group;

	public Users				user;
	
	public String				contact;
	
}
