package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule extends CommonCustomerBean implements ISchedule
{

	private static final long	serialVersionUID	= -647097802354872181L;

	protected long				scheduleId;

	protected String			scheduleName;

	protected String			occurrenceType;

	@Column(name = "scheduleid")
	public long getScheduleId()
	{
		return scheduleId;
	}

	@Column(name = "schedulename")
	public String getScheduleName()
	{
		return scheduleName;
	}

	@Column(name = "occurrencetype")
	public String getOccurrenceType()
	{
		return occurrenceType;
	}

	public void setScheduleId(long scheduleId)
	{
		this.scheduleId = scheduleId;
	}

	public void setScheduleName(String scheduleName)
	{
		this.scheduleName = scheduleName;
	}

	public void setOccurrenceType(String occurrenceType)
	{
		this.occurrenceType = occurrenceType;
	}

}
