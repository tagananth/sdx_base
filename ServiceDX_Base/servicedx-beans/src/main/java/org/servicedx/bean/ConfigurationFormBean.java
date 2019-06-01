package org.servicedx.bean;

import org.servicedx.bean.model.Configuration;

public class ConfigurationFormBean extends APIStatus
{

	private static final long	serialVersionUID	= 2490152380120347818L;

	public Configuration		configuration		= new Configuration();

	public String				toMailId;
	
	public String 				messageCode;

}
