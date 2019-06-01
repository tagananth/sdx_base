package org.servicedx.bean.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "scheduledetails")
public class ScheduleDetails extends CommonCustomerBean implements IScheduleDetails
{

	private static final long	serialVersionUID	= -647097802354872181L;

	protected long				scheduleDetailId;
	
	protected long				scheduleId;
	
	protected String			scheduleName;

	protected long				userId;
	
	protected String			userName;
	
	protected long				groupId;
	
	protected String			groupName;
	
	protected String			scheduleTime;
	
	protected String			intervalDay;
	
	protected String			occurrenceType;
	
	protected String			startDate;
	
	protected String			endDate;

	protected String			entity;
	

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

	
	@Column(name = "scheduledetailid")
	public long getScheduleDetailId()
	{
		return scheduleDetailId;
	}

	@Column(name = "userid")
	public long getUserId()
	{
		return userId;
	}

	@Column(name = "username")
	public String getUserName()
	{
		return userName;
	}

	@Column(name = "groupid")
	public long getGroupId()
	{
		return groupId;
	}

	@Column(name = "groupname")
	public String getGroupName()
	{
		return groupName;
	}

	@Column(name = "scheduletime")
	public String getScheduleTime()
	{
		return scheduleTime;
	}

	@Column(name = "intervalday")
	public String getIntervalDay()
	{
		return intervalDay;
	}

	@Column(name = "occurrencetype")
	public String getOccurrenceType()
	{
		return occurrenceType;
	}

	@Column(name = "startdate")
	public String getStartDate()
	{
		return startDate;
	}

	@Column(name = "enddate")
	public String getEndDate()
	{
		return endDate;
	}
	@Column(name = "entity")
	public String getEntity()
	{
		return entity;
	}


	public void setScheduleDetailId(long scheduleDetailId)
	{
		this.scheduleDetailId = scheduleDetailId;
	}


	public void setScheduleId(long scheduleId)
	{
		this.scheduleId = scheduleId;
	}
	
	public void setScheduleName(String scheduleName)
	{
		this.scheduleName = scheduleName;
	}


	public void setUserId(long userId)
	{
		this.userId = userId;
	}


	public void setUserName(String userName)
	{
		this.userName = userName;
	}


	public void setGroupId(long groupId)
	{
		this.groupId = groupId;
	}


	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}


	public void setScheduleTime(String scheduleTime)
	{
		this.scheduleTime = scheduleTime;
	}


	public void setIntervalDay(String intervalDay)
	{
		this.intervalDay = intervalDay;
	}


	public void setOccurrenceType(String occurrenceType)
	{
		this.occurrenceType = occurrenceType;
	}


	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}


	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public void setEntity(String entity)
	{
		this.entity = entity;
	}

	@Transient
	public String getFormattedStartDate()
	{
		return this.startDate.toString();
		//return this.startDate.format(DateTimeFormatter.ISO_DATE);
	}
	@Transient
	public String getFormattedEndDate()
	{
		return this.startDate.toString();
		//return this.endDate.format(DateTimeFormatter.ISO_DATE);
	}
}
